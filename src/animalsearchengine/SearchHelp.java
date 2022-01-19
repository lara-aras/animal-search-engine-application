/*
 * Filename: AdminHelp.java
 * Author: Lara Aras
 * Created: 08/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the panel for the search help section of the 
 *              application.
 */
package animalsearchengine;

/**
 * Panel containing help information about the search section of the application.
 *
 * @author Lara Aras
 */
public class SearchHelp extends javax.swing.JPanel {

    /**
     * Version: Project 1
     * <p>
     * Date: 08/10/2021
     * <p>
     * Creates new panel SearchHelp.
     *
     * @author Lara Aras
     */
    public SearchHelp() {
        initComponents();
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 08/10/2021
     * <p>
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchHeadingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchHelpTextArea = new javax.swing.JTextArea();

        searchHeadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchHeadingLabel.setText("Search Help");

        searchHelpTextArea.setEditable(false);
        searchHelpTextArea.setColumns(20);
        searchHelpTextArea.setLineWrap(true);
        searchHelpTextArea.setRows(5);
        searchHelpTextArea.setText("To use the search feature, type your search query into the search bar and hit the search button.\n\nIf there are any search results, they will appear in a table below the \"Search results\" heading. If your query did not return any results, you will be notified of this.\n\nYou can search for either an animal or species name, and any matching animal/species will be returned in the search results.\n\nPlease note that only letters and spaces are allowed in your search query. You cannot use any numbers or other special characters in your search query.");
        searchHelpTextArea.setWrapStyleWord(true);
        searchHelpTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchHelpTextArea.setOpaque(false);
        jScrollPane1.setViewportView(searchHelpTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(searchHeadingLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(searchHeadingLabel)
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel searchHeadingLabel;
    private javax.swing.JTextArea searchHelpTextArea;
    // End of variables declaration//GEN-END:variables
}
