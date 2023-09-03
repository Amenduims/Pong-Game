package Amorim;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable, KeyListener{


	boolean x = false;
	boolean y = true;
	boolean a = true; 
	boolean b = false;
	
	int confirm;

	int pJogador;
	int pInimigo;
	
	private JFrame frame;
	private final int width = 180;
	private final int height = 160;
	private final int scale = 5;
	private boolean running;
	private Thread thread;
	
	public static Player player;
	public static Enemy enemy;
	public static Bola ball;
	public static Linha line;


	
	
	private BufferedImage image;

	
	
	
	
	public Game(){		
		this.setPreferredSize(new Dimension(width*scale,height*scale));
		frame = new JFrame("Amorim's Pong");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.addKeyListener(this);
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		player = new Player(70, height - 6);
		enemy = new Enemy(70, 1);
		ball = new Bola(85, height/2);
		line = new Linha(width/2, 0);


		
	}

	
	
	public synchronized void start() {		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	
	public void update() {	
		player.update();
		enemy.update();
		ball.update();
		
	
		
	}
	
	public void render() {	
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if( bs != null) {
			
			Graphics g = image.getGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0 ,width, height);
			
			
			pJogador = ball.PontosJogador();
			pInimigo = ball.PontosInimigo();
		
			g.setColor(Color.pink);
			g.setFont(new Font("Arial", Font.ITALIC, 10));
			g.drawString("PLayer: " + pJogador, 0, 157);
			g.drawString("Enemy: " + pInimigo, 0, 10);
			
			
			
			if(pInimigo == 10 ) {
				this.running=false;
				JOptionPane.showMessageDialog(null, "Inimigo ganhou!!!");
				confirm = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente ?");
				if (confirm == 0) {
					
					ball.resetPontosJogador();
					ball.resetPontosInimigo();
					player.setX(70);
					enemy.setX(70);
					this.running = true;
				}
			}
			
			if(pJogador == 10 ) {
				this.running=false;
				JOptionPane.showMessageDialog(null, "Jogador ganhou!!!");
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente ?");
				if (confirm == 0) {
					ball.resetPontosJogador();
					ball.resetPontosInimigo();
					player.setX(70);
					enemy.setX(70);
					this.running = true;
				}
			}
			    
			
			player.render(g);
			enemy.render(g);
			ball.render(g);
	
	
			
	
	
			g = bs.getDrawGraphics();
			g.drawImage(image, 0, 0, width*scale, height*scale, null);
			
			
			
			bs.show();
			
		}else {
			this.createBufferStrategy(3);
		}
	}
	
	
	
	@Override
	public void run() {
		
		String dificuldade = JOptionPane.showInputDialog(null, "1 - fácil   2- médio   3- difícil ?");
		
		while(running) {
			
			
			int velocidade = 0, velocidadeFinal = 0;
			
			velocidade = Integer.parseInt(dificuldade);
			
			if(velocidade == 1)
				velocidadeFinal = 90;
			else if(velocidade == 2)
				velocidadeFinal = 120;
			else if(velocidade == 3)
				velocidadeFinal = 240;
			else
				velocidadeFinal = 90;
			
			
			update();
			render();
			
			ball.getPlayerX(player.getX());
			ball.getEnemyX(enemy.getX());
			enemy.getBallX(ball.getX());
			enemy.getballY(ball.getY());
			player.ballY(ball.getY());
			
			
			try {
				
			Thread.sleep(1000/velocidadeFinal);
			
			}catch(InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
	
	@Override
	public void keyPressed(KeyEvent k) {
		
		if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.setRight(true);
				//ball.setDown(true);
		}	
		
		if(k.getKeyCode() == KeyEvent.VK_LEFT) {
				player.setLeft(true);
				//ball.setUp(true);
			
		}
		
		/*if(k.getKeyCode() == KeyEvent.VK_D) {
				enemy.setRight(true);
		}	
		
		if(k.getKeyCode() == KeyEvent.VK_A) {
				enemy.setLeft(true);
			
		}*/
		
		
	}



	@Override
	public void keyReleased(KeyEvent k) {
		if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setRight(false);
			//ball.setDown(false);
		}
		
		
		
		if(k.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setLeft(false);
			//ball.setUp(false);
		}
		
		/*if(k.getKeyCode() == KeyEvent.VK_D) {
			enemy.setRight(false);
		}
		
		if(k.getKeyCode() == KeyEvent.VK_A) {
			enemy.setLeft(false);
		}*/
		
		
	
		
	}	
		
		

}
