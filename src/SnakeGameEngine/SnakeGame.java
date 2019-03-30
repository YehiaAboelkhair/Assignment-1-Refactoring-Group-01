/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameEngine;

import Model.Core;
import Model.Direction;
import Model.KeyboardController;
import Model.MouseController;
import Model.PointPosition;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mohamed
 */
public class SnakeGame extends Core {

    
    PointPosition pointPosition;
    Snake snake;
    Food food;
   
    KeyboardController keyboardController1;
    MouseController mouseControllor;
    SnakeCollisionDetector snakecollisionDetector;
    
    public SnakeGame(){
    
        snake = new Snake(new PointPosition(0, 0), Color.GREEN, Color.RED, Direction.Directions.RIGHT);
        food = new Food(new PointPosition(100, 100), Color.BLUE, snake.moveAmount);

        keyboardController1 = new KeyboardController(snake, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        mouseControllor = new MouseController(snake);
        
        snakecollisionDetector = new SnakeCollisionDetector(snake, food);
        
    }
    
    public void init(){
        
                super.init();
		Window w = sm.getFullScreenWindow();
		w.addKeyListener(keyboardController1);

                snake.sm = sm;
                food.sm = sm;
    }
    
    
    
    
    @Override
    public void draw(Graphics2D g) {
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
        
           for (PointPosition pointPosition : snake.pointPositions) {
                g.setColor(snake.color);
                g.fillRect(pointPosition.xPosition, pointPosition.yPosition, 10, 10);
                
            }
           
                g.setColor(snake.headColor);
                g.fillRect(snake.p.xPosition, snake.p.yPosition, 10, 10);
           
           
        if(snakecollisionDetector.isThereFoodCollision()){
            snake.haveEaten = true;
            PointPosition pointPosition = food.GenerateFood();
            g.setColor(food.color);
            g.fillRect(pointPosition.xPosition, pointPosition.yPosition, 20, 20);
            
        }else{
            
            g.setColor(food.color);
            g.fillRect(food.pointPosition.xPosition, food.pointPosition.yPosition, 20, 20);
        }
        
    }

    @Override
    public void update() {
       
            snake.move();
            
        if(snakecollisionDetector.isThereObjectCollision()){
            System.exit(0);
        }else{
          
                snake.pointPositions.add(snake.p);
        }
       
    }

        
}

