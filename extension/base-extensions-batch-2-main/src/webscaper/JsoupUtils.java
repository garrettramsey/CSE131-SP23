package webscaper;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class JsoupUtils {
	public static Document connectAndGet(String url) {
		Connection connection = Jsoup.connect(url);
		try {
			return connection.get();
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}
}
