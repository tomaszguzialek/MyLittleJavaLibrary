package info.guzialek.MyLittleJavaLibrary;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class exposing methods to generate hashes with certain hashing algorithms.
 */
public class HashUtils {

	private static final Logger logger = LoggerFactory.getLogger(HashUtils.class);
	
	/**
	 * Returns the hash of a {@link String}
	 * 
	 * @param input {@link String} input to be hashed
	 * @return {@link String} with hex representation of the hash
	 */
	public static String md5(String input) {
		try {
			final byte[] inputBytes = input.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] hashBytes = messageDigest.digest(inputBytes);
			StringBuffer sb = new StringBuffer();
			for (byte b : hashBytes) {
				sb.append(String.format("%02x", b & 0xff));
			}
			String hashString = sb.toString();
			return hashString;
		} catch (UnsupportedEncodingException e) {
			logger.error("UTF-8 has not been found in encodings", e);
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5 has not been found in available algorithms", e);
			throw new RuntimeException(e);
		}
	}
	
}
