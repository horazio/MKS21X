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
    long startTime = System.currentTimeMillis();
    int[] randish = new int[1000];
    //int[] randish = new int[0];
    //int[] randish = new int[1];
    //int[] randish = new int[2];
    //int[] randish = new int[3];
    //int[] randish = new int[100000];

    for(int i = 0 ; i < randish.length; i++){ //PURELY RANDOM
      randish[i] = (int)(Math.random()*100);
    }

    //for(int i = 0 ; i < randish.length; i++){ //ALL THE SAME NUMBER OR YOU CAN JUST RUN CODE WITHOUT ANY FOR LOOPS
    //  randish[i] = 1;
    //}

    //for(int i = 0 ; i < randish.length; i++){ //BIGGEST TO SMALLEST
    //  randish[i] = randish.length - i;
    //}

    //for(int i = 0 ; i < randish.length; i++){ // SMALLEST to BIGGEST
    //  randish[i] = i;
    //}

    System.out.println(Arrays.toString(randish));

    //Sorts Tests Here:

    //System.out.println("selectionSort:");
    //selectionSort(randish);

    //System.out.println("insertionSort:");
    //insertionSort(randish);

    System.out.println("bubbleSort:");
    bubbleSort(randish);

    System.out.println(Arrays.toString(randish));

    System.out.println("Runtime: " +
                       (System.currentTimeMillis() - startTime) + "ms or " +
                       (System.currentTimeMillis() - startTime)/1000.0 + "s"
                       );
    
    }
}
