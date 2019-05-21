package org.bibliotex.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonConfig {
	private static Gson gson = new Gson();	
	
	private static JsonObject jsonObject = loadConfig();
	
	private static JsonObject loadConfig() 
	{		
		JsonObject jObject = null;
		try {
			URL sapiEnumResource = Resources.getResource("config.json");
			File file = new File(sapiEnumResource.getFile());						
			JsonElement jsonElement = gson.fromJson(new FileReader(file), JsonElement.class);			
			if (jsonElement!=null)
				jObject = jsonElement.getAsJsonObject();
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return jObject;
	}

	private static String[] getArrayPath(String path) {
		if (!path.contains("/"))
			path = path + "/";
			
		String[] tmp = path.split("\\.");
		return tmp;
	}
	
	private static JsonElement getElement(String path) {
		String[] nodes = getArrayPath(path);
		
		JsonObject jObject = jsonObject; 
		JsonElement jsonPrimitive = null;
		
		for(String n:nodes) {
			if (jObject.get(n).isJsonObject()) {
				jObject = jObject.getAsJsonObject(n);
			}
			else if (jObject.get(n).isJsonPrimitive()) {
				jsonPrimitive = jObject.get(n);
				break;
			}			
		}

		return jsonPrimitive;
	}
	
	public static JsonObject getJsonObject() {
		return jsonObject;
	}
	
	//dot separated path root.leaf.leaf.leaf with value
	public static String asString(String path) {
		JsonElement jsonPrimitive = getElement(path);

		return jsonPrimitive == null ? null : jsonPrimitive.getAsString();
	}
	
	public static short asShort(String path) {
		JsonElement jsonPrimitive = getElement(path);
		return jsonPrimitive == null ? null : jsonPrimitive.getAsShort();
	}
	
	public static Integer asInt(String path) {
		JsonElement jsonPrimitive = getElement(path);
		return jsonPrimitive == null ? null : jsonPrimitive.getAsInt();
	}
	
	public static Boolean asBoolean(String path) {
		JsonElement jsonPrimitive = getElement(path);
		return jsonPrimitive == null ? null : jsonPrimitive.getAsBoolean();
	}
}
