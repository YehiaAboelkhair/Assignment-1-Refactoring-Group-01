 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Mohamed
 */
public class MouseController implements MouseListener{

    private MovedGameObject object;

    public MouseController(MovedGameObject object) {
        
        this.object = object;
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getButton()== MouseEvent.BUTTON1){
            
            if (object.direction == Direction.DOWN){
                            object.direction = Direction.RIGHT;
            }
            else if (object.direction == Direction.UP){
				object.direction = Direction.LEFT;
            }
            else if (object.direction == Direction.LEFT){
				object.direction = Direction.DOWN;
            }
            else if (object.direction == Direction.RIGHT){
				object.direction = Direction.UP;
            }
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            
            if (object.direction == Direction.DOWN){
                            object.direction = Direction.LEFT;
            }
            else if (object.direction == Direction.UP){
				object.direction = Direction.RIGHT;
            }
            else if (object.direction == Direction.LEFT){
				object.direction = Direction.UP;
            }
            else if (object.direction == Direction.RIGHT){
				object.direction = Direction.DOWN;
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
