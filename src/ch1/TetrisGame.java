package ch1;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TetrisGame extends JFrame implements KeyListener {

	private GameHandler handler;
	private JTextArea textArea = new JTextArea();
	
	public TetrisGame() {
		setTitle("Let's play Tetris");
		setSize(720, 920);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // this will center your apps
		textArea.setFont(new Font("courier New", Font.PLAIN, 30));
		textArea.addKeyListener(this);
		add(textArea);
		textArea.setEditable(false);
		setVisible(true);
		
		handler = new GameHandler(textArea);
		new Thread(new GameThread()).start();
	}
	
	public static void main(String[] args) {
		new TetrisGame();
	}
	
	class GameThread implements Runnable {
		
		@Override
		public void run() {
			// game loop
			while (!handler.isGameOver()) {
				// 1. Game timing ===================
				handler.gameTiming();
				
				// 3. Game logic ====================
				handler.gameLogic();
				
				// 4. Render output =================
				handler.drawAll();
			}
			// game over
			handler.drawGameOver();
		}
		
		// 2. Get Input ==========================
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}