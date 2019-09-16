package logic;

import views.MainWindow;

public class Logic {
	private String[] terminals;
	private String[] noTerminals;
	
	/**
	 * Clase encargada de comprobar los simbolos terminales y no terminales de la gramatica
	 */
	
	public Logic() {
		terminals = new String[0];
		noTerminals = new String[0];
	}
	
	
	/**
	 * Inicializacion de los simbolos Terminales
	 * @param terminals
	 */
	public void initTerminals(String[] terminals) {
		if (noRepeat(terminals)) {
			for (int i = 0; i < terminals.length; i++) {
				terminals[i] = terminals[i].toLowerCase();
			}
			this.terminals = terminals;	
		}else {
			MainWindow.showMessage("Los simbolos no deben repetirse o ser diferentes a los no terminales");
		}
		
	}
	
	/**
	 * Inicializacion de los simbolos no terminales
	 * @param noTerminals
	 */
	public void initNoTerminals(String[] noTerminals) {
		if (isDiferent(noTerminals) && noRepeat(noTerminals)) {
			for (int i = 0; i < noTerminals.length; i++) {
				noTerminals[i] = noTerminals[i].toUpperCase();
			}
			this.noTerminals = noTerminals;	
		}else {
			MainWindow.showMessage("Los simbolos deben se diferentes a los terminales o se estan repitiendo");
		}
	}
	
	/**
	 * Verifica que no existan simbolos terminales y no terminales iguales
	 * @param noTerminals2
	 * @return
	 */
	public boolean isDiferent(String[] noTerminals2) {
		for (int i = 0; i < terminals.length; i++) {
			for (int j = 0; j < noTerminals2.length; j++) {
				if (terminals[i].equals(noTerminals2[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verifica que no se repita ningun simbolo
	 * @param list
	 * @return
	 */
	public boolean noRepeat(String[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j < list.length; j++) {
				if (list[i].equals(list[j])) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean canInitProductions() {
		return (terminals.length > 0 && noTerminals.length > 0);
	}
	
	public String[] getNoTerminals() {
		return noTerminals;
	}
	
	public String[] getTerminals() {
		return terminals;
	} 
	

}
