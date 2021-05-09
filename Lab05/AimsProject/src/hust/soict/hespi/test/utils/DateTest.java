package hust.soict.hespi.test.utils;
import hust.soict.hespi.*;
import hust.soict.hespi.aims.utils.MyDate;

// Format: yyyy/mm/dd

public class DateTest {

	public static void main(String[] args) {

		 MyDate currentTime = new MyDate();
		 currentTime.print();

		 MyDate timeTest = new MyDate(1, 1, 1855);
		 timeTest.print();

		 MyDate timeTest2 = new MyDate("2090 February 14th");
		 timeTest2.print();

		 MyDate timeTest3 = new MyDate("2010 Aug 1st");
		 timeTest3.print();

		 MyDate timeTest4 = new MyDate("1234 6 23");
		 timeTest4.print();

		// MyDate timeTest5 = new MyDate();
		// timeTest5.accept();
		// timeTest5.print();

		/*****************************************************************/

		// week 4

		// G�?i method readYear với các giá trị khác nhau
		// MyDate timeTest6 = new MyDate();
		// timeTest6.print();
		// System.out.println(timeTest6.readYear("twenTy seventy-seven"));
		// System.out.println(timeTest6.readYear("three huNdred"));
		// System.out.println(timeTest6.readYear("nineteen seVENty-five"));
		// System.out.println(timeTest6.readYear("forty-ThReE twenty-one"));
		// System.out.println(timeTest6.readYear("sixty-five"));
		// System.out.println(timeTest6.readYear("seven hundred fifty-three"));
		// System.out.println(timeTest6.readYear("two thousand three"));

		// �?�?c date "5/6/2345" với các format khác nhau
		// MyDate timeTest7 = new MyDate("five", "jun", "twenty-three forty-five");
		// timeTest7.print();
		// timeTest7.printWithDifferentFormats();

		// Tạo object dateList là mảng các Object MyDate bên trên, in ra mảng trước và sau sắp xếp
		// DateUtils dateList = new DateUtils();
		// dateList.addDate(currentTime, timeTest, timeTest2, timeTest3, timeTest4,
		// 	timeTest7);
		// dateList.print();

		// System.out.println("\n**************************\n");
		// dateList.sortDateList();
		// dateList.print();

		// Tạo Object list là mảng các MyDate được tạo ngẫu nhiên, in ra mảng trước và sau khi sắp xếp
		// DateUtils list = new DateUtils(10);
		// list.print();

		// System.out.println("\n**************************\n");
		// list.sortDateList();
		// list.print();

	}

}
