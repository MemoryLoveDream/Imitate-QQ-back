package com.example.easychat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String objectToJson(Object data) {
    	try {
            return MAPPER.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
    	return null;
    }

    public static <T> T jsonToObject(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
            return MAPPER.readValue(jsonData, javaType);
		} catch (Exception e) {
            log.error(e.getMessage());
		}
    	return null;
    }
    
}
