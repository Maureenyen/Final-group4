import java.awt.RenderingHints.Key;
import java.util.ArrayList;


public class WebPageListsort {

	private ArrayList<WebPage> lst;
	
	public WebPageListsort(ArrayList<WebPage> w){
		this.lst = w;
    }
	
	public void sort(){
		quickSort(0, lst.size()-1);
	}
	
	private void swap(int aIndex, int bIndex){
		WebPage temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	
	
	
	private void quickSort(int leftbound, int rightbound){
		//implement quickSort algorithm
		/*
		if(leftbound>=rightbound) {
			return;
		}
		
		WebPage pivot = lst.get(rightbound);
		int pivotNum = rightbound;
		int j = leftbound;
		int k = rightbound-1;
		
		while(j<k) {
			while(j<rightbound && lst.get(j).rootscore < pivot.rootscore) {
				j++;
			}
			
			while(leftbound<k && lst.get(k).rootscore > pivot.rootscore) {
				k--;
			}
			if(j<k) {
				swap(j, k);
				System.out.println(lst.get(j).rootscore+" change with "+lst.get(k).rootscore);
			}
			
		}
		if(j<pivotNum) {
			if(lst.get(j).rootscore>lst.get(pivotNum).rootscore) {
			swap(j,pivotNum);
			}
			System.out.println(lst.get(j).rootscore+" change with "+lst.get(pivotNum).rootscore);
		}

		quickSort(leftbound, j-1);
		quickSort(j+1, rightbound);
		*/
		
		 if(rightbound>leftbound){
			 
		   int i = leftbound+1;
		   int j = rightbound;
		  
		  double pivot = lst.get(leftbound).rootscore;
		  while(true){
			  
			  	while(lst.get(i).rootscore<=pivot&&i<rightbound){
			  		i++;
			  	}
			  	while(lst.get(j).rootscore>=pivot&&leftbound<j){
			  		j--;
			  	}
			  	
			  	
			  	if(i<j){
			  		swap(i, j);
			  		//System.out.println("swap");
			  	}else {
			  		if(j>leftbound){
			  			swap(leftbound, j);
			  			//System.out.println("swap");
			  		}
			  			break;
			  	}
		   
		  }
		  
		  if(j>leftbound){
		   quickSort(leftbound, j-1);
		  }
		  
		  if(j<rightbound){
		   quickSort(j+1, rightbound);
		  }
		  
	   }
		
		
	}
	
	
	
	
	
	
}
