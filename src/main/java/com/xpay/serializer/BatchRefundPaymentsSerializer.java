package com.xpay.serializer;

import com.google.gson.*;
import com.xpay.model.BatchRefundPayments;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/28.
 */
public class BatchRefundPaymentsSerializer implements JsonSerializer<BatchRefundPayments> {

    @Override
    public JsonElement serialize(BatchRefundPayments batchRefundPayments, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .disableHtmlEscaping();

        return gsonBuilder.create().toJsonTree(batchRefundPayments, type);
    }
}
