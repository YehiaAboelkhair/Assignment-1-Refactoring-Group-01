/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public abstract class GameObject {
    
    public Direction.Directions currentDirection;
    public Color color;
    public int moveAmount;

    public PointPosition p;
    public ArrayList<PointPosition> pointPositions; 
    
    public ScreenManager sm;
    
    
    public abstract void move();
    
    
    
}
