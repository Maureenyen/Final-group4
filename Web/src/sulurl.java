import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import org.omg.CORBA.PRIVATE_MEMBER;


public class sulurl {
	
	public sulurl() {
		
	}
	
	private String fetchContentsuburl(String suburl) throws IOException

	{
		String retVal = "";

		URL u = new URL(suburl);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	
	
	
		public ArrayList<String> subquery(String googleurl) throws IOException{

		String subcontent;
		subcontent= fetchContentsuburl(googleurl);

		
		Document doc = Jsoup.parse(subcontent);
		Elements lis = doc.select("a"); 
//		lis = lis.select(".ZINbbc");
		
		
		ArrayList<String> suburl = new ArrayList<String>();
		int exist = -1;
		
		for(int i =0 ; i<5 ; i++) // for 
		{
			//System.out.println(li);
			try 

			{
				//System.out.println(lis.get(i).attr("href"));
				int location ;
				location = googleurl.indexOf(".com");
				
				char b = '/';
				if(lis.get(i).attr("href").charAt(0) == b) {
				suburl.add(googleurl.substring(0,location+4)+lis.get(i).attr("href"));
					//webpagelist.add(page);
					}else {
						suburl.add(lis.get(i).attr("href"));
						//System.out.println(lis.get(i).attr("href"));
					}
				


			} catch (IndexOutOfBoundsException e) {

				

			}

			

		}
		
		return suburl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
