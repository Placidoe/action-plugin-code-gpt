package org.example.codegpt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author: Ryan Hong
 */
public class MapObjectUtil {

    public static <T> T toObject(Map<String, String> map, Class<T> tClass) {
        assert map != null;
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        T obj = mapper.convertValue(map, tClass);
        return obj;
    }


    public static Map<String, String> toMap(Object object) {
        assert object != null;
        ObjectMapper m = new ObjectMapper();
        Map<String, String> reMap = m
                .convertValue(object, new TypeReference<Map<String, String>>() {
                });
        return reMap;
    }

}
