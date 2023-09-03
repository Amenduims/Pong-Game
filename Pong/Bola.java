package Amorim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bola extends Entity {

	int pontosJogador = 0;
	int pontosInimigo = 0;
	
	boolean x = false;
	boolean y = true;
	
	boolean a = false; 
	boolean b = false;
	
	boolean c = false;
	boolean c1 = false;
	
	
	boolean d = false;
	boolean d1 = false;
	
	double velocityUp = 0.4, velocityDown = 0.4;
	
	
	int scorePLayer = 0;
	int scoreEnemy = 0;

	double  playerX, enemyX, var;

	
	Random Random = new Random();
	
	
	private boolean up, down;
	
	public boolean isDown() {
		return this.down;
	}

	public void setDown(boolean down) {
		
		this.down = down;
	}


	public boolean isUp() {
		return this.up;
	}

	public void setUp(boolean up) {
		
			this.up = up;
	}
	
	
	public Bola(double x, double y) {
		super(x, y);
		this.setWidth(10);
		this.setHeight(7);
	}

	
	@Override
	public void update() {
		
		if(isUp()) {
			if(getY() > 0)
				this.setY(getY() - velocityDown);
			
		}else if(isDown()) {
			if(getY() < 160 - this.getHeight())
				this.setY(getY() + velocityUp);
		}
		
		ballMovement();
	}

	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval((int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight());
		
	}
	
	
	
	public void resetPontosJogador() {
		this.pontosJogador = 0;
	}
	
	public void resetPontosInimigo() {
		this.pontosInimigo = 0;
	}
	
	public int PontosJogador() {
		return pontosJogador;
	}
	
	public int PontosInimigo() {
		return pontosInimigo;
	}
	
	
	public void getPlayerX( double x) {
		this.playerX = x;
	}
	
	public double getPlayerX() {
		return this.playerX;
	}
	
	public void getEnemyX( double x) {
		this.enemyX = x;
	}
	
	public double getEnemyX() {
		return this.enemyX;
	}
	

	
	public void ballMovement(){
			
			
		
			
			this.setUp(x);
			this.setDown(y);
			ballRight(a);
			ballLeft(b);
			
			
			
			if(this.getX() >= getPlayerX()- 10 && this.getX() <= getPlayerX() + 40 && this.getY() > 153 - 5) {
				x = true;
				y = false;
				
				
				if(a == false && b == false && this.getX() >= getPlayerX() - 10 && this.getX() <= getPlayerX() + 20)
					c = true;
				else if(a == false && b == false && this.getX() >= getPlayerX() +20 && this.getX() <= getPlayerX() + 40)
					c1 = true;
				
				 var = Random.nextDouble(0.5, 1.2);
				 
				 velocityDown = 1.0;
				 velocityUp = 1.0;
			
			}
			
			ballRight(c1);
			ballLeft(c);
			
			if(this.getX() > 180 - this.getWidth()) {
				a = false;
				b = true;
				
				c = false;
				c1 = false;


			}
			
			if(this.getX() < 0) {
				b = false;
				a = true;
				
				c = false;
				c1 = false;

			}
			
			
			if(this.getX() >= getEnemyX() - 10 && this.getX() <= getEnemyX() + 40 && this.getY() <  5) {
				y = true;
				x = false;
				
				var = Random.nextDouble(0.5, 1.2);
				
				if(a == false && b == false && this.getX() >= getEnemyX() - 10 && this.getX() <= getEnemyX() + 20)
					c = true;
				else if(a == false && b == false && this.getX() >= getEnemyX() +20 && this.getX() <= getEnemyX() + 40)
					c1 = true;
				
				
				velocityDown = 1.0;
				velocityUp = 1.0;
				 
			}
			

			if(this.getY() >= 153) {
				
				
				pontosInimigo += 1;
				
				this.setY(160/2);
				this.setX(180/2);
				a = false;
				b = false;
				
				c = false;
				c1 = false;
	
				x = false;
				y = true;
				
				velocityDown = 0.5;
				velocityUp = 0.5;
			}
			
			if(this.getY() <= 0) {

				pontosJogador += 1;
				this.getPlayerX(70);
				this.getEnemyX(70);
				
				this.setY(160/2);
				this.setX(180/2);
				a = false;
				b = false;
				
				c = false;
				c1 = false;
				
				x = true;
				y = false; 
				
				velocityDown = 0.5;
				velocityUp = 0.5;
				 
			}
			
		}
		
		
		
		
		
		public void ballLeft(boolean op) {		
			if(op == true) {	
				this.setX(this.getX() - var);
			}
		}
		
		public void ballRight(boolean op) {			
			if(op == true) {
				this.setX(this.getX() + var);
			}
		}
	

}
