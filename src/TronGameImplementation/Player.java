/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TronGameImplementation;

import GameEngine.PointPosition;
import GameEngine.ScreenManager;
import GameEngine.Direction;
import GameEngine.Direction.Directions;
import GameEngine.GameObject;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class Player extends GameObject{

    public Player(PointPosition point, Color color, Directions initialDirection) {

        this.p = point;
        this.color = color;
        this.currentDirection = initialDirection;
        moveAmount = 5;
        
        pointPositions = new ArrayList();

        this.sr = sr;
    }

    public void move() {
        
        PointPosition p1 = new PointPosition(p.xPosition, p.yPosition);
        p = p1;
        if (currentDirection == Directions.UP) {
            if (p.yPosition > 0) {
                p.yPosition -= moveAmount;
            } else {
                p.yPosition = sr.getHeight();
            }
        }
        
        else if (currentDirection == Directions.DOWN) {
            if (p.yPosition < sr.getHeight()) {
                p.yPosition += moveAmount;
            } else {
                p.yPosition = 0;
            }
        }
        
        else if (currentDirection == Directions.RIGHT) {
            if (p.xPosition < sr.getWidth()) {
                p.xPosition += moveAmount;
            } else {
                p.xPosition = 0;
            }
        }
        
        else if (currentDirection == Directions.LEFT) {
            if (p.xPosition > 0) {
                p.xPosition -= moveAmount;
            } else {
                p.xPosition = sr.getWidth();
            }
        }

    }

    
}


