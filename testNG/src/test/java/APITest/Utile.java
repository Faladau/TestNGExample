package APITest;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Utile {
	
	// asa se construieste un obj de tip JSON cu Jackson
	public static Object getUserDataFromJson(String jsonString, String fieldName) {
		  Object value = null;
		  
		  ObjectMapper mapper = new ObjectMapper();
		  try {
		   JsonNode jsonObject = mapper.readTree(jsonString);
		   value = jsonObject.findValue(fieldName);
		   
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   return "";
		  }
		  
		  return value;
		  
		 }
	
	
	public static String createUserJson(String name, String job) {
		  ObjectMapper mapper = new ObjectMapper();
		  ObjectNode rootNode = mapper.createObjectNode();
		  rootNode.put("name", name);
		  rootNode.put("job", job);
		  
		  return rootNode.toString();
		 }

}
