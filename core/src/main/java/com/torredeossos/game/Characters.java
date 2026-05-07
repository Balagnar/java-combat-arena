package com.torredeossos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;;

public class Characters {

    private Animation<TextureRegion> idleAnim, runAnim, currentAnim;

    public Texture idleSheet;
    public Texture runSheet;
    
    private float stateTime;
    private float x = 200, y = 260;

    public Characters(){

        //---INICIO DA ANIMAÇÃO DE FICAR PARADO---//

        idleSheet = new Texture("Character/Units/Blue_Units/Warrior/Warrior_Idle.png");
        runSheet = new Texture("Character/Units/Blue_Units/Warrior/Warrior_Run.png");

        TextureRegion[][] tmpIdle = TextureRegion.split(idleSheet, 192, 192);
        TextureRegion[] idleFrames = new TextureRegion[8 * 1];

        int index = 0;
        for(int i=0; i < 8; i++){
            idleFrames[index++] = tmpIdle[0][i];
        }

        idleAnim = new Animation<TextureRegion>(0.1f, idleFrames);

        //---INICIO DA ANIMAÇÃO DE CORRER---//

        TextureRegion[][] tmpRun = TextureRegion.split(runSheet, 192, 192);
        TextureRegion[] runFrames = new TextureRegion[6 * 1];

        index = 0;
        for(int i=0; i < 6; i++){
            runFrames[index++] = tmpRun[0][i];
        }

        runAnim = new Animation<TextureRegion>(0.1f, runFrames);

        stateTime = 0f;
    }

    //Metodo que faz a animação "andar"
    public void update(float delta){
        stateTime += delta;
        boolean movendo = false;

        if(Gdx.input.isKeyPressed(Input.Keys.W)){   
            y += 200 * delta;
            movendo = true;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.A)){   
            x -= 200 * delta;
            movendo = true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){   
            y -= 200 * delta;
            movendo = true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){   
            x += 200 * delta;
            movendo = true;

        }
        
        if(movendo){
            currentAnim = runAnim;
        } else {
            currentAnim = idleAnim;
        }
    }

    //Metodo que faz a animação sempre se atualizar com o frameAtual
    public void draw(SpriteBatch batch){
        TextureRegion frame = currentAnim.getKeyFrame(stateTime, true); //true impede o loop de parar
        batch.draw(frame, x, y);
    }

}
