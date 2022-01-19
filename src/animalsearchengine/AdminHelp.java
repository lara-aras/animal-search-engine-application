/*
 * Filename: AdminHelp.java
 * Author: Lara Aras
 * Created: 08/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the panel for the admin help section of the 
 *              application.
 */
package animalsearchengine;

/**
 * Panel containing help information about the admin section of the application.
 * 
 * @author Lara Aras
 */
public class AdminHelp extends javax.swing.JPanel {

    /**
     * Version: Project 1
     * <p>
     * Date: 08/10/2021
     * <p>
     * Creates new panel AdminHelp.
     *
     * @author Lara Aras
     */
    public AdminHelp() {
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
        jTextArea1 = new javax.swing.JTextArea();

        searchHeadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchHeadingLabel.setText("Admin Help");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("The admin section is for modifying data in the database. You will need to provide valid admin login credentials to access this feature.\n\nThere are three tabs in this section, \"Insert\", \"Update\", and \"Delete\". The Insert and Update sections are divided into \"Animal\" and \"Species\" tabs. Note that you can only delete an animal from the database and not a species.\n\nTo insert a new species, type the new species name into the text field and click the \"Submit\" button. To insert a new animal. type the new name and description into the text fields, select a species for the new animal, and click the \"Submit\" button.\n\nTo update a species, select the species you would like to update from the drop down list, type a new name into the text field, and click the \"Submit\" button. To update an animal, select the animal you would like to update from the drop down list, and modify the information you would like to change in the text fields and/or select a new species for the animal and click the \"Submit\" button.\n\nTo delete an animal. select the animal you would like to delete from the drop down list and click the \"Submit\" button.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(searchHeadingLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(searchHeadingLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel searchHeadingLabel;
    // End of variables declaration//GEN-END:variables
}
