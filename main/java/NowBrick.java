
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
public class NowBrick {

    static int x;
    static int y;
    static int nextBrick=0;
    static int nowBrick =0;
    static int state = 0;
    static int check = 0;

    public NowBrick() {
        this.x = 5;
        this.y = 0;
    }

    public static void findNextBrick() {
    	nowBrick=nextBrick;
        nextBrick = (int) (Math.random() * 7);
        
    }

    public static void paintNowBrick(Graphics g) {
    	try {
    		if (nowBrick == 0) {
                paintTbrick(g);
            }
            if (nowBrick == 1) {
                paintObrick(g);
            }
            if (nowBrick == 2) {
                paintIbrick(g);
            }
            if (nowBrick == 3) {
                paintLbrick(g);
            }
            if (nowBrick == 4) {
                paintL2brick(g);
            }
            if (nowBrick == 5) {
                paintSbrick(g);
            }
            if (nowBrick == 6) {
                paintS2brick(g);
            }
    	}
    	catch(ArrayIndexOutOfBoundsException exception) {
    	    if(x>=5)
    	    {
    	    	y-=1;
    	    	x-=1;
    	    }
    	    else {
    	    	y-=1;
    	    	x+=1;
    	    }
    	}
        
    }

    public static void moveL() {

        x -= 1;
    }

    public static void moveR() {
        x += 1;
    }

    public static void checkStop(int checkX, int checkY) {
        if (checkY >= 21 || NowState.stateTable[checkY + 1][checkX] != 0) {
            state = 0;
            check = 1;
        }
    }

