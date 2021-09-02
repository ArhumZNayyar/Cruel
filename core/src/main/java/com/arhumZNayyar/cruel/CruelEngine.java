package com.arhumZNayyar.cruel;

import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;
import org.mini2Dx.tiled.TiledMap;

public class CruelEngine extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.arhumZNayyar.cruel";

    Viewport viewport;
    float gameWidth = 800;
    float gameHeight = 600;
    private Player player;
	private Texture texture;
    private TiledMap tiledMap;
    // private OrthographicCamera camera;
	
	@Override
    public void initialise() {
    	// texture = new Texture("mini2Dx.png");
         viewport = new FitViewport(gameWidth, gameHeight);
        player = new Player();
        try {
            tiledMap = new TiledMap(Gdx.files.internal("Maps/YurenField.tmx"));
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        // camera = new OrthographicCamera();
        // camera.setToOrtho(false, 400, 400);
    }
    
    @Override
    public void update(float delta) {
        player.update(delta);
        // camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);
        // camera.update();
    }
    
    @Override
    public void interpolate(float alpha) {
        player.interpolate(alpha);
    }
    
    @Override
    public void render(Graphics g) {
        viewport.apply(g);
        System.out.println("Player X/Y: " + player.getSprite().getX() + " , " + player.getSprite().getY());
        if (player.getSprite().getX() < tiledMap.getPixelWidth() && player.getSprite().getY() < tiledMap.getPixelHeight()) {
            g.translate(player.getSprite().getX() - gameWidth / 2, player.getSprite().getY() - gameHeight / 2);
        }
        tiledMap.draw(g, 0, 0);
        player.draw(g);
    }
}
