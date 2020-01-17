package view;

import controller.SokovanMaster;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ArrowInput extends JFrame implements KeyListener {
	private JTextArea ta = new JTextArea();
	private SokovanMaster gameMaster;

	public ArrowInput(SokovanMaster gameMaster) {
		this.gameMaster = gameMaster;
		ta.addKeyListener(this);
		add(ta);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Integer cursor = e.getKeyCode();
		gameMaster.movePlayerWithInteger(cursor);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}

