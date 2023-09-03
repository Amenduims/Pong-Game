package Amorim;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity{
	
	private boolean right, left;
	
	double ballY;
	
	Game g ;
	
	
	public Player(int x, int y) {
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


	public void ballY(double y) {
		ballY = y;
	}
	
	
	@Override
	public void update() {
		
		
		if (ballY >= 152 || ballY <= 1)
			this.setX(70);
		
		if(isRight()) {
			if(getX() < 180 - this.getWidth())
				this.setX(getX() + 1);
			
		}else if(isLeft()) {
			if(getX() > 0)
				this.setX(getX() - 1);
			
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight());
	}
	
	
}
