public class Keyword {
	public String name;
	//public double weight;
	
	public Keyword(String name){
		this.name = name;
		//this.weight = weight;
		// this.weight = 0.1;
	}
	
	@Override
	public String toString(){
		return "["+name+"]";
	}
}
