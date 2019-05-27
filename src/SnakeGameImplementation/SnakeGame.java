/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGameImplementation;

import GameEngine.Boundary;
import GameEngine.Core;
import GameEngine.Direction;
import GameEngine.KeyboardController;
import GameEngine.MouseController;
import GameEngine.Position;
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

    
    Position pointPosition;
    private Snake snake;
    private Food food;
   
    private KeyboardController keyboardController1;
    private MouseController mouseControllor;
    private SnakeCollisionDetector snakecollisionDetector;
    
    private ScreenResolution resolution;
    private Boundary bounds;
    
    public SnakeGame(){
    
        snake = new Snake(new Position(0, 0), Color.GREEN, Color.RED, Direction.RIGHT);
        food = new Food(new Position(100, 100), Color.BLUE);

        keyboardController1 = new KeyboardController(snake, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        mouseControllor = new MouseController(snake);
        
        snakecollisionDetector = new SnakeCollisionDetector(snake, food);
    }
    
    public void init(){
        
                super.init();
		Window w = sm.getFullScreenWindow();
		w.addKeyListener(keyboardController1);

                bounds = new Boundary(sm.getWidth(), sm.getHeight());  
    }
    
    
    
    
    @Override
    public void draw(Graphics2D g) {

        super.draw(g);
        
        for (Position point : snake.getPath().get()) {
                g.setColor(snake.getColor());
                g.fillRect(point.getX(), point.getY(), 10, 10);     
            }
           
                g.setColor(snake.getHeadColor());
                g.fillRect(snake.getPosition().getX(), snake.getPosition().getY(), 10, 10);
           
           
        if(snakecollisionDetector.isThereFoodCollision()){
            snake.setHaveEaten(true);
            food.getFoodPosition(bounds);
        }           

        g.setColor(food.getColor());
        g.fillRect(food.getPosition().getX(), food.getPosition().getY(), 10, 10);
 
    }

    @Override
    public void update() {
       
            snake.move(bounds);
            
        if(snakecollisionDetector.isThereObjectCollision()){
            System.exit(0);
        }else{
                addSnakeValidPoints();
        }
       
    }

    public void addSnakeValidPoints() {
        snake.getPath().add(snake.getPosition());
        if(snake.getHaveEaten())
            snake.setHaveEaten(false);
        else
            snake.getPath().delete(0);
    }

        
}

