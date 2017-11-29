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
    

    





}
