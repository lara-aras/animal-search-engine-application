/*
 * Filename: ASEMainFrame.java
 * Author: Lara Aras
 * Created: 04/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the functionality for the main
 *              container (frame) of the Animal Search Engine (ASE) that will
 *              hold the search and admin GUIs, as well as the menu for the 
 *              application.
 */
package animalsearchengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main frame of application that holds the menu and all panels.
 * 
 * @author Lara Aras
 */
public class ASEMainFrame extends javax.swing.JFrame {

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Creates new frame ASEMainFrame and adds window listener for letting user
     * decide what action they want to take when closing the application.
     *
     * @author Lara Aras
     */
    public ASEMainFrame() {
        initComponents();
        mainPanel.add(new Search(), BorderLayout.CENTER);

        /* Create window event listener to show option dialogue when closing
           window to let user choose whether to exit or minimize the application */
        JFrame frame = (JFrame) this;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                String[] closeOptions = {"Exit", "Minimize"};

                int response = JOptionPane.showOptionDialog(frame,
                        "Would you like to exit or minimize the application?",
                        "Close Application", 0, JOptionPane.QUESTION_MESSAGE,
                        null, closeOptions, closeOptions[0]);

                if (response == 0) {
                    /* Exit application */
                    System.exit(0);
                } else if (response == 1) {
                    /* Minimize application */
                    frame.setState(Frame.ICONIFIED);
                }
            }
        });

        pack();
        repaint();
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        aseMenuBar = new javax.swing.JMenuBar();
        searchMenu = new javax.swing.JMenu();
        searchMenuItem = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        databaseMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        searchHelpMenuItem = new javax.swing.JMenuItem();
        adminHelpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        searchMenu.setText("Search");

        searchMenuItem.setText("Search");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(searchMenuItem);

        aseMenuBar.add(searchMenu);

        adminMenu.setText("Admin");

        databaseMenuItem.setText("Database");
        databaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseMenuItemActionPerformed(evt);
            }
        });
        adminMenu.add(databaseMenuItem);

        aseMenuBar.add(adminMenu);

        HelpMenu.setText("Help");

        searchHelpMenuItem.setText("Search Help");
        searchHelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHelpMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(searchHelpMenuItem);

        adminHelpMenuItem.setText("Admin Help");
        adminHelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminHelpMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(adminHelpMenuItem);

        aseMenuBar.add(HelpMenu);

        setJMenuBar(aseMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Loads login/database admin panel.
     *
     * @author Lara Aras
     * @param evt
     */
    private void databaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseMenuItemActionPerformed
        /* Clear all content in the main panel and then add the login panel */
        mainPanel.removeAll();

        /* Only show login page if loggedIn is false */
        if (!AnimalSearchEngine.loggedIn) {
            /* Send frame and panel objects along with destination to login class
           to switch to correct panel on successful login */
            mainPanel.add(new Login((JFrame) this, mainPanel), BorderLayout.CENTER);
        } else {
            mainPanel.add(new DatabaseAdmin());
        }

        pack();
        repaint();
    }//GEN-LAST:event_databaseMenuItemActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Loads search panel.
     *
     * @author Lara Aras
     * @param evt
     */
    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
        /* Clear all content in the main panel and then add the search panel */
        mainPanel.removeAll();
        mainPanel.add(new Search(), BorderLayout.CENTER);
        pack();
        repaint();
    }//GEN-LAST:event_searchMenuItemActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 08/10/2021
     * <p>
     * Loads search help panel.
     *
     * @author Lara Aras
     * @param evt
     */
    private void searchHelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHelpMenuItemActionPerformed
        /* Clear all content in the main panel and then add the admin help
           panel */
        mainPanel.removeAll();
        mainPanel.add(new SearchHelp(), BorderLayout.CENTER);
        pack();
        repaint();
    }//GEN-LAST:event_searchHelpMenuItemActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 08/10/2021
     * <p>
     * Loads admin help panel.
     *
     * @author Lara Aras
     * @param evt
     */
    private void adminHelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminHelpMenuItemActionPerformed
        /* Clear all content in the main panel and then add the admin help
           panel */
        mainPanel.removeAll();
        mainPanel.add(new AdminHelp(), BorderLayout.CENTER);
        pack();
        repaint();
    }//GEN-LAST:event_adminHelpMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem adminHelpMenuItem;
    private javax.swing.JMenu adminMenu;
    private javax.swing.JMenuBar aseMenuBar;
    private javax.swing.JMenuItem databaseMenuItem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem searchHelpMenuItem;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JMenuItem searchMenuItem;
    // End of variables declaration//GEN-END:variables
}
