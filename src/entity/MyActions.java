package entity;

public enum MyActions {
	 DISABLE("disable_button"), TERMINAL_CODE("1"), NO_TERMINAL_CODE("2"), SEPARATOR_TERMINAL(",");
	 private String command;
	 
	 private MyActions(String command) {
		 this.command = command;
	 }
	 
	 public String getCommand() {
		return command;
	}

}
