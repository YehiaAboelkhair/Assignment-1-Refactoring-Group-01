/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.Boundary;
import GameEngine.GameObject;
import GameEngine.Position;
import GameEngine.ScreenManager;
import GameEngine.ScreenResolution;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Mohamed
 */
public class Food extends GameObject{

    private int amount;
    public Food(Position point, Color color){
        this.position = point;
        this.color = color;
        this.amount = 5;
    }

    
    public Position getFoodPosition(Boundary bounds){
        
        Random rand = new Random(); 
        do{
            position.setX(rand.nextInt(bounds.getWidth()));
            position.setY(rand.nextInt(bounds.getWidth()));
            
        }while((position.getX() % amount != 0) && (position.getY() % amount != 0));
        return position; 
    }    

}
