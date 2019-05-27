/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TronGameImplementation;

import GameEngine.Boundary;
import GameEngine.Position;
import GameEngine.Direction;
import GameEngine.MovedGameObject;
import java.awt.Color;

/**
 *
 * @author Mohamed
 */
public class Player extends MovedGameObject{

    private Path path;
    
    public Player(Position position, Color color, Direction currentDirection) {

        this.position = position;
        this.color = color;
        this.direction = currentDirection; 
        this.path = new Path();
        this.moveAmount = 5;
    }

    public void move(Boundary bounds) {
        
        Position newPoint = new Position(position.getX(), position.getY());
        position = newPoint;
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

}