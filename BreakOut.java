import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class BreakOut extends Canvas implements KeyListener, Runnable{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private Block brick1;
	private Block brick2;
	private Block brick3;
	private Block brick4;
	private Block brick5;
	
	public BreakOut()
	{
		ball = new Ball(200,200,10,10,Color.BLACK,2,1);
		paddle = new Paddle(350,370,75,10,Color.BLUE,3);
		brick1 = new Block(50,50,50,20,Color.RED);
		brick2 = new Block(320,50,50,20,Color.RED);
		brick3 = new Block(520,50,50,20,Color.RED);
		brick4 = new Block(150,100,50,20,Color.RED);
		brick5 = new Block(370,100,50,20,Color.RED);
		keys = new boolean[2];
		
		setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void paint(Graphics window)
	{
		Graphics2D twoDGraph = (Graphics2D)window;
		
		if(back==null)
			back = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		Graphics graphToBack = back.createGraphics();
		
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		brick1.draw(graphToBack);
		brick2.draw(graphToBack);
		brick3.draw(graphToBack);
		brick4.draw(graphToBack);
		brick5.draw(graphToBack);
		graphToBack.setColor(Color.black);
		
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}
		if(ball.getY()<=5)
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		if((ball.getY()+ball.getHeight())>(paddle.getY()+paddle.getHeight()))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			graphToBack.drawString("GAME OVER", 350, 300);
		}
		//bottom of ball collides with top of paddle
		if(((ball.getY()+ball.getHeight())>=paddle.getY()) &&
				(ball.getX()>paddle.getX()) && ((ball.getX()+ball.getWidth())<(paddle.getX()+paddle.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		//bottom of ball collides with top of bricks
		if(((ball.getY()+ball.getHeight())==brick1.getY()) &&
				(ball.getX()>brick1.getX()) && ((ball.getX()+ball.getWidth())<(brick1.getX()+brick1.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if(((ball.getY()+ball.getHeight())==brick2.getY()) &&
				(ball.getX()>brick2.getX()) && ((ball.getX()+ball.getWidth())<(brick2.getX()+brick2.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if(((ball.getY()+ball.getHeight())==brick3.getY()) &&
				(ball.getX()>brick3.getX()) && ((ball.getX()+ball.getWidth())<(brick3.getX()+brick3.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if(((ball.getY()+ball.getHeight())==brick4.getY()) &&
				(ball.getX()>brick4.getX()) && ((ball.getX()+ball.getWidth())<(brick4.getX()+brick4.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if(((ball.getY()+ball.getHeight())==brick5.getY()) &&
				(ball.getX()>brick5.getX()) && ((ball.getX()+ball.getWidth())<(brick5.getX()+brick5.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		//top of ball collides with bottom of bricks
		if((ball.getY())==(brick1.getY()+brick1.getHeight()) &&
				(ball.getX()>brick1.getX()) && ((ball.getX()+ball.getWidth())<(brick1.getX()+brick1.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if((ball.getY())==(brick2.getY()+brick2.getHeight()) &&
				(ball.getX()>brick2.getX()) && ((ball.getX()+ball.getWidth())<(brick2.getX()+brick2.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if((ball.getY())==(brick3.getY()+brick3.getHeight()) &&
				(ball.getX()>brick3.getX()) && ((ball.getX()+ball.getWidth())<(brick3.getX()+brick3.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if((ball.getY())==(brick4.getY()+brick4.getHeight()) &&
				(ball.getX()>brick4.getX()) && ((ball.getX()+ball.getWidth())<(brick4.getX()+brick4.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if((ball.getY())==(brick5.getY()+brick5.getHeight()) &&
				(ball.getX()>brick5.getX()) && ((ball.getX()+ball.getWidth())<(brick5.getX()+brick5.getWidth())))
		{
			ball.setXSpeed(ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		//left of ball collides with right of bricks
		if((ball.getX())==(brick1.getX()+brick1.getWidth()) &&
				(ball.getY()>brick1.getY()) && (ball.getY()+ball.getHeight())<(brick1.getY()+brick1.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX())==(brick2.getX()+brick2.getWidth()) &&
				(ball.getY()>brick2.getY()) && (ball.getY()+ball.getHeight())<(brick2.getY()+brick2.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX())==(brick3.getX()+brick3.getWidth()) &&
				(ball.getY()>brick3.getY()) && (ball.getY()+ball.getHeight())<(brick3.getY()+brick3.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX())==(brick4.getX()+brick4.getWidth()) &&
				(ball.getY()>brick4.getY()) && (ball.getY()+ball.getHeight())<(brick4.getY()+brick4.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX())==(brick5.getX()+brick5.getWidth()) &&
				(ball.getY()>brick5.getY()) && (ball.getY()+ball.getHeight())<(brick5.getY()+brick5.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		//right of ball collides with left of bricks
		if((ball.getX()+ball.getWidth())==(brick1.getX()) &&
				(ball.getY()>brick1.getY()) && (ball.getY()+ball.getHeight())<(brick1.getY()+brick1.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX()+ball.getWidth())==(brick2.getX()) &&
				(ball.getY()>brick2.getY()) && (ball.getY()+ball.getHeight())<(brick2.getY()+brick2.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX()+ball.getWidth())==(brick3.getX()) &&
				(ball.getY()>brick3.getY()) && (ball.getY()+ball.getHeight())<(brick3.getY()+brick3.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX()+ball.getWidth())==(brick4.getX()) &&
				(ball.getY()>brick4.getY()) && (ball.getY()+ball.getHeight())<(brick4.getY()+brick4.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		if((ball.getX()+ball.getWidth())==(brick5.getX()) &&
				(ball.getY()>brick5.getY()) && (ball.getY()+ball.getHeight())<(brick5.getY()+brick5.getHeight()))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
		}
		
		//ball collides with brick1 in any way
		if(((ball.getY()+ball.getHeight())==brick1.getY()) &&
				(ball.getX()>brick1.getX()) && ((ball.getX()+ball.getWidth())<(brick1.getX()+brick1.getWidth())) ||
				(ball.getY())==(brick1.getY()+brick1.getHeight()) &&
				(ball.getX()>brick1.getX()) && ((ball.getX()+ball.getWidth())<(brick1.getX()+brick1.getWidth())) ||
				(ball.getX())==(brick1.getX()+brick1.getWidth()) &&
				(ball.getY()>brick1.getY()) && (ball.getY()+ball.getHeight())<(brick1.getY()+brick1.getHeight()) ||
				(ball.getX()+ball.getWidth())==(brick1.getX()) &&
				(ball.getY()>brick1.getY()) && (ball.getY()+ball.getHeight())<(brick1.getY()+brick1.getHeight()))
		{
			graphToBack.clearRect(50,50,50,20);
			brick1 = new Block(3000,3000);
		}
		//ball collides with brick2 in any way
		if(((ball.getY()+ball.getHeight())==brick2.getY()) &&
				(ball.getX()>brick2.getX()) && ((ball.getX()+ball.getWidth())<(brick2.getX()+brick2.getWidth())) ||
				(ball.getY())==(brick2.getY()+brick2.getHeight()) &&
				(ball.getX()>brick2.getX()) && ((ball.getX()+ball.getWidth())<(brick2.getX()+brick2.getWidth())) ||
				(ball.getX())==(brick2.getX()+brick2.getWidth()) &&
				(ball.getY()>brick2.getY()) && (ball.getY()+ball.getHeight())<(brick2.getY()+brick2.getHeight()) ||
				(ball.getX()+ball.getWidth())==(brick2.getX()) &&
				(ball.getY()>brick2.getY()) && (ball.getY()+ball.getHeight())<(brick2.getY()+brick2.getHeight()))
		{
			graphToBack.clearRect(320,50,50,20);
			brick2 = new Block(3000,3000);
		}
		//ball collides with brick3 in any way
		if(((ball.getY()+ball.getHeight())==brick3.getY()) &&
				(ball.getX()>brick3.getX()) && ((ball.getX()+ball.getWidth())<(brick3.getX()+brick3.getWidth())) ||
				(ball.getY())==(brick3.getY()+brick3.getHeight()) &&
				(ball.getX()>brick3.getX()) && ((ball.getX()+ball.getWidth())<(brick3.getX()+brick3.getWidth())) ||
				(ball.getX())==(brick3.getX()+brick3.getWidth()) &&
				(ball.getY()>brick3.getY()) && (ball.getY()+ball.getHeight())<(brick3.getY()+brick3.getHeight()) ||
				(ball.getX()+ball.getWidth())==(brick3.getX()) &&
				(ball.getY()>brick3.getY()) && (ball.getY()+ball.getHeight())<(brick3.getY()+brick3.getHeight()))
		{
			graphToBack.clearRect(520,50,50,20);
			brick3 = new Block(3000,3000);
		}
		if(((ball.getY()+ball.getHeight())==brick4.getY()) &&
				(ball.getX()>brick4.getX()) && ((ball.getX()+ball.getWidth())<(brick4.getX()+brick4.getWidth())) ||
				(ball.getY())==(brick4.getY()+brick4.getHeight()) &&
				(ball.getX()>brick4.getX()) && ((ball.getX()+ball.getWidth())<(brick4.getX()+brick4.getWidth())) ||
				(ball.getX())==(brick4.getX()+brick4.getWidth()) &&
				(ball.getY()>brick4.getY()) && (ball.getY()+ball.getHeight())<(brick4.getY()+brick4.getHeight()) ||
				(ball.getX()+ball.getWidth())==(brick4.getX()) &&
				(ball.getY()>brick4.getY()) && (ball.getY()+ball.getHeight())<(brick4.getY()+brick4.getHeight()))
		{
			graphToBack.clearRect(150,100,50,20);
			brick4 = new Block(3000,3000);
		}
		if(((ball.getY()+ball.getHeight())==brick5.getY()) &&
				(ball.getX()>brick5.getX()) && ((ball.getX()+ball.getWidth())<(brick5.getX()+brick5.getWidth())) ||
				(ball.getY())==(brick5.getY()+brick5.getHeight()) &&
				(ball.getX()>brick5.getX()) && ((ball.getX()+ball.getWidth())<(brick5.getX()+brick5.getWidth())) ||
				(ball.getX())==(brick5.getX()+brick5.getWidth()) &&
				(ball.getY()>brick5.getY()) && (ball.getY()+ball.getHeight())<(brick5.getY()+brick5.getHeight()) ||
				(ball.getX()+ball.getWidth())==(brick5.getX()) &&
				(ball.getY()>brick5.getY()) && (ball.getY()+ball.getHeight())<(brick5.getY()+brick5.getHeight()))
		{
			graphToBack.clearRect(370,100,50,20);
			brick5 = new Block(3000,3000);
		}
		
		//all bricks are at (3000,3000)
		if(brick1.getX()==3000 && brick2.getX()==3000 && brick3.getX()==3000 && brick4.getX()==3000 && brick5.getX()==3000
				&& brick1.getY()==3000 && brick2.getY()==3000 && brick3.getY()==3000 && brick4.getY()==3000 && brick5.getY()==3000)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("YOU WIN!", 350, 300);
		}
		
		if(keys[0]==true)
			paddle.moveLeftAndDraw(graphToBack);
		if(keys[1]==true)
			paddle.moveRightAndDraw(graphToBack);
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
		case 'J' : keys[0]=true; break;
		case 'K' : keys[1]=true; break;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
		case 'J' : keys[0]=false; break;
		case 'K' : keys[1]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}

	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(8);
				repaint();
			}
		}catch(Exception e)
		{
		}
	}
}
