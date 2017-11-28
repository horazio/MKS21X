public class ReferenceBook extends LibraryBook{
    String collection;
    public ReferenceBook(String au, String ti, String is, String ca, String co){
	super(au, ti, is, ca);
	collection = co;
    }
    public String getCollection(){
	return collection;
    }
    public void setCollection(String co){
	collection = co;
    }
    public void checkout(String patron, String due){
	System.out.println("You cannot check out a reference book!!");
    }
    public void returned(){
	System.out.println("reference books cannot be checked out, return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + " , " + collection;
    }
    

}
