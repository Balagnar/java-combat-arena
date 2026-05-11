package com.torredeossos.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    TiledMap mapa;
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    Characters player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        
        // Carrega o mapa e o renderer
        mapa = new TmxMapLoader().load("Mapas/teste.tmx"); // Ajuste para o nome do seu arquivo
        renderer = new OrthogonalTiledMapRenderer(mapa);
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        player = new Characters();
        // Aqui você carregaria o seletor único que criamos
        // player.setSeletor(new TextureRegion(new Texture("UI/seletor_unico.png")));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        renderer.render();

        // --- LÓGICA DE INPUT E COLISÃO ---
        if (Gdx.input.justTouched()) {
            Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click);

            // 1. Se clicar no boneco, seleciona ele
            if (player.foiClicado(click.x, click.y)) {
                player.setSelected(true);
            } 
            // 2. Se já estiver selecionado e clicar no chão, tenta mover
            else if (player.isSelected()) {
                if (!isTileColidivel(click.x, click.y)) {
                    player.setTarget(click.x, click.y);
                }
            }
        }

        player.update(Gdx.graphics.getDeltaTime());

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
    }

    // O MÉTODO QUE LÊ A PROPRIEDADE NO TILED
    private boolean isTileColidivel(float worldX, float worldY) {
        // Converte pixel para a grade do tile (64x64)
        int tileX = (int) (worldX / 64);
        int tileY = (int) (worldY / 64);

        // Pega a camada que você configurou (ex: Agua-fundo)
        TiledMapTileLayer camada = (TiledMapTileLayer) mapa.getLayers().get("Agua-fundo");

        if (camada != null) {
            TiledMapTileLayer.Cell celula = camada.getCell(tileX, tileY);
            if (celula != null && celula.getTile() != null) {
                // Checa se o tile nessa célula tem a propriedade "colidivel"
                return celula.getTile().getProperties().containsKey("colidivel");
            }
        }
        return false; // Se não tem tile ou camada, está livre para andar
    }

    @Override
    public void dispose() {
        batch.dispose();
        mapa.dispose();
        renderer.dispose();
    }
}