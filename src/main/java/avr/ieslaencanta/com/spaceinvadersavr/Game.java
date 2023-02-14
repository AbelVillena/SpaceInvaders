/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avr.ieslaencanta.com.spaceinvadersavr;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAWTarde
 */
public class Game {

    private Terminal terminal;
    private Screen screen;
    private boolean exit_key;
    private Bullet bala;
    private Ship nave;
    private Wall wall;

    public Game() {
        this.exit_key = false;

        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(this.terminal);
            screen.setCursorPosition(null);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        bala = new Bullet(40, 12);
        nave = new Ship(60,20); 
        wall = new Wall(50,15);
    }

    public void loop() {
        try {
            int x, y = 0;
            screen.startScreen();
            screen.clear();
            while (!this.exit_key) {
                x = (int) Math.random() * 80;
                y = (int) Math.random() * 24;
                //Se procesa la entrada.
                process_input();
                update();
                paint();
                try {
                    Thread.sleep(( 1 / 60 ) * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Al pulsar escape se cierra la ventana y el terminal.
            screen.close();
            terminal.close();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void paint(Screen s) {
        try {
            TerminalSize terminalSize = s.getTerminalSize();
            for (int column = 0; column < terminalSize.getColumns(); column++) {
                for (int row = 0; row < terminalSize.getRows(); row++) {
                    s.setCharacter(column, row, new TextCharacter(
                            ' ',
                            TextColor.ANSI.GREEN,
                            TextColor.ANSI.BLACK));
                }
            }
            this.nave.paint(s);
            this.bala.paint(s);
            this.wall.paint(s);
            screen.refresh();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update() {
        this.nave.moveBullets();
    }

    private void paint() {
        try {
            this.nave.paint(this.screen);
            this.bala.paint(this.screen);
            this.wall.paint(screen);
            screen.refresh();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void process_input() {
        KeyStroke keyStroke = null;
        try {
            keyStroke = screen.pollInput();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si se ha pulsado una tecla.
        if (keyStroke != null) {
            //Si la tecla es la de escape.
            if (keyStroke.getKeyType() == KeyType.Escape) {
                this.exit_key = true;
            }
            if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                this.bala.moveVertical(-1, 0, 24);
                screen.clear();
            }
            if (keyStroke.getKeyType() == KeyType.ArrowDown) {
                this.bala.moveVertical(1, 0, 24);
                screen.clear();
            }
            if (keyStroke.getKeyType() == KeyType.ArrowRight) {
                this.nave.moveHorizontal(1, 0, 80);
                screen.clear();
            }
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
                this.nave.moveHorizontal(-1, 0, 80);
                screen.clear();
            }
            if (keyStroke.getKeyType() == KeyType.Enter) {
                this.nave.shoot();
                screen.clear();
            }
        }
    }
}









