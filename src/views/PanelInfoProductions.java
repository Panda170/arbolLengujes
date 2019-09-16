package views;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

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
					if (e.getKeyCode() == 32) {
						((JTextField) e.getSource()).setText((((JTextField) e.getSource()).getText()).substring(0, ((JTextField) e.getSource()).getText().length()-1) + "|");
					}
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			tf.setName(noTerminalsList[i] + "_tf");
			if (i == 0) {
				p.add(new JLabel("-->" + noTerminalsList[i]));	
			}else {
				p.add(new JLabel(noTerminalsList[i]));
			}
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

	public String[] getList(){
		String[] out = new String[myTextFields.size()];
		for (int i = 0; i < myTextFields.size(); i++) {
			out[i] = myTextFields.get(i).getText();
		}
		return out;
	}
}