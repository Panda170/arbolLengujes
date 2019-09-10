package controller;

import views.MainWindow;

public class Controller {
	private MainWindow mainWindow;
	
	public Controller() {
		initMainWindows();
	}
	
	private void initMainWindows() {
		mainWindow =  new MainWindow();
	}
}
