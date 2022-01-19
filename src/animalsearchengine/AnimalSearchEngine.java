/*
 * Filename: AnimalSearchEngine.java
 * Author: Lara Aras
 * Created: 04/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the main class of the client application.
 */
package animalsearchengine;

import javax.swing.*;

/**
 * Main class of the application, serves as the entry point for the rest of
 * the application.
 *
 * @author Lara Aras
 */
public class AnimalSearchEngine {

    /**
     * Used to determine if user has logged in once during the session
     * already.
     */
    public static boolean loggedIn = false;

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Description: The main method of the AnimalSearchEngine class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        /* Set look and feel for GUI */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
        }

        /* Instantiate main frame class */
        new ASEMainFrame().setVisible(true);
    }
}
