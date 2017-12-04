import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    SuperArray myArray;
    int upTo;
    public SuperArrayIterator(SuperArray a){
        myArray = a;
        upTo = 0;
    }
    
    public boolean hasNext(){
        return upTo < myArray.size();
    }
    
    public String next(){
        return myArray.get(upTo++);
        
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
}