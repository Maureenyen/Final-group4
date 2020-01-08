import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		KeywordList list = new KeywordList(13);
		
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String op = in.next();
			switch(op){
			case "add":
				String name = in.next();
				int count = in.nextInt();
				list.add(new Keyword(name, count));
				break;
				
			case "find":
				int c = in.nextInt();
				list.getKeyWordByCount(c);
				break;
			default:
				System.out.println("InvalidOperation");
				
			}
		}
		in.close();

	}

}
