/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.ICollisionDetector;

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
            for (int i = 0; i < snake.getPath().size(); i++) {
                if(snake.getPosition().equals(snake.getPath().get(i))) 
                    return true;
            }
        return false;
    }
    
    public boolean isThereFoodCollision()
    {
            if(snake.getPosition().equals(food.getPosition()))
                return true;
        return false;
    }
}