package views;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

@SuppressWarnings("serial")
public class PanelInfoProductions extends PanelHeader{

	public PanelInfoProductions(String titleT, Controller controller) {
		super(titleT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	
	
	public void initPanel(String[] noTerminalsList) {
		for (int i = 0; i < noTerminalsList.length; i++) {
			JPanel p = new JPanel();
			JTextField tf = new JTextField(20);
			tf.setName(noTerminalsList[i]);
			p.add(new JLabel(noTerminalsList[i]));
			p.add(tf);
			p.setName(noTerminalsList[i] + "_panel");
			add(p);
		}
		for (Component i : getComponents()) {
			System.out.println(i.getName());
		}
		revalidate();
	}

}
