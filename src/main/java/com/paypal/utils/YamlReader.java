package com.paypal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

	/**
	 * @param country
	 * @param key
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public static Map<String, Object> getKeyValue(String country, String key)
			throws IOException {

		InputStream input = new FileInputStream(new File("src/main/resources/"
				+ country + "/" + country + ".yaml"));
		Map<String, Object> value = null;
		Yaml yaml = new Yaml();
		for (Object data : yaml.loadAll(input)) {
			value = (Map<String, Object>) data;
			if (value.containsValue(key)) {
				return value;
			}

		}
		return null;

	}

	/**
	 * @param country
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public static Map<String, Object> getKeyValue(String country)
			throws IOException {

		InputStream input = new FileInputStream(new File("src/main/resources/"
				+ country + "/" + country + ".yaml"));
		Map<String, Object> value = null;
		Yaml yaml = new Yaml();
		for (Object data : yaml.loadAll(input)) {
			value = (Map<String, Object>) data;
			if (value.containsValue("default")) {
				return value;
			}

		}
		return null;

	}
}
