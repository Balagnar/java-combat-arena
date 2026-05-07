package com.torredeossos.game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class Mapa {

    //Declaração de Variaveis
    private TiledMap mapa;
    private OrthogonalTiledMapRenderer renderizador;

    //Construtor - Só é chamado uma vez no Create() - recebe a textura e divide nós setores que são 9.
    public Mapa() {   
        mapa = new TmxMapLoader().load("Mapas/teste.tmx");
        renderizador = new OrthogonalTiledMapRenderer(mapa, 1f);

    }

    public OrthogonalTiledMapRenderer getRenderizador() {
        return renderizador;
    }

    public void drawMapa(OrthographicCamera cameraPrincipal){
        renderizador.setView(cameraPrincipal);
        renderizador.render();

    }
}
