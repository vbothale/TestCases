package Utility;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	@SuppressWarnings("unchecked")
	public static void writeJSON()
	{
		JSONObject obj = new JSONObject();  
        obj.put("testdata", "for QA env."); 
  
        JSONArray users = new JSONArray();  
        users.add("fmartin");  
        users.add("sdietz");  
        users.add("alockhart");  
  
        obj.put("username", users);  
        obj.put("password is", "Provenir1");
        
        try {  
            
            // Writing to a file  
            File file=new File("C:\\Users\\provenir\\Desktop\\TestDataJSONFile.json");  
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print(obj);  
  
            fileWriter.write(obj.toJSONString());  
            fileWriter.flush();  
            fileWriter.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

	}
	
	@SuppressWarnings("unchecked")
	public static void readJSONToHashMap(HashMap<String,Map<String,String>> hashMap){
		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("C:\\Workspace_QA\\TestCases\\java\\demo\\DemoTestNG\\resources\\Login.json"));
			Iterator iter = jsonObject.entrySet().iterator();
			while(iter.hasNext()) {
				Map.Entry<String, Map<String, String>> entryMap = (Entry<String, Map<String, String>>) iter.next();
				HashMap<String, String> properties = new HashMap<String, String>();
				String key = entryMap.getKey();
				Map<String, String> valueMap = entryMap.getValue();
				Iterator propIter = valueMap.entrySet().iterator();
				
				while(propIter.hasNext()) {
					Map.Entry<String, String> propertyEntry =  (Entry<String, String>) propIter.next();
					properties.put(propertyEntry.getKey(), propertyEntry.getValue());
				}
				
				hashMap.put(key, properties);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
