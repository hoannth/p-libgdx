package com.hamudev.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hamudev.game.Assets.Assets;

public class Feather extends AbstractGameObject {

    private TextureRegion regFeather;
    public boolean collected;

    public Feather() {
        init();
    }

    private void init() {
        dimension.set(0.5f, 0.5f);
        regFeather = Assets.instance.feather.feather;

        bounds.set(0, 0, dimension.x, dimension.y);
        collected = false;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = regFeather;

        batch.draw(reg.getTexture(),
                position.x, position.y,
                origin.x, origin.y,
                dimension.x, dimension.y,
                scale.x, scale.y,
                rotation,
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }

    public int getScore() {
        return 250;
    }
}
