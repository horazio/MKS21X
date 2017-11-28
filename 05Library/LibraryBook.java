abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    String callNumber;

    public LibraryBook(String au, String ti, String is, String ca){
	super(au, ti, is);
	callNumber = ca;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String ca){
	callNumber = ca;
    }
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public int compareTo(LibraryBook other){
	return callNumber.compareTo(other.getCallNumber());


    }
    
    public String toString(){
	return super.toString() + " , " + callNumber + " , " + this.circulationStatus();
    }




}
