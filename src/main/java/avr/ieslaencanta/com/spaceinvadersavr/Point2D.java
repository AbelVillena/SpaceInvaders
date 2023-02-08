/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avr.ieslaencanta.com.spaceinvadersavr;

/**
 *
 * @author DAWTarde
 */
public class Point2D {
    private int x;
    private int y;
    
    //Le damos la posición al eje x e y.
    public Point2D(){
        this.x=-1;
        this.y=-1;
    }
    
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Incrementa o decrementa la posición del eje x.
     * @param inc_x 
     */
    public void addx(int inc_x){
        this.setX(this.getX() + inc_x);
    }
    
    /**
     * Incrementa o decrementa la posición del eje y.
     * @param inc_y 
     */
    public void addy(int inc_y){
        this.setY(this.getY() + inc_y);
    }
    
    //getters y setters

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
}








