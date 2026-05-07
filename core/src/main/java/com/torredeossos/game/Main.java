package com.torredeossos.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Mapa mapa;
    private Characters player;
    private FitViewport viewpoint;
    private OrthographicCamera camera;
    
    // Aqui foi o segredo: inicializar com o 'new' para evitar o NullPointerException
    private Vector3 vector = new Vector3(); 

    @Override
    public void resize(int width, int height) {
        viewpoint.update(width, height, true);
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Characters();

        camera = new OrthographicCamera();
        viewpoint = new FitViewport(1280, 955, camera);

        camera.position.set(1280 / 2f, 960 / 2f, 0);
        camera.update();
        
        mapa = new Mapa();
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);

        // Tudo o que depende do clique deve ficar dentro deste bloco
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            // 1. Pega a posição bruta do mouse
            vector.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            
            // 2. Traduz a posição da tela para o mundo (coordenadas do mapa)
            viewpoint.unproject(vector);

            // 3. Calcula a grade (Grid) dividindo pelo tamanho do Tile (64)
            int coluna = (int) (vector.x / 64);
            int linha = (int) (vector.y / 64);

            System.out.println("Clique na Coluna: " + coluna + " | Linha: " + linha);
        }

        // Movimentação e lógica do player
        player.update(Gdx.graphics.getDeltaTime());

        camera.update();
        mapa.drawMapa(camera);

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        // Lembre-se de dar dispose no mapa e nas texturas do player quando possível
    }
}