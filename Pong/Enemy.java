package Amorim;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity{

	
	private boolean left, right;
	private double ballX, ballY;
	
	public Enemy(int x, int y) {
		super(x, y);
		this.setWidth(40);
		this.setHeight(5);
	}

	
	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		
		this.right = right;
	}




	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		
			this.left = left;
	}
	
	
	public void getBallX(double x) {
		this.ballX = x;
	}
	
	public double ballX() {
		return this.ballX;
	}
	
	public void getballY(double y) {
		ballY = y;
	}
	
	public double ballY() {
		return this.ballY;
	}
	
	@Override
	public void update() {
		
		
		if(ballY >= 152 || ballY <= 1)
			this.setX(70);
		
		if(this.getX() >= 0) {
			if(this.getX() + 20 > ballX()) {
				this.setX(this.getX() - 0.9);
			}
		}
		
		if(this.getX() < 180 - this.getWidth()) {
			if(this.getX() + 20 < ballX()) {
				this.setX(this.getX() + 0.9);
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight());
	}
	
}
