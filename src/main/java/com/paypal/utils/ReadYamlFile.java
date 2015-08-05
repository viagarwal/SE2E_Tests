package com.paypal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class ReadYamlFile {
	
	public static String getKeyValue(String country, String key) throws IOException {
		
		Yaml yaml = new Yaml();
		Map<String, Map<String, String>> values = (Map<String, Map<String, String>>) yaml
				.load(new FileInputStream(new File("src/main/resources/"+country+"/"+country+".yaml")));

		Object object  = values.get(key);
		System.out.println(object);
		return object.toString();

	}

}
