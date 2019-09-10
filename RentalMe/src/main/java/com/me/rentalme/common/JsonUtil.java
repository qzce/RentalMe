package com.me.rentalme.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* Json Util 
* 
* @author Ȳ����
* @version ver1.0
* ������� : 2019.09.07
*/
public class JsonUtil {
	
	/**
	*  Map�� JSONObject���� ��ȯ
	* 
	* @param  Map<String, Object> map
	* @return JsonObject 
	* @author Ȳ����
	* ������� : 2019.09.07
	*/
	public JSONObject getMapToJsonObject(Map<String, Object> map) {
		JSONObject jsonObject = new JSONObject();
		
		//entrySet() : ���� key�� value�� �� ��� ���� 
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			Object key 		= entry.getKey();
			Object value 	= entry.getValue();
			jsonObject.put(key, value);
		}
		
		return jsonObject;
	}
	
	/**
	*  List<Map<Object,Object>>�� JSONArray�� ��ȯ
	* 
	* @param  List<Map<String, Object>> list
	* @return JsonArray
	* @author Ȳ����
	* ������� : 2019.09.07
	*/
	public JSONArray getListMapToJsonArray(List<Map<String,Object>> listMap) {
		
		JSONArray jsonArray = new JSONArray();
		for(Map<String, Object> map : listMap) {
			jsonArray.add(getMapToJsonObject(map));
		}
		
		return jsonArray;
	}
	
	/**
	* List<Map<String,Object>>�� JSONString���� ��ȯ
	* 
	* @param  List<Map<Object,Object>> listMap
	* @return String 
	* @author Ȳ����
	* ������� : 2019.09.07
	*/
	public String getListMapToString(List<Map<String,Object>> listMap) {
		
		JSONArray jsonArray = getListMapToJsonArray(listMap);
		return jsonArray.toJSONString();
	}
	
	/**
	* JsonObject��  Map�� ��ȯ
	* 
	* @param  JSONObject
	* @return Map<String,Object>
	* @author Ȳ����
	* ������� : 2019.09.07
	*/
	public static Map<String, Object> getJsonObjectToMap(JSONObject jsonObject){
		
		Map<String,Object> map = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			map = mapper.readValue(
					jsonObject.toJSONString(), new TypeReference<Map<Object,Object>>() {});
			System.out.println("json -> map : "+map);
		} catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return map;
	}
	/**
	 * JsonObject��  HashMap�� ��ȯ
	 * 
	 * @param  JSONObject
	 * @return Map<String,Object>
	 * @author Ȳ����
	 * ������� : 2019.09.07
	 */
	public static Map<String, String> getJsonObjectToHashMap(JSONObject jsonObject){
		
		HashMap<String, String> map = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			map = mapper.readValue(
					jsonObject.toJSONString(), new TypeReference<HashMap<String, Object>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	* JsonArray��  List<Map<String,Object>>�� ��ȯ
	* 
	* @param  JSONArray
	* @return List<Map<String,Object>> listMap
	* @author Ȳ����
	* ������� : 2019.09.07
	*/	
	public List<Map<String,Object>> JsonArrayToListMap(JSONArray jsonArray){
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		
		if(jsonArray != null) {
			for(int i = 0; i < jsonArray.size(); i++) {
				Map<String, Object> map = JsonUtil.getJsonObjectToMap((JSONObject)jsonArray.get(i));
				listMap.add(map);
			}
		}
		
		return listMap;
	}
	
}
