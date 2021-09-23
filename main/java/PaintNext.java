import java.awt.Color;
import java.awt.Graphics;

public class PaintNext {
	public static void paintNext(Graphics g)
	{
		if(NowBrick.nextBrick==0)
		{
			g.setColor(Color.MAGENTA);
			g.fillRect(275, 225, 25, 25);
			g.fillRect(250, 250, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(300, 250, 25, 25);
		}
		if(NowBrick.nextBrick==1)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(300, 225, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(300, 250, 25, 25);
			g.fillRect(275, 225, 25, 25);
		}
		if(NowBrick.nextBrick==2)
		{
			g.setColor(Color.CYAN);
			g.fillRect(275, 225, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(275, 275, 25, 25);
			g.fillRect(275, 200, 25, 25);
		}
		if(NowBrick.nextBrick==3)
		{
			g.setColor(Color.ORANGE);
			g.fillRect(275, 225, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(300, 250, 25, 25);
			g.fillRect(275, 200, 25, 25);
		}
		if(NowBrick.nextBrick==4)
		{
			g.setColor(Color.BLUE);
			g.fillRect(275, 225, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(250, 250, 25, 25);
			g.fillRect(275, 200, 25, 25);
		}
		if(NowBrick.nextBrick==5)
		{
			g.setColor(Color.RED);
			g.fillRect(250, 225, 25, 25);
			g.fillRect(300, 250, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(275, 225, 25, 25);
		}
		if(NowBrick.nextBrick==6)
		{
			g.setColor(Color.GREEN);
			g.fillRect(250, 250, 25, 25);
			g.fillRect(275, 250, 25, 25);
			g.fillRect(275, 225, 25, 25);
			g.fillRect(300, 225, 25, 25);
		}
	}
	public static void paintLine(Graphics g)
	{
		g.setColor(Color.WHITE);
		for(int i=0;i<5;i++)
		{
			g.drawLine(250,200+25*i , 350, 200+25*i);
		}
		for(int i=0;i<5;i++)
		{
			g.drawLine(250+25*i,200 , 250+25*i, 300);
		}
	}
}
