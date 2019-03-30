 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Mohamed
 */
public class MouseController extends Direction implements MouseListener{

    GameObject object;

    public MouseController(GameObject object) {
        
        this.object = object;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getButton()== MouseEvent.BUTTON1){
            
            if (object.currentDirection == Directions.DOWN){
                            object.currentDirection = Directions.RIGHT;
            }
            else if (object.currentDirection == Directions.UP){
				object.currentDirection = Directions.LEFT;
            }
            else if (object.currentDirection == Directions.LEFT){
				object.currentDirection = Directions.DOWN;
            }
            else if (object.currentDirection == Directions.RIGHT){
				object.currentDirection = Directions.UP;
            }
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            
            if (object.currentDirection == Directions.DOWN){
                            object.currentDirection = Directions.LEFT;
            }
            else if (object.currentDirection == Directions.UP){
				object.currentDirection = Directions.RIGHT;
            }
            else if (object.currentDirection == Directions.LEFT){
				object.currentDirection = Directions.UP;
            }
            else if (object.currentDirection == Directions.RIGHT){
				object.currentDirection = Directions.DOWN;
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
