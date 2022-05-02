package main;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import main.Plateau;

public class main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() throws IOException {
		initialize();
		Plateau.screenRender(frame);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100, 1200,720);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
