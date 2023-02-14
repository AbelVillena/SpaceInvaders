/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avr.ieslaencanta.com.spaceinvadersavr;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author DAWTarde
 */
public class Wall {

    private Point2D posicion;
    private int width = 7;
    private int height = 2;
    private char cartoon[][] = {
    {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'},
    {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'}};

    public Wall() {

    }

    public Wall(int x, int y) {

    }

    public Wall(Point2D p){
    
    }

    /**
     * @return the posicion
     */
    public Point2D getPosicion() {
        return posicion;
    }
    
    public void paint(Screen s){
        char c;
        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j < this.width ; j++){
                c=this.cartoon[i][j];
                //s.setCharacter(this.getPosicion().getX()+j, this.getPosicion().getY()+i,
                        //new TextCharacter (c,
                        //TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
            }
        }
    }
    
    //public boolean collission(Bullet b){
        
    //}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}