package com.torredeossos.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;

public class Characters {

    private Animation<TextureRegion> idleAnim, runAnim, currentAnim;
    public Texture idleSheet, runSheet;

    private TextureRegion seletor;
    private boolean isSelected = false;
    
    private float stateTime;
    private float x = 200;
    private float y = 200;

    // --- VARIÁVEIS PARA O CLIQUE ---
    private float targetX = 200;
    private float targetY = 200;
    private float velocidade = 200f; 

    public Characters() {
        idleSheet = new Texture("Character/Units/Blue_Units/Warrior/Warrior_Idle.png");
        runSheet = new Texture("Character/Units/Blue_Units/Warrior/Warrior_Run.png");

        TextureRegion[][] tmpIdle = TextureRegion.split(idleSheet, 192, 192);
        TextureRegion[] idleFrames = new TextureRegion[8];
        for(int i = 0; i < 8; i++) idleFrames[i] = tmpIdle[0][i];
        idleAnim = new Animation<>(0.1f, idleFrames);

        TextureRegion[][] tmpRun = TextureRegion.split(runSheet, 192, 192);
        TextureRegion[] runFrames = new TextureRegion[6];
        for(int i = 0; i < 6; i++) runFrames[i] = tmpRun[0][i];
        runAnim = new Animation<>(0.1f, runFrames);

        currentAnim = idleAnim; 
        stateTime = 0f;
    }

    public void update(float delta) {
        stateTime += delta;
        boolean movendo = false;

        // Cálculo de distância até o alvo
        float dx = targetX - x;
        float dy = targetY - y;
        float distancia = (float) Math.sqrt(dx * dx + dy * dy);

        // Só move se estiver a mais de 5 pixels do destino (evita tremedeira)
        if (distancia > 5) {
            movendo = true;
            // Normaliza o movimento (anda na mesma velocidade em qualquer direção)
            x += (dx / distancia) * velocidade * delta;
            y += (dy / distancia) * velocidade * delta;
        }

        if (movendo) {
            currentAnim = runAnim;
        } else {
            currentAnim = idleAnim;
        }
    }

    public void draw(SpriteBatch batch) {
        if (isSelected && seletor != null) {
            batch.draw(seletor, x + 4, y, 128, 128); 
        }

        TextureRegion frame = currentAnim.getKeyFrame(stateTime, true);
        batch.draw(frame, x - 32, y - 20, 192, 192);
    }

    // --- MÉTODOS AUXILIARES ---

    public void setTarget(float tx, float ty) {
        // Ajustamos o target para o centro da hitbox (opcional)
        this.targetX = tx - 64; 
        this.targetY = ty - 64;
    }

    public boolean foiClicado(float mouseX, float mouseY) {
        // Checa se o clique foi dentro da área do personagem
        return mouseX >= x && mouseX <= (x + 128) && mouseY >= y && mouseY <= (y + 128);
    }

    public Rectangle getHitbox() {
        return new Rectangle(x, y, 128, 128);
    }

    public void setSeletor(TextureRegion seletorParam) { this.seletor = seletorParam; }
    public void setSelected(boolean status) { this.isSelected = status; }
    public boolean isSelected() { return isSelected; }
}