package views;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import entity.MyActions;

@SuppressWarnings("serial")
public class PanelInfoProductions extends PanelHeader {
	
	private ArrayList<JTextField> myTextFields;
	private Controller controller;
	

	public PanelInfoProductions(String titleT, Controller controller) {
		super(titleT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.controller = controller;
		myTextFields = new ArrayList<>();
	}

	public void initPanel(String[] noTerminalsList) {
		removeAll();
		for (int i = 0; i < noTerminalsList.length; i++) {
			JPanel p = new JPanel();
			JTextField tf = new JTextField(20);
			tf.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) { 
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() != 8 && e.getKeyCode() != 16 && e.getKeyCode() != 17 && e.getKeyCode() != 20 && e.getKeyCode() !=18) {
						((JTextField) e.getSource()).setText(((JTextField) e.getSource()).getText() + "|");
					}
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			tf.setName(noTerminalsList[i] + "_tf");
			p.add(new JLabel(noTerminalsList[i]));
			p.add(tf);
			myTextFields.add(tf);
			p.setName(noTerminalsList[i] + "_panel");
			add(p);
		}
		JButton btIniciar = new JButton("Comenzar");
		btIniciar.addActionListener(controller);
		btIniciar.setActionCommand(MyActions.START.toString());
		add(btIniciar);
		revalidate();
	}

	public ArrayList<JTextField> getList(){
		return myTextFields;
	}
}