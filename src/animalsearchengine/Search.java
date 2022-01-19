/*
 * Filename: Search.java
 * Author: Lara Aras
 * Created: 04/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the functionality for the search GUI.
 */
package animalsearchengine;

import javax.swing.*;
import java.awt.*;
import java.util.regex.*;
import java.util.*;

/**
 * Panel that contains search functionality.
 *
 * @author Lara Aras
 */
public class Search extends javax.swing.JPanel {

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Creates new form Search.
     *
     * @author Lara Aras
     */
    public Search() {
        initComponents();
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

        searchField = new javax.swing.JTextField();
        searchHeadingLabel = new javax.swing.JLabel();
        searchResultsLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchResultsPane = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(750, 400));

        searchHeadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchHeadingLabel.setText("Animal Search Engine");

        searchResultsLabel.setText("Search results:");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchResultsPaneLayout = new javax.swing.GroupLayout(searchResultsPane);
        searchResultsPane.setLayout(searchResultsPaneLayout);
        searchResultsPaneLayout.setHorizontalGroup(
            searchResultsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        searchResultsPaneLayout.setVerticalGroup(
            searchResultsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(searchHeadingLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(searchResultsLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton)))))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(searchHeadingLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(searchResultsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Version: Project 1
     * <p>
     * Date: 05/10/2021
     * <p>
     * Validates search query and sends request to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchQuery = searchField.getText();

        /* Create request map to be sent to server */
        HashMap request = new HashMap();
        request.put("action", "search");

        /* Only letters and spaces allowed in search query */
        Pattern validatePattern = Pattern.compile("^[a-zA-Z ]+$");
        Matcher matcher = validatePattern.matcher(searchQuery);
        boolean matches = matcher.matches();
        if (matches) {
            /* Add search query to request and create new client instance to 
               send request */
            request.put("searchString", searchQuery);
            Client client = new Client();

            String response = client.sendRequest(request);

            /* Check if there were search results or not */
            if (response.equals("no results") || response.equals("server off")) {
                /* Show message in a text area to indicate that there were no 
                   results for the search */
                JTextArea noResultsTextArea = new JTextArea("Your query did not"
                        + " return any results. Please try again.");

                /* Give text area a size so that it displays when the main 
                   container is repainted */
                noResultsTextArea.setSize(new Dimension(369, 235));

                /* Wrap lines of text are and set to wrap on words */
                noResultsTextArea.setLineWrap(true);
                noResultsTextArea.setWrapStyleWord(true);

                /* Give text area a clear background */
                noResultsTextArea.setOpaque(false);

                /* Set text area's font to be the same as the other text in the 
                   frame */
                noResultsTextArea.setFont(new Font("Tahoma", 0, 11));

                /* Make the text area uneditable */
                noResultsTextArea.setEditable(false);

                /* Clear results container panel and add message */
                searchResultsPane.removeAll();
                searchResultsPane.add(noResultsTextArea);
            } else {
                /* Create array for header row of table that search results will
               will be displayed in */
                String[] headerRow = {"Name", "Description", "Species"};

                /* Split response string into rows by ":" delimeter */
                String[] resultRows = response.split(":");

                /* Create array to hold table rows that is the same length as the 
               number of search results */
                String[][] tableRows = new String[resultRows.length][1];
                int i = 0;
                for (String row : resultRows) {
                    /* Split row string into columns by "@" delimeter and add the 
                   resulting array to the tableRows array */
                    String[] columns = row.split("@");
                    tableRows[i] = columns;
                    i++;
                }

                JTable resultsTable = new JTable(tableRows, headerRow);

                /* Set table to fill its container even when there aren't 
                   enough rows */
                resultsTable.setFillsViewportHeight(true);

                /* Add table to a scroll pane */
                JScrollPane resultsScrollPane = new JScrollPane(resultsTable);

                /* Give scroll pane a size so that it displays when the main 
                   container is repainted */
                resultsScrollPane.setSize(new Dimension(369, 235));

                /* Clear results container panel and add table with new results */
                searchResultsPane.removeAll();
                searchResultsPane.add(resultsScrollPane);
            }

            /* Repaint the container to show the new contents */
            searchResultsPane.revalidate();
            searchResultsPane.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "You have entered an invalid search query. "
                    + "Search queries must consist only of letters and spaces.",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchHeadingLabel;
    private javax.swing.JLabel searchResultsLabel;
    private javax.swing.JPanel searchResultsPane;
    // End of variables declaration//GEN-END:variables
}
