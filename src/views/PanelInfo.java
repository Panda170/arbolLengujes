package views;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.Controller;
import entity.MyActions;

@SuppressWarnings("serial")
public class PanelInfo extends PanelHeader {
	private JTextField info;
	private String placeHolder;
	private JButton nextJB;
	private boolean panelIsActive;

	public PanelInfo(String titleT, String placeHolder, Controller controller) {
		super(titleT);
		this.placeHolder = placeHolder;
		panelIsActive = true;
		initcomponents(controller);
	}

	public void disablePanel() {
		panelIsActive = false;
		for (Component i : getComponents()) {
			i.setEnabled(false);
		}
	}
	
	public void enablePanel() {
		panelIsActive = true;
		for (Component i : getComponents()) {
			i.setEnabled(true);
		}
	}
	public void setButtoname(String name) {
		nextJB.setName(name);
	}
	
	public String getTextInfo() {
		return info.getText();
	}
	private void initcomponents(Controller controller) {
		nextJB = new JButton("Siguiente");
		nextJB.setActionCommand(MyActions.DISABLE.toString());
		info = new JTextField(20) {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if (panelIsActive) {
					if (getText().length() == 0) {
						g.drawString(placeHolder, 5, 15);
						nextJB.setEnabled(false);
					} else {
						info.setEnabled(true);
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