/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import TronGameEngine.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Mohamed
 */
public class KeyboardController extends Direction implements KeyListener{
 
    int upKey;
    int downKey;
    int rightKey;
    int leftKey;
    
    GameObject object;

    public KeyboardController(GameObject object, int upKey, int downKey, int rightKey, int leftKey) {
        
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
			if (object.currentDirection != Directions.DOWN){
                            object.currentDirection = Directions.UP;
			}
		} else if (e.getKeyCode() == downKey) {
			if (object.currentDirection != Directions.UP){
				object.currentDirection = Directions.DOWN;
				}
		} else if (e.getKeyCode() == rightKey) {
			if (object.currentDirection != Directions.LEFT){
				object.currentDirection = Directions.RIGHT;
				}
		} else if (e.getKeyCode() == leftKey) {
			if (object.currentDirection != Directions.RIGHT){
				object.currentDirection = Directions.LEFT;
				}
		}
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
