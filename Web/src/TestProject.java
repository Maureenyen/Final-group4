import org.python.core.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		
		
		Calculate calculate = new Calculate();
		calculate.putkeyword(request.getParameter("keyword"));
		calculate.callGoogle();
		HashMap<String, String> query = calculate.sort();
		
		HashMap<String, String> related = calculate.related();
		
		
		
	/*	GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> query = google.query();*/
		
		// ArrayList<String> content = new ArrayList<String>();
		// ContentFetcher cf = new ContentFetcher();
		
		String[][] s = new String[query.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    // content.add(cf.contentFetch(value));
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		} 
		
		/*
		SemanticAnalysis sa = new SemanticAnalysis(content);
		
		ArrayList<String> relatedwords = new ArrayList<String>();
		
		try {
			PyList ans = sa.analysis();
			
			for(Object o : ans) {
				String term = (String)o;
				relatedwords.add(term);
			}
		}catch(FileNotFoundException e) {
			System.out.println("FNFE");
		}
		System.out.println("related words");
		*/
		
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
