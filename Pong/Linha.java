package Amorim;

import java.awt.Color;
import java.awt.Graphics;

public class Linha extends Entity{

	public Linha(int x, int y) {
		super(x, y);
		this.setWidth(1);
		this.setHeight(160);
	}

	@Override
	public void update() {

		
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.pink);
		g.fillRect((int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight());
	}
	
	

}
