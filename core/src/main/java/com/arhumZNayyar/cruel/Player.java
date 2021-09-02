package com.arhumZNayyar.cruel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Player {
    Sprite sprite;
    SpriteSheet spriteSheet;

    private String playerSpriteSheet = "Sprites/Player.png";
    private int playerPosX = 10;
    private int playerPosY = 10;

    public Player() {
        init();
    }

    public void init() {
        spriteSheet = new SpriteSheet(new Texture(Gdx.files.internal(playerSpriteSheet)), 31, 31);
        System.out.println("Sprite Sheet: " + spriteSheet.getTotalColumns() + " total rows: " + spriteSheet.getTotalRows() + " total frames: " + spriteSheet.getTotalFrames());

        // sprite = new Sprite(new Texture(Gdx.files.internal(playerSpriteSheet)), 31, 31);
        // sprite.setPosition(playerPosX, playerPosY);
    }

    public Sprite getSprite() {
        return spriteSheet.getSprite(0);
    }
}