    public static void paintTbrick(Graphics g) {
        g.setColor(Color.MAGENTA);
        if (state % 4 == 0) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x + 1, y + 1);
            checkStop(x, y + 1);
            checkStop(x - 1, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 1;
                NowState.stateTable[y + 1][x] = 1;
                NowState.stateTable[y + 1][x + 1] = 1;
                NowState.stateTable[y + 1][x - 1] = 1;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 1) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 2);
            checkStop(x + 1, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 1;
                NowState.stateTable[y + 1][x] = 1;
                NowState.stateTable[y + 1][x + 1] = 1;
                NowState.stateTable[y + 2][x] = 1;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 2) {
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 2);
            checkStop(x + 1, y + 1);
            checkStop(x - 1, y + 1);
            if (check == 1) {
                NowState.stateTable[y + 1][x - 1] = 1;
                NowState.stateTable[y + 1][x] = 1;
                NowState.stateTable[y + 1][x + 1] = 1;
                NowState.stateTable[y + 2][x] = 1;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 3) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 2);
            checkStop(x - 1, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 1;
                NowState.stateTable[y + 1][x] = 1;
                NowState.stateTable[y + 1][x - 1] = 1;
                NowState.stateTable[y + 2][x] = 1;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }

    public static void paintObrick(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x * 25, y * 25 + 15, 25, 25);
        g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
        g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
        g.fillRect((x + 1) * 25, (y) * 25 + 15, 25, 25);
        checkStop(x + 1, y + 1);
        checkStop(x, y + 1);
        if (check == 1) {
            NowState.stateTable[y][x] = 2;
            NowState.stateTable[y + 1][x + 1] = 2;
            NowState.stateTable[y + 1][x] = 2;
            NowState.stateTable[y][x + 1] = 2;
            y = 0;
            x = 5;
            NowState.checkClear();
            findNextBrick();
        }
        check = 0;
    }

    public static void paintIbrick(Graphics g) {
        g.setColor(Color.CYAN);
        if (state % 2 == 0) {
            g.fillRect((x) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 3) * 25 + 15, 25, 25);
            checkStop(x, y + 3);
            if (check == 1) {
                NowState.stateTable[y][x] = 3;
                NowState.stateTable[y + 1][x] = 3;
                NowState.stateTable[y + 2][x] = 3;
                NowState.stateTable[y + 3][x] = 3;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 2 == 1) {

            g.fillRect((x) * 25, y * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x + 2) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y) * 25 + 15, 25, 25);
            checkStop(x, y);
            checkStop(x + 1, y);
            checkStop(x + 2, y);
            checkStop(x - 1, y);
            if (check == 1) {
                NowState.stateTable[y][x] = 3;
                NowState.stateTable[y][x + 1] = 3;
                NowState.stateTable[y][x - 1] = 3;
                NowState.stateTable[y][x + 2] = 3;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }

    public static void paintLbrick(Graphics g) {
        g.setColor(Color.ORANGE);
        if (state % 4 == 0) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 2) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x + 1, y + 2);
            checkStop(x, y + 2);
            if (check == 1) {
                NowState.stateTable[y][x] = 4;
                NowState.stateTable[y + 1][x] = 4;
                NowState.stateTable[y + 2][x + 1] = 4;
                NowState.stateTable[y + 2][x] = 4;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 1) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x - 1, y + 1);
            checkStop(x, y);
            checkStop(x + 1, y);
            if (check == 1) {
                NowState.stateTable[y][x] = 4;
                NowState.stateTable[y][x + 1] = 4;
                NowState.stateTable[y][x - 1] = 4;
                NowState.stateTable[y + 1][x - 1] = 4;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 2) {
            g.fillRect((x) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 2);
            checkStop(x - 1, y);
            if (check == 1) {
                NowState.stateTable[y][x] = 4;
                NowState.stateTable[y][x - 1] = 4;
                NowState.stateTable[y + 1][x] = 4;
                NowState.stateTable[y + 2][x] = 4;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 3) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 2) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x, y + 1);
            checkStop(x - 1, y + 1);
            checkStop(x - 2, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 4;
                NowState.stateTable[y + 1][x] = 4;
                NowState.stateTable[y + 1][x - 1] = 4;
                NowState.stateTable[y +1][x - 2] = 4;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }

    public static void paintL2brick(Graphics g) {
        g.setColor(Color.BLUE);
        if (state % 4 == 0) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 2) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x - 1, y + 2);
            checkStop(x, y + 2);
            if (check == 1) {
                NowState.stateTable[y][x] = 5;
                NowState.stateTable[y + 1][x] = 5;
                NowState.stateTable[y + 2][x - 1] = 5;
                NowState.stateTable[y + 2][x] = 5;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 1) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 2) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x + 1, y + 1);
            checkStop(x, y + 1);
            checkStop(x + 2, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 5;
                NowState.stateTable[y + 1][x + 1] = 5;
                NowState.stateTable[y + 1][x + 2] = 5;
                NowState.stateTable[y + 1][x] = 5;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 2) {
            g.fillRect((x) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect(x * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 2);
            checkStop(x + 1, y);
            if (check == 1) {
                NowState.stateTable[y][x] = 5;
                NowState.stateTable[y][x + 1] = 5;
                NowState.stateTable[y + 1][x] = 5;
                NowState.stateTable[y + 2][x] = 5;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 4 == 3) {
            g.fillRect(x * 25, y * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 2) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x, y + 1);
            checkStop(x - 1, y);
            checkStop(x - 2, y);
            if (check == 1) {
                NowState.stateTable[y][x] = 5;
                NowState.stateTable[y][x - 1] = 5;
                NowState.stateTable[y][x - 2] = 5;
                NowState.stateTable[y + 1][x] = 5;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }

    public static void paintSbrick(Graphics g) {
        g.setColor(Color.red);
        if (state % 2 == 0) {
            g.fillRect((x) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x - 1, y);
            checkStop(x, y + 1);
            checkStop(x + 1, y + 1);
            if (check == 1) {
                NowState.stateTable[y][x] = 6;
                NowState.stateTable[y][x - 1] = 6;
                NowState.stateTable[y + 1][x] = 6;
                NowState.stateTable[y + 1][x + 1] = 6;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 2 == 1) {

            g.fillRect((x) * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x - 1) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 1);
            checkStop(x - 1, y + 2);
            if (check == 1) {
                NowState.stateTable[y][x] = 6;
                NowState.stateTable[y + 1][x] = 6;
                NowState.stateTable[y + 1][x - 1] = 6;
                NowState.stateTable[y + 2][x - 1] = 6;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }

    public static void paintS2brick(Graphics g) {
        g.setColor(Color.GREEN);
        if (state % 2 == 0) {
            g.fillRect((x) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x +1) * 25, (y) * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y +1) * 25 + 15, 25, 25);
            g.fillRect((x -1) * 25, (y + 1) * 25 + 15, 25, 25);
            checkStop(x - 1, y+1);
            checkStop(x, y + 1);
            checkStop(x + 1, y );
            if (check == 1) {
                NowState.stateTable[y][x] = 7;
                NowState.stateTable[y][x + 1] = 7;
                NowState.stateTable[y + 1][x] = 7;
                NowState.stateTable[y + 1][x - 1] = 7;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
        if (state % 2 == 1) {

            g.fillRect((x) * 25, y * 25 + 15, 25, 25);
            g.fillRect((x) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 1) * 25 + 15, 25, 25);
            g.fillRect((x + 1) * 25, (y + 2) * 25 + 15, 25, 25);
            checkStop(x, y + 1);
            checkStop(x + 1, y + 2);
            if (check == 1) {
                NowState.stateTable[y][x] = 7;
                NowState.stateTable[y + 1][x] = 7;
                NowState.stateTable[y + 1][x + 1] = 7;
                NowState.stateTable[y + 2][x + 1] = 7;
                y = 0;
                x = 5;
                NowState.checkClear();
                findNextBrick();
            }
            check = 0;
        }
    }
}
