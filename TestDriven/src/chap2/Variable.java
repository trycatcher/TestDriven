package chap2;

import java.util.Map;

public class Variable implements Segment{
	private String name;

	public Variable(String name) {
		this.name = name;
	}
	
	public boolean equals(Object other) {
		return name.equals(((Variable) other).name);
	}
	
	public String toString() {
		return "Variable:" + name;
	}
	
	public int hashCode() {
		int result = 3;
		
		return result*37 + name.hashCode();
	}

	public String evaluate(Map<String, String> variables) {
		if(!variables.containsKey(name)) {
			throw new MissingValueException(
					"No value for ${" + name + "}");
		}
		return variables.get(name);
	}
}
