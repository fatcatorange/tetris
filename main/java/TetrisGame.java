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
public class TetrisGame {
    public static void main(String[] args) {
       // TetrisFrame tetrisFrame = new TetrisFrame();
        Runnable runnable=new TetrisFrame();
        Thread thread=new Thread(runnable);
        thread.start();
        try {
			Clip bgm = AudioSystem.getClip();
			InputStream is = TetrisGame.class.getClassLoader().getResourceAsStream("Tetris 99 - Main Theme(3).wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
			bgm.open(ais);
			bgm.start();
			
			bgm.loop(Clip.LOOP_CONTINUOUSLY);
			while (1 == 1) {
				if(TetrisFrame.running==0)
				{
					bgm.stop();
				}
				else {
					bgm.start();
					bgm.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
