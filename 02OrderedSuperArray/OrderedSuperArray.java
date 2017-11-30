public class OrderedSuperArray extends SuperArray{

    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(int capacity){
        super(capacity);
    }

    public OrderedSuperArray(String[] ary){
        super();
        for(int x = 0; x < ary.length; x++){
            this.add(ary[x]);
        }
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();  
    }
    /*call the proper add.*/
    public void add(int index, String value){
        add(value);
    }

    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
        //add to the correct spot.
        //you may still use super.add(index,value)
        super.add(this.rightSpaceBinary(value), value);
        return true;
    }

    
    public int rightSpace(String value){
        int pos = this.size();
        for(int x = 0; x < this.size(); x++){
            if(value.compareTo(this.get(x)) < 0){
                pos = x;
                return pos;
            }
        }
         return pos;
    }
    
    public int rightSpaceBinary(String value){
        int lower = 0;
        int upper = this.size();
        int middle = 0;    
        if( upper > 0 && value.compareTo(this.get(0)) < 0){
            return 0;
        }
        while(upper - lower > 1){
            middle = (lower + upper) / 2;
            if(value.compareTo(this.get(middle)) < 0){
                upper = middle;
            }
            else{
                lower = middle;
            }
        }
        return upper;
    }
    
    public int indexOfBinary(String element){
        if(this.contains(element)){
            int pos = this.rightSpaceBinary(element);
            while(pos > 0 && (this.get(pos - 1)).equals(element) ){
                pos--;
            }
        return pos;
        }
        return -1;
    }
    
    public int lastIndexOfBinary(String element){
        if(this.contains(element)){
            int pos = this.rightSpaceBinary(element);
            while(pos < this.size() - 1 && (this.get(pos + 1)).equals(element) ){
                pos++;
            }
            pos--;
            return pos;
        }
        return -1;
    }

}
