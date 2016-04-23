/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MafiaGame;
import model.Player;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.country.BaseCountry;
import model.drug.BaseDrug;

/**
 *
 * @author CHRIS
 */
public class MafiaGameWindow extends javax.swing.JFrame {

    MafiaGame mainGame;
    
    /**
     * Creates new form TestGUI.
     * Gets the list of buying drugs and selling drugs for the first time game starts
     *
     */
    public MafiaGameWindow(MafiaGame main) {
        this.mainGame = main;
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setVisible(true);
        updateModelBoxes();
        jSliderBuyDrugs.setValue(0);
        jSliderSellDrugs.setValue(0);
        jSliderSellDrugs.setMaximum(0);
    }
    
    /**
     * Get's the correct substringed name of the current selected buying drug.
     * @return String as Drugname
     */
    public String getSelectedBuyingDrugName() {
        String selected = jComboBoxBuyingDrugs.getSelectedItem().toString();
        return selected.substring(0, selected.indexOf("-") - 1);
    }
    
    /**
     * Get's the buying Slider Drug Amount.
     * @return selectedAmount
     */
    public int getSelectedBuyingDrugAmount() {
        int selectedAmount = jSliderBuyDrugs.getValue();
        return selectedAmount;
    }
    
    /**
     * Get's the correct substringed name of the current selected buying drug. 
     * @return String as Drugname
     */
    public String getSelectedSellingDrugName() {
        Object object = jComboBoxSellingDrugs.getSelectedItem();
        if (object != null) {
            String selected = object.toString();
            return selected.substring(0, selected.indexOf("-") - 1);
        }
        return "null";
    }
    
    /**
     * Get's the selling Slider Drug Amount.
     * @return selectedAmount
     */
    public int getSelectedSellingDrugAmount() {
        int selectedAmount = jSliderSellDrugs.getValue();
        return selectedAmount;
    }
    
