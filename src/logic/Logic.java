package logic;

public class Logic {
	private String[] terminals;
	private String[] noTerminals;
	
	public Logic() {
		
	}
	
	public void initTerminals(String[] terminals) {
		for (int i = 0; i < terminals.length; i++) {
			terminals[i] = terminals[i].toLowerCase();
			System.out.println(terminals[i]);
		}
	}
	
	public void initNoTerminals(String[] noTerminals) {
		for (String i : noTerminals) {
			i = i.toUpperCase();
			System.out.println(i);
		}
	}

}
