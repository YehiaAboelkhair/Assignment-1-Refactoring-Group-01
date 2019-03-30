/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameEngine;

import Interfaces.ICollisionDetector;
import TronGameEngine.Player;

/**
 *
 * @author Mohamed
 */
public class SnakeCollisionDetector implements ICollisionDetector{
    
    Snake snake;
    Food food;

    public SnakeCollisionDetector(Snake snake, Food food){
        
        this.snake = snake;
        this.food = food;
    }
    
     public boolean isThereObjectCollision(){
        
                for (int i = 0; i < snake.pointPositions.size(); i++) {
                
                    if(
                            (snake.p.xPosition == snake.pointPositions.get(i).xPosition) 
                         && (snake.p.yPosition == snake.pointPositions.get(i).yPosition)
                      )
                        
                        return true;
                }
                
        return false;
    }
    
    public boolean isThereFoodCollision()
    {
        for(int i = 0; i < 15 ; i++){
            for(int j = 0; j < 15 ; j ++){
        
        if(            
                            ((snake.p.xPosition == food.pointPosition.xPosition + i) 
                         && (snake.p.yPosition == food.pointPosition.yPosition + j))
                
                         || ((snake.p.xPosition == food.pointPosition.xPosition - i) 
                         && (snake.p.yPosition == food.pointPosition.yPosition - j))
                
                
                         || ((snake.p.xPosition == food.pointPosition.xPosition + i) 
                         && (snake.p.yPosition == food.pointPosition.yPosition - j))
                
                
                         || ((snake.p.xPosition == food.pointPosition.xPosition - i) 
                         && (snake.p.yPosition == food.pointPosition.yPosition + j))
          )
                        
                        return true;
            }
}
    
        return false;
}
}