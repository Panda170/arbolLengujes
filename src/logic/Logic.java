package logic;

public class Logic {
	private String[] terminals;
	private String[] noTerminals;
	
	public Logic() {
		terminals = new String[0];
		noTerminals = new String[0];
	}
	
	public void initTerminals(String[] terminals) {
		for (int i = 0; i < terminals.length; i++) {
			terminals[i] = terminals[i].toLowerCase();
		}
		this.terminals = terminals;
	}
	
	public void initNoTerminals(String[] noTerminals) {
		for (int i = 0; i < noTerminals.length; i++) {
			noTerminals[i] = noTerminals[i].toUpperCase();
		}
		this.noTerminals = noTerminals;
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