    public void updateModelBoxes() {
        jComboBoxBuyingDrugs.setModel(getBuyDrugModel());
        jComboBoxSellingDrugs.setModel(getSellDrugModel());
        jLabelCurrentMoney.setText("Current money: $" + mainGame.getPlayer().getMoney());
        int amount = mainGame.getPlayerCurrentDrugAmount(getSelectedSellingDrugName());
        jSliderSellDrugs.setMaximum(amount);
        amount = mainGame.getCurrentCountry().getDrug(getSelectedBuyingDrugName()).getAmount();
        jSliderBuyDrugs.setMaximum(amount);
        jLabelWelcomeText.setText("Welcome to " + mainGame.getCurrentCountry().getName() + "!");
        jComboBoxCountries.setModel(getTravelModel());
        jLabelCurrentTurn.setText("Current turn: " + mainGame.getTurn());
        int health = mainGame.getPlayer().getHealth();
        jProgressBarCurrentHP.setValue(health);
        jProgressBarCurrentHP.setString(health + "/100");
        if (health == 0 || mainGame.getTurn() >= 20) {
            endGame();
            this.dispose();
            try {
                mainGame.EndGame();
                mainGame = new MafiaGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void endGame() {
        for (BaseDrug d : mainGame.getPlayer().getDrugs()) {
            try {
                mainGame.sellDrug(d.getName(), d.getAmount());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Game Over!" + System.lineSeparator() +
                                            "You ended with $" + mainGame.getPlayer().getMoney());
    }
    
    public DefaultComboBoxModel getSellDrugModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        Player player = mainGame.getPlayer();
        ArrayList<BaseDrug> playerDrugs = player.getDrugs();
        BaseCountry country = mainGame.getCurrentCountry();
        ArrayList<BaseDrug> countryDrugs = country.getDrugs();
        for (int i = 0; i < playerDrugs.size(); i++) {
            BaseDrug d = playerDrugs.get(i);
            for (BaseDrug cDrug : countryDrugs) {
                if (d.getName().equals(cDrug.getName())) {
                    if (d.getAmount() > 0) {
                        model.addElement(d.getName() + " - " + cDrug.getPrice());
                    }
                }
            }
        }
        return model;
    }
    
    
    public DefaultComboBoxModel getBuyDrugModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        BaseCountry country = mainGame.getCurrentCountry();
        ArrayList<BaseDrug> drugs = country.getDrugs();
        for (int i = 0; i < drugs.size(); i++) {
            BaseDrug d = drugs.get(i);
            if (d.getAmount() > 0) {
                model.addElement(d.getName() + " - " + d.getPrice());
            }
        }
        return model;
    }
    
    public DefaultComboBoxModel getTravelModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        BaseCountry country = mainGame.getCurrentCountry();
        System.out.println("[getTravelModel]: " + country.getName());
        ArrayList<BaseCountry> countries = mainGame.getCountries();
        for (int i = 0; i < countries.size(); i++) {
            BaseCountry c = countries.get(i);
            if (!c.getName().equals(country.getName())) {
                model.addElement(c.getName());
            }
        }
        return model;
    }
    
    /**
     * Updates the High Scores table with data inserted like normal european reading direction.
     * @see getHighScoresFromDatabase() in control.MafiaGame
     */
    public void updateHighScores() {
        
        DefaultTableModel tModel = new DefaultTableModel();
        
        ArrayList<String> scores = mainGame.getHighScoresFromDatabase(); //Getting Strings from database
        
        scores = new ArrayList();                           //TEST
        scores.add("hej");                                  //TEST
        scores.add("hej2");                                 //TEST
        scores.add("hej3");                                 //TEST
        scores.add("hej4");                                 //TEST
        scores.add("hej5");                                 //TEST
        scores.add("hej6");                                 //TEST
        
        tModel.addColumn("Username");                       //Creates the username column in the modle
        tModel.addColumn("Scores");                         //Create the score column in the model
        tModel.setRowCount( (scores.size() / 2) + 1 );      //Making the table long enugh to import varias data
        int rowCounter = 0;                                 //Initializing a row counter for changing row the correct time after all columns in row is filled
        int columnCounter = 0;                              //Initializing a column counter for getting data correct in
        System.out.println(tModel.getColumnCount());        //TEST
        for (String string : scores) {                      //Looping every String from database
            System.out.println("row insert: " + string);    //Print is for test porpose and error finding.
            tModel.setValueAt(string, rowCounter, columnCounter); //This was the old way = tModel.insertRow(p, new Object[] { string }); // Insert a row at position p
            if ( columnCounter == 1 ) {
                rowCounter++;
                columnCounter = 0;
            }
            else if ( !(columnCounter == 1) ) {
                columnCounter++;                                //Increment columCountrer all the time, because it is like the eyes of a reading person.
            }
        }
        jTableHighScore.setModel(tModel); //Inserting the prereadied table to the GUI.
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelWelcomeText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxBuyingDrugs = new javax.swing.JComboBox<>();
        jComboBoxSellingDrugs = new javax.swing.JComboBox<>();
        jLabelCurrentMoney = new javax.swing.JLabel();
        jButtonBuyDrugs = new javax.swing.JButton();
        jSliderBuyDrugs = new javax.swing.JSlider();
        jSliderSellDrugs = new javax.swing.JSlider();
        jButtonSellDrugs = new javax.swing.JButton();
        jButtonUpdatePlayerInventoryTest = new javax.swing.JButton();
        jLabelCurrentTurn = new javax.swing.JLabel();
        jProgressBarCurrentHP = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxCountries = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButtonTravel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonPrintAllDrugPrices = new javax.swing.JButton();
        jButtonTestHighScore = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabelHighScoreHeadline = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHighScore = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelWelcomeText.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabelWelcomeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcomeText.setText("Welcome to Denmark!");
        jPanel1.add(jLabelWelcomeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 560, 34));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buy drugs");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 260, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sell drugs");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 85, 260, -1));

        jComboBoxBuyingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuyingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBuyingDrugsItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxBuyingDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 260, -1));

        jComboBoxSellingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSellingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSellingDrugsItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxSellingDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 110, 270, -1));

        jLabelCurrentMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentMoney.setText("Current money:");
        jPanel1.add(jLabelCurrentMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 260, -1));

        jButtonBuyDrugs.setText("Buy drugs (0)");
        jButtonBuyDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyDrugsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuyDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 260, -1));

        jSliderBuyDrugs.setMajorTickSpacing(10);
        jSliderBuyDrugs.setMaximum(60);
        jSliderBuyDrugs.setMinorTickSpacing(5);
        jSliderBuyDrugs.setPaintLabels(true);
        jSliderBuyDrugs.setPaintTicks(true);
        jSliderBuyDrugs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderBuyDrugsStateChanged(evt);
            }
        });
        jPanel1.add(jSliderBuyDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 260, -1));

        jSliderSellDrugs.setMajorTickSpacing(10);
        jSliderSellDrugs.setMaximum(60);
        jSliderSellDrugs.setMinorTickSpacing(5);
        jSliderSellDrugs.setPaintLabels(true);
        jSliderSellDrugs.setPaintTicks(true);
        jSliderSellDrugs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSellDrugsStateChanged(evt);
            }
        });
        jPanel1.add(jSliderSellDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 150, 280, -1));

        jButtonSellDrugs.setText("Sell drugs (0)");
        jButtonSellDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSellDrugsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSellDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 210, 270, -1));

        jButtonUpdatePlayerInventoryTest.setText("Force Update Models");
        jButtonUpdatePlayerInventoryTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePlayerInventoryTestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdatePlayerInventoryTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 260, 270, -1));

        jLabelCurrentTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentTurn.setText("Current turn: ");
        jPanel1.add(jLabelCurrentTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, -1));

        jProgressBarCurrentHP.setForeground(new java.awt.Color(0, 204, 0));
        jProgressBarCurrentHP.setToolTipText("");
        jProgressBarCurrentHP.setValue(100);
        jProgressBarCurrentHP.setDoubleBuffered(true);
        jProgressBarCurrentHP.setString("100/100");
        jProgressBarCurrentHP.setStringPainted(true);
        jPanel1.add(jProgressBarCurrentHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 265, 260, 21));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Current HP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, 260, -1));

        jTabbedPane1.addTab("Drugs", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCountries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBoxCountries, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 200, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Go to country");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 580, -1));

        jButtonTravel.setText("Travel");
        jButtonTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTravelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTravel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 90, -1));

        jTabbedPane1.addTab("Travel", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPrintAllDrugPrices.setText("Print All Drug Prices");
        jButtonPrintAllDrugPrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintAllDrugPricesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonPrintAllDrugPrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 200, -1));

        jButtonTestHighScore.setText("Test High Score");
        jButtonTestHighScore.setToolTipText("");
        jButtonTestHighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestHighScoreActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonTestHighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, -1));

        jTabbedPane1.addTab("Extra", jPanel3);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHighScoreHeadline.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelHighScoreHeadline.setText("High Scores in the Mafia Game");
        jPanel5.add(jLabelHighScoreHeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 5, -1, -1));

        jTableHighScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHighScore.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTableHighScore);
        jTableHighScore.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 250));

        jTabbedPane1.addTab("High Score", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 620, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderBuyDrugsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBuyDrugsStateChanged
        jButtonBuyDrugs.setText("Buy drugs (" + jSliderBuyDrugs.getValue() + ")");
    }//GEN-LAST:event_jSliderBuyDrugsStateChanged

    private void jComboBoxBuyingDrugsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBuyingDrugsItemStateChanged
        System.out.println("[jComboBoxBuyingDrugsPropertyChange] Changed to item: " + getSelectedBuyingDrugName());
        int amount = mainGame.getCountryCurrentDrugAmount(getSelectedBuyingDrugName());
        jSliderBuyDrugs.setMaximum(amount);
        jSliderBuyDrugs.setValue(0);
    }//GEN-LAST:event_jComboBoxBuyingDrugsItemStateChanged

    private void jComboBoxSellingDrugsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSellingDrugsItemStateChanged
        System.out.println("[jComboBoxSellingDrugsPropertyChange] Changed to item: " + getSelectedSellingDrugName());
        int amount = mainGame.getPlayerCurrentDrugAmount(getSelectedSellingDrugName());
        jSliderSellDrugs.setMaximum(amount);
    }//GEN-LAST:event_jComboBoxSellingDrugsItemStateChanged

    private void jSliderSellDrugsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSellDrugsStateChanged
        jButtonSellDrugs.setText("Sell drugs (" + jSliderSellDrugs.getValue() + ")");
    }//GEN-LAST:event_jSliderSellDrugsStateChanged

    private void jButtonBuyDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyDrugsActionPerformed
        String drugName = getSelectedBuyingDrugName();
        int amount = getSelectedBuyingDrugAmount();
        if (amount > 0) {
            int price = mainGame.getCurrentCountry().getDrug(drugName).getPrice();
            try {
                mainGame.buyDrug(drugName, amount, price);
                updateModelBoxes();
            } catch (Exception e) {
                String msg = e.getMessage();
                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }//GEN-LAST:event_jButtonBuyDrugsActionPerformed

    private void jButtonSellDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSellDrugsActionPerformed
        String drugName = getSelectedSellingDrugName();
        int amount = getSelectedSellingDrugAmount();
        if (!drugName.equals("null") && amount > 0) {
            try {
                mainGame.sellDrug(drugName, amount);
                updateModelBoxes();
            } catch (Exception e) {
                String msg = e.getMessage();
                JOptionPane.showMessageDialog(null, msg);
            }
            
        }
    }//GEN-LAST:event_jButtonSellDrugsActionPerformed

    private void jButtonUpdatePlayerInventoryTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePlayerInventoryTestActionPerformed
        updateModelBoxes();
    }//GEN-LAST:event_jButtonUpdatePlayerInventoryTestActionPerformed

    private void jButtonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTravelActionPerformed
        String selectedCountry = jComboBoxCountries.getSelectedItem().toString();
        BaseCountry country = mainGame.getCountry(selectedCountry);
        mainGame.Travel(country);
        updateModelBoxes();
    }//GEN-LAST:event_jButtonTravelActionPerformed

    private void jButtonPrintAllDrugPricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintAllDrugPricesActionPerformed
        ArrayList<BaseCountry> countries = mainGame.getCountries();
        for (int i = 0; i < countries.size(); i++) {
            BaseCountry c = countries.get(i);
            ArrayList<BaseDrug> drugs = c.getDrugs();
            System.out.println("---- " + c.getName() + " ----");
            for (int j = 0; j < drugs.size(); j++) {
                BaseDrug d = drugs.get(j);
                System.out.println(d.getName() + ", Price: " + d.getPrice() + ", Amount: " + d.getAmount());
            }
        }
    }//GEN-LAST:event_jButtonPrintAllDrugPricesActionPerformed

    private void jButtonTestHighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestHighScoreActionPerformed
        updateHighScores();
        
    }//GEN-LAST:event_jButtonTestHighScoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuyDrugs;
    private javax.swing.JButton jButtonPrintAllDrugPrices;
    private javax.swing.JButton jButtonSellDrugs;
    private javax.swing.JButton jButtonTestHighScore;
    private javax.swing.JButton jButtonTravel;
    private javax.swing.JButton jButtonUpdatePlayerInventoryTest;
    private javax.swing.JComboBox<String> jComboBoxBuyingDrugs;
    private javax.swing.JComboBox<String> jComboBoxCountries;
    private javax.swing.JComboBox<String> jComboBoxSellingDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCurrentMoney;
    private javax.swing.JLabel jLabelCurrentTurn;
    private javax.swing.JLabel jLabelHighScoreHeadline;
    private javax.swing.JLabel jLabelWelcomeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBarCurrentHP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSliderBuyDrugs;
    private javax.swing.JSlider jSliderSellDrugs;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableHighScore;
    // End of variables declaration//GEN-END:variables
}
