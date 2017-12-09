public class Sorts{

  public static String name(){
      return "10.Fusco.Horace"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      int holder = 0;
      for(int j = 0; j < data.length;  j++){
          holder = j;
          for(int i = j; i < data.length; i++){
              if(data[i] < data[holder]){
                  holder = i;
              }
          }
          swap(data, j, holder);
      }  
  }
    
    public static void insertionSort(int[] data){
	for(int j = 1; j < data.length; j++){
	    int i = j;
	    while(i != 0 && data[i - 1] > data[i]){
		swap(data, i - 1, i);
		i--;
	    }
		    
	    }
	    
	    
	}
	
  private static void swap(int[] ary, int a, int b){
      int holder = ary[a];
      ary[a] = ary[b];
      ary[b] = holder;
  }

  
    public static void bubbleSort(int[] ary){
        for(int i = ary.length; i > 0; i--){
            for(int j = 0; j < i - 1; j ++){
                if(ary[j] > ary[j + 1]){
                    swap(ary, j, j + 1);
                }
            }
        }
    }
  
  
    public static void main(String[] args){
        
        
        
	int[] a = {1, 2,1234, 5 ,1235, 4, 1346, 13, -665, -13656,23, 4, 4,4, 4, 4,4 , 3, 4, 5, 123, 1234, 8, 9, 0};



    String input = "[";
    for (int i=0;i<a.length;i++){
      input += a[i];
      if (i!=a.length-1){
        input += ",";
      }
    }
    input += "]";
    System.out.println(input);
    Sorts.bubbleSort(a);
    System.out.println("-----Sorted Below----");
    String output = "[";
    for (int i=0;i<a.length;i++){
      output += a[i];
      if (i!=a.length-1){
        output += ",";
      }
    }
    output += "]";
    System.out.println(output);
  }
}
