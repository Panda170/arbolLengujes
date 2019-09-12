package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private PanelInfo panelTerminals;
	private PanelInfo panelNoTerminals;
	private PanelInfoProductions panelProductions;

	public MainWindow(Controller controller) {
		initWindow(controller);
	}
	
	public void disablePanel(String name) {
		if (name.equals("1")) {
			panelTerminals.disablePanel();
			panelTerminals.setEnabled(false);
		}else {
			panelNoTerminals.disablePanel();
			panelNoTerminals.setEnabled(false);
		}
	}

	private void initWindow(Controller controller) {
		initFrame();
		initLayout(controller);
		setVisible(true);
	}

	private void initLayout(Controller controller) {
		JPanel p = new JPanel(new GridLayout(1, 3));
		panelTerminals = new PanelInfo("Terminales", "a,b,c", controller);
		panelTerminals.setButtoname("1");
		panelNoTerminals = new PanelInfo("No Terminales", "S, A, T", controller);
		panelNoTerminals.setButtoname("2");
		panelProductions = new PanelInfoProductions("Producciones", "E = []", controller);
		p.setSize(this.getWidth(), (int) (this.getHeight() * 0.15f));
		p.setPreferredSize(p.getSize());
		p.setBackground(Color.RED);
		p.add(panelTerminals);
		p.add(panelNoTerminals);
		p.add(panelProductions);
		add(p, BorderLayout.NORTH);
	}

	private void initFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		int screenHeight = (int) (screenSize.height * 0.8f);
		int screenWidth = (int) (screenSize.width * 0.75f);
		setSize(screenWidth, screenHeight);
		setLocationRelativeTo(null);

	}
}
