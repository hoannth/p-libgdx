package com.hamudev.game.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.hamudev.game.util.Constants;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;

    public AssetFonts fonts;
    public AssetBunny bunny;
    public AssetRock rock;
    public AssetGoldCoin goldCoin;
    public AssetFeather feather;
    public AssetLevelDecoration levelDecoration;

    private Assets() {

    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);

        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
        assetManager.finishLoading();

        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
        for(String a : assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "\tAsset: " + a);
        }

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

        for (Texture t : atlas.getTextures())
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        fonts = new AssetFonts();
        bunny = new AssetBunny(atlas);
        rock = new AssetRock(atlas);
        goldCoin = new AssetGoldCoin(atlas);
        feather = new AssetFeather(atlas);
        levelDecoration = new AssetLevelDecoration(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset " + asset.fileName);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
        fonts.defaultNormal.dispose();
    }
}
