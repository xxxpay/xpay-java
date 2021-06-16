package com.xpay.serializer;

import com.google.gson.*;
import com.xpay.model.App;
import com.xpay.model.Payment;
import com.xpay.model.PaymentRefundCollection;

import java.lang.reflect.Type;

/**
 * Created by afon on 14/11/25.
 */
public class PaymentDeserializer implements JsonDeserializer<Payment> {

    @Override
    public Payment deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject paymentJson = jsonElement.getAsJsonObject();
        JsonElement element = paymentJson.get("credential");
        if (!(element instanceof JsonNull)) {
            JsonObject credentialJson = paymentJson.getAsJsonObject("credential");
            JsonObject channelCredential;
            if (credentialJson.getAsJsonObject("wx") != null) {
                JsonObject wx = credentialJson.getAsJsonObject("wx");
                Long timestamp = wx.get("timestamp").getAsLong();
                wx.addProperty("timestamp", Long.toString(timestamp));
            } else if (credentialJson.getAsJsonObject("wx_pub") != null) {
                JsonObject wxPub = credentialJson.getAsJsonObject("wx_pub");
                if (null == wxPub.get("signed_data") && wxPub.get("timeStamp") != null) {
                    Long timestamp = wxPub.get("timeStamp").getAsLong();
                    wxPub.addProperty("timeStamp", Long.toString(timestamp));
                }
            } else if ((channelCredential = credentialJson.getAsJsonObject("bfb")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("bfb_wap")) != null) {
                if (channelCredential.has("total_amount")) {
                    Long total_amount = channelCredential.get("total_amount").getAsLong();
                    channelCredential.addProperty("total_amount", Long.toString(total_amount));
                }
            } else if ((channelCredential = credentialJson.getAsJsonObject("alipay")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("alipay_wap")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("alipay_pc_direct")) != null) {
                if (channelCredential.has("payment_type")) {
                    Long paymentType = channelCredential.get("payment_type").getAsLong();
                    channelCredential.addProperty("payment_type", Long.toString(paymentType));
                }
            }
        }

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                registerTypeAdapter(PaymentRefundCollection.class, new PaymentRefundCollectionDeserializer())
                .create();
        JsonElement appElement = paymentJson.get("app");
        Payment payment = gson.fromJson(jsonElement, Payment.class);

        if (null != appElement && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            payment.setApp(app);
        }
        return payment;
    }
}
