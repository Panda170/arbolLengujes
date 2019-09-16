package logic;

import java.util.regex.Pattern;

import views.MainWindow;

public class Produccion {

	private String[][] producciones;
	
	public Produccion() {
		producciones = new String[0][0];
	}
	
	
	public String[][] getProduccionMatriz() {
		return producciones;
	}

	public void initProduccion(String[] noTerminal, String[] datas, String[] terminal) {
		if (verifyProduccion(noTerminal, datas, terminal)) {
			producciones = new String[noTerminal.length][];
			for (int i = 0; i < noTerminal.length; i++) {
				String separador = Pattern.quote("|");
				String[] outacept = datas[i].split(separador);
				producciones[i] = new String[outacept.length+1];
				producciones[i][0] = noTerminal[i];
				for (int j = 0; j < outacept.length; j++) {
					producciones[i][j+1] = outacept[j];
				}
			}	
		}
		else {
			MainWindow.showMessage("Hay un simbolo Erroneo en las producciones");
		}
	}
	
	private boolean existInArray(String a, String[] terminal) {
		boolean out = false;
		for (int i = 0; i < a.length(); i++) {
			char l = a.charAt(i);
			for (int j = 0; j < terminal.length; j++) {
				if ((l+"").equals(terminal[j])) {
					out = true;
				}
			}
		}
		return out;
	}
	
	private boolean verifyProduccion(String[] noTerminal, String[] datas, String[] terminal) {
		for (int i = 0; i < datas.length; i++) {
			String separador = Pattern.quote("|");
			String[] outacept = datas[i].split(separador);
			for (int j = 0; j < outacept.length; j++) {
				if (outacept[j].length()>1) {
					if (existInArray( outacept[j], terminal) || existInArray( outacept[j], noTerminal)) {
					}else {
						return false;
					}	
				}else {
					if (existInArray( outacept[j], terminal) || existInArray( outacept[j], noTerminal)) {
					}else {
						return false;
					}
				}
			}
		}
		return true;
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
			out[i] += producciones[i][0] + ": ";
			for (int j = 1; j < producciones[i].length; j++) {
				if (!producciones[i][j].equals("")) {
					out[i] += producciones[i][j] + " | ";
				}
			}
		}
		return out;
	}
}