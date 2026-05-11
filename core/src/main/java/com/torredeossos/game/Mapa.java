package com.torredeossos.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Mapa {

    private TiledMap mapa;
    private OrthogonalTiledMapRenderer renderizador;
    private TiledMapTileLayer camadaColisao;
    private Texture tileHighlight; // A textura para o brilho no chão

    public Mapa() {   
        mapa = new TmxMapLoader().load("Mapas/teste.tmx");
        renderizador = new OrthogonalTiledMapRenderer(mapa, 1f);
        
        // Buscamos a camada de colisão uma única vez para ganhar performance
        camadaColisao = (TiledMapTileLayer) mapa.getLayers().get("Agua-fundo");

        // Criamos um quadradinho branco dinâmico para o highlight (sem precisar de arquivo externo)
        Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        tileHighlight = new Texture(pixmap);
        pixmap.dispose();
    }

    public void drawMapa(OrthographicCamera cameraPrincipal) {
        renderizador.setView(cameraPrincipal);
        renderizador.render();
    }

    // MÉTODO NOVO: Desenha os tiles onde o player pode andar
    public void drawAcessibilidade(SpriteBatch batch, Characters player) {
        if (player.isSelected()) {
            int raio = 3; // Quantos tiles o herói alcança
            int pX = (int) (player.getX() / 64);
            int pY = (int) (player.getY() / 64);

            batch.setColor(0, 0.5f, 1, 0.3f); // Azul transparente
            
            for (int x = pX - raio; x <= pX + raio; x++) {
                for (int y = pY - raio; y <= pY + raio; y++) {
                    if (isAndavel(x * 64, y * 64)) {
                        batch.draw(tileHighlight, x * 64, y * 64, 64, 64);
                    }
                }
            }
            batch.setColor(Color.WHITE); // Reset cor do batch
        }
    }

    // MÉTODO NOVO: A pergunta mágica de colisão
    public boolean isAndavel(float worldX, float worldY) {
        int tx = (int) (worldX / 64);
        int ty = (int) (worldY / 64);

        if (camadaColisao != null) {
            TiledMapTileLayer.Cell celula = camadaColisao.getCell(tx, ty);
            // Se a célula existe e tem a propriedade que você pintou, NÃO é andável
            if (celula != null && celula.getTile() != null) {
                return !celula.getTile().getProperties().containsKey("colidivel");
            }
        }
        return true; // Se não tem nada bloqueando, pode passar
    }

    public void dispose() {
        mapa.dispose();
        renderizador.dispose();
        tileHighlight.dispose();
    }
}