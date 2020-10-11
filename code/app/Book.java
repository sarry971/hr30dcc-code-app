package librarycatalogue;

public class Book{
	
	//Properties, Fields, Global variable
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;	//whether the book is checked out or not 
	int dayCheckedOut = -1;
	
	//constructor
	public Book(String booktitle, int bookpageCount, int bookISBN){
		this.title = booktitle;	
		this.pageCount = bookpageCount;
		this.ISBN = bookISBN;
		isCheckedOut = false;
	}

	//getters -> INSTANCE METHODS
	public String getTitle(){
		return this.title;
	}
	
	public int getpageCount(){
		return this.pageCount;
	}
	public int getISBN(){
		return this.ISBN;
	}
	public boolean getisCheckedOut(){
		return this.isCheckedOut;
	}
	public int getdayCheckedOut(){
		return this.dayCheckedOut;
	}
	
	//setters -> 
	
	public void setIsCheckedOut(boolean newisCheckedOut, int currentdayCheckedOut){
		this.isCheckedOut = newisCheckedOut;
	}
	
	private void setdayCheckedOut (int day){
	this.dayCheckedOut = day;
	}
}