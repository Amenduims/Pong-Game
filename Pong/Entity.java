package Amorim;

import java.awt.Graphics;

public abstract class Entity {
	
	
	

	
	private int width, height;
	private double x, y;

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	
	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public Entity(double x, double  y) {
		this.x = x;
		this.y = y;
	}
	

	public abstract void update();
	public abstract void render(Graphics g);
	
	
}
