package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInfo extends JPanel {
	private JTextField info;
	private String placeHolder;
	private JButton nextJB;

	public PanelInfo(String titleT, String placeHolder) {
		this.placeHolder = placeHolder;
		initPanel(titleT);
		initcomponents();
	}

	private void initPanel(String titleT) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titleB = BorderFactory.createTitledBorder(titleT);
		titleB = BorderFactory.createTitledBorder(blackline, titleT);
		titleB.setTitleJustification(TitledBorder.CENTER);
		setBorder(titleB);
	}
	
	private void initcomponents() {
		boolean isActive = true;
		nextJB = new JButton("Siguiente");
		info = new JTextField(20) {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if (getText().length() == 0) {
					g.drawString(placeHolder, 5, 15);
					nextJB.setEnabled(false);
				}else {
					nextJB.setEnabled(true);
				}
			}
		};
		
		nextJB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Component i : getComponents()) {
					i.setEnabled(false);
				}
			}
		});
		add(info);
		add(nextJB);
		
	}
	
	

}
