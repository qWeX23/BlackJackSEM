package gui;

import Games.*;
import Games.GameCoordinator;
import backend.Table;

import javax.swing.*;

/**
 * Created by bjc90_000 on 11/6/2015.
 */
public class WindowController {


    // how to get the main menu to talk?????????


    MainMenu mainMenu;
    JFrame mainFrame;
    Table table;
    PlayGUI playGui;


    BJGame playBJGame;
    // other GCs go here
    //
    //
    //
    //


    public WindowController( Table table, BJGame playBJGame) {

        this.table = table;
        this.playBJGame = playBJGame;
        mainMenu = new MainMenu(table);
        playGui = new PlayGUI(table);
    }
    private void showMainMenu(){
        mainMenu.setVisible(true);
    }

    private void showPlayGUI(){
        playGui.setVisible(true);
    }

    private void hideMainMenu(){
        mainMenu.setVisible(false);
    }
    private void hidePlayGUI(){
        playGui.setVisible(false);
    }

    private void switchGC(GameCoordinator gc){
        playGui.setGC(gc);
    }









}
