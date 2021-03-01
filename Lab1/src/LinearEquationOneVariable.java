import javax.swing.JOptionPane;

public class LinearEquationOneVariable {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "The equation has the form: ax + b = 0 \nPress OK to continue!");

        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", 
            "Input the first number", JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", 
            "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double a, b;

        a = Double.parseDouble(strNum1);
        b = Double.parseDouble(strNum2);

        if(a == 0){
            JOptionPane.showMessageDialog(null, "The equation has no solution");
        }
        else {
            JOptionPane.showMessageDialog(null, "x = " + -a/b);
        }

            System.exit(0);
    }
}
