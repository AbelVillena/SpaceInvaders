/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avr.ieslaencanta.com.spaceinvadersavr;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author DAWTarde
 */
public class Bullet {
    private Point2D posicion;
    private TextColor color;
    private TextColor backgroundcolor;
    private TextCharacter bulletsymbol;
    private int MAX_COUNTER=24;
    private int counter=MAX_COUNTER;  

    public Bullet() {
    }

    public Bullet(Point2D posicion) {
        this.posicion = posicion;
    }
    
    public Bullet(int x, int y) {
        this.posicion =new Point2D(x,y);
        this.init();
    }
    
    private void init(){
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.BLACK;
        
        this.bulletsymbol = TextCharacter.fromCharacter(Symbols.ARROW_UP)
           [0].withForegroundColor(this.color).withBackgroundColor
           (this.backgroundcolor);
    }
    
    public void paint(Screen s){
        s.setCharacter(this.getPosicion().getX(), this.getPosicion().getY(), this.bulletsymbol);
    }
    
    public void moveVertical(int incy, int miny, int maxy){
        this.counter--;
        if(this.counter==0){
            this.counter=this.MAX_COUNTER;
        if( this.getPosicion().getY() + incy >= miny && this.getPosicion().getY() + incy<maxy){
            this.getPosicion().addy(incy);
        }
    }
    }

    /**
     * @return the posicion
     */
    public Point2D getPosicion() {
        return posicion;
    }
    
}








