package com.xpay.serializer;

import com.google.gson.*;
import com.xpay.model.PaymentEssentials;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/06.
 */
public class PaymentEssentialsSerializer implements JsonSerializer<PaymentEssentials> {

    @Override
    public JsonElement serialize(PaymentEssentials paymentEssentials, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Double.class, new DoubleTypeSerializer())
                .disableHtmlEscaping();

        if (paymentEssentials.getChannel() != null) {
            gsonBuilder.serializeNulls();
        }

        return gsonBuilder.create().toJsonTree(paymentEssentials, type);
    }
}
