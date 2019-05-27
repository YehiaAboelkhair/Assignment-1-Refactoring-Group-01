package GameEngine;

import java.awt.Color;

/**
 *
 * @author Mohamed
 */
public abstract class MovedGameObject extends GameObject{
    protected Direction direction;
    protected int moveAmount;

    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public Direction getDirection(){
        return this.direction;
    }
}
