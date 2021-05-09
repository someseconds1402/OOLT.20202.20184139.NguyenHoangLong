import javax.swing.JOptionPane;

public class SecondDegreeEquation {
    public static void main(String[] args){

        JOptionPane.showMessageDialog(null, "The equation has the form: " 
            + "\nax^2 + bx + c = 0 (a != 0)\nPress OK to continue!");
        String strNum1, strNum2, strNum3;

        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ");
        strNum2 = JOptionPane.showInputDialog(null, "Please input b: ");
        strNum3 = JOptionPane.showInputDialog(null, "Please input c: ");

        double a, b, c, delta, x1, x2;
        a = Double.parseDouble(strNum1);
        b = Double.parseDouble(strNum2);
        c = Double.parseDouble(strNum3);

        delta = b*b - 4*a*c;

        if(a <= 0)
            JOptionPane.showMessageDialog(null, "Error: a must be greater than 0!");
        else{
            if(delta < 0)
                JOptionPane.showMessageDialog(null, "The equation has no solution!");
            else if(delta == 0)
                JOptionPane.showMessageDialog(null, "The equations has double root: " + -b/(2*a));
            else{
                x1 = (-b + Math.sqrt(delta)) / (2*a);
                x2 = (-b - Math.sqrt(delta)) / (2*a);
                JOptionPane.showMessageDialog(null, "The equations has has two distinct roots: " + 
                    "\n x1 = " + x1 + "\n x2 = " + x2);
            }
        }

        
        System.exit(0);
    }
}
