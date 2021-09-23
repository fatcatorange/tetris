
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class TetrisPanel extends JPanel {
	static Label finalScore=new Label();
    static Button restart = new Button("restart");
    static Label gameScore=new Label();
    static Label level = new Label("Level:");
    public TetrisPanel() {
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        Button start = new Button("start");
        this.add(start);
        this.setLayout(null);
        start.setBounds(75, 150, 100, 50);
        restart.setBounds(75, 150, 100, 50);
        this.add(restart);
        restart.setVisible(false);
        Label title = new Label("TETRIS");
        title.setFont(new Font("", Font.PLAIN, 40));
        title.setForeground(Color.red);
        title.setBounds(50, 100, 150, 50);
        this.add(title);
        this.add(gameScore);
        Label next = new Label("next brick:");
        next.setForeground(Color.WHITE);
        next.setBounds(255, 150, 100, 50);
        this.add(next);
        this.add(finalScore);
        finalScore.setBounds(50, 300, 150, 50);
        finalScore.setVisible(false);
        finalScore.setBackground(Color.WHITE);
        finalScore.setForeground(Color.BLACK);
        gameScore.setForeground(Color.WHITE);
        gameScore.setBackground(Color.LIGHT_GRAY);
        gameScore.setBounds(251, 0, 100, 50);
        level.setForeground(Color.WHITE);
        level.setBackground(Color.LIGHT_GRAY);
        level.setBounds(251, 50, 100, 50);
        
        this.add(level);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TetrisFrame.running = 1;
                start.setVisible(false);
                title.setVisible(false);
                TetrisFrame.startGame=1;
            }
        });
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TetrisFrame.running = 1;
                restart.setVisible(false);
                finalScore.setVisible(false);
				TetrisFrame.score=0;
                NowState.clear();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (TetrisFrame.running == 1) {
            NowState.paintNowState(g);
            NowBrick.paintNowBrick(g);
            PaintNext.paintNext(g);
            PaintNext.paintLine(g);
        }
        else {
        	if(TetrisFrame.startGame==0)
        	{
        		DrawBackground.drawFirst();
            	DrawBackground.paintNowState(g);
        	}
        }
        DrawBackground.drawBackground(g);
    }
}
