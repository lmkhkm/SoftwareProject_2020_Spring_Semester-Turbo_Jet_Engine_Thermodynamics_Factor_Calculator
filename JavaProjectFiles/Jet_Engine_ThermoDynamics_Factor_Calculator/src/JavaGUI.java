import java.awt.*;
import javax.swing.*;

public class JavaGUI extends JFrame
{
	public JavaGUI() 
	{
		setTitle("�� - �з�");
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
		
		leftPanel.add(new JLabel("�� �Է�"));
		leftPanel.add(new JTextField(10));
		rightPanel.add(calculateButton);
		downPanel.add(new JLabel("�з��� : "));
		
		setSize(350,150);
		setVisible(true);
		
	}
	
}
