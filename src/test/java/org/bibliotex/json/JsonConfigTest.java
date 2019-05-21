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
	public void TestConnection()  throws Exception {

		String cs = JsonConfig.asString("properties.name.type");
		Integer value = JsonConfig.asInt("properties.name.value");
		String desc = JsonConfig.asString("properties.name.description");

		System.out.println(cs);
		System.out.println(value);
		System.out.println(desc);
		
		System.out.println(JsonConfig.getJsonObject());
		Assert.assertTrue("key not found", cs !=null);
		//Assert.assertTrue("key not found", value !=null);
		Assert.assertTrue("key not found", desc !=null);
	}
}
