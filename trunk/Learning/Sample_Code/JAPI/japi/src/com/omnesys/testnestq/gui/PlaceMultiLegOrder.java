/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlaceMultiLegOrder.java
 *
 * Created on Jul 6, 2009, 2:53:59 PM
 */

package com.omnesys.testnestq.gui;

import com.omnesys.nestq.classes.MultiLegParams;
import com.omnesys.nestq.classes.NestClient;
import com.omnesys.nestq.classes.NestControl;
import com.omnesys.nestq.classes.OrderParams;
import com.omnesys.nestq.classes.SymbolData;
import java.util.Vector;

/**
 *
 * @author Pankaj
 */
public class PlaceMultiLegOrder extends javax.swing.JFrame implements Runnable
{
    private NestControl nc;
    private NestClient nestClient;
    private int index1 = 0;
    private int index2 = 0;
    private int index3 = 0;
     private SymbolData symboldata;
      private boolean    flag1;
    /** Creates new form PlaceMultiLegOrder */
    public PlaceMultiLegOrder() {
        nc = HomePage.nc;
        nestClient = HomePage.nestClient;
        flag1= HomePage.nc.bUserEnable;
        init();        
    }

    public void init()
    {
        HomePage.listSymbols = new Vector();
        HomePage.listSymbols.add("Scrip names");
        HomePage.listExchanges = new Vector();
        java.awt.EventQueue.invokeLater(this);
        initComponents();        
       // nc.GetAllExchanges(this,"JAPI");
//        if(HomePage.listExchanges != null && HomePage.listExchanges.size() > 0)
//            nc.GetAllSymbols(this,(String)HomePage.listExchanges.get(0));
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CustomerFirmJComboBox2 = new javax.swing.JComboBox();
        ProductJComboBox3 = new javax.swing.JComboBox();
        AccIDJTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ExchSegJComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        BS1JComboBox4 = new javax.swing.JComboBox();
        OrdType1JComboBox5 = new javax.swing.JComboBox();
        ScripName1JComboBox6 = new javax.swing.JComboBox();
        Qty1JTextField2 = new javax.swing.JTextField();
        DQty1TextField3 = new javax.swing.JTextField();
        OrdPrice1JTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BS2JComboBox7 = new javax.swing.JComboBox();
        ScripName2JComboBox9 = new javax.swing.JComboBox();
        Qty2JTextField6 = new javax.swing.JTextField();
        DQty2JTextField7 = new javax.swing.JTextField();
        OrdPrice2JTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BS3JComboBox10 = new javax.swing.JComboBox();
        ScripName3JComboBox12 = new javax.swing.JComboBox();
        Qty3JTextField10 = new javax.swing.JTextField();
        DQty3JTextField11 = new javax.swing.JTextField();
        OrdPrice3JTextField12 = new javax.swing.JTextField();
        PlaceOrderJButton1 = new javax.swing.JButton();
        CancelJButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        LotSize1JTextField = new javax.swing.JTextField();
        LotSize2JTextField = new javax.swing.JTextField();
        LotSize3JTextField = new javax.swing.JTextField();
        ValidityJComboBox = new javax.swing.JComboBox();

        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel1.setText("Place MultiLeg Order");

        jLabel2.setText("Exch Seg           OrderType                    Cutomer Firm    Product Type     Account ID       Validity");

        CustomerFirmJComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLI" }));

        ProductJComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ARB", "NRML", "CNC", "MIS", "MLB" }));

        if(!flag1)
        {
            AccIDJTextField1.setName("");
            AccIDJTextField1.setEnabled(false);
        }
        AccIDJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccIDJTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Order 1");

        ExchSegJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String [] {"nse_fo"}));
        ExchSegJComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ExchSegJComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Buy/Sell       Scrip Name                     Quantity          Disc Qty           Order Price            Lot Size");

        BS1JComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buy", "Sell" }));

        OrdType1JComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spread Order", "2L", "3L" }));
        OrdType1JComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OrdType1JComboBox5ItemStateChanged(evt);
            }
        });

        ScripName1JComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIFTY10DECFUT" }));
        ScripName1JComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ScripName1JComboBox6ItemStateChanged(evt);
            }
        });

        Qty1JTextField2.setText("0");

        DQty1TextField3.setText("0");

        OrdPrice1JTextField4.setText("0.0");

        jLabel7.setText("Buy/Sell       Scrip Name                     Quantity         Disc Qty           Order Price           Lot Size");

        BS2JComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buy", "Sell" }));

        ScripName2JComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIFTY10DEC6100PE" }));
        ScripName2JComboBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ScripName2JComboBox9ItemStateChanged(evt);
            }
        });

        Qty2JTextField6.setText("0");

        DQty2JTextField7.setText("0");

        OrdPrice2JTextField8.setText("0.0");
        OrdPrice2JTextField8.setEnabled(false);

        jLabel9.setText("Buy/Sell       Scrip Name                      Quantity         Disc Qty           Order Price           Lot Size");
        jLabel9.setEnabled(false);

        BS3JComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buy", "Sell" }));
        BS3JComboBox10.setEnabled(false);

        ScripName3JComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIFTY10DEC6100CE" }));
        ScripName3JComboBox12.setEnabled(false);
        ScripName3JComboBox12.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ScripName3JComboBox12ItemStateChanged(evt);
            }
        });

        Qty3JTextField10.setText("0");
        Qty3JTextField10.setEnabled(false);

        DQty3JTextField11.setText("0");
        DQty3JTextField11.setEnabled(false);

        OrdPrice3JTextField12.setText("0.0");
        OrdPrice3JTextField12.setEnabled(false);

        PlaceOrderJButton1.setText("Place Order");
        PlaceOrderJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOrderJButton1ActionPerformed(evt);
            }
        });

        CancelJButton2.setText("Cancel");
        CancelJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelJButton2ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));

        jLabel11.setText("Order2");

        jLabel12.setText("Order3");
        jLabel12.setEnabled(false);

        LotSize1JTextField.setEditable(false);
        LotSize1JTextField.setText("50");

        LotSize2JTextField.setEditable(false);
        LotSize2JTextField.setText("50");

        LotSize3JTextField.setEditable(false);
        LotSize3JTextField.setText("50");
        LotSize3JTextField.setEnabled(false);

        ValidityJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DAY", "IOC" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BS1JComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ExchSegJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(OrdType1JComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CustomerFirmJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ProductJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(AccIDJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(ScripName1JComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Qty1JTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(DQty1TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(OrdPrice1JTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(LotSize1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(ValidityJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BS2JComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ScripName2JComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Qty2JTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DQty2JTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OrdPrice2JTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LotSize2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BS3JComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ScripName3JComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Qty3JTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DQty3JTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OrdPrice3JTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LotSize3JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(PlaceOrderJButton1)
                        .addGap(34, 34, 34)
                        .addComponent(CancelJButton2))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExchSegJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdType1JComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerFirmJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccIDJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValidityJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BS1JComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qty1JTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DQty1TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdPrice1JTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LotSize1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScripName1JComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BS2JComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScripName2JComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qty2JTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DQty2JTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdPrice2JTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LotSize2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BS3JComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScripName3JComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qty3JTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DQty3JTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdPrice3JTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LotSize3JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelJButton2)
                    .addComponent(PlaceOrderJButton1))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccIDJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccIDJTextField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_AccIDJTextField1ActionPerformed

    private void OrdType1JComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OrdType1JComboBox5ItemStateChanged
        System.out.println("Item state chenged");
        String itemSelected = ((String)OrdType1JComboBox5.getSelectedItem()).trim();
        if(itemSelected.equalsIgnoreCase("Spread Order"))
        {
            if(ValidityJComboBox.getItemCount() == 1)
            {
                ValidityJComboBox.addItem("DAY");
            }
                //

            //order2 elements
            OrdPrice2JTextField8.disable();
            ScripName2JComboBox9.disable();
            

            //order3 elements
            jLabel12.disable();
            jLabel9.disable();
            BS3JComboBox10.disable();
            ScripName3JComboBox12.disable();
            Qty3JTextField10.disable();
            DQty3JTextField11.disable();
            OrdPrice3JTextField12.disable();
            LotSize3JTextField.disable();
            
        }        
        else if(itemSelected.equalsIgnoreCase("2l"))
        {
            System.out.println(ValidityJComboBox.getItemCount());
            if(ValidityJComboBox.getItemCount() == 2)
            {
                //ValidityJComboBox.removeItem("DAY");
            }
            //order2 elements
            OrdPrice2JTextField8.enable();
            ScripName2JComboBox9.enable();

            //order3 elements
            jLabel12.disable();
            jLabel9.disable();
            BS3JComboBox10.disable();
            ScripName3JComboBox12.disable();
            Qty3JTextField10.disable();
            DQty3JTextField11.disable();
            OrdPrice3JTextField12.disable();
            LotSize3JTextField.disable();
            
        }
        else if(itemSelected.equalsIgnoreCase("3l"))
        {
         if(ValidityJComboBox.getItemCount() == 2)
         {
            // ValidityJComboBox.removeItem("DAY");
         }
                
            
            //order2 elements
            OrdPrice2JTextField8.enable();
            ScripName2JComboBox9.enable();

            //order3 elements
            jLabel12.enable();
            jLabel9.enable();
            BS3JComboBox10.enable();
            ScripName3JComboBox12.enable();
            Qty3JTextField10.enable();
            DQty3JTextField11.enable();
            OrdPrice3JTextField12.enable();
            LotSize3JTextField.enable();
        }
        ValidityJComboBox.repaint();

        //order2 elements
        OrdPrice2JTextField8.repaint();
        ScripName2JComboBox9.repaint();

        //order3 elements
        jLabel12.repaint();
        jLabel9.repaint();
        BS3JComboBox10.repaint();
        ScripName3JComboBox12.repaint();
        Qty3JTextField10.repaint();
        DQty3JTextField11.repaint();
        OrdPrice3JTextField12.repaint();
        LotSize3JTextField.repaint();
}//GEN-LAST:event_OrdType1JComboBox5ItemStateChanged

    private void ExchSegJComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ExchSegJComboBox1ItemStateChanged
        String str = evt.getItem().toString();
        System.out.println(str);
      HomePage.nc.GetAllSymbols(this, str,"JAPI");
    }//GEN-LAST:event_ExchSegJComboBox1ItemStateChanged

    private void CancelJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelJButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelJButton2ActionPerformed

    private void PlaceOrderJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOrderJButton1ActionPerformed
        try {
           boolean flag = false;
           long temp = 1;

           OrderParams orderParams = new OrderParams();
           MultiLegParams multiLegParams = new MultiLegParams();

           orderParams.sOrderType = ((String)OrdType1JComboBox5.getSelectedItem()).trim();
           if(orderParams.sOrderType.equalsIgnoreCase("Spread Order"))
               orderParams.sOrderType = "SP";
           System.out.println(flag+" Order type "+orderParams.sOrderType);

           if(Qty1JTextField2.getText() == null ||
              Qty1JTextField2.getText().length() == 0)
           {
               Qty1JTextField2.setText("0");
           }
           orderParams.lQuantity = Long.parseLong(Qty1JTextField2.getText());
           //temp = ((SymbolData)HomePage.symbolData.get(index1)).lLotSize;


           temp=1;
           if(orderParams.lQuantity % temp != 0)
           {
               System.out.println("not multiple1");
               jLabel6.setText("Quantity for order1 must be multiple of lot size");
               return;
           }
           if(orderParams.lQuantity <= 0)
                flag = true;
           
           System.out.println(flag+" Quantity "+orderParams.lQuantity);

           if(DQty1TextField3.getText() == null ||
              DQty1TextField3.getText().length() == 0)
           {
               DQty1TextField3.setText("0");
           }
           orderParams.lDiscQuantity = Long.parseLong(DQty1TextField3.getText());
           if(orderParams.lDiscQuantity < 0)
                flag = true;
           System.out.println(flag+" Disclosed qty "+orderParams.lDiscQuantity);

           if(OrdPrice1JTextField4.getText() == null ||
              OrdPrice1JTextField4.getText().length() == 0)
           {
               OrdPrice1JTextField4.setText("0.0");
           }
           orderParams.dPrice = 100*Double.parseDouble(OrdPrice1JTextField4.getText());
           if((orderParams.sOrderType.equalsIgnoreCase("L") ||
               orderParams.sOrderType.equalsIgnoreCase("SL")) &&
               orderParams.dPrice <= 0)
               flag = true;
           System.out.println(flag+" price "+orderParams.dPrice);

           orderParams.sExchSeg = (String)ExchSegJComboBox1.getSelectedItem();
           System.out.println(flag+" Exchange "+orderParams.sExchSeg);

           orderParams.sTrdSymbol = (String)ScripName1JComboBox6.getSelectedItem();
           if(orderParams.sTrdSymbol.equalsIgnoreCase("Scrip names"))
               flag = true;
           System.out.println(flag+" Trd symbol "+orderParams.sTrdSymbol);

           orderParams.sTransType = (String)BS1JComboBox4.getSelectedItem();
           orderParams.sTransType = ""+ orderParams.sTransType.charAt(0);
           System.out.println(flag+" Trans type "+orderParams.sTransType);
           
          

            if(flag1)
           {
           orderParams.sAccountId = AccIDJTextField1.getText();
           if(orderParams.sAccountId == null ||
              orderParams.sAccountId.length() == 0)
           {
               flag = true;
           }
           }

           else
           {
                orderParams.sAccountId ="SET";
           }

           System.out.println(flag+" Acc ID "+orderParams.sAccountId);

           orderParams.sCustomerFirm = ((String)CustomerFirmJComboBox2.getSelectedItem()).trim();
           orderParams.sCustomerFirm = "" + orderParams.sCustomerFirm.charAt(0);
           if(orderParams.sCustomerFirm == null ||
              orderParams.sCustomerFirm.length() == 0)
           {
               flag = true;
           }
           System.out.println(flag+" Customer firm "+orderParams.sCustomerFirm);

           orderParams.sProduct = (String)ProductJComboBox3.getSelectedItem();
           if(orderParams.sProduct.equalsIgnoreCase("mlb"))
               orderParams.sProduct = "ML";
           System.out.println(flag+" product "+orderParams.sProduct);
           
           orderParams.sOrdDuration = (String)ValidityJComboBox.getSelectedItem();

           //order 2
           System.out.println("check box 2 is selected");
//         multiLegParams = new MultiLegParams();
           if(OrdPrice2JTextField8.getText() == null ||
              OrdPrice2JTextField8.getText().length() == 0)
           {
                OrdPrice2JTextField8.setText("0.0");
           }
           multiLegParams.dPrice_Leg2 = 100*Double.parseDouble(OrdPrice2JTextField8.getText());
           if(!orderParams.sOrderType.equalsIgnoreCase("sp") &&
                   multiLegParams.dPrice_Leg2 <= 0)
           {
               System.out.println("failed "+orderParams.sOrderType);
                flag = true;
           }

           if(DQty2JTextField7.getText() == null ||
              DQty2JTextField7.getText().length() == 0)
            {
                DQty2JTextField7.setText("0");
            }
           multiLegParams.lDiscQuantity_Leg2 = Long.parseLong(DQty2JTextField7.getText());
           if(multiLegParams.lDiscQuantity_Leg2 < 0)
                flag = true;

           if(Qty2JTextField6.getText() == null ||
              Qty2JTextField6.getText().length() == 0)
            {
                Qty2JTextField6.setText("0");
            }
           multiLegParams.lQuantity_Leg2 = Long.parseLong(Qty2JTextField6.getText());
         //  temp = ((SymbolData)HomePage.symbolData.get(index2)).lLotSize;

           temp=1;
           if(multiLegParams.lQuantity_Leg2 % temp != 0)
           {
               System.out.println("not multiple2");
               jLabel6.setText("Quantity for order2 must be multiple of lot size");
               return;
           }
           if(multiLegParams.lQuantity_Leg2 <= 0)
                flag = true;

           multiLegParams.sTransType_Leg2 = (String)BS2JComboBox7.getSelectedItem();
           multiLegParams.sTransType_Leg2 = ""+ multiLegParams.sTransType_Leg2.charAt(0);

           if(orderParams.sOrderType.equalsIgnoreCase("SP"))
                multiLegParams.sTrdSymbol_Leg2 = (String)ScripName1JComboBox6.getSelectedItem();
           else
                multiLegParams.sTrdSymbol_Leg2 = (String)ScripName2JComboBox9.getSelectedItem();
           if(multiLegParams.sTrdSymbol_Leg2.equalsIgnoreCase("Scrip names"))
                flag = true;
           
           if(((String)OrdType1JComboBox5.getSelectedItem()).equalsIgnoreCase("3l"))
           {
               System.out.println("check box 3 is selected");
               if(OrdPrice3JTextField12.getText() == null ||
                  OrdPrice3JTextField12.getText().length() == 0)
                {
                    OrdPrice3JTextField12.setText("0.0");
                }
                multiLegParams.dPrice_Leg3 = 100*Double.parseDouble(OrdPrice3JTextField12.getText());
                if(multiLegParams.dPrice_Leg3 <= 0)
                    flag = true;

                if(DQty3JTextField11.getText() == null ||
                   DQty3JTextField11.getText().length() == 0)
                {
                    DQty3JTextField11.setText("0");
                }
                multiLegParams.lDiscQuantity_Leg3 = Long.parseLong(DQty3JTextField11.getText());
                if(multiLegParams.lDiscQuantity_Leg3 < 0)
                    flag = true;

                if(Qty3JTextField10.getText() == null ||
                   Qty3JTextField10.getText().length() == 0)
                {
                    Qty3JTextField10.setText("0");
                }
                multiLegParams.lQuantity_Leg3 = Long.parseLong(Qty3JTextField10.getText());
                //temp = ((SymbolData)HomePage.symbolData.get(index3)).lLotSize;
                temp=1;
                if(multiLegParams.lQuantity_Leg3 % temp != 0)
                {
                    System.out.println("not multiple3");
                    jLabel6.setText("Quantity for order3 must be multiple of lot size");
                    return;
                }
                if(multiLegParams.lQuantity_Leg2 <= 0)
                    flag = true;
                if(multiLegParams.lQuantity_Leg3 <= 0)
                    flag = true;

                multiLegParams.sTransType_Leg3 = (String)BS3JComboBox10.getSelectedItem();
                multiLegParams.sTransType_Leg3 = ""+ multiLegParams.sTransType_Leg3.charAt(0);

                multiLegParams.sTrdSymbol_Leg3 = (String)ScripName3JComboBox12.getSelectedItem();
                if(multiLegParams.sTrdSymbol_Leg3.equalsIgnoreCase("Scrip names"))
                    flag = true;
           }

           if(flag)
           {
               jLabel6.setText("All data fields must be filled");
           }
           else
           {
               //placing order
               System.out.println("Placing Multileg order:");              
               nc.PlaceMultiLegOrder(this, multiLegParams, orderParams);                              
               this.setVisible(false);
           }
        }catch(Exception e)
        {
            System.out.println("Wrong data when placing order");
            e.printStackTrace();
        }
    }//GEN-LAST:event_PlaceOrderJButton1ActionPerformed

    private void ScripName1JComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ScripName1JComboBox6ItemStateChanged
        int index = ScripName1JComboBox6.getSelectedIndex();
        System.out.println("index is "+index);
       /* if(index > 0)
        {
            SymbolData sd = (SymbolData)HomePage.symbolData.get(index - 1);
            System.out.println(sd.sTrdSymbol+" "+sd.lLotSize);
            LotSize1JTextField.setText(""+sd.lLotSize);
            index1 = index - 1;
        }

        */
           LotSize1JTextField.setText(""+"50");
    }//GEN-LAST:event_ScripName1JComboBox6ItemStateChanged

    private void ScripName2JComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ScripName2JComboBox9ItemStateChanged
        int index = ScripName2JComboBox9.getSelectedIndex();
        System.out.println("index is "+index);
       /* if(index > 0)
        {
            SymbolData sd = (SymbolData)HomePage.symbolData.get(index - 1);
            System.out.println(sd.sTrdSymbol+" "+sd.lLotSize);
            LotSize2JTextField.setText(""+sd.lLotSize);
            index2 = index - 1;
        }
        */
        LotSize2JTextField.setText(""+"50");
    }//GEN-LAST:event_ScripName2JComboBox9ItemStateChanged

    private void ScripName3JComboBox12ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ScripName3JComboBox12ItemStateChanged
        int index = ScripName3JComboBox12.getSelectedIndex();
        System.out.println("index is "+index);
        /*if(index > 0)
        {
            SymbolData sd = (SymbolData)HomePage.symbolData.get(index - 1);
            System.out.println(sd.sTrdSymbol+" "+sd.lLotSize);
            LotSize3JTextField.setText(""+sd.lLotSize);
            index3 = index - 1;
        }*/
        LotSize3JTextField.setText(""+"50");
    }//GEN-LAST:event_ScripName3JComboBox12ItemStateChanged

    /*
     * int index = ScripName1JComboBox6.getSelectedIndex();
        SymbolData sd = (SymbolData)HomePage.symbolData.get(index-1);
        LotSize1JTextField.setText(""+sd.lLotSize);
     */
    public void run()
    {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccIDJTextField1;
    private javax.swing.JComboBox BS1JComboBox4;
    private javax.swing.JComboBox BS2JComboBox7;
    private javax.swing.JComboBox BS3JComboBox10;
    private javax.swing.JButton CancelJButton2;
    private javax.swing.JComboBox CustomerFirmJComboBox2;
    private javax.swing.JTextField DQty1TextField3;
    private javax.swing.JTextField DQty2JTextField7;
    private javax.swing.JTextField DQty3JTextField11;
    private javax.swing.JComboBox ExchSegJComboBox1;
    private javax.swing.JTextField LotSize1JTextField;
    private javax.swing.JTextField LotSize2JTextField;
    private javax.swing.JTextField LotSize3JTextField;
    private javax.swing.JTextField OrdPrice1JTextField4;
    private javax.swing.JTextField OrdPrice2JTextField8;
    private javax.swing.JTextField OrdPrice3JTextField12;
    javax.swing.JComboBox OrdType1JComboBox5;
    private javax.swing.JButton PlaceOrderJButton1;
    private javax.swing.JComboBox ProductJComboBox3;
    private javax.swing.JTextField Qty1JTextField2;
    private javax.swing.JTextField Qty2JTextField6;
    private javax.swing.JTextField Qty3JTextField10;
    private javax.swing.JComboBox ScripName1JComboBox6;
    private javax.swing.JComboBox ScripName2JComboBox9;
    private javax.swing.JComboBox ScripName3JComboBox12;
    private javax.swing.JComboBox ValidityJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
