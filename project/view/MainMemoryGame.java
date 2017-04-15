package view;

import java.awt.BorderLayout;

import javax.swing.JButton;

import controller.HomeController;

public class MainMemoryGame {
	public MainMemoryGame() {
	}

	public static void main(String[] args) {
		HomeView home = new HomeView();
		JButton fh	= new JButton("ABC");
		home.add(fh);
		fh.setBounds(50, 50, 100, 10);
		home.add(new JButton("Abc"), BorderLayout.WEST);
		HomeController homecontrol = new HomeController(home);
		homecontrol.initMouseAction();
	}
}
