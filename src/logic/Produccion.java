package logic;

import views.MainWindow;

public class Produccion {

	private String[][] producciones;
	
	public Produccion() {
		producciones = new String[0][0];
	}
	
	public void initProduccion(String[] noTerminal, String[] datas, String[] terminal) {
		if (verifyProduccion(noTerminal, datas, terminal)) {
			producciones = new String[noTerminal.length][20];
			fullMatriz();
			for (int i = 0; i < noTerminal.length; i++) {
				producciones[i][0] = noTerminal[i];
				String[] split = datas[i].split("|");
				for (int j = 0; j < split.length; j++) {
					if (!split[j].equals("|")) {
						producciones[i][j+1] = split[j];
					}
				}
			}	
		}
		else {
			MainWindow.showMessage("Hay un simbolo Erroneo en las producciones");
		}
	}
	
	private void fullMatriz() {
		for (int i = 0; i < producciones.length; i++) {
			for (int j = 0; j < producciones[i].length; j++) {
				producciones[i][j] = "";
			}
		}
	}
	
	private boolean verifyProduccion(String[] noTerminal, String[] datas, String[] terminal) {
		for (int i = 0; i < datas.length; i++) {
			String[] datSplit = datas[i].split("|");
			for (int k = 0; k < datSplit.length; k++) {
				boolean[] isTerminal = new boolean[10];
				boolean[] isnoTerminal = new boolean[10];
				if (!datSplit[k].equals("|")) {
					isnoTerminal = new boolean[noTerminal.length];
					for (int j = 0; j < noTerminal.length; j++) {
						if (!datSplit[k].equals(noTerminal[j])) {
							isnoTerminal[j] = false;
						}else {
							isnoTerminal[j] = true;
						}
					}
					isTerminal = new boolean[terminal.length];
					for (int j = 0; j < terminal.length; j++) {
						if (!datSplit[k].equals(terminal[j])) {
							isTerminal[j] = false;
						}else {
							isTerminal[j] = true;
						}
					}
					if (!(calculingBoolean(isnoTerminal) || calculingBoolean(isTerminal))) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean calculingBoolean(boolean[] boole) {
		boolean out = false;
		for (boolean b : boole) {
			out = out || b;
		}
		return out;
	}
	
	private String[] full(String[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = "";
		}
		return a; 
	}
	
	public String[] getProducciones() {
		String[] out = new String[producciones.length];
		full(out);
		for (int i = 0; i < producciones.length; i++) {
			System.out.println(producciones[i][0]);
			out[i] += producciones[i][0] + ": ";
			for (int j = 1; j < producciones[i].length; j++) {
				if (!producciones[i][j].equals("")) {
					out[i] += producciones[i][j] + " | ";
					System.out.println(out[i]);
				}
			}
		}
		return out;
	}
}