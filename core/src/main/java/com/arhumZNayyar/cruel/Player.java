package com.arhumZNayyar.cruel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Player {
    Sprite sprite;
    SpriteSheet spriteSheet;
    InputHandler inputHandler;

    private String playerSpriteSheet = "Sprites/Player.png";
    private float playerPosX = 10;
    private float playerPosY = 10;

    private CollisionPoint point;

    public Player() {
        init();
    }

    public void init() {
        spriteSheet = new SpriteSheet(new Texture(Gdx.files.internal(playerSpriteSheet)), 31, 31);
        System.out.println("Sprite Sheet: " + spriteSheet.getTotalColumns() + " total rows: " + spriteSheet.getTotalRows() + " total frames: " + spriteSheet.getTotalFrames());

        inputHandler = new InputHandler();
        point = new CollisionPoint();

        getSprite().setY(playerPosY);
        getSprite().setX(playerPosX);
        // sprite = new Sprite(new Texture(Gdx.files.internal(playerSpriteSheet)), 31, 31);
        // sprite.setPosition(playerPosX, playerPosY);
    }

    public void update(float delta) {
        checkInput(delta);
        if (playerPosX < 0)
            playerPosX = 0.0f;
        if (playerPosY < 0)
            playerPosY = 0.0f;
        getSprite().setY(playerPosY);
        getSprite().setX(playerPosX);

        point.preUpdate();
        point.set(playerPosX, playerPosY);
    }

    public void interpolate(float alpha) {
        point.interpolate(null, alpha);
    }

    public void draw(Graphics g) {
        g.drawSprite(getSprite(), point.getRenderX(), point.getRenderY());
    }

    public void checkInput(float delta) {
        if (inputHandler.wasWPressed()) {
            playerPosY -= 4.0f;
        }
        else if (inputHandler.wasSPressed()) {
            playerPosY += 4.0f;
        }
        else if (inputHandler.wasAPressed()) {
            playerPosX -= 4.0f;
        }
        else if (inputHandler.wasDPressed()) {
            playerPosX += 4.0f;
        }
    }

    public Sprite getSprite() {
        return spriteSheet.getSprite(0);
    }
}
