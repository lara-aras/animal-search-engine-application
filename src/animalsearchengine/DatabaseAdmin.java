/*
 * Filename: DatabaseAdmin.java
 * Author: Lara Aras
 * Created: 04/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the functionality for the database section
 *              of the administrator GUI.
 */
package animalsearchengine;

import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Panel that contains all database admin functionality for modifying data in
 * the database.
 *
 * @author Lara Aras
 */
public class DatabaseAdmin extends javax.swing.JPanel {

    /* Arrays that are initialised with data returned from the server */
    private String[][] animalsArray;
    private String[][] speciesArray;

    /* Hash maps getting details of selected animals/species from drop-down 
       lists */
    private HashMap<String, HashMap<String, String>> animalsMap;
    private HashMap<String, String> speciesMap;

    /* Lists with animal/species names for update/delete forms */
    private ArrayList animalNames;
    private ArrayList speciesNames;

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Creates new panel DatabseAdmin.
     *
     * @author
     */
    public DatabaseAdmin() {
        initComponents();
        setComboBoxOptions();
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Fetches all animals and species from database to set options in form
     * combo boxes and create maps to store related data about options.
     *
     * @author Lara Aras
     */
    private void setComboBoxOptions() {
        /* Get animals and species from database to populate combo boxes
           and update forms */
        Client client = new Client();
        try {
            animalsArray = client.getAnimalsForForms();
            speciesArray = client.getSpeciesForForms();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error has occured:\n"
                    + e.toString(),
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }

        initFormMaps();
        initFormLists();

        /* Set items for combo boxes */
        insertAnimalSpeciesList.setModel(new javax.swing.DefaultComboBoxModel(speciesNames.toArray()));
        selectSpeciesUpdateList.setModel(new javax.swing.DefaultComboBoxModel(speciesNames.toArray()));
        selectAnimalUpdateList.setModel(new javax.swing.DefaultComboBoxModel(animalNames.toArray()));
        updateAnimalSpeciesList.setModel(new javax.swing.DefaultComboBoxModel(speciesNames.toArray()));
        selectAnimalDeleteList.setModel(new javax.swing.DefaultComboBoxModel(animalNames.toArray()));
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Create maps with the species/animal names as keys to get details of
     * species/animal chosen from combo boxes.
     *
     * @author Lara Aras
     */
    private void initFormMaps() {
        /* Populate animals hash map */
        animalsMap = new HashMap<>();
        for (String[] animalRow : animalsArray) {
            HashMap<String, String> animalDetails = new HashMap();
            animalDetails.put("animalID", animalRow[0]);
            animalDetails.put("description", animalRow[2]);
            animalDetails.put("speciesID", animalRow[3]);

            animalsMap.put(animalRow[1], animalDetails);
        }

        /* Populate species hash map */
        speciesMap = new HashMap<>();
        for (String[] speciesRow : speciesArray) {
            speciesMap.put(speciesRow[1], speciesRow[0]);
        }
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Create arrays with the species/animal names for form combo boxes.
     *
     * @author Lara Aras
     */
    private void initFormLists() {
        /* Populate animals list */
        animalNames = new ArrayList();
        for (String[] animalRow : animalsArray) {
            animalNames.add(animalRow[1]);
        }

        /* Populate species list */
        speciesNames = new ArrayList();
        for (String[] speciesRow : speciesArray) {
            speciesNames.add(speciesRow[1]);
        }
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Send request to client object to be sent to server, and notify user if
     * action was successful or not.
     *
     * @author Lara Aras
     * @param request
     */
    private String performAction(HashMap request) {
        /* Send request map to Client class to be sent to server */
        Client client = new Client();
        String response = client.sendRequest(request);

        /* Notify user of success/failure */
        if (response.equals("success")) {
            JOptionPane.showMessageDialog(this, "Success!",
                    "Success", JOptionPane.INFORMATION_MESSAGE
            );
        } else if (!response.equals("server off")) {
            /* If the error was not caused by the server being off */
            JOptionPane.showMessageDialog(this, "An error has occured. "
                    + "Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }

        return response;
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Populates animal update form with details of animal selected from combo
     * box to make updating easier.
     *
     * @author Lara Aras
     * @param animalToUpdate
     */
    private void populateAnimalUpdateForm(String animalToUpdate) {
        /* Get the details of the selected animal */
        HashMap animalToUpdateDetails = animalsMap.get(animalToUpdate);

        /* Set text field values */
        updateAnimalNameField.setText(animalToUpdate);
        updateAnimalDescriptionField.setText(animalToUpdateDetails.get("description").toString());

        /* Get species name from animal's species ID to set value for species combo box */
        for (Map.Entry<String, String> entry : speciesMap.entrySet()) {
            /* If entry value (which is the species ID) matches the animal's species ID, get the
               corresponding key (which is the species name needed to set the combo box value) */
            if (entry.getValue().equals(animalToUpdateDetails.get("speciesID").toString())) {
                /* Set species combo box value */
                updateAnimalSpeciesList.setSelectedItem(entry.getKey());
                break;
            }
        }
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @author Lara Aras
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        databaseHeadingLabel = new javax.swing.JLabel();
        dbAdminTabbedPane = new javax.swing.JTabbedPane();
        insertPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        insertTabbedPane = new javax.swing.JTabbedPane();
        insertSpeciesPanel = new javax.swing.JPanel();
        insertSpeciesNameLabel = new javax.swing.JLabel();
        insertSpeciesNameField = new javax.swing.JTextField();
        insertSpeciesButton = new javax.swing.JButton();
        insertAnimalPanel = new javax.swing.JPanel();
        insertAnimalNameLabel = new javax.swing.JLabel();
        insertAnimalNameField = new javax.swing.JTextField();
        insertAnimalDescriptionLabel = new javax.swing.JLabel();
        insertAnimalDescriptionField = new javax.swing.JTextField();
        insertAnimalSpeciesLabel = new javax.swing.JLabel();
        insertAnimalButton = new javax.swing.JButton();
        insertAnimalSpeciesList = new javax.swing.JComboBox<>();
        updatePanel = new javax.swing.JPanel();
        updateTabbedPane = new javax.swing.JTabbedPane();
        updateSpeciesPanel = new javax.swing.JPanel();
        updateSpeciesNameLabel = new javax.swing.JLabel();
        updateSpeciesNameField = new javax.swing.JTextField();
        updateSpeciesButton = new javax.swing.JButton();
        selectSpeciesUpdateLabel = new javax.swing.JLabel();
        selectSpeciesUpdateList = new javax.swing.JComboBox<>();
        updateAnimalPanel = new javax.swing.JPanel();
        updateAnimalNameLabel = new javax.swing.JLabel();
        updateAnimalNameField = new javax.swing.JTextField();
        updateAnimalDescriptionLabel = new javax.swing.JLabel();
        updateAnimalDescriptionField = new javax.swing.JTextField();
        updateAnimalSpeciesLabel = new javax.swing.JLabel();
        updateAnimalButton = new javax.swing.JButton();
        selectAnimalUpdateLabel = new javax.swing.JLabel();
        selectAnimalUpdateList = new javax.swing.JComboBox<>();
        updateAnimalSpeciesList = new javax.swing.JComboBox<>();
        deletePanel = new javax.swing.JPanel();
        selectAnimalDeleteLabel = new javax.swing.JLabel();
        deleteAnimalButton = new javax.swing.JButton();
        selectAnimalDeleteList = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(750, 400));

        databaseHeadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        databaseHeadingLabel.setText("Database Admin");

        insertSpeciesNameLabel.setText("Species name:");

        insertSpeciesButton.setText("Submit");
        insertSpeciesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSpeciesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insertSpeciesPanelLayout = new javax.swing.GroupLayout(insertSpeciesPanel);
        insertSpeciesPanel.setLayout(insertSpeciesPanelLayout);
        insertSpeciesPanelLayout.setHorizontalGroup(
            insertSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertSpeciesPanelLayout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addGroup(insertSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertSpeciesNameLabel)
                    .addComponent(insertSpeciesNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(insertSpeciesPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(insertSpeciesButton)))
                .addGap(274, 274, 274))
        );
        insertSpeciesPanelLayout.setVerticalGroup(
            insertSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertSpeciesPanelLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(insertSpeciesNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertSpeciesNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertSpeciesButton)
                .addGap(86, 86, 86))
        );

        insertTabbedPane.addTab("Species", insertSpeciesPanel);

        insertAnimalNameLabel.setText("Animal name:");

        insertAnimalDescriptionLabel.setText("Description:");

        insertAnimalSpeciesLabel.setText("Species:");

        insertAnimalButton.setText("Submit");
        insertAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAnimalButtonActionPerformed(evt);
            }
        });

        insertAnimalSpeciesList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout insertAnimalPanelLayout = new javax.swing.GroupLayout(insertAnimalPanel);
        insertAnimalPanel.setLayout(insertAnimalPanelLayout);
        insertAnimalPanelLayout.setHorizontalGroup(
            insertAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertAnimalPanelLayout.createSequentialGroup()
                .addGroup(insertAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertAnimalPanelLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(insertAnimalButton))
                    .addGroup(insertAnimalPanelLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(insertAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insertAnimalSpeciesLabel)
                            .addComponent(insertAnimalDescriptionLabel)
                            .addComponent(insertAnimalDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(insertAnimalNameLabel)
                            .addComponent(insertAnimalNameField)
                            .addComponent(insertAnimalSpeciesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        insertAnimalPanelLayout.setVerticalGroup(
            insertAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertAnimalPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(insertAnimalNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertAnimalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertAnimalDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertAnimalDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertAnimalSpeciesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertAnimalSpeciesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(insertAnimalButton)
                .addGap(21, 21, 21))
        );

        insertTabbedPane.addTab("Animal", insertAnimalPanel);

        javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
        insertPanel.setLayout(insertPanelLayout);
        insertPanelLayout.setHorizontalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(insertTabbedPane)
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addComponent(insertTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dbAdminTabbedPane.addTab("Insert", insertPanel);

        updateTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                updateTabbedPaneStateChanged(evt);
            }
        });

        updateSpeciesNameLabel.setText("New species name:");

        updateSpeciesButton.setText("Submit");
        updateSpeciesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSpeciesButtonActionPerformed(evt);
            }
        });

        selectSpeciesUpdateLabel.setText("Select species to update:");

        selectSpeciesUpdateList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout updateSpeciesPanelLayout = new javax.swing.GroupLayout(updateSpeciesPanel);
        updateSpeciesPanel.setLayout(updateSpeciesPanelLayout);
        updateSpeciesPanelLayout.setHorizontalGroup(
            updateSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSpeciesPanelLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(updateSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectSpeciesUpdateLabel)
                    .addComponent(updateSpeciesNameLabel)
                    .addComponent(updateSpeciesNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addGroup(updateSpeciesPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(updateSpeciesButton))
                    .addComponent(selectSpeciesUpdateList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        updateSpeciesPanelLayout.setVerticalGroup(
            updateSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSpeciesPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(selectSpeciesUpdateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectSpeciesUpdateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateSpeciesNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateSpeciesNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateSpeciesButton)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        updateTabbedPane.addTab("Species", updateSpeciesPanel);

        updateAnimalNameLabel.setText("New animal name:");

        updateAnimalDescriptionLabel.setText("New description:");

        updateAnimalSpeciesLabel.setText("New species:");

        updateAnimalButton.setText("Submit");
        updateAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAnimalButtonActionPerformed(evt);
            }
        });

        selectAnimalUpdateLabel.setText("Select animal to update:");

        selectAnimalUpdateList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectAnimalUpdateList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectAnimalUpdateListItemStateChanged(evt);
            }
        });

        updateAnimalSpeciesList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout updateAnimalPanelLayout = new javax.swing.GroupLayout(updateAnimalPanel);
        updateAnimalPanel.setLayout(updateAnimalPanelLayout);
        updateAnimalPanelLayout.setHorizontalGroup(
            updateAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateAnimalPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addGroup(updateAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectAnimalUpdateLabel)
                    .addGroup(updateAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updateAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateAnimalSpeciesLabel)
                            .addComponent(updateAnimalDescriptionLabel)
                            .addComponent(updateAnimalDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(updateAnimalNameLabel)
                            .addComponent(updateAnimalNameField))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateAnimalPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateAnimalButton)
                            .addGap(56, 56, 56)))
                    .addComponent(selectAnimalUpdateList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateAnimalSpeciesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        updateAnimalPanelLayout.setVerticalGroup(
            updateAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateAnimalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectAnimalUpdateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAnimalUpdateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateAnimalNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateAnimalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateAnimalDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateAnimalDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateAnimalSpeciesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateAnimalSpeciesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateAnimalButton)
                .addGap(14, 14, 14))
        );

        updateTabbedPane.addTab("Animal", updateAnimalPanel);

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateTabbedPane)
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateTabbedPane)
        );

        dbAdminTabbedPane.addTab("Update", updatePanel);

        selectAnimalDeleteLabel.setText("Select animal to delete:");

        deleteAnimalButton.setText("Submit");
        deleteAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAnimalButtonActionPerformed(evt);
            }
        });

        selectAnimalDeleteList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
        deletePanel.setLayout(deletePanelLayout);
        deletePanelLayout.setHorizontalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAnimalDeleteList, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
                            .addComponent(selectAnimalDeleteLabel)
                            .addGap(350, 350, 350))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
                            .addComponent(deleteAnimalButton)
                            .addGap(337, 337, 337)))))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(selectAnimalDeleteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAnimalDeleteList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteAnimalButton)
                .addGap(108, 108, 108))
        );

        dbAdminTabbedPane.addTab("Delete", deletePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(databaseHeadingLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(dbAdminTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(databaseHeadingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dbAdminTabbedPane))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Sends form data to client object to be sent to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void insertAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAnimalButtonActionPerformed
        /* Create request HashMap with submitted value to send to server */
        HashMap request = new HashMap();
        request.put("action", "insert");
        request.put("tableName", "animal");
        request.put("animalName", insertAnimalNameField.getText());
        request.put("description", insertAnimalDescriptionField.getText());

        /* Get corresponding species ID from selected species name */
        int speciesID = Integer.parseInt(speciesMap.get(
                insertAnimalSpeciesList.getSelectedItem().toString()));
        request.put("speciesID", speciesID);

        String response = performAction(request);
        /* Reset form fields on successful insert and refresh combo box 
           options */
        if (response.equals("success")) {
            insertAnimalNameField.setText("");
            insertAnimalDescriptionField.setText("");
            insertAnimalSpeciesList.setSelectedIndex(0);
            setComboBoxOptions();
        }
    }//GEN-LAST:event_insertAnimalButtonActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Sends form data to client object to be sent to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void insertSpeciesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertSpeciesButtonActionPerformed
        String newSpeciesName = insertSpeciesNameField.getText();

        /* Check if species already exists and let user know if it does */
        if (speciesNames.contains(newSpeciesName)) {
            JOptionPane.showMessageDialog(this, "This species already exists "
                    + "in the database.",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        } else {
            /* Create request HashMap with submitted value to send to server */
            HashMap request = new HashMap();
            request.put("action", "insert");
            request.put("tableName", "species");
            request.put("speciesName", newSpeciesName);

            String response = performAction(request);
            /* Reset form field on successful insert and add new species to
               refresh combo box options */
            if (response.equals("success")) {
                insertSpeciesNameField.setText("");
                speciesNames.add(newSpeciesName);
                setComboBoxOptions();
            }
        }
    }//GEN-LAST:event_insertSpeciesButtonActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Sends form data to client object to be sent to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void updateSpeciesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSpeciesButtonActionPerformed
        String newSpeciesName = updateSpeciesNameField.getText();

        /* Get the species ID for the species that was selected to be updated 
           for where clause */
        int speciesID = Integer.parseInt(
                speciesMap.get(
                        selectSpeciesUpdateList.getSelectedItem().toString()));

        /* Create request HashMap with submitted value to send to server */
        HashMap request = new HashMap();
        request.put("action", "update");
        request.put("tableName", "species");
        request.put("speciesName", newSpeciesName);
        request.put("speciesID", speciesID);

        String response = performAction(request);
        /* Reset form fields on successful update and refresh combo box 
           options */
        if (response.equals("success")) {
            selectSpeciesUpdateList.setSelectedIndex(0);
            updateSpeciesNameField.setText("");
            setComboBoxOptions();
        }
    }//GEN-LAST:event_updateSpeciesButtonActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Sends form data to client object to be sent to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void updateAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAnimalButtonActionPerformed
        /* Create request HashMap with submitted value to send to server */
        HashMap request = new HashMap();
        request.put("action", "update");
        request.put("tableName", "animal");
        request.put("animalName", updateAnimalNameField.getText());
        request.put("description", updateAnimalDescriptionField.getText());

        /* Get the animal ID for the animal that was selected to be updated 
           for where clause */
        String animalToUpdate
                = selectAnimalUpdateList.getSelectedItem().toString();
        HashMap animalDetails = animalsMap.get(animalToUpdate);
        int animalID = Integer.parseInt(
                animalDetails.get("animalID").toString());
        request.put("animalID", animalID);

        /* Get corresponding species ID from selected species name */
        int speciesID = Integer.parseInt(speciesMap.get(
                updateAnimalSpeciesList.getSelectedItem().toString()));
        request.put("speciesID", speciesID);

        String response = performAction(request);
        /* Reset form fields on successful update and refresh combo box 
           options */
        if (response.equals("success")) {
            selectAnimalUpdateList.setSelectedIndex(0);
            updateAnimalNameField.setText("");
            updateAnimalDescriptionField.setText("");
            updateAnimalSpeciesList.setSelectedIndex(0);
            setComboBoxOptions();
        }
    }//GEN-LAST:event_updateAnimalButtonActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Sends form data to client object to be sent to server.
     *
     * @author Lara Aras
     * @param evt
     */
    private void deleteAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAnimalButtonActionPerformed
        /* Create request HashMap with submitted value to send to server */
        HashMap request = new HashMap();
        request.put("action", "delete");
        request.put("tableName", "animal");

        /* Get the animal ID for the animal that was selected to be deleted 
           for where clause */
        String animalToDelete
                = selectAnimalDeleteList.getSelectedItem().toString();
        HashMap animalDetails = animalsMap.get(animalToDelete);
        int animalID = Integer.parseInt(
                animalDetails.get("animalID").toString());
        request.put("animalID", animalID);

        String response = performAction(request);
        /* Reset form field on successful delete and refresh combo box 
           options */
        if (response.equals("success")) {
            selectAnimalDeleteList.setSelectedIndex(0);
            animalNames.remove(animalToDelete);
            setComboBoxOptions();
        }
    }//GEN-LAST:event_deleteAnimalButtonActionPerformed

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Call method to populate animal update form when animal to be updated is
     * selected.
     *
     * @author Lara Aras
     * @param evt
     */
    private void selectAnimalUpdateListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectAnimalUpdateListItemStateChanged
        /* Get the details of animal that was selected to update to 
           populate update form */
        String animalToUpdate = selectAnimalUpdateList.getSelectedItem().toString();
        populateAnimalUpdateForm(animalToUpdate);
    }//GEN-LAST:event_selectAnimalUpdateListItemStateChanged

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Call method to populate animal update form with details of default combo
     * box option when switching to animal update tab.
     *
     * @author Lara Aras
     * @param evt
     */
    private void updateTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateTabbedPaneStateChanged
        /* When switching to the update animal tab, the form should be populated
           with the values of the default selected animal in the "Select 
           animal to update" combo box */
        JTabbedPane pane = (JTabbedPane) evt.getSource();
        if (pane.getSelectedIndex() == 1) {
            /* Get the default selected animal and its details */
            String selectedAnimal = selectAnimalUpdateList.getSelectedItem().toString();
            populateAnimalUpdateForm(selectedAnimal);
        }
    }//GEN-LAST:event_updateTabbedPaneStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel databaseHeadingLabel;
    private javax.swing.JTabbedPane dbAdminTabbedPane;
    private javax.swing.JButton deleteAnimalButton;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JButton insertAnimalButton;
    private javax.swing.JTextField insertAnimalDescriptionField;
    private javax.swing.JLabel insertAnimalDescriptionLabel;
    private javax.swing.JTextField insertAnimalNameField;
    private javax.swing.JLabel insertAnimalNameLabel;
    private javax.swing.JPanel insertAnimalPanel;
    private javax.swing.JLabel insertAnimalSpeciesLabel;
    private javax.swing.JComboBox<String> insertAnimalSpeciesList;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JButton insertSpeciesButton;
    private javax.swing.JTextField insertSpeciesNameField;
    private javax.swing.JLabel insertSpeciesNameLabel;
    private javax.swing.JPanel insertSpeciesPanel;
    private javax.swing.JTabbedPane insertTabbedPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel selectAnimalDeleteLabel;
    private javax.swing.JComboBox<String> selectAnimalDeleteList;
    private javax.swing.JLabel selectAnimalUpdateLabel;
    private javax.swing.JComboBox<String> selectAnimalUpdateList;
    private javax.swing.JLabel selectSpeciesUpdateLabel;
    private javax.swing.JComboBox<String> selectSpeciesUpdateList;
    private javax.swing.JButton updateAnimalButton;
    private javax.swing.JTextField updateAnimalDescriptionField;
    private javax.swing.JLabel updateAnimalDescriptionLabel;
    private javax.swing.JTextField updateAnimalNameField;
    private javax.swing.JLabel updateAnimalNameLabel;
    private javax.swing.JPanel updateAnimalPanel;
    private javax.swing.JLabel updateAnimalSpeciesLabel;
    private javax.swing.JComboBox<String> updateAnimalSpeciesList;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JButton updateSpeciesButton;
    private javax.swing.JTextField updateSpeciesNameField;
    private javax.swing.JLabel updateSpeciesNameLabel;
    private javax.swing.JPanel updateSpeciesPanel;
    private javax.swing.JTabbedPane updateTabbedPane;
    // End of variables declaration//GEN-END:variables
}
