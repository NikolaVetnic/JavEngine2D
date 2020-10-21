package com.npv.game;

import java.awt.event.KeyEvent;
import java.io.IOException;

import com.npv.engine.AbstractGame;
import com.npv.engine.GameContainer;
import com.npv.engine.Renderer;
import com.npv.engine.gfx.Image;
import com.npv.engine.gfx.ImageTile;

public class GameManager extends AbstractGame {
	
	private ImageTile image;
	
	public GameManager() {
			
		try {
			
			image = new ImageTile("/anim.png", 16, 16);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc, float dt) {
		
		if (gc.getInput().isKeyDown(KeyEvent.VK_A))
			System.out.println("A was pressed.");
		
		temp += dt * 10;
		if (temp > 4) temp = 0;
	}
	
	// TEST TEST
	
	float temp = 0;

	@Override
	public void render(GameContainer gc, Renderer r) {
		
		r.drawImageTile(image, gc.getInput().getMouseX() - 8, gc.getInput().getMouseY() - 16, (int) temp, 0);
	}
	
	public static void main(String[] args) {
		
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
}
