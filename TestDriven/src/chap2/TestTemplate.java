package chap2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTemplate {
	
	@Test
	public void oneVariable() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		assertEquals("Hello, Reader", template.evaluate());
	}
	
	@Test
	public void differentValue() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "someone else");
		assertEquals("Hello, someone else", template.evaluate());
	}
	
	@Test
	public void differentTemplate() throws Exception {
		Template template = new Template("Hi, ${name}");
		template.set("name", "someone else");
		assertEquals("Hi, someone else", template.evaluate());
	}
	
	@Test
	public void multipleVariables() throws Exception {
		Template template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
		assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void unknownVariablesAreIgnored() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		template.set("doesnotexist", "hi");
		assertEquals("Hello, Reader", template.evaluate());
	}
}
