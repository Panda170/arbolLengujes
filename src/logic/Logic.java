package logic;

public class Logic {
	private String[] terminals;
	private String[] noTerminals;
	
	public Logic() {
		
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
	
	
	public String[] getNoTerminals() {
		return noTerminals;
	}
	
	public String[] getTerminals() {
		return terminals;
	} 
	

}
