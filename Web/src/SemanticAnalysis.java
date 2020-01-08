import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SemanticAnalysis {
	
	private ArrayList<String> articles;
	// private ArrayList<String> tags;
	
	public SemanticAnalysis(ArrayList<String> articles) {
		
		this.articles = articles;
		
	}
	
	public PyList analysis() throws FileNotFoundException {
		
		String articleLines = "";
		
		for(String element: articles) {
			articleLines += element + "\n";
		}
		
		// System.out.println(articleLines);
		
		PythonInterpreter PyIp = new PythonInterpreter();
		
		PyIp.exec("import sys");
		PyIp.exec("sys.path.append('./lib/jython2.7.1/Lib')");
		PyIp.exec("sys.path.append('./lib')");
		PyIp.exec("sys.path.append('./lib/jython2.7.1/Lib/site-packages')");
		
		FileInputStream f = new FileInputStream("./lib/tf_idf.py");
		PyIp.execfile(f);
		
		PyFunction pyf = (PyFunction)PyIp.get("tf_idf", PyFunction.class);
		
		PyString str = Py.newStringOrUnicode(articleLines);
		
		PyList res = (PyList)pyf.__call__(str); 
		
		PyIp.cleanup();
		PyIp.close();
		
		
		return res;
		
	}
	
	
	public PyObject Pytest(int num1, int num2) throws FileNotFoundException {
		
		PythonInterpreter PyIp = new PythonInterpreter();
		
		FileInputStream f = new FileInputStream("./lib/tester.py");
		PyIp.execfile(f);
		
		PyFunction pyf = (PyFunction)PyIp.get("test", PyFunction.class);
		
		PyObject res = pyf.__call__(new PyInteger(num1), new PyInteger(num2)); 
		
		PyIp.cleanup();
		PyIp.close();
		
		
		return res;
	}

}
