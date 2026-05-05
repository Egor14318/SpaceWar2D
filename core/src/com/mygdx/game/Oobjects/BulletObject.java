package com.mygdx.game.Oobjects;


import static com.mygdx.game.GameSettings.BULLET_VELOCITY;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class BulletObject extends GameObject {
    public BulletObject(int x, int y, int width, int height, String texturePath, World world) {
        super(texturePath, x, y, width, height, world);
        body.setLinearVelocity(new Vector2(0, BULLET_VELOCITY));

    }
    public boolean hasToBeDestroyed() {
        return false;
    }


}
