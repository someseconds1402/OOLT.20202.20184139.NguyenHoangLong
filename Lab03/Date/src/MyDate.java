import java.util.Scanner;
import java.util.Calendar;

public class MyDate {

	private int day;
	private int month;
	private int year;

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

	public void processString(String InputDate) {
		String[] parts = InputDate.split(" ");
		String stringYear = parts[0];
		String stringMonth = parts[1];
		String stringDay = parts[2];

		setYear(Integer.parseInt(stringYear));

		switch(stringMonth.toLowerCase()) {
			case "january":     case "jan.":     case "jan":     case "1":     case "01":
				month = 1;
				break;
			case "february":    case "feb.":     case "feb":     case "2":     case "02":
				month = 2;
				break;
			case "march":       case "mar.":     case "mar":     case "3":     case "03":
				month = 3;
				break;
			case "april":       case "apr.":     case "apr":     case "4":     case "04":
				month = 4;
				break;
			case "may":                                          case "5":     case "05":
				month = 5;
				break;
			case "june":                         case "jun":     case "6":     case "06":
				month = 6;
				break;
			case "july":                         case "jul":     case "7":     case "07":
				month = 7;
				break;
			case "august":      case "aug.":     case "aug":     case "8":     case "08":
				month = 8;
				break;
			case "september":   case "sept.":    case "sep":     case "9":     case "09":
				month = 9;
				break;
			case "october":     case "oct.":     case "oct":     case "10":
				month = 10;
				break;
			case "November":    case "Nov.":     case "Nov":     case "11":
				month = 11;
				break;
			case "December":    case "Dec.":     case "Dec":     case "12":
				month = 12;
				break;
			default: {
				System.out.println("Month invalid! Set to Current Time.");
				setToCurrentTime();
			}
		}

		int stringLength = stringDay.length();

		if(stringLength == 1 || stringLength == 2) {
			setDay(Integer.parseInt(stringDay));
		}
		else if(stringLength == 3) {
			setDay(Integer.parseInt(stringDay, 0, 1, 10));
		}
		else if(stringLength == 4) {
			setDay(Integer.parseInt(stringDay, 0, 2 , 10));
		}
		else {
			System.out.println("Day invalid! Set to Current Time.");
			setToCurrentTime();
		}
	}

	public MyDate(String InputDate) { // E.g: 2019 February 18th
		processString(InputDate);
	}

	public void accept() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the date in format yyyy/mm/dd: (E.g: 2019 February 18th or 2019 FEB. 18, etc...)");
		String Input = keyboard.nextLine();
		// System.out.println(Input);
		processString(Input);
	}

	public void print() {
		System.out.println(year + "/" + month + "/" + day + "\n");
	}

}
