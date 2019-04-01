/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.Core;
import GameEngine.Direction;
import GameEngine.KeyboardController;
import GameEngine.MouseController;
import GameEngine.PointPosition;
import GameEngine.ScreenResolution;
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
    
    ScreenResolution sr;
    
    public SnakeGame(){
    
        snake = new Snake(new PointPosition(0, 0), Color.GREEN, Color.RED, Direction.Directions.RIGHT);
        food = new Food(new PointPosition(100, 100), Color.BLUE, snake.moveAmount);

        keyboardController1 = new KeyboardController(snake, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        mouseControllor = new MouseController(snake);
        
        snakecollisionDetector = new SnakeCollisionDetector(snake, food);
        sr = new ScreenResolution(sm.getWidth(), sm.getHeight());
    }
    
    public void init(){
        
                super.init();
		Window w = sm.getFullScreenWindow();
		w.addKeyListener(keyboardController1);

                snake.sr = sr;
                food.sr = sr;
    }
    
    
    
    
    @Override
    public void draw(Graphics2D g) {

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

