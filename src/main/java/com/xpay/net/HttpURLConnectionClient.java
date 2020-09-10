package com.xpay.net;

import com.xpay.XPay;
import com.xpay.exception.APIConnectionException;
import com.xpay.util.StreamUtils;
import com.xpay.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.*;

public class HttpURLConnectionClient extends HttpClient {
    /** Initializes a new instance of the {@link HttpURLConnectionClient}. */
    public HttpURLConnectionClient() {
        super();
    }

    /**
     * Sends the given request to XPay's API.
     *
     * @param request the request
     * @return the response
     * @throws APIConnectionException if an error occurs when sending or receiving
     */
    @Override
    public XPayResponse request(XPayRequest request) throws APIConnectionException {
        HttpURLConnection conn = null;

        try {
            conn = createXPayConnection(request);

            // trigger the request
            int responseCode = conn.getResponseCode();
            HttpHeaders headers = HttpHeaders.of(conn.getHeaderFields());
            String responseBody;

            if (responseCode >= 200 && responseCode < 300) {
                responseBody = StreamUtils.readToEnd(conn.getInputStream(), APIResource.CHARSET);
            } else {
                responseBody = StreamUtils.readToEnd(conn.getErrorStream(), APIResource.CHARSET);
            }

            return new XPayResponse(responseCode, responseBody, headers);
        } catch (IOException e) {
            throw new APIConnectionException(
                    String.format(
                            "IOException during API request to XPay (%s): %s "
                                    + "Please check your internet connection and try again.",
                            XPay.getApiBase(), e.getMessage()),
                    e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    static HttpHeaders getHeaders(XPayRequest request) {
        Map<String, List<String>> userAgentHeadersMap = new HashMap<>();

        userAgentHeadersMap.put("User-Agent", Collections.singletonList(buildUserAgentString()));
        userAgentHeadersMap.put(
                "X-Client-User-Agent", Collections.singletonList(buildXPayClientUserAgentString()));

        return request.getHeaders().withAdditionalHeaders(userAgentHeadersMap);
    }

    private static HttpURLConnection createXPayConnection(XPayRequest request)
            throws IOException {
        HttpURLConnection conn = (HttpURLConnection) request.url.openConnection();

        conn.setConnectTimeout(request.options.getConnectTimeout());
        conn.setReadTimeout(request.options.getReadTimeout());
        conn.setUseCaches(false);
        for (Map.Entry<String, List<String>> entry : getHeaders(request).map().entrySet()) {
            conn.setRequestProperty(entry.getKey(), StringUtils.join(",", entry.getValue()));
        }

        conn.setRequestMethod(request.method.name());

        String requestTime = currentTimeString();
        conn.setRequestProperty("X-Request-Timestamp", requestTime);
        String signature = buildXPaySignature(request, requestTime);
        if (signature != null) {
            conn.setRequestProperty("X-Signature", signature);
        }

        if (request.content != null) {
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", request.content.contentType);

            try (OutputStream output = conn.getOutputStream()) {
                output.write(request.content.byteArrayContent);
            }
        }

        return conn;
    }
}
