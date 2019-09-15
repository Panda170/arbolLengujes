package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import entity.MyActions;

@SuppressWarnings("serial")
public class PanelInfoCreate extends JPanel{
	
	private JLabel terminales;
	private JLabel terminalesData;
	private JLabel noTerminales;
	private JLabel noTerminalesData;
	private JLabel producciones;
	private JLabel produccionesData;

	public PanelInfoCreate() {
		setLayout(new FlowLayout(15));
		setSize(this.getWidth(), (int) (this.getHeight() * 0.15f));
		terminales = new JLabel("Terminales");
		noTerminales = new JLabel("No Terminales");
		producciones = new JLabel("Producciones");
		
		terminalesData = new JLabel();
		noTerminalesData = new JLabel();
		produccionesData = new JLabel();
		add(terminales);
		add(terminalesData);
		add(noTerminales);
		add(noTerminalesData);
		add(producciones);
		add(produccionesData);
	}
	
	public void addDataTerminal(String[] datas) {
		terminalesData.setText(getString(datas));
	}
	
	public void addDataNoTerminal(String[] datas) {
		noTerminalesData.setText(getString(datas));
	}
	
	public void addDataProduccion(String[] datas) {
		produccionesData.setText(getString(datas));
	}
	
	
	private String getString(String[] datas) {
		String out ="";
		for (int i = 0; i < datas.length; i++) {
			out+= datas[i] + " - ";
		}
		return out;
	}
}