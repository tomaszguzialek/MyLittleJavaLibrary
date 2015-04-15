package info.guzialek.MyLittleJavaLibrary;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Generates all the permutations of a given string.
 *
 */
public class Permutator {

	private Collection<String> permutations;

	public Collection<String> getAllPermutations(String input) {
		this.permutations = new ArrayList<String>();
		permute("", input);
		return permutations;
	}

	private void permute(String prefix, String suffix) {
		if (suffix.length() == 0) {
			permutations.add(prefix);
		}

		for (int i = 0; i < suffix.length(); i++) {
			permute(prefix + suffix.charAt(i),
					suffix.substring(0, i) + suffix.substring(i + 1));
		}
	}

}
