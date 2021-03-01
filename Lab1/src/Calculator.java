import javax.swing.JOptionPane;
public class Calculator{
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", 
            "Input the first number", JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", 
            "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum, difference, product, quotient;

        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;

        JOptionPane.showMessageDialog(null, 
            "Sum of 2 double numbers " + num1 + " and " + num2 + " is " + sum, 
            "Sum", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, 
            "Difference of 2 double numbers " + num1 + " and " + num2 + " is " + difference, 
            "Difference", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, 
            "Product of 2 double numbers " + num1 + " and " + num2 + " is " + product, 
            "Product", JOptionPane.INFORMATION_MESSAGE);

        if(num2 == 0){
            JOptionPane.showMessageDialog(null, 
                "Cannot perform calculation!\n 2nd number must be different from 0", 
                "Quotient", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, 
                "Quotient of 2 double numbers " + num1 + " and " + num2 + " is " + quotient, 
                "Quotient", JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);
    }
}