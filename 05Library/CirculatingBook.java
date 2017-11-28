public class CirculatingBook extends LibraryBook{
    String currentHolder;
    String dueDate;
    public CirculatingBook(String au, String ti, String is, String ca){
	super(au, ti, is, ca);
    }

    public void checkout(String person, String due){
	currentHolder = person;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder==null){
	    return "The book is on the shelves";
	} else {
	    return currentHolder;
	}
    }

    public String toString(){
	if (currentHolder == null){
	    return super.toString();
	}else{
	    return super.toString() + " , " + currentHolder + " , " + dueDate;
	}
    }

}
