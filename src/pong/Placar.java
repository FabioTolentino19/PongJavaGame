package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Placar {
	
	public int x, y;
	
	public int width, height;
	
	String jog1="Comput", jog2="Fabio";
	public int Pjog1, Pjog2, diff;
	
	public Placar(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 160;
		this.height = 60;
		this.Pjog1 = 0;
		this.Pjog2 = 0;
		this.diff = 4;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.drawLine(0, 80, 200, 80);
		
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.white);
		g.drawString("Pong", 80-20 , 10);
		g.setFont(new Font("Dialog", Font.PLAIN, 9));
		g.setColor(Color.red);
		g.drawString("J1: " + jog1 + " - " + Pjog1, 10, 30);
		g.setColor(Color.yellow);
		g.drawString("ESC: Sair", 95, 30);
		g.setColor(Color.blue);
		g.drawString("J2: " + jog2 + " - " + Pjog2, 10, 40);
		g.setColor(Color.white);
		g.drawString("Dificuldade: " + diff, 10, 50);
		g.drawString("Jog:dir/esq", 95, 40);
		g.drawString("Dif:cima/baixo", 95, 50);
		g.drawString("Pressione Espaço para começar", 10, 75);
	}
	
	public void finishRender(Graphics g, int jogador) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.drawLine(0, 80, 200, 80);
		
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.white);
		g.drawString("Pong", 80-20 , 10);
		g.setFont(new Font("Dialog", Font.PLAIN, 9));
		g.setColor(Color.red);
		g.drawString("J1: " + jog1 + " - " + Pjog1, 10, 30);
		if(jogador == 1)
			g.drawString("Parabens " + jog1 + ", você ganhou !!!", 10, 60);
		g.setColor(Color.yellow);
		g.drawString("ESC: Sair", 110, 30);
		g.setColor(Color.blue);
		g.drawString("J2: " + jog2 + " - " + Pjog2, 10, 40);
		if(jogador == 2)
			g.drawString("Parabens " + jog2 + ", você ganhou !!!", 10, 60);
		g.setColor(Color.white);
		g.drawString("Dificuldade: " + diff, 10, 50);
		g.drawString("Pressione Espaço para começar", 10, 75);
	}
	
}

