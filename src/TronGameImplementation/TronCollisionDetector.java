
package TronGameImplementation;

import GameEngine.ICollisionDetector;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class TronCollisionDetector implements ICollisionDetector{
    
    private ArrayList<Player> players;

    public TronCollisionDetector(ArrayList<Player> players) {
        
        this.players = players;
    }
    
    @Override
    public boolean isThereObjectCollision(){
        
        for (Player outer : players) {
            for (Player inner : players) {
                for (int counter = 0; counter < inner.getPath().size(); counter++) {
                    if(outer.getPosition().equals(inner.getPath().get(counter)))
                        return true;      
                }
            }
        }
        return false;
    }
    
}