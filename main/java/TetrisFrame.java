
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class TetrisFrame extends JFrame implements Runnable, KeyListener {

	static int check = 0;
	static int running = 0;
	static int score = 0;
	static int checkL = 0;
	static int clear=0;
	static int startGame=0;
	public TetrisFrame() {
		NowBrick.findNextBrick();
		NowBrick.findNextBrick();
		this.setVisible(true);
		this.setSize(350, 600);
		this.setTitle("Tetris");
		TetrisPanel tetrisPanel = new TetrisPanel();
		this.add(tetrisPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		NowState.clear();
	}

	public static void checkSL(int x, int y) {
		try {
			if (NowState.stateTable[y + 1][x - 1] != 0) {
				check = 1;
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			if(NowBrick.nowBrick==2&&NowBrick.x==0)
			{
				check=1;
				return;
			}
			NowBrick.y -= 1;

			NowBrick.x += 1;
		}

	}

	public static void checkSR(int x, int y) {
		try {
			if (NowState.stateTable[y + 1][x + 1] != 0) {
				check = 1;
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			// NowBrick.y-=1;
			if(NowBrick.nowBrick==2&&(NowBrick.x==9||NowBrick.x==8))
			{
				check=1;
				return;
			}
			if (NowBrick.nowBrick == 2 || NowBrick.nowBrick == 3)
				NowBrick.x -= 1;
			NowBrick.x -= 1;
		}

	}

	public static void checkL(int x, int y) {
		if (x == 0) {
			check = 1;
			return;
		}
		if (NowState.stateTable[y + 1][x - 1] != 0) {
			check = 1;
			return;
		}

	}

	public static void checkR(int x, int y) {
		if (x == 9) {
			check = 1;
			return;
		}
		if (NowState.stateTable[y + 1][x + 1] != 0) {
			check = 1;
			return;
		}

	}

	@Override
	public void run() {
		NowBrick nowBrick = new NowBrick();
		while (true) {
			TetrisPanel.gameScore.setText("Score:" + score);
			TetrisPanel.level.setText("Level:" + clear/10);
			try {
				Thread.sleep(200-((clear/10)*10));
			} catch (InterruptedException ex) {
				Logger.getLogger(TetrisFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
			if (running == 1) {
				nowBrick.y += 1;
			}
			// NowBrick.checkStop();
			repaint();
			NowState.checkDead();
		} // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 0) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x - 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 1) {
				checkL(NowBrick.x, NowBrick.y + 0);
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 2) {
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x - 1, NowBrick.y);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 3) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x - 1, NowBrick.y + 1);
				checkL(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 1) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 2 && (NowBrick.state % 2) == 0) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x, NowBrick.y + 2);
				checkL(NowBrick.x, NowBrick.y + 3);
			}
			if (NowBrick.nowBrick == 2 && (NowBrick.state % 2) == 1) {
				checkL(NowBrick.x - 1, NowBrick.y);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 0) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 1) {
				checkL(NowBrick.x - 1, NowBrick.y);
				checkL(NowBrick.x - 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 2) {
				checkL(NowBrick.x - 1, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 3) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x - 2, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 0) {
				checkL(NowBrick.x - 1, NowBrick.y + 2);
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 1) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 2) {
				checkL(NowBrick.x, NowBrick.y + 2);
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 3) {
				checkL(NowBrick.x - 2, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 5 && (NowBrick.state % 2) == 0) {
				checkL(NowBrick.x - 1, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 5 && (NowBrick.state % 2) == 1) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x - 1, NowBrick.y + 1);
				checkL(NowBrick.x - 1, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 6 && (NowBrick.state % 2) == 0) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x - 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 6 && (NowBrick.state % 2) == 1) {
				checkL(NowBrick.x, NowBrick.y);
				checkL(NowBrick.x, NowBrick.y + 1);
				checkL(NowBrick.x + 1, NowBrick.y + 2);
			}
			if (check == 0) {

				NowBrick.moveL();
			}

			check = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 0) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x + 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 1) {
				checkR(NowBrick.x, NowBrick.y + 0);
				checkR(NowBrick.x + 1, NowBrick.y + 1);
				checkR(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 2) {
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x + 1, NowBrick.y);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4) == 3) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 1) {
				checkR(NowBrick.x + 1, NowBrick.y);
				checkR(NowBrick.x + 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 2 && (NowBrick.state % 2) == 0) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x, NowBrick.y + 2);
				checkR(NowBrick.x, NowBrick.y + 3);
			}
			if (NowBrick.nowBrick == 2 && (NowBrick.state % 2) == 1) {
				checkR(NowBrick.x + 2, NowBrick.y);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 0) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x + 1, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 1) {
				checkR(NowBrick.x + 1, NowBrick.y);
				checkR(NowBrick.x - 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 2) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 3 && (NowBrick.state % 4) == 3) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 0) {
				checkR(NowBrick.x, NowBrick.y + 2);
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 1) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x + 2, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 2) {
				checkR(NowBrick.x, NowBrick.y + 2);
				checkR(NowBrick.x + 1, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && (NowBrick.state % 4) == 3) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 5 && (NowBrick.state % 2) == 0) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x + 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 5 && (NowBrick.state % 2) == 1) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
				checkR(NowBrick.x - 1, NowBrick.y + 2);
			}
			if (NowBrick.nowBrick == 6 && (NowBrick.state % 2) == 0) {
				checkR(NowBrick.x + 1, NowBrick.y);
				checkR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 6 && (NowBrick.state % 2) == 1) {
				checkR(NowBrick.x, NowBrick.y);
				checkR(NowBrick.x + 1, NowBrick.y + 1);
				checkR(NowBrick.x + 1, NowBrick.y + 2);
			}
			if (check == 0)
				NowBrick.moveR();
			check = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4 == 1)) {
				checkSL(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 0 && (NowBrick.state % 4 == 3)) {
				checkSR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 2 && (NowBrick.state % 2 == 0)) {
				checkSL(NowBrick.x - 1, NowBrick.y );
				if (check == 1)
					checkSR(NowBrick.x + 2, NowBrick.y );
				
			}
			if (NowBrick.nowBrick == 3 && NowBrick.state % 4 == 0) {
				checkSL(NowBrick.x, NowBrick.y);
			}
			if (NowBrick.nowBrick == 3 && NowBrick.state % 4 == 2) {
				checkSL(NowBrick.x - 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && NowBrick.state % 4 == 0) {
				checkSR(NowBrick.x + 1, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 4 && NowBrick.state % 4 == 2) {
				checkSR(NowBrick.x - 2, NowBrick.y);
			}
			if (NowBrick.nowBrick == 5 && NowBrick.state % 2 == 1) {
				checkSR(NowBrick.x, NowBrick.y + 1);
			}
			if (NowBrick.nowBrick == 6 && NowBrick.state % 2 == 1) {
				checkSL(NowBrick.x, NowBrick.y + 1);
			}
			if (check == 0)
			{
				NowBrick.state++;
				//NowBrick.y-=1;
			}
			check = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			NowBrick.y+=1;
			repaint();
		}
		// To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// To change body of generated methods, choose Tools | Templates.
	}

}
