 abstract class Book{
    String author;
    String title;
    String ISBN;
    public Book(){
    }
    public Book(String au, String ti, String is){
	author = au;
	title = ti;
	ISBN = is;
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }
    
    public void setString(String au){
	author = au;
    }
    public void setTitle(String ti){
	title = ti;
    }
    public void setISBN(String is){
	ISBN = is;
    }
    public String toString(){
	return author + " , " + title + " , " + ISBN;
    }
    
}
