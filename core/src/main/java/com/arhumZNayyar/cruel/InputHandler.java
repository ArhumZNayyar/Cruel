package com.arhumZNayyar.cruel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler {

    boolean wasWPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.W);
    }
    boolean wasSPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.S);
    }
    boolean wasDPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.D);
    }
    boolean wasAPressed() {
        return Gdx.input.isKeyPressed(Input.Keys.A);
    }
}
