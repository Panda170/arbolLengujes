package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public MainWindow() {
		initWindow();
	}

	private void initWindow() {
		initFrame();
		initLayout();
		setVisible(true);
	}

	private void initLayout() {
		JPanel p = new JPanel(new GridLayout(1, 3));

		p.setSize(this.getWidth(), (int) (this.getHeight() * 0.15f));
		p.setPreferredSize(p.getSize());
		p.setBackground(Color.RED);
		p.add(new PanelInfo("Terminales", "a,b,c"));
		p.add(new PanelInfo("No Terminales", "S, A, T"));
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
