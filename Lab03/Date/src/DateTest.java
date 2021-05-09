
// Format: yyyy/mm/dd

public class DateTest {

	public static void main(String[] args) {

		MyDate currentTime = new MyDate();
		currentTime.print();

		MyDate timeTest = new MyDate(32, 11, 2020);
		timeTest.print();

		MyDate timeTest2 = new MyDate("1990 February 14th");
		timeTest2.print();

		MyDate timeTest3 = new MyDate("2010 Aug 1st");
		timeTest3.print();

		MyDate timeTest4 = new MyDate("1234 6 23");
		timeTest4.print();

		MyDate timeTest5 = new MyDate();
		timeTest5.accept();
		timeTest5.print();

	}

}
