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



public class test 

{

	public String searchKeyword;

	public String url;

	public String content;
	
	
	
	
	public test(String searchKeyword)

	{

		this.searchKeyword = searchKeyword;

		this.url = "http://www.google.com.tw/search?q="+searchKeyword+"&oe=utf8&num=30";

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

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
	
	
	
	public ArrayList<WebPage> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		//System.out.println(doc.text());
		Elements lis = doc.select("div"); 
		lis = lis.select(".ZINbbc"); //  
		//System.out.println(lis.size());
		
		ArrayList<WebPage> webpagelist = new ArrayList<WebPage>();
		int exist = -1;
		for(Element li : lis) // for 
		{
			//System.out.println(li);
			try 

			{
				//if((exist = li.select("a").get(0).attr("href").indexOf("https")) == -1) {
				
				
				String site = li.select("a").get(0).attr("href");
				if(site.contains("/search"))
					continue;
				char b = '/';
				if(li.select("a").get(0).attr("href").charAt(0) == b) {
					site = "http://google.com" + site;
					}
				
				WebPage page = new WebPage(site, li.select(".BNeawe").get(0).text());
				webpagelist.add(page);
					
				
				//WebPage page = new WebPage("google.com"+li.select("a").get(0).attr("href"), li.select(".BNeawe").get(0).text());
				//webpagelist.add(page);
				
				System.out.println(li.select(".BNeawe").get(0).text());
				System.out.println(site);
				
//				for(int i = 0 ; i < block.size(); i++)
//					System.out.println(block.get(i).text());
				
//				System.out.println(block.get(1).text());
//				System.out.println(block.get(2).text());
				
//				String title = block.get(1).text();
//				String citeUrl = block.get(2).text();
				
//				System.out.println(title+" "+citeUrl);

				

				

			} catch (IndexOutOfBoundsException e) {

				

			}

			

		}
		
		

		
		//System.out.println(count);
		/*
		ArrayList<String> b = this.getsuburl(doc);
		for(int i =0;i < 5; i++) {
			System.out.println(b.get(i));
		}
		*/
		
		return webpagelist;
	}
	
	
	private ArrayList<String> getsuburl(Document doc){
		Elements e = doc.select("a");
		ArrayList<String> suburl = new ArrayList<String>();
		for(int i =0; i < 5; i++) {
			suburl.add(e.get(i).attr("href"));
		}
		return suburl;
		
	}
	
	public HashMap<String, String> related() throws IOException{
		
		  if(content==null)

		  {

		   content= fetchContent();

		  }
		  
		  
		  HashMap<String, String> retVal = new HashMap<String, String>();
		  
		  Document doc = Jsoup.parse(content);
		  // System.out.println(doc.text());
		  Elements lis = doc.select("div");
		  lis = lis.select(".ZINbbc");
		  // System.out.println(lis.size());
		  
		  int cnt = 0;
		  for(Element li : lis)
		  {
		   if(cnt > 8) {
		    try 

		    {
		     
		     for(int index = 1; index < 20; index+=2) {
		      retVal.put(li.select(".BNeawe").get(index).text(),li.select("a").get(index-1).attr("href"));
		      
		     }
		     // System.out.println(li.select(".BNeawe").get(index).text());
		     // System.out.println(li.select("a").get(index-1).attr("href"));
		     /*
		     for(int i = 0 ; i < block.size(); i++)
		      System.out.println(block.get(i).text());
		     
		     System.out.println(block.get(1).text());
		     System.out.println(block.get(2).text());
		     
		     String title = block.get(1).text();
		     String citeUrl = block.get(2).text();
		     
		     System.out.println(title+" "+citeUrl);

		     retVal.put(title, citeUrl);
		     */
		     

		    } catch (IndexOutOfBoundsException e) {

		     
		    }
		   }
		   cnt++;
		   

		  }

		  return retVal;
	}

	
	
	
	
	
	

}






