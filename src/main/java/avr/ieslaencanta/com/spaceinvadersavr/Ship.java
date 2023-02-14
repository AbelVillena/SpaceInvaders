/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avr.ieslaencanta.com.spaceinvadersavr;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import java.awt.Toolkit;

/**
 *
 * @author DAWTarde
 */
public class Ship {
    private Point2D posicion;
    private int width=7;
    private int height=2;
    private Bullet bullets[];
    private static int max_bullets = 3;
    private String cartoon[] = {
          " ⢀⣀⣾⣷⣀⡀ " ,
          " ⣿⣿⣿⣿⣿⣿ "
};
    
    public Ship() {
        this.posicion = new Point2D();
        this.bullets = new Bullet [Ship.max_bullets];
    }

    public Ship(Point2D posicion) {
        this.posicion = posicion;
        this.bullets = new Bullet [Ship.max_bullets];
    }
    
    public Ship(int x, int y) {
        this.posicion =new Point2D(x,y);
        this.bullets = new Bullet [Ship.max_bullets];
    }

    /**
     * @return the posicion
     */
    public Point2D getPosicion() {
        return posicion;
    }
    
    
    
    public void moveHorizontal(int incx, int minx, int maxx){
        if(this.posicion.getX() + incx>= minx && this.posicion.getX() + incx + this.width <=maxx){
            this.posicion.addx(incx);
        } else{
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public void shoot(){
        this.bullets[0]=new Bullet(
                this.posicion.getX()+this.width/2,
                this.posicion.getY()-2
        );
    }
    
    public void moveBullets(){
        for (int i=0;i<this.bullets.length;i++){
            if(this.bullets[i]!=null){
                this.bullets[i].moveVertical(-1, 0, 24);
                if(this.bullets[i].getPosicion().getY()<=0){
                    this.bullets[i]=null;
                }
            }
        }
    }
    
    public void paint(Screen s){
        char c;
        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j < this.width ; j++){
                c=this.cartoon[i].charAt(j);
                s.setCharacter(this.posicion.getX()+j,
                        this.posicion.getY()+i,
                        new TextCharacter (c,
                        TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
            }
        }
        for (int i=0;i<this.bullets.length;i++){
            if(this.bullets[i]!=null){
                this.bullets[i].paint(s);
            }
        }
    }
    
   /* private void init(){
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.BLACK;
        
        this.shipsymbol = TextCharacter.fromCharacter(Symbols.ARROW_RIGHT)
           [0].withForegroundColor(this.color).withBackgroundColor
           (this.backgroundcolor);
    }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
}
