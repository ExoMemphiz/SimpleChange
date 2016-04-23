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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
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
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelWelcomeText.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabelWelcomeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcomeText.setText("Welcome to Denmark!");
        jPanel1.add(jLabelWelcomeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 383, 34));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buy drugs");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 85, 181, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sell drugs");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 85, 185, -1));

        jComboBoxBuyingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuyingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBuyingDrugsItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxBuyingDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 188, -1));

        jComboBoxSellingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSellingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSellingDrugsItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxSellingDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 110, 185, -1));

        jLabelCurrentMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentMoney.setText("Current money:");
        jPanel1.add(jLabelCurrentMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 60, 185, -1));

        jButtonBuyDrugs.setText("Buy drugs (0)");
        jButtonBuyDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyDrugsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuyDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 187, -1));

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
        jPanel1.add(jSliderBuyDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 148, 187, -1));

        jSliderSellDrugs.setMajorTickSpacing(10);
        jSliderSellDrugs.setMaximum(60);
        jSliderSellDrugs.setPaintLabels(true);
        jSliderSellDrugs.setPaintTicks(true);
        jSliderSellDrugs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSellDrugsStateChanged(evt);
            }
        });
        jPanel1.add(jSliderSellDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 148, 182, -1));

        jButtonSellDrugs.setText("Sell drugs (0)");
        jButtonSellDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSellDrugsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSellDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 209, 186, -1));

        jButtonUpdatePlayerInventoryTest.setText("Force Update Models");
        jButtonUpdatePlayerInventoryTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePlayerInventoryTestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdatePlayerInventoryTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 258, 186, -1));

        jLabelCurrentTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentTurn.setText("Current turn: ");
        jPanel1.add(jLabelCurrentTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 188, -1));

        jProgressBarCurrentHP.setForeground(new java.awt.Color(0, 204, 0));
        jProgressBarCurrentHP.setToolTipText("");
        jProgressBarCurrentHP.setValue(100);
        jProgressBarCurrentHP.setDoubleBuffered(true);
        jProgressBarCurrentHP.setString("100/100");
        jProgressBarCurrentHP.setStringPainted(true);
        jPanel1.add(jProgressBarCurrentHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 187, 21));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Current HP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 238, 187, -1));

        jTabbedPane1.addTab("Drugs", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCountries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBoxCountries, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 32, 192, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Go to country");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 383, -1));

        jButtonTravel.setText("Travel");
        jButtonTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTravelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTravel, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 91, 84, -1));

        jTabbedPane1.addTab("Travel", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPrintAllDrugPrices.setText("Print All Drug Prices");
        jButtonPrintAllDrugPrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintAllDrugPricesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonPrintAllDrugPrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jTabbedPane1.addTab("Extra", jPanel3);
        jTabbedPane1.addTab("High Score", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 350));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuyDrugs;
    private javax.swing.JButton jButtonPrintAllDrugPrices;
    private javax.swing.JButton jButtonSellDrugs;
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
    private javax.swing.JLabel jLabelWelcomeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBarCurrentHP;
    private javax.swing.JSlider jSliderBuyDrugs;
    private javax.swing.JSlider jSliderSellDrugs;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
