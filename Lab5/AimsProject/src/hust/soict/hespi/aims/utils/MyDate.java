package hust.soict.hespi.aims.utils;

import java.util.Scanner;
import java.util.Calendar;

public class MyDate {

	private int day;
	private int month;
	private int year;

	private final String[] monthName = { "January", "February", "March", "April", "May", "Jun", "July", "August",
			"September", "October", "November", "December" };
	private final String[] monthNameCompact = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
			"Nov", "Dec" };
	private final String[] digit = { "hundred", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirdteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "thirdty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public void setToCurrentTime() {
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
	}

	/**********************************************************************/

	public int getDay() {
		return day;
	}

	public boolean setDay(int day) {
		if (day < 0) {
			System.out.println("Invalid day! Set to Current Time.");
			setToCurrentTime();
			return false;
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day > 31) {
				System.out.println("Invalid day! Set to Current Time.");
				setToCurrentTime();
				return false;
			} else {
				this.day = day;
				return true;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30) {
				System.out.println("Invalid day! Set to Current Time.");
				setToCurrentTime();
				return false;
			} else {
				this.day = day;
				return true;
			}
		case 2:
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				if (day > 29) {
					System.out.println("Invalid day! Set to Current Time.");
					setToCurrentTime();
					return false;
				} else {
					this.day = day;
					return true;
				}
			} else {
				if (day > 28) {
					System.out.println("Invalid day! Set to Current Time.");
					setToCurrentTime();
					return false;
				} else {
					this.day = day;
					return true;
				}
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + month);
		}
	}

	public int getMonth() {
		return month;
	}

	public boolean setMonth(int month) {
		if (month < 1 || month > 12) {
			System.out.println("Month invalid! Set to Current Time.");
			setToCurrentTime();
			return false;
		} else {
			this.month = month;
			return true;
		}
	}

	public int getYear() {
		return year;
	}

	public boolean setYear(int year) {

		if (year < 0) {
			System.out.println("Year invalid! Set to Current Time.");
			setToCurrentTime();
			return false;
		} else {
			this.year = year;
			return true;
		}
	}

	/**********************************************************************/

	// Format: yyyy/mm/dd

	public MyDate() {
		setToCurrentTime();
	}

	public MyDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public void processString(String stringYear, String stringMonth, String stringDay) {

		setYear(Integer.parseInt(stringYear));

		switch (stringMonth.toLowerCase()) {
		case "january":
		case "jan.":
		case "jan":
		case "1":
		case "01":
			month = 1;
			break;
		case "february":
		case "feb.":
		case "feb":
		case "2":
		case "02":
			month = 2;
			break;
		case "march":
		case "mar.":
		case "mar":
		case "3":
		case "03":
			month = 3;
			break;
		case "april":
		case "apr.":
		case "apr":
		case "4":
		case "04":
			month = 4;
			break;
		case "may":
		case "5":
		case "05":
			month = 5;
			break;
		case "june":
		case "jun":
		case "6":
		case "06":
			month = 6;
			break;
		case "july":
		case "jul":
		case "7":
		case "07":
			month = 7;
			break;
		case "august":
		case "aug.":
		case "aug":
		case "8":
		case "08":
			month = 8;
			break;
		case "september":
		case "sept.":
		case "sep":
		case "9":
		case "09":
			month = 9;
			break;
		case "october":
		case "oct.":
		case "oct":
		case "10":
			month = 10;
			break;
		case "november":
		case "nov.":
		case "nov":
		case "11":
			month = 11;
			break;
		case "december":
		case "dec.":
		case "dec":
		case "12":
			month = 12;
			break;
		default: {
			System.out.println("Month invalid! Set to Current Time.");
			setToCurrentTime();
		}
		}

		int stringLength = stringDay.length();

		if (stringLength == 1 || stringLength == 2) {
			setDay(Integer.parseInt(stringDay));
		} else if (stringLength == 3) {
			setDay(Integer.parseInt(stringDay, 0, 1, 10));
		} else if (stringLength == 4) {
			setDay(Integer.parseInt(stringDay, 0, 2, 10));
		} else {
			System.out.println("Day invalid! Set to Current Time.");
			setToCurrentTime();
		}
	}

	public MyDate(String InputDate) { // E.g: 2019 February 18th
		String[] parts = InputDate.split(" ");
		String stringYear = parts[0];
		String stringMonth = parts[1];
		String stringDay = parts[2];
		processString(stringYear, stringMonth, stringDay);
	}

	public void accept() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the date in format yyyy/mm/dd: (E.g: 2019 February 18th or 2019 FEB. 18, etc...)");
		String Input = keyboard.nextLine();
		String[] parts = Input.split(" ");
		String stringYear = parts[0];
		String stringMonth = parts[1];
		String stringDay = parts[2];
		// System.out.println(Input);
		processString(stringYear, stringMonth, stringDay);
	}

	// Week 4

	// Hàm xử lý chuỗi có dấu "-" (E.g: forty-five), trả v�? -1 nếu không đ�?c được
	public int subFunction(String str) {
		int result = 0, i;
		String[] parts = str.split("-");

		if (parts.length == 2) {
			for (i = 20; i < 27; i++) {
				if (parts[0].toLowerCase().equals(digit[i].toLowerCase())) {
					result = (i - 18) * 10;
					break;
				}
			}

			if (result == 0) {
				return -1;
			}

			for (i = 0; i < 10; i++) {
				if (parts[1].toLowerCase().equals(digit[i].toLowerCase())) {
					result = result + i;
					break;
				}
			}
			if (result == 0) {
				return -1;
			}
			return result;

		} else {
			for (i = 0; i < 27; i++) {
				if (str.toLowerCase().equals(digit[i].toLowerCase())) {
					if (i <= 20) {
						return i;
					} else {
						return (i - 18) * 10;
					}
				}
			}
			return -1;
		}
	}

	// �?�?c string year, trả v�? -1 nếu không đ�?c được
	public int readYear(String stringYear) {
		int i, year = 0, check;
		String[] parts = stringYear.split(" ");
		// Tách chuỗi bằng dấu " ", có 2 trư�?ng hợp: có 3 chuỗi (E.g: three hundred
		// twenty) và có 2 chuỗi (E.g: nineteen forty-five)
		if (parts.length > 2) {
			// part[] có 3 phần tử -> số có 3 chữ số (E.g: five hundred sixty-five) hoặc có
			// 4 chữ số nhưng có 2 số 0 ở giữa (E.g: one thousand two)
			if (parts[1].equals("hundred")) {
				for (i = 1; i < 10; i++) {
					if (parts[0].toLowerCase().equals(digit[i].toLowerCase())) {
						year = i * 100;
						break;
					}
				}
			} else if (parts[1].toLowerCase().equals("thousand".toLowerCase())) {
				for (i = 1; i < 10; i++) {
					if (parts[0].toLowerCase().equals(digit[i].toLowerCase())) {
						year = i * 1000;
						break;
					}
				}
			}

			if (year == 0) {
				return -1;
			}
			check = subFunction(parts[2]);
			if (check == -1) {
				return -1;
			}
			return year + check;
		} else if (parts.length == 2) {
			// part[] có 2 phần tử -> số có 4 chữ số (E.g: twenty twenty-one) hoặc 3 chữ số
			// nhưng tròn trăm (E.g: one hundred)
			year = subFunction(parts[0]) * 100;
			if (year < 0) {
				return -1;
			}
			check = subFunction(parts[1]);
			if (check == -1) {
				return -1;
			}
			return year + check;
		} else {
			// part[] có 1 phần tử -> số có 1 hoặc 2 chữ số
			return subFunction(parts[0]);
		}
	}

	// �?�?c string month, trả v�? -1 nếu không đ�?c được
	public int readMonth(String stringMonth) {
		for (int i = 0; i < 12; i++) {
			if (stringMonth.toLowerCase().equals(monthName[i].toLowerCase())) {
				return i + 1;
			}
		}
		return -1;
	}

	public int readDay(String stringDay) {
		return subFunction(stringDay);
	}

	public MyDate(String day, String month, String year) {
		setYear(readYear(year));
		setMonth(readMonth(month));
		setDay(readDay(day));
	}

	public void print() {
		System.out.print(monthName[getMonth() - 1] + " ");
		int day = getDay(), leatsNumber = day % 10;
		System.out.print(day);
		switch (leatsNumber) {
		case 1:
			System.out.print("st ");
			break;
		case 2:
			System.out.print("nd ");
			break;
		case 3:
			System.out.print("rd ");
			break;

		default:
			System.out.print("th ");
			break;
		}
		System.out.println(getYear());
	}

	// In ngày tháng năm với các format khác nhau do ngư�?i dùng ch�?n trong console

	public void printWithDifferentFormats() {

		int day = getDay(), month = getMonth(), year = getYear();
		String stringMonth = monthNameCompact[month + 1];
		String stringDayNumber, stringMonthNumber;

		if (day < 10) {
			stringDayNumber = "0" + String.valueOf(day);
		} else {
			stringDayNumber = String.valueOf(day);
		}

		if (month < 10) {
			stringMonthNumber = "0" + String.valueOf(month);
		} else {
			stringMonthNumber = String.valueOf(month);
		}

		while (true) {
			System.out.println("Choose the format:");
			System.out.println("\t 1. yyyy-MM-dd");
			System.out.println("\t 2. d/M/yyyy");
			System.out.println("\t 3. dd-MMM-yyyy");
			System.out.println("\t 4. MMM d yyyy");
			System.out.println("\t 5. mm-dd-yyyy");
			System.out.println("\t 6. Quit");
			System.out.print("Choose your option: ");

			Scanner keyboard = new Scanner(System.in);
			String option = keyboard.next();

			System.out.println();

			switch (option) {
			case "1":
				// yyyy-MM-dd
				System.out.println(year + "-" + stringMonthNumber + "-" + stringDayNumber);
				break;

			case "2":
				// d/M/yyyy
				System.out.println(day + "/" + month + "/" + year);
				break;

			case "3":
				// dd-MMM-yyyy
				System.out.println(stringDayNumber + "-" + stringMonth + "-" + year);
				break;

			case "4":
				// MMM d yyyy
				System.out.println(stringMonth + " " + day + " " + year);
				break;

			case "5":
				// mm-dd-yyyy
				System.out.println(stringMonthNumber + "-" + stringDayNumber + "-" + year);
				break;

			case "6":
				return;

			default:
				System.out.println("Error! Invalid input!");
				break;
			}
			System.out.println("\n***********************\n");
		}
	}

}
