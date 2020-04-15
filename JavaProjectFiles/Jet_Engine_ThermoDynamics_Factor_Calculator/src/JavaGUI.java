import java.awt.*;
import javax.swing.*;

public class JavaGUI extends JFrame
{
	public JavaGUI() 
	{
		setTitle("고도 - 압력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentpane = new Container();
		contentpane = getContentPane();
		contentpane.setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel downPanel = new JPanel();
		
		JButton calculateButton = new JButton("Calculate");
		
		contentpane.add(leftPanel, BorderLayout.WEST);
		contentpane.add(rightPanel, BorderLayout.EAST);
		contentpane.add(downPanel, BorderLayout.SOUTH);
		
		leftPanel.add(new JLabel("고도 입력"));
		leftPanel.add(new JTextField(10));
		rightPanel.add(calculateButton);
		downPanel.add(new JLabel("압력은 : "));
		
		setSize(350,150);
		setVisible(true);
		
	}
	
}
