package info.guzialek.MyLittleJavaLibrary;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashUtils {

	private static final Logger logger = LoggerFactory.getLogger(HashUtils.class);
	
	public static String md5(String input) {
		try {
			final byte[] inputBytes = input.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] hashBytes = messageDigest.digest(inputBytes);
//			String hashString = Base64.encodeBase64String(hashBytes);
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
