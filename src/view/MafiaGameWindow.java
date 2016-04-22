/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MafiaGame;
import model.Player;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;

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
        } catch (Exception ex){}
        setVisible(true);
        jComboBoxBuyingDrugs.setModel( mainGame.getBuyDrugListAsComboBoxModel() );
        jComboBoxSellingDrugs.setModel( mainGame.getSellDrugListAsComboBoxModel() );
        jLabelCurrentMoney.setText("Current money: $" + mainGame.getPlayer().getMoney() );
    }
    
    /**
     * 
     * @return 
     */
    public String getSelectedBuyingDrugName() {
        String selected = jComboBoxBuyingDrugs.getSelectedItem().toString();
        return selected.substring(0, selected.indexOf("-") - 1);
    }
    
    public String getSelectedSellingDrugName() {
        String selected = jComboBoxSellingDrugs.getSelectedItem().toString();
        return selected.substring(0, selected.indexOf("-") - 1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxBuyingDrugs = new javax.swing.JComboBox<>();
        jComboBoxSellingDrugs = new javax.swing.JComboBox<>();
        jLabelCurrentMoney = new javax.swing.JLabel();
        jButtonBuyDrugs = new javax.swing.JButton();
        jSliderBuyDrugs = new javax.swing.JSlider();
        jSliderSellDrugs = new javax.swing.JSlider();
        jButtonSellDrugs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxCountries = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Denmark!");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buy drugs");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sell drugs");

        jComboBoxBuyingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuyingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBuyingDrugsItemStateChanged(evt);
            }
        });

        jComboBoxSellingDrugs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSellingDrugs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSellingDrugsItemStateChanged(evt);
            }
        });

        jLabelCurrentMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentMoney.setText("Current money:");

        jButtonBuyDrugs.setText("Buy drugs (0)");
        jButtonBuyDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyDrugsActionPerformed(evt);
            }
        });

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

        jSliderSellDrugs.setMajorTickSpacing(10);
        jSliderSellDrugs.setMaximum(60);
        jSliderSellDrugs.setPaintLabels(true);
        jSliderSellDrugs.setPaintTicks(true);
        jSliderSellDrugs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSellDrugsStateChanged(evt);
            }
        });

        jButtonSellDrugs.setText("Sell drugs (0)");
        jButtonSellDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSellDrugsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxBuyingDrugs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSellingDrugs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelCurrentMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSliderBuyDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButtonBuyDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonSellDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSliderSellDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabelCurrentMoney)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxBuyingDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSellingDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSliderSellDrugs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderBuyDrugs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuyDrugs)
                    .addComponent(jButtonSellDrugs))
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("Drugs", jPanel1);

        jComboBoxCountries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCountries.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCountriesItemStateChanged(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Go to country");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCountries, 0, 383, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Travel", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Extra", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderBuyDrugsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBuyDrugsStateChanged
        jButtonBuyDrugs.setText("Buy drugs (" + jSliderBuyDrugs.getValue() + ")");
    }//GEN-LAST:event_jSliderBuyDrugsStateChanged

    private void jComboBoxBuyingDrugsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBuyingDrugsItemStateChanged
        System.out.println("[jComboBoxBuyingDrugsPropertyChange] Changed to item: " + getSelectedBuyingDrugName());
        int amount = mainGame.getCountryCurrentDrugAmount( getSelectedBuyingDrugName() );
        jSliderBuyDrugs.setMaximum(amount);
    }//GEN-LAST:event_jComboBoxBuyingDrugsItemStateChanged

    private void jComboBoxSellingDrugsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSellingDrugsItemStateChanged
        System.out.println("[jComboBoxSellingDrugsPropertyChange] Changed to item: " + getSelectedSellingDrugName());
        int amount = mainGame.getPlayerCurrentDrugAmount( getSelectedSellingDrugName() );
        jSliderSellDrugs.setMaximum(amount);
    }//GEN-LAST:event_jComboBoxSellingDrugsItemStateChanged

    private void jSliderSellDrugsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSellDrugsStateChanged
        jButtonSellDrugs.setText("Sell drugs (" + jSliderSellDrugs.getValue() + ")");
    }//GEN-LAST:event_jSliderSellDrugsStateChanged

    private void jComboBoxCountriesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCountriesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCountriesItemStateChanged

    private void jButtonBuyDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyDrugsActionPerformed
        mainGame.buyDrugsFromCountry ( getSelectedBuyingDrugName(), getSelectedBuyingDrugAmount() );
        
    }//GEN-LAST:event_jButtonBuyDrugsActionPerformed

    private void jButtonSellDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSellDrugsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSellDrugsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuyDrugs;
    private javax.swing.JButton jButtonSellDrugs;
    private javax.swing.JComboBox<String> jComboBoxBuyingDrugs;
    private javax.swing.JComboBox<String> jComboBoxCountries;
    private javax.swing.JComboBox<String> jComboBoxSellingDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCurrentMoney;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSliderBuyDrugs;
    private javax.swing.JSlider jSliderSellDrugs;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}