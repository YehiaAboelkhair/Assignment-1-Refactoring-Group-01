package TronGameEngine;
import Model.PointPosition;
import Model.Core;
import Model.MouseController;
import Model.KeyboardController;
import Model.Direction;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class TronGame extends Core{

    
    Player player1;
    Player player2;
    Player player3;
    
    KeyboardController keyboardController1;
    KeyboardController keyboardController2;
    KeyboardController keyboardController3;

    MouseController  mouseController;

    TronCollisionDetector collisionDetector;
    ArrayList<Player> players;
    
    public TronGame(){
    
        
        
        player1 = new Player(new PointPosition(0, 0), Color.GREEN, Direction.Directions.RIGHT);
        keyboardController1 = new KeyboardController(player1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);

                
        player2 = new Player(new PointPosition(1366, 600), Color.RED, Direction.Directions.LEFT);
        keyboardController2 = new KeyboardController(player2, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A);
        
        player3 = new Player(new PointPosition(0, 400), Color.YELLOW, Direction.Directions.RIGHT);
        keyboardController3 = new KeyboardController(player3, KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD4);
        
        
        mouseController = new MouseController(player2);
        
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        //players.add(player3);
       
        
        collisionDetector = new TronCollisionDetector(players);


    }
    
    
        public void init(){
        
                super.init();
		Window w = sm.getFullScreenWindow();
		w.addKeyListener(keyboardController1);
                w.addKeyListener(keyboardController2);
                w.addKeyListener(keyboardController3); 
		w.addMouseListener(mouseController);

                for (Player player : players) {
                    player.sm = sm;
                }
                
                
    }
    
    @Override
    public void draw(Graphics2D g) {
        
    }

    @Override
    public void update() {
        
    }
    
}
