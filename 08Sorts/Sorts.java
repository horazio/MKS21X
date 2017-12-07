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
          holder = j;
          for(int i = j; i < data.length; i++){
              if(data[i] < data[holder]){
                  holder = i;
                  //System.out.println(holder + " -----" + data[holder] + "----" + i);
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

    public static void main(String[] args){
        int[] a = {9, 8, 7, 6, -5, 4, 3, 2, -1};
        selectionSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}