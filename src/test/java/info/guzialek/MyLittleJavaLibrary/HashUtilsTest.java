package info.guzialek.MyLittleJavaLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashUtilsTest {

	@Test
	public void testTomasz() {
		String hash = HashUtils.md5("tomasz");
		assertEquals("2df8ce7d317c7d89dfa95be7695d2de0", hash);
	}
	
	@Test
	public void testStringWithWhitespace() {
		String hash = HashUtils.md5("My Little Java Library");
		assertEquals("05e092a43ce3b47961aa855bb895691c", hash);
	}

}
