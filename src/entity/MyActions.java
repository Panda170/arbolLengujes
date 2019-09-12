package entity;

public enum MyActions {
	 DISABLE("disable_button");
	 private String command;
	 
	 private MyActions(String command) {
		 this.command = command;
	 }
	 
	 public String getCommand() {
		return command;
	}

}
