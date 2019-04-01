package GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Core {

	private static final DisplayMode modes[] = 
		{
		new DisplayMode(1366,768,32,0),
		new DisplayMode(1680,1050,32,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0),
		};
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
		DisplayMode dm = sm.findFirstCompatibaleMode(modes);
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
        };
	
}
