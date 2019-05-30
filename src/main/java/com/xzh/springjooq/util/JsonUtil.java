package com.xzh.springjooq.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * @Authur: joshuasiu
 * @Date: 2019-05-30 15:04
 * @Description:
 */
public class JsonUtil {

    private static final Gson gson = new GsonBuilder()
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")//时间转化为特定格式
            .setVersion(1.0).disableHtmlEscaping().create();


    private static final Gson notNullGson = new GsonBuilder()
            .enableComplexMapKeySerialization().disableHtmlEscaping() //支持Map的key为复杂对象的形式
            .setDateFormat("yyyy-MM-dd HH:mm:ss")//时间转化为特定格式
            .setVersion(1.0).disableHtmlEscaping().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static String toJsonNotNull(Object obj) {
        return notNullGson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static <T> T fromJsonByType(String json, Type type) {
        try {
            // Type jsonType = new TypeToken<T>(){}.getType();
            return gson.fromJson(json, type);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
