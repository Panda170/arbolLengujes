package views;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controller;
import entity.MyActions;

@SuppressWarnings("serial")
public class PanelDraw extends JPanel {

	private JTextField entrada;
	
	public PanelDraw(Controller controller) {
		setLayout(new GridLayout(2, 1));
		entrada = new JTextField();
		entrada.setSize(this.getWidth(), (int) (this.getHeight() * 0.15f));
		entrada.setBorder(new TitledBorder("Palabra"));
		add(entrada);
		
		
		JButton buscar = new JButton("Consultar");
		buscar.addActionListener(controller);
		buscar.setActionCommand(MyActions.BUSCAR.toString());
		add(buscar);
	}

	public String getWord() {
		return entrada.getText();
	}
	
}