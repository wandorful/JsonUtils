package com.atguigu.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

	/**
	 * 任意对象转json字符串
	 * @throws JsonProcessingException 
	 */
	public static String object_to_json(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(object);
	}
	
	/**
	 * json字符串转泛型对象
	 * @throws IOException
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> T json_to_object(String json, Class<T> mainClass, Class<?>... parametricClasses) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JavaType parametricType = mapper.getTypeFactory().constructParametricType(mainClass, parametricClasses);
		T readValue = mapper.readValue(json, parametricType);
		return readValue;
	}
	
}
