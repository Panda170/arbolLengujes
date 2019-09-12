package logic;

public class Logic {
	private String[] terminals;
	private String[] noTerminals;
	
	public Logic() {
		
	}
	
	public void initTerminals(String[] terminals) {
		for (int i = 0; i < terminals.length; i++) {
			terminals[i] = terminals[i].toUpperCase();
		}
	}
	
	public void initNoTerminals(String[] noTerminals) {
		for (String i : noTerminals) {
			i = i.toLowerCase();
		}
	}

}
