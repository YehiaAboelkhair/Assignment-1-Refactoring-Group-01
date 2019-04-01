/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.Direction;
import GameEngine.GameObject;
import GameEngine.PointPosition;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class Snake extends GameObject{
    
    boolean haveEaten;
    Color headColor;
    public Snake(PointPosition point, Color snakeColor, Color snakeHeadColor, Direction.Directions initialDirection) {

        this.p = point;
        this.color = snakeColor;
        this.headColor = snakeHeadColor;
        this.currentDirection = initialDirection;
        moveAmount = 10;
        haveEaten = false;
        pointPositions = new ArrayList();
        startSnakePoints(point);
    }

    public void startSnakePoints(PointPosition point){
    
        int xPosition = 0;
          for (int i = 0; i < 10; i++) {
           pointPositions.add(new PointPosition(point.xPosition + xPosition , point.yPosition));
           xPosition = pointPositions.get(i).xPosition; 
        }
        
           
 }
    
    
    public void move() {
        
        p = new PointPosition(p.xPosition, p.yPosition);
                
        if (currentDirection == Direction.Directions.UP) {
            if (p.yPosition > 0) {
                p.yPosition -= moveAmount;
            } else {
                p.yPosition = sr.getHeight();
            }
        }
        
        else if (currentDirection == Direction.Directions.DOWN) {
            if (p.yPosition < sr.getHeight()) {
                p.yPosition += moveAmount;
            } else {
                p.yPosition = 0;
            }
        }
        
        else if (currentDirection == Direction.Directions.RIGHT) {
            if (p.xPosition < sr.getWidth()) {
                p.xPosition += moveAmount;
            } else {
                p.xPosition = 0;
            }
        }
        
        else if (currentDirection == Direction.Directions.LEFT) {
            if (p.xPosition > 0) {
                p.xPosition -= moveAmount;
            } else {
                p.xPosition = sr.getWidth();
            }
        }
        
        if(!haveEaten){
            pointPositions.remove(0);
        }
        haveEaten = false;

    }
   
    
}
