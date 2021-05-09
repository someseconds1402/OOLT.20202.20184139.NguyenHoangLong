import javax.swing.JOptionPane;

public class LinearEquationTwoVariable {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "The equation has the form: \n" 
            + "ax  + by  = c  \n" + "a'x + b'y = c'" + "\nPress OK to continue!");
    
        String strNum1_a, strNum1_b, strNum1_c; 
        String strNum2_a, strNum2_b, strNum2_c;

        strNum1_a = JOptionPane.showInputDialog(null, "Please input : a");
        strNum1_b = JOptionPane.showInputDialog(null, "Please input : b");
        strNum1_c = JOptionPane.showInputDialog(null, "Please input : c");
        strNum2_a = JOptionPane.showInputDialog(null, "Please input : a'");
        strNum2_b = JOptionPane.showInputDialog(null, "Please input : b'");
        strNum2_c = JOptionPane.showInputDialog(null, "Please input : c'");
    
        double a1, b1, c1, a2, b2, c2;

        a1 = Double.parseDouble(strNum1_a);
        b1 = Double.parseDouble(strNum1_b);
        c1 = Double.parseDouble(strNum1_c);
        a2 = Double.parseDouble(strNum2_a);
        b2 = Double.parseDouble(strNum2_b);
        c2 = Double.parseDouble(strNum2_c);

        double D, Dx, Dy;
        D = a1*b2 - a2*b1;
        Dx = c1*b2 - c2*b1;
        Dy = a1*c2 - a2*c1;

        if(D == 0){
            if(Dx == Dy)
                JOptionPane.showMessageDialog(null, "The equations has infinitely many solutions!");
            else
                JOptionPane.showMessageDialog(null, "The equation has no solution!");
        }
        else{
            JOptionPane.showMessageDialog(null, "The equations has a unique solution:\n"
                + "x = " + Dx/D + "\ny = " + Dy/D);
        }

        System.exit(0);
    }
}
