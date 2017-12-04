import java.util.*;
public class SuperArray implements Iterable<String>{

    private String[] data;
    private int size;

    public SuperArray(int size){
        data = new String[size];

    }
    public SuperArray(){
        this(10);
    }

    public Iterator<String> iterator(){
        return new SuperArrayIterator(this);
    }
    public void clear(){
        data = new String[data.length];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    // this should be private but is public for testing purposes
    public void resize(){
        if (size == data.length){
            String[] nextArray = new String[data.length * 2];
            for(int count = 0; count < data.length; count++){
                nextArray[count] = data[count];

            }
            data = nextArray;
        }
    }
    public boolean add(String element){
        this.resize();
        data[size] = element;
        size++;
        return true;
    }


    public String toString(){
        String stringRep = "[ ";
        for(int count = 0; count < size; count++){
            stringRep += " " +  data[count] + ", ";
        }
        return stringRep + "]";
    }

    public String get(int index){
        if (index < 0 || index >= size){
            System.out.println("No! Index out of Range");
            return null;
        }
        return data[index];
    }

        public String set(int index, String element){
        if (index < size && index >= 0){
            String holder = data[index];
            data[index] = element;
            return holder;
        }
        else{
            System.out.println("No! Index out of Range");
            return null;
        }
    }
    
    
    
    public boolean contains(String target){
        for(int count = 0; count < size; count++){
            if (data[count].equals(target)){
                return true;
            }
        }
        return false;
    }
    
    public int indexOf(String element){
        for(int count = 0; count < size; count++){
            if (data[count].equals(element)){
                return count;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element){
        for(int count = size - 1; count >= 0; count--){
            if (data[count].equals(element)){
                return count;
            }
        }
        return -1;
    }

    public void add(int index, String element){
        if ( index < 0 || index > size){
            System.out.println("No! Index out of Range");
        }
        else{ 
            this.resize();
            for(int count = size; count > index; count--){
                data[count] = data[count - 1];
            }
            data[index] = element;
            size++;
        }
    }
    
    public String remove(int index){
        if(size == 0 || index < 0 || index >= size){
            System.out.println("No! Index out of Range or length of array 0");
            return null;
        }
        this.resize();
        String holder = data[index];
        for(int count = index; count < size; count++){
            data[count] = data[count + 1];
        }
        size--;
        return holder;
    }
    
    public boolean remove(String element){
        if(this.contains(element)){
            this.remove(this.indexOf(element));
            return true;
        }
        return false;
    }
}
