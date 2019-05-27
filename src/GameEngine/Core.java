package GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Core {

        private boolean running;
	protected ScreenManager sm;
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			sm.restoreScreen();
		}
	}
	
	public void init(){
		sm = new ScreenManager();
		DisplayMode dm = sm.findFirstCompatibaleMode();
		sm.setFullScreen(dm);
		Window w = sm.getFullScreenWindow();
		w.setFont(new Font("Arial",Font.PLAIN,20));
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null")); 
		running = true;
                
	}
	
	public void gameLoop(){

            while (running){

			update();
			Graphics2D g = sm.getGraphics();
			draw(g);
			g.dispose();
			sm.update();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	
	public abstract void update();
	
	public void draw(Graphics2D g){
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
        }
	
}
