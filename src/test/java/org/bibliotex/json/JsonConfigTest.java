package org.bibliotex.json;

import org.junit.Test;
import org.junit.Assert;
import org.bibliotex.json.JsonConfig;


/**
 *
 * @author 
 */
public class JsonConfigTest
{

	@Test
	public void TestJSonRead()  throws Exception {

		JsonConfig jsonConfig = JsonConfig.getInstance("demo.json");
		String cs = jsonConfig.asString("properties.name.type");
		Integer value = jsonConfig.asInt("properties.name.value");
		String desc = jsonConfig.asString("properties.name.description");

		System.out.println(cs);
		System.out.println(value);
		System.out.println(desc);
		
		System.out.println(jsonConfig.getJsonObject());
		Assert.assertTrue("key not found", cs !=null);
		//Assert.assertTrue("key not found", value !=null);
		Assert.assertTrue("key not found", desc !=null);
	}
}
