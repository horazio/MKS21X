abstract Class Book{
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
    public setAuthor(String au){
	author = au;
    }
    public setTitle(String ti){
	title = ti;
    }
    public setISBN(String is){
	ISBN = is;
    }
    public String toString(){
	return author + " , " + title + " , " + ISBN;
    }
    














}
