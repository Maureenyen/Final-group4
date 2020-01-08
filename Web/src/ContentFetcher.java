import java.net.*;
import org.jsoup.Jsoup;
import java.io.*;

public class ContentFetcher {
	
	
	public String contentFetch(String urlstr) throws IOException {
		
		String html = this.htmlFetch(urlstr);		
		return Jsoup.parse(html).text();
	
	}
	
	
	private String htmlFetch(String urlstr)  throws IOException {
		
		URL url = new URL(urlstr);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        String html = "";
        while ((inputLine = in.readLine()) != null)
            html += inputLine; 
        in.close();
        
        return html;	
		
		
	}
	
}