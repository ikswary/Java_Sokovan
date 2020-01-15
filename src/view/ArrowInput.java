package view;

import controller.StageController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// ActionEvenct 처리 -> ActionListener
// KeyEvent 처리		-> KeyListener
// MouseEvent 처리	-> MouseListenera

// 키 입력 이벤트 처리 인터페이스 KeyListener 구현
public class ArrowInput extends JFrame implements KeyListener {
	private JTextArea ta = new JTextArea();
	private StageController stageController;


	public ArrowInput(StageController stageController) {
		this.stageController = stageController;
		ta.addKeyListener(this);
		add(ta);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	// 키가 눌려진 상태일 때의 동작을 정의
	@Override
	public void keyPressed(KeyEvent e) {
		Integer cursor = e.getKeyCode();
		stageController.movePlayer(cursor);
	}

	// 키를 눌렀다 뗐을 때의 동작을 정의
	@Override
	public void keyReleased(KeyEvent e) {
	}

	// 글자가 입력됐을 때의 동작을 정의
	@Override
	public void keyTyped(KeyEvent e) {
	}
}

