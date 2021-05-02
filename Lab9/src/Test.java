

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {

	public static void main(String[] args) {
		JPanel mainJPanel = new JPanel(new FlowLayout());
		mainJPanel.add(new JLabel("Hello world!"));
		mainJPanel.add(new JButton("Button"));
		
		
	}

}
