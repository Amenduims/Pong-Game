package Amorim;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Placar extends Entity{

	
	Graphics text ;
	
	public Placar(int x, int y) {
		super(x, y);
		this.setWidth(20);
		this.setHeight(20);

	}

	@Override
	public void update() {
		
	
		
	}

	@Override
	public void render(Graphics g) {

		g.fillRect((int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight());
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.pink);
		g.drawString("Olá mundo!!!", (int)this.getX(), (int)this.getY());
		
	}

}
