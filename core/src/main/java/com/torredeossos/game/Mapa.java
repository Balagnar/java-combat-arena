package com.torredeossos.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class Mapa {

    //Declaração de Variaveis
    private TiledMap mapa;
    private OrthogonalTiledMapRenderer renderizador;
    private OrthographicCamera camera;

    //Construtor - Só é chamado uma vez no Create() - recebe a textura e divide nós setores que são 9.
    public Mapa() {
        
        mapa = new TmxMapLoader().load("Mapas/teste.tmx");

        renderizador = new OrthogonalTiledMapRenderer(mapa);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

    }

    public void drawMapa(){

        camera.update();
        renderizador.setView(camera);
        renderizador.render();

    }
}
