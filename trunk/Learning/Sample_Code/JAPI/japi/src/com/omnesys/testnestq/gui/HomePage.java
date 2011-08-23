/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HomePage.java
 *
 * Created on Jul 2, 2009, 10:21:17 AM
 */

package com.omnesys.testnestq.gui;

import com.omnesys.nestq.classes.NestClient;
import com.omnesys.nestq.classes.NestControl;
import com.omnesys.testnestq.classes.TestAPI;

import java.awt.EventQueue;
import java.util.Vector;

/**
 *
 * @author Pankaj
 */
public class HomePage extends javax.swing.JFrame
{
    public static NestClient            nestClient;
    public static NestControl           nc;
    public static Vector                orderHistory;
    public static OrderHistoryPage      orderHistoryPage;
    public static Vector                fillReport;
    public static TradeHistoryPage      tradeHistoryPage;
    public static Vector                listExchanges;
    public static Vector                listSymbols;
    public static PlaceOrder            placeOrder;
    public static Vector                symbolData;
    public static PlaceMultiLegOrder    placeMLOrder;
    public static CancelOrderPage       cancelOrderPage;
    public static GetPositions          getPositions;
    public static GetLimits             getLimits;
    public static Funds                 funds;
    public static Vector                positionshistory;
    public static PositionBook          positionHistoryPage;
   
    public static TradeBook              TradeBookPage;
    public static Vector                 Trade;
    public static TradeHistoryParams      TradeHistoryParams;

    public static OrderReportParams       orderreportparams;

    public static OrderBook              OrderBookPage;
  
    public static Vector                 Order;


    public static GetClients             GetClientsPage;
    public static Vector                 GetClientsBook;
    public static VersionPage        arg1;
    /** Creates new form HomePage */
    public HomePage() {
        nestClient = new TestAPI();
        nc = new NestControl(nestClient);
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 15));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NestQAPI");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Button pressed");
        Login login = new Login();//nc, nestClient);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
