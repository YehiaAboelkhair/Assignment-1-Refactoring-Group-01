/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameEngine;

import Model.PointPosition;
import Model.ScreenManager;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Mohamed
 */
public class Food {

    public ScreenManager sm;
    public PointPosition pointPosition;
    public Color color;
    int amount;
    public Food(PointPosition pointPosition, Color color, int constantAmount){
        this.pointPosition = pointPosition;
        this.color = color;
        this.amount = constantAmount;
    }

    
    public PointPosition GenerateFood(){
        
        Random rand = new Random(); 

        pointPosition.xPosition = rand.nextInt(sm.getWidth());
            pointPosition.yPosition = rand.nextInt(sm.getHeight());
        

        return pointPosition; 
    }
    
}
