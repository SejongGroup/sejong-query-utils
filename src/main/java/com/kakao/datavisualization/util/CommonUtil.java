package com.kakao.datavisualization.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.kakao.datavisualization.model.BoardVO;

public class CommonUtil {

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static Object StringToObject(String requestBody, Class<?> classType)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(requestBody, classType);
	}

	public static String urlDecord(String param) {
		return URLDecoder.decode(param);
	}

	public static List<Map<String, Object>> paramNullCheck(List<Map<String, Object>> result) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < result.size(); i++) {
			Map<String, Object> new_map = new HashMap<String, Object>();
			
			Map<String, Object> map = result.get(i);
			Iterator<String> keys = result.get(i).keySet().iterator();
			
			while(keys.hasNext() ){
				String key = keys.next();
				Object value = map.get(key);
				System.out.println(value.toString());
				if (map.get(key) == null || map.get(key).toString() == null) {
					new_map.put(key, "null");
					System.out.println("여기왕씀");
				} else {
					new_map.put(key, value);
				}
			}
			list.add(new_map);
		}
		return list;
	}


}
