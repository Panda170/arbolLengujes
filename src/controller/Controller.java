package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import entity.MyActions;
import logic.Logic;
import logic.Produccion;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener {
	
	private Logic logic;
	private MainWindow mainWindow;
	private Produccion produccion; 
	
	public Controller() {
		logic = new Logic();
		produccion = new Produccion();
		initMainWindows();
	}

	private void initMainWindows() {
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (MyActions.valueOf(e.getActionCommand())) {
		case DISABLE:
			mainWindow.disablePanel(button.getName());
			if (button.getName().equals(MyActions.TERMINAL_CODE.getCommand())) {
				logic.initTerminals(mainWindow.getTextInfo(MyActions.TERMINAL_CODE.getCommand()));
				mainWindow.setDatasInfoTerminal(logic.getTerminals());
			}else {
				logic.initNoTerminals(mainWindow.getTextInfo(MyActions.NO_TERMINAL_CODE.getCommand()));
				mainWindow.setDatasInfoNoTerminal(logic.getNoTerminals());
			}
			if (logic.canInitProductions()) {
				mainWindow.initPanel(logic.getNoTerminals());
			}else {
				mainWindow.enablePanel(button.getName());
			}
			break;
		case START:
			produccion.initProduccion(logic.getNoTerminals(), mainWindow.getList(), logic.getTerminals());
			mainWindow.setDatasInfoProducciones(produccion.getProducciones());
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		JTextField tf = (JTextField) e.getSource();
		if (Character.isLetter(c)) {
			tf.setText(tf.getText() + c+"-");
		} 
		e.consume();
	}
}