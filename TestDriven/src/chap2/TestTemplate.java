package chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTemplate {
	private Template template;
	
	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	@Test
	public void multipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3");
	}

	@Test
	public void unknownVariablesAreIgnored() throws Exception {
		template.set("doesnotexist", "hi");
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	
	@Test
	public void missingValueThrowsException() throws Exception {
		try {
			new Template("${foo}").evaluate();
			fail("evaulate() should throw an exception if" +
					" a vaiable was left without a value!");
		}
		catch(MissingValueException expected) {
			assertEquals("No value for ${foo}", expected.getMessage());
		}
	}
	
	private void assertTemplateEvaluatesTo(String templateText) {
		assertEquals(templateText, template.evaluate());		
	}
}
