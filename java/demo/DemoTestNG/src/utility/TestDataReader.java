package utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class TestDataReader {
	
	private final static Logger log = Logger.getLogger(TestDataReader.class);

	
	// reading value from JSON to Hashmap

	@SuppressWarnings("unchecked")
	public static void readValue(
			HashMap<String, Map<String, String>> hashMap, String str) {
		try {

			System.out.println(str);
			JSONObject jsonObject = (JSONObject) new JSONParser()
					.parse(new FileReader(str));
			Iterator iter = jsonObject.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Map<String, String>> entryMap = (Entry<String, Map<String, String>>) iter
						.next();
				HashMap<String, String> properties = new HashMap<String, String>();
				String key = entryMap.getKey();
				Map<String, String> valueMap = entryMap.getValue();
				Iterator propIter = valueMap.entrySet().iterator();

				while (propIter.hasNext()) {
					Map.Entry<String, String> propertyEntry = (Entry<String, String>) propIter
							.next();
					properties.put(propertyEntry.getKey(),
							propertyEntry.getValue());
				}

				hashMap.put(key, properties);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}
	
	}
	
	// updating value into JSON from Hashmap

	@SuppressWarnings("unchecked")
	public static void updateValue(
			HashMap<String, Map<String, String>> hashMap, String str, String value) {
		try {
			System.out.println(str);
			JSONObject jsonObject = (JSONObject) new JSONParser()
					.parse(new FileReader(str));
			Iterator iter = jsonObject.entrySet().iterator();
			while(iter.hasNext())
			{
				Map.Entry<String, Map<String, String>> entryMap = (Entry<String, Map<String, String>>) iter
						.next();
				HashMap<String, String> properties = new HashMap<String, String>();
				String key = entryMap.getKey();
				Map<String, String> valueMap = entryMap.getValue();
				Iterator propIter = valueMap.entrySet().iterator();

				while (propIter.hasNext()) {
					Map.Entry<String, String> propertyEntry = (Entry<String, String>) propIter
							.next();
					properties.put(propertyEntry.getKey(),
							propertyEntry.setValue(value));
				}

				hashMap.put(key, properties); 
			}
		} catch (Exception e) {
//			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}
	}
	
	// deleting value from JSON through Hashmap
	
	public static void deleteValue(
			HashMap<String, Map<String, String>> hashMap, String str, String value) {
		
		
	}
}
