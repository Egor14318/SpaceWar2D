package com.mygdx.game.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Oobjects.ShipObject;

public class GameScreen extends ScreenAdapter {

    MyGdxGame myGdxGame;
    ShipObject shipObject;
    public GameScreen(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;
        shipObject = new ShipObject(
                GameSettings.SCREEN_WIDTH / 2, 150,
                GameSettings.SHIP_WIDTH, GameSettings.SHIP_HEIGHT,
                GameResources.gameResources.SHIP_IMG_PATH,
                myGdxGame.world
        );

    }
    @Override
    public void render(float delta){
        myGdxGame.stepWorld();
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);
        myGdxGame.batch.begin();
        shipObject.draw(myGdxGame.batch);
        myGdxGame.batch.end();

    }


}

