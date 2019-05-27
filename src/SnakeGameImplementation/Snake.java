/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.Boundary;
import GameEngine.Direction;
import GameEngine.MovedGameObject;
import GameEngine.Position;
import GameEngine.Path;
import java.awt.Color;

/**
 *
 * @author Mohamed
 */
public class Snake extends MovedGameObject{
    
    private boolean haveEaten;
    private Color headColor;
    private Path path;
    public Snake(Position point, Color snakeColor, Color snakeHeadColor, Direction initialDirection) {

        this.position = point;
        this.color = snakeColor;
        this.headColor = snakeHeadColor;
        this.direction = initialDirection;
        moveAmount = 5;
        haveEaten = false;
        this.path = new Path();
        startSnakePoints();
    }
    
    public void startSnakePoints(){
        int x = 5;
        Position point = new Position(position.getX(), position.getY());
        for (int i = 0; i < 10; i++) {
           path.add(point);
           point = new Position(point.getX() + x , point.getY());
        } 
        this.position = point;
    }
    public void move(Boundary bounds) {
        
        position = new Position(position.getX(), position.getY());
                
         if (this.direction == Direction.UP) {
            if (position.getY() > 0) {
                position.setY(position.getY() - moveAmount);
            } else {
                position.setY(bounds.getHeight());
            }
        }
        
        else if (this.direction == Direction.DOWN) {
            if (position.getY() < bounds.getHeight()) {
                position.setY(position.getY() + moveAmount);
            } else {
                position.setY(0);
            }
        }
        
        else if (direction == Direction.RIGHT) {
            if (position.getX() < bounds.getWidth()) {
                position.setX(position.getX() + moveAmount);
            } else {
                position.setX(0);
            }
        }
        
        else if (direction == Direction.LEFT) {
            if (position.getX() > 0) {
                position.setX(position.getX() - moveAmount);
            } else {
                position.setX(bounds.getWidth());
            }
        }
        
    }

    public Path getPath() {
        return path;
    }
    
    public Color getHeadColor()
    {
        return this.headColor;
    }
    
    public void setHaveEaten(boolean haveEaten){
        this.haveEaten = haveEaten;
    }
    
    public boolean getHaveEaten(){
        return haveEaten;
    }
    
}
