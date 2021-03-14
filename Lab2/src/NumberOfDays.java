// Nhap nam va thang tu ban phim, in ra so ngay co trong thang do cua nam do

import java.util.Scanner;

public class NumberOfDays {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the year: ");
        int year = keyboard.nextInt();
        System.out.print("Enter the month: ");
        String month = keyboard.next();

        System.out.print(year + "/" + month + ": ");

        switch (month) {
            case "January":     case "Jan.":     case "Jan":     case "1":
            case "March":       case "Mar.":     case "Mar":     case "3":
            case "May":                                          case "5":
            case "July":                         case "Jul":     case "7":
            case "August":      case "Aug.":     case "Aug":     case "8":
            case "October":     case "Oct.":    case "Oct":     case "10":
            case "December":    case "Dec.":     case "Dec":     case "12":
                        
                System.out.println(" 31 days");
                break;
        
            case "April":       case "Apr.":     case "Apr":     case "4":
            case "June":                         case "Jun":     case "6":
            case "September":   case "Sept.":    case "Sep":     case "9":
            case "November":    case "Nov.":     case "Nov":     case "11":

                System.out.println(" 30 days");
                break;
        
            case "February":    case "Feb.":     case "Feb":     case "2":
            {
                if(year % 4 == 0 && year % 100 != 0 || year % 4 == 0) 
                    System.out.println(" 29 days");
                else
                    System.out.println(" 28 days");
            }
                
                break;
        
            default:
                System.out.println("Wrong! Please try again!");
                break;
        }

        System.exit(0);
    }
}
