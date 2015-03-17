package chap2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {
	//private String variableValue;
	private Map<String, String> variables;
	private String templateText;
	
	public Template(String templateText) {
		this.templateText = templateText;
		this.variables = new HashMap<String, String>();
	}
	
	public void set(String name, String value) {
		this.variables.put(name, value);
	}
	
	public String evaluate(){
		String res = replaceVariables();		
		checkForMissingValues(res);
		
		return res;
	}

	private String replaceVariables() {
		String result = templateText;
		for(Entry<String, String> entry: variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}
	
	private void checkForMissingValues(String result) {
		Matcher m = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
		if (m.find()) {
			throw new MissingValueException("No value for " + m.group());
		}
	}
}
