import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JavaGUI extends JFrame
{
	public JavaGUI() 
	{
		StandardAirFactorCalculator calc = new StandardAirFactorCalculator();
		
		setTitle("고도 - 압력");
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
		
		leftPanel.add(new JLabel("고도 입력"));
		leftPanel.add(heightTextField);
		rightPanel.add(calculateButton);
		downPanel.add(new JLabel("압력은 : "));
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
