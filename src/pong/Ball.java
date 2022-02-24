package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 0.0;
	public Rectangle crash;
	public int atingido;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		//int angle = new Random().nextInt(135 - 45) + 45;		
		//dx = Math.cos(Math.toRadians(angle));
		//dy = Math.sin(Math.toRadians(angle));
	
		dx = .01 * 0;
		dy = .01 * 100;
	}
		
	public void tick() {
		
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx *= -1;									
		} else if(x+(dx*speed) < 0) {
			dx *= -1;
		}
		
		if(y >= Game.HEIGHT )
		{
			//Ponto do inimigo
			//new Game();
			Game.restartGame(1);
			return;
		} else if(y < 80) {
			//Ponto do jogador
			//new Game();
			Game.restartGame(2);
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+dy*speed), width, height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
				
		if(bounds.intersects(boundsPlayer)) {
			crash = bounds.intersection(boundsPlayer);
			atingido = crash.x - boundsPlayer.x - boundsPlayer.width/2 ;
			dx = .1 * atingido;
			dy *= -1;
		} else if(bounds.intersects(boundsEnemy)) {
			crash = bounds.intersection(boundsEnemy);
			atingido = crash.x - boundsEnemy.x - boundsEnemy.width/2;
			dx = .1 * atingido;
			dy *= -1;
		}
		
		x += dx*speed;
		y += dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int) y, width, height);
	}
}
