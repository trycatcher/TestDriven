package chap2;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestPlainTextSegment {
	@Test
	public void parsingTemplateIntoSegmentObject() throws Exception {
		Map<String, String> variables = new HashMap<String, String>();
		String text = "abc def";
		assertEquals(text, new PlainText(text).evaluate(variables));
	}
}
