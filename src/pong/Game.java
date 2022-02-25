package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 160;
	public static int HEIGHT = 230;
	public static int SCALE = 3;
	private static boolean isRunning = true;
	private static int ganhador;
	
	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	public static Placar placar;
		
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		this.addKeyListener(this);
		
		player = new Player(80-15, HEIGHT-5);
		enemy = new Enemy(80-15, 90);
		ball = new Ball(80, ((230-100)/2) + 90);
		placar = new Placar(0,0);
		ganhador = 0;
	}
	
	public static void restartGame(int jogador) {
		if(jogador == 1) {
			placar.Pjog1++;
			if(placar.Pjog1 == 3) {
				ganhador = 1;
				Sound.winComput.play(Sound.effectsVolume);
			}
		}
		else {
			placar.Pjog2++;
			if(placar.Pjog2 == 3) {
				ganhador = 2;
				Sound.winPlayer.play(Sound.effectsVolume);
			}
		}
		player.x = 80-15;
		player.y = HEIGHT-5;
		enemy.x = 80-15;
		enemy.y = 90;
		ball.x = 80-2;
		ball.y = ((230-100)/2)+90;
		ball.speed = 0.0;
		ball.dx = 0;
	}

	public static void main(String[] args) {
		Game game = new Game();		
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
		placar.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		//Fundo
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		placar.render(g);
		if(ganhador != 0)
			placar.finishRender(g, ganhador);
		
		g = bs.getDrawGraphics();		
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
	}
		
	@Override
	public void run() {
		requestFocus();
		while(isRunning) {
			tick();
			render();
			try {
				Thread.sleep(1000/120);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(ganhador != 0) {
				ganhador = 0;
				placar.Pjog1 = 0;
				placar.Pjog2 = 0;				
			}
			ball.speed = 1;
			//Sound.backgroundMusic.play(Sound.musicVolume);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			isRunning = false;
			System.exit(1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(placar.diff < 9)
				placar.diff ++;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(placar.diff > 1)
				placar.diff --;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}

}
