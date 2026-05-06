package com.torredeossos.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Mapa mapa;

    @Override
    public void create() {
        batch = new SpriteBatch();
        
    }

    @Override
    public void render() {

        // Cor de fundo (Navy Blue escuro)
        ScreenUtils.clear(Color.valueOf("#47aba9"));

        //Inicia o Render
        batch.begin();
        
        // Primeiro: Desenha o chão (passando o empurrão do Offset)
        mapa = new Mapa();
        mapa.drawMapa();
        
        //Finaliza o Render
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        // É bom dar dispose nas texturas depois, mas por enquanto foque no movimento
    }
}