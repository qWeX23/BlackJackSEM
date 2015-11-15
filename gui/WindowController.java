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
    Basics basics;
    // other GCs go here
    //
    //
    //
    //
    public static boolean showMenu = false, showPlayGUI = false;

    public WindowController(Table table, BJGame playBJGame) {

        this.table = table;
        this.playBJGame = playBJGame;
        mainMenu = new MainMenu(table);
        playGui = new PlayGUI(playBJGame);
        hidePlayGUI();
        new MenuListener().run();
    }

    public void showMainMenu() {
        mainMenu.setVisible(true);
    }

    private void showPlayGUI() {
        playGui.showFrame();
    }

    private void hideMainMenu() {
        mainMenu.setVisible(false);
    }

    private void hidePlayGUI() {
        playGui.hideFrame();
    }

    private void switchGC(GameCoordinator gc) {
        playGui.setGC(gc);
    }


    private class MenuListener extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (WindowController.showMenu) {
                    showMainMenu();
                    hidePlayGUI();
                    showMenu=false;

                }
                if (WindowController.showPlayGUI) {
                    showPlayGUI();
                    hideMainMenu();
                    showPlayGUI=false;

                }
            }
        }

    }


}
