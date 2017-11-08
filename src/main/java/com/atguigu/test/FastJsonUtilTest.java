package com.atguigu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.utils.FastJsonUtil;

public class FastJsonUtilTest {

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
	public void testObject() {
		String jsonString = JSON.toJSONString(cart);
		T_MALL_SHOPPINGCAR parseObject = JSON.parseObject(jsonString, T_MALL_SHOPPINGCAR.class);
		System.out.println(parseObject);
		
		jsonString = JSON.toJSONString(cartList);
		List<T_MALL_SHOPPINGCAR> parseArray = JSON.parseArray(jsonString, T_MALL_SHOPPINGCAR.class);
		System.out.println(parseArray);
		jsonString = JSON.toJSONString(cartMap);
		TypeReference<Map<String, T_MALL_SHOPPINGCAR>> type = new TypeReference<Map<String, T_MALL_SHOPPINGCAR>>() {};
		Map<String, T_MALL_SHOPPINGCAR> parseObject2 = JSON.parseObject(jsonString, type);
		System.out.println(parseObject2);
	}

	@Test
	public void testList() {
		String cartListJson = FastJsonUtil.object_to_json(cartList);
		System.out.println(cartListJson);
		
		List<T_MALL_SHOPPINGCAR> list = (List<T_MALL_SHOPPINGCAR>)FastJsonUtil.json_to_list(cartListJson, T_MALL_SHOPPINGCAR.class);
		System.out.println(list.get(0));
		
	}
	
	@Test
	public void testMap() {
		String cartMapJson = FastJsonUtil.object_to_json(cartMap);
		System.out.println(cartMapJson);
		TypeReference<Map<String, T_MALL_SHOPPINGCAR>> type = new TypeReference<Map<String, T_MALL_SHOPPINGCAR>>() {};
		
		Map<String, T_MALL_SHOPPINGCAR> map = JSON.parseObject(cartMapJson, type);
		System.out.println(map.get("cart1"));
		
	}

}
