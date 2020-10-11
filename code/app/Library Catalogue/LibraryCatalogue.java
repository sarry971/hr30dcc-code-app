package librarycatalogue;

import java.util.*;

public class LibraryCatalogue{
	
	Map<String, Book>  bookCollection = new HashMap<String, Book>();
	int currentDay = 0 ; 
	int lengthOfCheckOutPeriod = 7;
	double initialLateFee = 0.50;
	double feeperLateDay = 1.00;

	public LibraryCatalogue(Map<String, Book> collection){
		this.bookCollection = collection;
	}
	
	public LibraryCatalogue(Map<String, Book> collection , int lengthOfCheckOutPeriod, double initialLateFee, double feeperLateDay){
		this.bookCollection = collection;
		this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
		this.initialLateFee = initialLateFee;
		this.feeperLateDay = feeperLateDay;
	}
	
	
	//getters
	
	public int getcurrentDay(){
		return this.currentDay;
	}
	public Map<String, Book> getbookCollection(){
		return this.bookCollection;
	}
	public Book getBook(String bookTitle){
		return getbookCollection().get(bookTitle);
	}
	public int getlengthOfCheckOutPeriod(){
		return this.lengthOfCheckOutPeriod;
	}
	public double getinitialLateFee(){
		return this.initialLateFee;
	}
	public double getfeeperLateDay(){
		return this.feeperLateDay;
	}
	
	
	//setter
	public void nextDay(){
		currentDay++;
	}
	
	public void setDay(int day){
		currentDay = day;
	}
	
	//INSTACE METHOD;
	
	public void checkOut(String title){
		Book book = getBook(title);
		if (book.getisCheckedOut()){
			sorryBookAlreadyCheckedOut(book);
		}
		else{
			book.setIsCheckedOut(true, currentDay);
			System.out.println("Your just check out"+title+". It is due on day"+getcurrentDay()+ getlengthOfCheckOutPeriod()+".");
		}
	}
	
	public void returnBook (String title){
		Book book = getBook(title);
		int daysLate = currentDay - (book.getdayCheckedOut() + getlengthOfCheckOutPeriod());
		if (daysLate >0)	System.out.println("Your owe library $"+(getinitialLateFee() + daysLate* getfeeperLateDay())+ "because your book is "+daysLate+"days overdue");
		else System.out.println("Book returned. Thank you.");
	}
	
	public void sorryBookAlreadyCheckedOut(Book book){
		System.out.println ("Sorry," +book.getTitle()+" is already checked out."+
		"It should be back on day" +(book.getdayCheckedOut() + getlengthOfCheckOutPeriod())+".");
	
	}
	


	public static void main(String args[]){
		Map<String, Book> bookCollection = new HashMap<String, Book>();
		Book harry = new Book("Harry Potter", 34567, 9999);
		bookCollection.put("Harry Potter", harry);
		LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
		lib.checkOut ("Harry Potter");
		lib.nextDay();
		lib.nextDay();
		lib.checkOut("Harry Potter");
		lib.setDay(20);
		lib.returnBook("Harry Potter");
		lib.checkOut("Harry Potter");
	}
}