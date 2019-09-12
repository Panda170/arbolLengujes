package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelHeader extends JPanel{
	public PanelHeader(String titleT) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titleB = BorderFactory.createTitledBorder(titleT);
		titleB = BorderFactory.createTitledBorder(blackline, titleT);
		titleB.setTitleJustification(TitledBorder.CENTER);
		setBorder(titleB);
	}
	
}
