import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUIActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("¾×¼Ç");
		else
			b.setText("Action");
	}
}
