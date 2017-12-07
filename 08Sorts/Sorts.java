public class Sorts{

  public static String name(){
      return "01.Fusco.Horace"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      int holder = 0;
      for(int j = 0; j < data.length;  j++){
          for(int i = j; i < data.length; i++){
              if(data[i] < holder){
                  holder = i;
              }
          }
          swap(data, j, holder);
      }  
  }
  
  private static void swap(int[] ary, int a, int b){
      int holder = ary[a];
      ary[a] = ary[b];
      ary[b] = holder;
  }

}