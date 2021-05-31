package com.xpay.serializer;

import com.google.gson.*;
import com.xpay.model.ChargeEssentials;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/06.
 */
public class ChargeEssentialsSerializer implements JsonSerializer<ChargeEssentials> {

    @Override
    public JsonElement serialize(ChargeEssentials paymentEssentials, Type type, JsonSerializationContext jsonSerializationContext) {
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
