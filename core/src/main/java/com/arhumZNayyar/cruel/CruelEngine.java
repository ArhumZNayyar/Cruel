package com.arhumZNayyar.cruel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.tiled.TiledMap;

import java.io.IOException;

public class CruelEngine extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.arhumZNayyar.cruel";

    private Player player;
	private Texture texture;
    private TiledMap tiledMap;
	
	@Override
    public void initialise() {
    	// texture = new Texture("mini2Dx.png");
        player = new Player();
        try {
            tiledMap = new TiledMap(Gdx.files.internal("Maps/YurenField.tmx"));
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(float delta) {
    
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
		g.drawTexture(texture, 0f, 0f);
        g.drawString("Hello World!", 32, 32);
        tiledMap.draw(g, 0, 0);
        g.drawSprite(player.getSprite());
    }
}
