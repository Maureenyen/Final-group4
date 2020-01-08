import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculate {
	
	private ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	private String searchkeyword = "";
	private ArrayList<WebPage> googleurllist = new ArrayList<WebPage>();		//webpage arraylist
	private ArrayList<WebPage> finalgoogleurllist = new ArrayList<WebPage>();
	
	
	public Calculate() {
		
	}
	
	public void putkeyword(String userInput) throws IOException{
		String[] keyword_array = userInput.split(" ");
		for(String name : keyword_array) {
			searchkeyword += name+"+";
			Keyword k = new Keyword(name);
			keywords.add(k);
		}
			
		searchkeyword = searchkeyword + "撖萇";
		keywords.add(new Keyword("撖萇"));
	}
	
	
	
	public void callGoogle() throws IOException{
		test googleurls = new test(searchkeyword);
		googleurllist = googleurls.query();
		
		sulurl suburl = new sulurl();										//摰�����ulurl霈
		for(WebPage w :googleurllist) {
			//-------------------------------------------------------------------
			WebTree tree = new WebTree(w);
			ArrayList<String> a = suburl.subquery(w.url);
			for(String substring : a){
				tree.root.addChild(new WebNode(new WebPage(substring,"")));
			}
			double score = tree.setPostOrderScore(keywords);
			//----------------------------------------------------------------------
			//銝�����tree靘���雯���蜇��
			if(score!=0) {
				w.rootscore = score;
				finalgoogleurllist.add(w);
			}
			//��� 1.googleurls鋆∠�ebPage��� 2.�蝞��摮�����
		}
		
	}
	
	

	public HashMap<String, String> sort() throws IOException{
		WebPageListsort aListsort = new WebPageListsort(finalgoogleurllist);
		aListsort.sort();
		
		HashMap<String, String> urlhashmap = new HashMap<String, String>();
		for(int i=finalgoogleurllist.size()-1 ; i>=0 ; i--) {
			urlhashmap.put(finalgoogleurllist.get(i).name, finalgoogleurllist.get(i).url);
		}
		
		return urlhashmap;
	}
	
	public HashMap<String, String> related() throws IOException{
		test googleurls = new test(searchkeyword);
		return googleurls.related();
	}



























}
