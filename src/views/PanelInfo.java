package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Controller;
import entity.MyActions;

@SuppressWarnings("serial")
public class PanelInfo extends JPanel {
	private JTextField info;
	private String placeHolder;
	private JButton nextJB;
	private boolean panelIsActive;

	public PanelInfo(String titleT, String placeHolder, Controller controller) {
		this.placeHolder = placeHolder;
		panelIsActive = true;
		initPanel(titleT);
		initcomponents(controller);
	}

	private void initPanel(String titleT) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titleB = BorderFactory.createTitledBorder(titleT);
		titleB = BorderFactory.createTitledBorder(blackline, titleT);
		titleB.setTitleJustification(TitledBorder.CENTER);
		setBorder(titleB);
	}

	public void disablePanel() {
		panelIsActive = false;
		for (Component i : getComponents()) {
			i.setEnabled(false);
		}
	}
	public void setButtoname(String name) {
		nextJB.setName(name);
	}
	
	public JButton getNextJB() {
		return nextJB;
	}

	private void initcomponents(Controller controller) {
		nextJB = new JButton("Siguiente");
		nextJB.setActionCommand(MyActions.DISABLE.name());
		info = new JTextField(20) {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if (panelIsActive) {
					if (getText().length() == 0) {
						g.drawString(placeHolder, 5, 15);
						nextJB.setEnabled(false);
					} else {
						nextJB.setEnabled(true);
					}
				}

			}
		};

		nextJB.addActionListener(controller);
		info.addKeyListener(controller);
		add(info);
		add(nextJB);

	}

}
