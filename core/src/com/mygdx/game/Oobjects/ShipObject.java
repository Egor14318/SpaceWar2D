package com.mygdx.game.Oobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameSettings;

public class ShipObject extends GameObject {
    public ShipObject(int x, int y, int width, int height, String texturePath, World world) {
        super(texturePath, x, y, width, height, world);
    }

    private void putInFrame() {
        if (getY() > (GameSettings.SCREEN_HEIGHT / 2f - height / 2f)) {
            setY(GameSettings.SCREEN_HEIGHT / 2 - height / 2);

        }
        if (getY() <= (height / 2)) {
            setY(height / 2);

        }
        if (getX()>(GameSettings.SCREEN_WIDTH + width / 2f)){
            setX(0);
        }
        if (getX()< (-width/2f)){
            setX(GameSettings.SCREEN_WIDTH);
        }
    }


    public void move(Vector3 vector3){
        float fx = (vector3.x - getX()) * GameSettings.SHIP_FORCE_RATIO;
        float fy = (vector3.y - getY()) * GameSettings.SHIP_FORCE_RATIO;
        body.applyForceToCenter(
                new Vector2(
                        (vector3.x - getX()) * GameSettings.SHIP_FORCE_RATIO,
                        (vector3.y - getY()) * GameSettings.SHIP_FORCE_RATIO
                ),
                true
        );body.setLinearDamping(10);

    }

    @Override
    public void draw(SpriteBatch batch) {
        putInFrame();
        super.draw(batch);
    }



}
