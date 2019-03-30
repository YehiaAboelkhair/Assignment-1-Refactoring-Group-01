
package TronGameEngine;

import Interfaces.ICollisionDetector;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class TronCollisionDetector implements ICollisionDetector{
    
    ArrayList<Player> players;

    public TronCollisionDetector(ArrayList<Player> players) {
        
        this.players = players;
    }
    
    
    public boolean isThereObjectCollision(){
        
        for (Player outerPlayer : players) {
            for (Player innerPlayer : players) {
                
                for (int counter = 0; counter < innerPlayer.pointPositions.size(); counter++) {
                
                    for(int i = 0; i < 5 ; i++){
                        for(int j = 0; j < 5 ; j ++){
                    
                    if(
                            ((outerPlayer.p.xPosition == innerPlayer.pointPositions.get(counter).xPosition + i) 
                         && (outerPlayer.p.yPosition == innerPlayer.pointPositions.get(counter).yPosition + j))
                         || ((outerPlayer.p.xPosition == innerPlayer.pointPositions.get(counter).xPosition - i) 
                         && (outerPlayer.p.yPosition == innerPlayer.pointPositions.get(counter).yPosition - j))                            
                         || ((outerPlayer.p.xPosition == innerPlayer.pointPositions.get(counter).xPosition + i) 
                         && (outerPlayer.p.yPosition == innerPlayer.pointPositions.get(counter).yPosition - j))
                         || ((outerPlayer.p.xPosition == innerPlayer.pointPositions.get(counter).xPosition - i) 
                         && (outerPlayer.p.yPosition == innerPlayer.pointPositions.get(counter).yPosition + j))
                                  
                            
                      )
                        
                        return true;
                        }
                    }
                }
                    
            }
            
        }
        
        return false;
    }
    
    
}
                           
 