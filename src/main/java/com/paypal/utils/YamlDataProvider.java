package com.paypal.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

public class YamlDataProvider {

	@SuppressWarnings("unchecked")
	@DataProvider(parallel = true)
	public static Object[][] geteDataProviderData(ITestNGMethod methodName, ITestContext testContext) throws FileNotFoundException {

		String testName = methodName.getRealClass().getCanonicalName().replaceAll("com.paypal.objects.", "").replaceAll("\\.", "/");
		System.out.println(methodName.getRealClass().getCanonicalName());
//		String localesInputDataFile =  + testName + ".yaml";
		ArrayList<YamlDataReader> dataObjects = new ArrayList<YamlDataReader>();

		Yaml yaml = new Yaml();
		Iterable<Object> allObjects = yaml.loadAll(ClassLoader.getSystemResourceAsStream("com/paypal/objects/CreateNewAccount.yaml"));
		ArrayList<Object> dataObjectsOfYaml = new ArrayList<Object>();

		for (Object data : allObjects) {
	 		  dataObjectsOfYaml.add(data);
		}
		for (Object data : dataObjectsOfYaml) {
			Map<Object, Object> allCountriesData = (Map<Object, Object>) data;
				YamlDataReader yamlDataReader = new YamlDataReader();
				  Map<Object, Object> eachCountryValues = (Map<Object, Object>) allCountriesData;
				  yamlDataReader.setLocale(eachCountryValues.get("locale").toString());
				  dataObjects.add(yamlDataReader);
		}

		Object[][] flowData = new Object[dataObjects.size()][1];

		for (int i = 0; i < dataObjects.size(); i++) {

			flowData[i][0] = dataObjects.get(i);

		}

		return flowData;

	}


}
