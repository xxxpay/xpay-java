package com.xpay.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.xpay.model.XPayRawJsonObject;

import java.lang.reflect.Type;

public class XPayRawJsonObjectDeserializer implements JsonDeserializer<XPayRawJsonObject> {
    public XPayRawJsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        XPayRawJsonObject object = new XPayRawJsonObject();
        object.json = json.getAsJsonObject();
        return object;
    }
}
