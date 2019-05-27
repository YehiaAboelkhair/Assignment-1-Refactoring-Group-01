/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

/**
 *
 * @author Mohamed
 */
public class Boundary {
    
    private int height;
    private int width;

    public Boundary(int height, int width){
    
        this.height = height;
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

