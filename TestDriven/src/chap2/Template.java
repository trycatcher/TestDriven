package chap2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public String evaluate() {
		String res = templateText;
		for(Entry<String, String> entry: variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			String result = entry.getValue();
			res = res.replaceAll(regex, result);
		}
		return res;
	}
}
