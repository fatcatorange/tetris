
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class NowState {
	static int clearScore = 0;
	static int[][] stateTable = new int[22][10];

	static void clear() {
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				stateTable[i][j] = 0;
			}
		}
	}

	public static void paintNowState(Graphics g) {
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				if (stateTable[i][j] != 0) {
					if (stateTable[i][j] == 1) {
						g.setColor(Color.MAGENTA);
					}
					if (stateTable[i][j] == 2) {
						g.setColor(Color.YELLOW);
					}
					if (stateTable[i][j] == 3) {
						g.setColor(Color.CYAN);
					}
					if (stateTable[i][j] == 4) {
						g.setColor(Color.ORANGE);
					}
					if (stateTable[i][j] == 5) {
						g.setColor(Color.BLUE);
					}
					if (stateTable[i][j] == 6) {
						g.setColor(Color.RED);
					}
					if (stateTable[i][j] == 7) {
						g.setColor(Color.GREEN);
					}
					g.fillRect(j * 25, i * 25 + 15, 25, 25);

				}
			}
		}
	}

	public static void checkDead() {
		for (int i = 0; i < 10; i++) {
			if (stateTable[1][i] != 0) {
				TetrisFrame.running = 0;
				TetrisPanel.restart.setVisible(true);
				TetrisPanel.finalScore.setText("      Score:" + TetrisFrame.score);
				NowBrick.y = 0;
				TetrisPanel.finalScore.setVisible(true);
				TetrisFrame.clear = 0;
			}
		}
	}

	public static void checkClear() {
		System.out.println("yoa");
		clearScore = 0;
		int flag = 0;
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("" + stateTable[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				if (stateTable[i][j] == 0) {
					flag = 1;
				}
			}
			if (flag == 0) {

				for (int j = 0; j < 10; j++) {
					stateTable[i][j] = 0;
				}
				try {
					Clip bgm = AudioSystem.getClip();
					InputStream is = TetrisGame.class.getClassLoader().getResourceAsStream("Sound effect.wav");
					AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
					bgm.open(ais);

					bgm.start();

				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clearLine(i);
				clearScore++;
				System.out.println("" + clearScore);
			}

			flag = 0;
		}
		if (clearScore == 1) {
			TetrisFrame.score += 200;
		}
		if (clearScore == 2) {
			TetrisFrame.score += 400;
		}
		if (clearScore == 3) {
			TetrisFrame.score += 800;
		}
		if (clearScore == 4) {
			TetrisFrame.score += 1600;
		}
		TetrisFrame.clear += clearScore;
	}

	public static void clearLine(int clearY) {
		for (int i = clearY; i > 0; i--) {
			for (int j = 0; j < 10; j++) {
				stateTable[i][j] = stateTable[i - 1][j];
			}

		}
	}
}
