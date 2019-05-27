package TronGameImplementation;
import GameEngine.Boundary;
import GameEngine.Position;
import GameEngine.Core;
import GameEngine.MouseController;
import GameEngine.KeyboardController;
import GameEngine.Direction;
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

    
    private Player player1;
    private Player player2;
    private Player player3;
    
    private KeyboardController keyboardController1;
    private KeyboardController keyboardController2;
    private KeyboardController keyboardController3;

    private MouseController  mouseController;

    private TronCollisionDetector collisionDetector;
    private ArrayList<Player> players;
    private Boundary bounds;
    
    public TronGame(){
    
        createPlayers();
        players = new ArrayList<>();
        addPlayersToGame(players, player1);
        addPlayersToGame(players, player2);
//        addPlayersToGame(players, player3);        
        collisionDetector = new TronCollisionDetector(players);

    }
    
        public void init(){
        
                super.init();
		Window w = sm.getFullScreenWindow();
		w.addKeyListener(keyboardController1);
                w.addKeyListener(keyboardController2);
                w.addKeyListener(keyboardController3); 
		w.addMouseListener(mouseController);

                bounds = new Boundary(sm.getWidth(), sm.getHeight());                
    }
    
    @Override
    public void draw(Graphics2D g) {
        
        super.draw(g);
        for(Player player : players){

            for (Position point: player.getPath().get()) {
                g.setColor(player.getColor());
                g.fillRect(point.getX(), point.getY(), 10, 10); 
            }
            
        }
    }

    @Override
    public void update() {
        movePlayers();
        if(collisionDetector.isThereObjectCollision())
            exit();
        else
            addPlayersValidMovementsToPath();
    }

    
    public void addPlayersValidMovementsToPath() {
        for(Player player : players){
            player.getPath().add(player.getPosition());
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void movePlayers() {
        for(Player player : players){
            player.move(bounds);
        }
    }



    public void createPlayers() {
        player1 = new Player(new Position(40, 40), Color.GREEN, Direction.RIGHT);
        keyboardController1 = new KeyboardController(player1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        
        
        player2 = new Player(new Position(600, 400), Color.RED, Direction.LEFT);
        keyboardController2 = new KeyboardController(player2, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A);
        
//      player3 = new Player(new Position(0, 400), Color.YELLOW, Direction.RIGHT);
//      keyboardController3 = new KeyboardController(player3, KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD4);
//        
        
//        mouseController = new MouseController(player3);
    
    }

    public void addPlayersToGame(ArrayList<Player> players, Player player) {
        
        players.add(player);

    }

}
