/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.PointPosition;
import GameEngine.ScreenManager;
import GameEngine.ScreenResolution;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Mohamed
 */
public class Food {

    public ScreenResolution sr;
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

        pointPosition.xPosition = rand.nextInt(sr.getWidth());
            pointPosition.yPosition = rand.nextInt(sr.getHeight());
        

        return pointPosition; 
    }
    
}
