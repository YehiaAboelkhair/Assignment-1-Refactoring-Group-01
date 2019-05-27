/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public abstract class GameObject {
    
    protected Color color;
    protected Position position;

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
    public Position getPosition(){
        return this.position;
    }
}
