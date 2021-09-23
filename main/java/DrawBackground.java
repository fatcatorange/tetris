
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class DrawBackground {
	static int[][] stateTable = new int[22][10];

	public static void clear() {
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				stateTable[i][j]=0;
			}
		}
	}
	public static void drawFirst()
	{
		stateTable[21][0]=3;
		stateTable[21][1]=3;
		stateTable[21][2]=3;
		stateTable[21][3]=3;
		stateTable[21][5]=4;
		stateTable[21][6]=4;
		stateTable[21][7]=4;
		stateTable[20][7]=4;
		stateTable[21][8]=5;
		stateTable[21][9]=5;
		stateTable[19][9]=5;
		stateTable[20][9]=5;
		stateTable[20][5]=7;
		stateTable[20][6]=7;
		stateTable[19][7]=7;
		stateTable[19][6]=7;
		stateTable[20][8]=5;
		stateTable[19][8]=5;
		stateTable[18][8]=5;
		stateTable[18][9]=5;
		stateTable[19][5]=4;
		stateTable[18][5]=4;
		stateTable[18][6]=4;
		stateTable[18][7]=4;
		stateTable[20][1]=1;
		stateTable[20][2]=1;
		stateTable[20][3]=1;
		stateTable[19][2]=1;
		stateTable[20][0]=6;
		stateTable[19][0]=6;
		stateTable[19][1]=6;
		stateTable[18][1]=6;
		stateTable[19][3]=7;
		stateTable[18][3]=7;
		stateTable[18][2]=7;
		stateTable[17][2]=7;
		stateTable[18][0]=1;
		stateTable[17][0]=1;
		stateTable[16][0]=1;
		stateTable[17][1]=1;
		stateTable[16][4]=3;
		stateTable[15][4]=3;
		stateTable[14][4]=3;
		stateTable[13][4]=3;
	}
	

	public static void drawBackground(Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i <= 10; i++) {
			g.drawLine(i * 25, 0, i * 25, 600);
		}
		for (int i = 0; i < 24; i++) {
			g.drawLine(0, i * 25 + 15, 250, i * 25 + 15);
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
}
