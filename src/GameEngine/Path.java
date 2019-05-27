/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import GameEngine.Position;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class Path {
    
    private ArrayList<Position> path;

    public Path() {
        this.path = new ArrayList<Position>();
    }

    public Position get(int index) {
        return path.get(index);
    }

    public int size() {
        return path.size();
    }

    public void add(Position position) {
        path.add(position);
    }
    
    public ArrayList<Position> get() {
        return path;
    }
    
    public void delete(int index){
        path.remove(index);
    }

}

