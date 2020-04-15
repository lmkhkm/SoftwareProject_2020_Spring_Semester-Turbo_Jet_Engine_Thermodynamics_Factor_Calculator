import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JavaGUI extends JFrame
{
	public JavaGUI() 
	{
		StandardAirFactorCalculator calc = new StandardAirFactorCalculator();
		
		setTitle("�� - �з�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentpane = new Container();
		contentpane = getContentPane();
		contentpane.setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel downPanel = new JPanel();
		
		JButton calculateButton = new JButton("Calculate");
		
		JTextField resultTextField = new JTextField(10);
		JTextField heightTextField = new JTextField(10);
		
		contentpane.add(leftPanel, BorderLayout.WEST);
		contentpane.add(rightPanel, BorderLayout.EAST);
		contentpane.add(downPanel, BorderLayout.SOUTH);
		
		leftPanel.add(new JLabel("�� �Է�"));
		leftPanel.add(heightTextField);
		rightPanel.add(calculateButton);
		downPanel.add(new JLabel("�з��� : "));
		downPanel.add(resultTextField);
		
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultTextField.setText(Float.toString(calc.Calculate(Float.parseFloat(heightTextField.getText()))));
				
			}
		});
		
		setSize(350,150);
		setVisible(true);
		
	}
	
}
