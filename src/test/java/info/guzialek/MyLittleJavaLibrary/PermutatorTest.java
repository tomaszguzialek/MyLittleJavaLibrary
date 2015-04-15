package info.guzialek.MyLittleJavaLibrary;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PermutatorTest {

	private Permutator permutator;

	@Before
	public void setUp() {
		permutator = new Permutator();
	}

	@Test
	public void testABC() {
		Collection<String> permutations = permutator.getAllPermutations("ABC");
		assertEquals(6, permutations.size());
		assertTrue(permutations.contains("ABC"));
		assertTrue(permutations.contains("ACB"));
		assertTrue(permutations.contains("BAC"));
		assertTrue(permutations.contains("BCA"));
		assertTrue(permutations.contains("CAB"));
		assertTrue(permutations.contains("CBA"));
	}

	@Test
	public void testEmptyString() {
		Collection<String> permutations = permutator.getAllPermutations("");
		assertEquals(1, permutations.size());
		assertTrue(permutations.contains(""));
	}

	@Test
	public void testOneCharacterString() {
		Collection<String> permutations = permutator.getAllPermutations("A");
		assertEquals(1, permutations.size());
		assertTrue(permutations.contains("A"));
	}

	@Test
	public void testTwoCalls() {
		Collection<String> permutations1 = permutator.getAllPermutations("ABC");
		assertEquals(6, permutations1.size());
		Collection<String> permutation2 = permutator.getAllPermutations("ABC");
		assertEquals(permutations1, permutation2);
	}

}
