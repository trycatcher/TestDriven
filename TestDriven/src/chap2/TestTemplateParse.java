package chap2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTemplateParse {	
	
	@Test
	public void plainTextEvaluatesAsIs() throws Exception {
		TemplateParse p = new TemplateParse();
		List<Segment> segments = p.parseSegment("a ${b} c ${d}");
		assertSegments(segments,
				new PlainText("a "), new Variable("b"),
				new PlainText(" c "), new Variable("d"));
	}

	@Test
	public void emptyTemplateRendersAsEmptyString() throws Exception {
		List<String> segments = parse("");
		assertSegments(segments, "");
	}
	
	@Test
	public void templateWithOnlyPlainText() throws Exception {
		List<String> segments = parse("plain text only");
		assertSegments(segments, "plain text only");
	}
	
	@Test
	public void parsingMultipleVariables() throws Exception {
		List<String> segments = parse("${a}:${b}:${c}");
		assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
	}
	
	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
	}
	
	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals("Number of segments don't match", actual.size(), expected.length);
		assertEquals(Arrays.asList(expected), actual);
	}
}
