/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import TronGameImplementation.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Mohamed
 */
public class KeyboardController implements KeyListener{
 
    private int upKey, downKey, rightKey, leftKey;

    private MovedGameObject object;

    public KeyboardController(MovedGameObject object, int upKey, int downKey, int rightKey, int leftKey) {
        
        this.upKey = upKey;
        this.downKey = downKey;
        this.rightKey = rightKey;
        this.leftKey = leftKey;
        this.object = object;
    }

    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        	if (e.getKeyCode() == upKey) {
			if (object.direction != Direction.DOWN){
                            object.direction = Direction.UP;
			}
		} else if (e.getKeyCode() == downKey) {
			if (object.direction != Direction.UP){
				object.direction = Direction.DOWN;
				}
		} else if (e.getKeyCode() == rightKey) {
			if (object.direction != Direction.LEFT){
				object.direction = Direction.RIGHT;
				}
		} else if (e.getKeyCode() == leftKey) {
			if (object.direction != Direction.RIGHT){
				object.direction = Direction.LEFT;
				}
		}
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
