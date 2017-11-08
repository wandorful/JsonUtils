package com.atguigu.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.utils.JacksonUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtilTest {

	T_MALL_SHOPPINGCAR cart = new T_MALL_SHOPPINGCAR();
	List<T_MALL_SHOPPINGCAR> cartList = new ArrayList<T_MALL_SHOPPINGCAR>();
	Map<String, T_MALL_SHOPPINGCAR> cartMap = new HashMap<String, T_MALL_SHOPPINGCAR>();

	@Before
	public void before() {

		cart.setSku_mch("商品名称");
		cart.setSku_jg(1000);
		cart.setTjshl(10);
		for (int i = 1; i <= 3; i++) {
			T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR = new T_MALL_SHOPPINGCAR();
			t_MALL_SHOPPINGCAR.setSku_mch("商品" + i);
			t_MALL_SHOPPINGCAR.setSku_jg(i * 1000);
			t_MALL_SHOPPINGCAR.setTjshl(i);
			cartList.add(t_MALL_SHOPPINGCAR);
			cartMap.put("cart" + i, t_MALL_SHOPPINGCAR);
		}
	}

	@Test
	public void testObject() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(cart);
		System.out.println(writeValueAsString);
		JacksonUtil.json_to_object(writeValueAsString, T_MALL_SHOPPINGCAR.class);
		T_MALL_SHOPPINGCAR readValue = mapper.readValue(writeValueAsString, T_MALL_SHOPPINGCAR.class);
		System.out.println(readValue);
		
		
		writeValueAsString = mapper.writeValueAsString(cartList);
		System.out.println(writeValueAsString);
		List<T_MALL_SHOPPINGCAR> json_to_object = JacksonUtil.json_to_object(writeValueAsString, List.class, T_MALL_SHOPPINGCAR.class);
		System.out.println(json_to_object);
		
		
		writeValueAsString = mapper.writeValueAsString(cartMap);
		System.out.println(writeValueAsString);
		Map<String, T_MALL_SHOPPINGCAR> json_to_object2 = JacksonUtil.json_to_object(writeValueAsString, Map.class, String.class, T_MALL_SHOPPINGCAR.class);
		System.out.println(json_to_object2);
	}

	@Test
	public void testCollection() throws IOException {
		//测试泛型List
		String cartListJson = JacksonUtil.object_to_json(cartList);
		System.out.println(cartListJson);
		
		List<T_MALL_SHOPPINGCAR> cartListFromJson = JacksonUtil.json_to_object(cartListJson, List.class, T_MALL_SHOPPINGCAR.class);
		System.out.println(cartListFromJson.get(0));
		
		
		//测试泛型Map
		String cartMapJson = JacksonUtil.object_to_json(cartMap);
		System.out.println(cartMapJson);
		
		Map<String, T_MALL_SHOPPINGCAR> map = JacksonUtil.json_to_object(cartMapJson, Map.class, String.class, T_MALL_SHOPPINGCAR.class);
		System.out.println(map.get("cart1"));
		
	}

}
