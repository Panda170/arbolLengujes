package logic;

public class Calculate {

	private String[][] producciones;
	
	private String word;
	private int under;
	private boolean isExist;
	
	/**
	 * prueba que exista la palabra en la gramatica
	 * @param producciones
	 * @param word
	 * @return
	 */
	public boolean exist(String[][] producciones, String word) {
		this.producciones = producciones;
		this.word = word;
		System.out.println( "PALABRA: " + word);
		isExist = false;
		System.out.println("FINAL!!" + startTree("") + " PALABRA EXISTE?: " + isExist);
		return isExist;
	}

	/**
	 * comienza con el arbol para la busqueda de la palabra
	 * @param contruct
	 * @return
	 */
	private String startTree(String contruct) {
		String[] start = producciones[0];
		String letter ="";
		under = 0;
		for (int i = 1; i < start.length; i++) {
			for (int j = 0; j < start[i].length(); j++) {
				char l = start[i].charAt(j);
				if (isTerminal(l+"")) {
					System.out.println("qcompara: "+ l);
					letter += l;
					if (worldExist(letter)) {
						isExist = true;
					}
				}else {
					letter += continueTree(getLine(l+""));
				}
			}
		}
		System.out.println("normal: " + letter);
		return letter;
	}
	
	/**
	 * uso de redundancia para la busqueda
	 * @param line
	 * @return
	 */
	private String continueTree(String[] line) {
		String letter = "";
		for (int i = 1; i < line.length; i++) {
			for (int j = 0; j < line[i].length(); j++) {
				char l = line[i].charAt(j);
				if (isTerminal(l+"")) {
					letter += l;
					if (worldExist(letter)) {
						isExist = true;
					}
				}else {
					if (under <= 10) {
						under++;
						letter += continueTree(getLine(l+""));	
					}
				}	
			}
		}
		if (worldExist(letter)) {
			isExist = true;
		}
		System.out.println("Palabra Actual: " + letter + " palabra Existe?: " + worldExist(letter));
		return letter;	
	}
	
	private boolean worldExist(String letter) {
		return letter.equals(word);
	}

	private String[] getLine(String l) {
		String[] out = new String[0];
		for (int i = 0; i < producciones.length; i++) {
			if (producciones[i][0].equals(l)) {
				out = producciones[i];
			}
		}
		return out;
	}
	
	private boolean isTerminal(String a) {
		char l = a.charAt(0);
		return !(l >= 65 && l <= 90);
	}
}