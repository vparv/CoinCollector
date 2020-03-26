//Vineet Parvathala

//the game is very basic at this point, more is soon to come!

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.awt.image.*;
import java.applet.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class CoinCollector extends JPanel implements KeyListener,Runnable,MouseListener,MouseMotionListener
{
	private float angle;
	private int x;
	private int y;
	private JFrame frame;
	Thread t;
	private boolean gameOn;
	private Font f;
	private Font l;
	int count;
	
	BufferedImage guy;
	BufferedImage image;
	BufferedImage[] guys=new BufferedImage[11];
	boolean restart=false;
	int imgCount=0;
	public CoinCollector()
	{
		frame=new JFrame();
		x=100;
		y=100;
		f=new Font("Courier",Font.BOLD,40);
		l=new Font("Courier",Font.BOLD,100);
		gameOn=true;

		 try {                
		          image = ImageIO.read(new File("Bank-PNG-Pic.png"));
		       } catch (IOException ex) {
		            
      }
		try {
			guy = ImageIO.read(new File("spinning-coin-spritesheet.png"));
			for(int x=0;x<11;x++)
				guys[x]=guy.getSubimage(x*171,1,171,170);
				imgCount++;

		}
		catch (IOException e) 
		{
		}

		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(2400,2000);
		frame.setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		t=new Thread(this);
		t.start();
	}

	public void run()
	{
		while(true)
		{
			if(gameOn)
			{


				repaint();
			}
			if(restart)
			{
				restart=false;
				gameOn=true;
			}
			try
			{
				t.sleep(10);
			}catch(InterruptedException e)
			{
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;


		g2d.setColor(Color.GRAY);
		g2d.fillRect(0,0,2400,2000);
		g2d.setColor(Color.BLACK);
		g2d.drawImage(guys[imgCount],x,y,50,50,null);
		g2d.drawImage(image,0,0,50,50,null);
		g2d.setFont(l);
		g2d.drawString("Coin Collector",11,70);
		g2d.setFont(f);
		g2d.drawString("Score:",11,220);
	
		g2d.drawString(""+count,13,250);
		imgCount++;
		
		if (imgCount==10)
		imgCount=0;

	}
	public void keyPressed(KeyEvent key)
	{
		System.out.println(key.getKeyCode());
		if(key.getKeyCode()==39)
		{
		x+=20;
			
		}
		if (key.getKeyCode()==37)
		{
		x-=20;
		}
		if (key.getKeyCode()==40)
		{
		y+=20;
		
		}
		if (key.getKeyCode()==38)
		{
		y-=20;
		}
		if(key.getKeyCode()==82)
			restart=true;
	}
	public void keyReleased(KeyEvent key)
	{
	}
	public void keyTyped(KeyEvent key)
	{
	}
	public void mouseMoved(MouseEvent e)
		{
		x=e.getX();
		y=e.getY();
		repaint();
	}
	public void mouseEntered(MouseEvent e)
			{
	
			}
	
		public void mouseExited(MouseEvent e)
			{
	
			}
		
		public void mouseDragged(MouseEvent e)
		{
	}
	public void mousePressed(MouseEvent e)
		{
	
		}
		public void mouseReleased(MouseEvent e)
		{
		}
		public void mouseClicked(MouseEvent e)
			{
				count++;
	
	   	 }
	
	
	public static void main(String args[])
	{
		CoinCollector app=new CoinCollector();
	}
}