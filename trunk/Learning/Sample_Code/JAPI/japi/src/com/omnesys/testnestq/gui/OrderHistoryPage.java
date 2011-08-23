/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OrderHistory.java
 *
 * Created on Jul 2, 2009, 12:33:16 PM
 */

package com.omnesys.testnestq.gui;

import com.omnesys.nestq.classes.NestControl;
import com.omnesys.nestq.classes.OrderHistory;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pankaj
 */
public class OrderHistoryPage extends javax.swing.JFrame implements Runnable
{
    private NestControl nc;    
    Vector orderHistory;
    /** Creates new form OrderHistory */
    public OrderHistoryPage() {        
        nc = HomePage.nc;
        java.awt.EventQueue.invokeLater(this);
        initComponents();
    }

    public OrderHistoryPage(Vector orderHistory)
    {
        nc = HomePage.nc;
        this.orderHistory = orderHistory;
        java.awt.EventQueue.invokeLater(this);
        initComponents();
        initTable();
    }

    public void initTable()
    {
        int nRows = orderHistory.size();        

        
        for(int i=0; i<nRows; i++)
        {
            int j = 0;
            OrderHistory oh = (OrderHistory)orderHistory.get(i);

            //exch seg
            if(oh.oOrderUpdate.oOrderParams.sExchSeg == null ||
               oh.oOrderUpdate.oOrderParams.sExchSeg.length() == 0)
                oh.oOrderUpdate.oOrderParams.sExchSeg = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sExchSeg, i, j++);

            //nest order no
            if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sNestOrdNum, i, j++);

            //request ID
            if(oh.oOrderUpdate.sReqId == null ||
               oh.oOrderUpdate.sReqId.length() == 0)
                oh.oOrderUpdate.sReqId = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sReqId, i, j++);

            //account ID
            if(oh.oOrderUpdate.oOrderParams.sAccountId == null ||
               oh.oOrderUpdate.oOrderParams.sAccountId.length() == 0)
                oh.oOrderUpdate.oOrderParams.sAccountId = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sAccountId, i, j++);

            //buy/cell or transaction tyep
            if(oh.oOrderUpdate.oOrderParams.sTransType == null ||
               oh.oOrderUpdate.oOrderParams.sTransType.length() == 0)
                oh.oOrderUpdate.oOrderParams.sTransType = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sTransType, i, j++);

            //symbol name
            if(oh.sSymbol == null ||
               oh.sSymbol.length() == 0)
                oh.sSymbol = "NA";
            jTable1.setValueAt(oh.sSymbol, i, j++);

            //instrument name
            if(oh.sSymbol == null ||
               oh.sSymbol.length() == 0)
                oh.sSymbol = "NA";
            jTable1.setValueAt("NA", i, j++);

            //strike price            
            jTable1.setValueAt("NA", i, j++);

            //expiry date
            jTable1.setValueAt("NA", i, j++);

            //option type
            jTable1.setValueAt("NA", i, j++);

            //price
            jTable1.setValueAt(new Double(oh.oOrderUpdate.oOrderParams.dPrice /100), i, j++);

            //avg price
            jTable1.setValueAt(new Double(oh.oOrderUpdate.dAvgPrice /100), i, j++);

            //total qty
            jTable1.setValueAt(new Long(oh.oOrderUpdate.oOrderParams.lQuantity), i, j++);

            //pending qty
            jTable1.setValueAt(new Long(oh.oOrderUpdate.lUnfilledSize), i, j++);

            //disclosed qty
            jTable1.setValueAt(new Long(oh.oOrderUpdate.oOrderParams.lDiscQuantity), i, j++);

            //exchange order no
            if(oh.oOrderUpdate.sExchOrdId == null ||
               oh.oOrderUpdate.sExchOrdId.length() == 0)
               oh.oOrderUpdate.sExchOrdId = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sExchOrdId, i, j++);

            //pro/client -- cutomer firm
            if(oh.oOrderUpdate.oOrderParams.sCustomerFirm == null ||
               oh.oOrderUpdate.oOrderParams.sCustomerFirm.length() == 0)
               oh.oOrderUpdate.oOrderParams.sCustomerFirm = "PRO";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sCustomerFirm, i, j++);

            //validity
/*            if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //good till date
/*            if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sValidDate, i, j++);

            //order type
            if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sOrderType, i, j++);

            //product type
            if(oh.oOrderUpdate.oOrderParams.sProduct == null ||
               oh.oOrderUpdate.oOrderParams.sProduct.length() == 0)
                oh.oOrderUpdate.oOrderParams.sProduct = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sProduct, i, j++);

            //trigger price
            jTable1.setValueAt(new Double(oh.oOrderUpdate.oOrderParams.dTriggerPrice /100), i, j++);

            //status
            if(oh.oOrderUpdate.sStatus == null ||
               oh.oOrderUpdate.sStatus.length() == 0)
                oh.oOrderUpdate.sStatus = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sStatus, i, j++);

            //rejection reason
            if(oh.oOrderUpdate.sText == null ||
               oh.oOrderUpdate.sText.length() == 0)
                oh.oOrderUpdate.sText = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sText, i, j++);

            //nest update time
            if(oh.oOrderUpdate.sNestUpdateTime == null ||
               oh.oOrderUpdate.sNestUpdateTime.length() == 0)
                oh.oOrderUpdate.sNestUpdateTime = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sNestUpdateTime, i, j++);

            //remarks
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //traded qty            
            jTable1.setValueAt(new Long(oh.oOrderUpdate.lFilledShares), i, j++);

            //market type
/*            if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //trading symbol
            if(oh.oOrderUpdate.oOrderParams.sTrdSymbol == null ||
               oh.oOrderUpdate.oOrderParams.sTrdSymbol.length() == 0)
                oh.oOrderUpdate.oOrderParams.sTrdSymbol = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sTrdSymbol, i, j++);

            //B - W - L
           /* if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //user ID
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sUserId, i, j++);

            //auction no
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //participant code
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //exchange order time stamp
            if(oh.oOrderUpdate.sExchTime == null ||
               oh.oOrderUpdate.sExchTime.length() == 0)
                oh.oOrderUpdate.sExchTime = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.sExchTime, i, j++);

            //order gen type
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //warehouse details
            if(oh.oOrderUpdate.oOrderParams.sWarehouseLoc == null ||
               oh.oOrderUpdate.oOrderParams.sWarehouseLoc.length() == 0)
                oh.oOrderUpdate.oOrderParams.sWarehouseLoc = "NA";
            jTable1.setValueAt(oh.oOrderUpdate.oOrderParams.sWarehouseLoc, i, j++);

            //modified by user
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //order source
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //exchange account ID
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //Qty in lots
            /*if(oh.oOrderUpdate.oh.oOrderUpdate.sExchTime == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);

            //qty units
            /*if(oh.oOrderUpdate.sNestOrdNum == null ||
               oh.oOrderUpdate.sNestOrdNum.length() == 0)
                oh.oOrderUpdate.sNestOrdNum = "NA";*/
            jTable1.setValueAt("NA", i, j++);


            //ModifiedInfo

            jTable1.setValueAt(oh.sModifiedInfo,i,j++);
            //Cancelled Indo
             jTable1.setValueAt(oh.sCancelledInfo,i,j++);
             jTable1.setValueAt(oh.sReport,i,j++);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Order History");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [orderHistory.size()][41] ,
            new String [] {
                "Exch Seg", "NestOrdNo", "RequestID", "AccountID", "Buy/Sell", "Symbol", "Instrument Name8", "Strike Price", "Expiry Date", "Option Type", "Price", "Average Price", "Total Qty", "Pending Qty", "Disclosed Qty", "ExchOrderID", "Pro/Client", "Validity", "Good Till Date", "Order Type", "Product Type", "Trigger Price", "Status", "Rejection Reason", "Nest Update Time", "Remarks", "Traded Qty", "Market Type", "Trading Symbol", "B - W - L", "UserID", "Auction Number", "Participant code", "ExchangeTimeStamp", "OrderGenType", "WareHouse Details", "Modified By User", "Order Source", "Exchange AccountID", "Qty in Lots", "Qty Units","ModifiedInfo","CancelledInfo","Report"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setMinimumSize(new java.awt.Dimension(3075, 80));
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(80);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setMinWidth(80);
        jTable1.getColumnModel().getColumn(2).setMinWidth(80);
        jTable1.getColumnModel().getColumn(3).setMinWidth(80);
        jTable1.getColumnModel().getColumn(4).setMinWidth(80);
        jTable1.getColumnModel().getColumn(5).setMinWidth(80);
        jTable1.getColumnModel().getColumn(6).setMinWidth(80);
        jTable1.getColumnModel().getColumn(7).setMinWidth(80);
        jTable1.getColumnModel().getColumn(8).setMinWidth(80);
        jTable1.getColumnModel().getColumn(9).setMinWidth(80);
        jTable1.getColumnModel().getColumn(10).setMinWidth(80);
        jTable1.getColumnModel().getColumn(11).setMinWidth(80);
        jTable1.getColumnModel().getColumn(12).setMinWidth(80);
        jTable1.getColumnModel().getColumn(13).setMinWidth(80);

        jButton1.setText("Close Window");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modify Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row            = jTable1.getSelectedRow();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(null, "Please select an order","", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            TableColumn column = jTable1.getColumn("Status");
            String status      = (String)jTable1.getValueAt(row, column.getModelIndex());
            if(status.equalsIgnoreCase("Open")||status.equalsIgnoreCase("trigger pending"))
            {
                column = jTable1.getColumn("Exch Seg");
                String exch        = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("NestOrdNo");
                String nestOrdNo   = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("AccountID");
                String accID       = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("Buy/Sell");
                String transType   = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("Pro/Client");
                String customerFm  = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("Product Type");
                String product     = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("Trading Symbol");
                String tradSymbol  = (String)jTable1.getValueAt(row, column.getModelIndex());
                column = jTable1.getColumn("UserID");
                String sUserId  = (String)jTable1.getValueAt(row, column.getModelIndex());
                
                OrderHistory oh     = (OrderHistory)HomePage.orderHistory.get(row);
                System.out.println("Reached here "+exch+" "+transType+" "+tradSymbol+" "+customerFm+" "+product+" "+accID+""+sUserId);
                column = jTable1.getColumn("Order Type");
                String ordType = (String)jTable1.getValueAt(row, column.getModelIndex());
                if(ordType.equals("SP") ||
                   ordType.equals("2L") ||
                   ordType.equals("3L"))
                {
                    JOptionPane.showMessageDialog(null, "This kind of order can't be modified","", JOptionPane.INFORMATION_MESSAGE);
                }else{

                    ModifyOrderPage mop = new ModifyOrderPage(nestOrdNo, null, null,
                                                          exch, transType, tradSymbol,
                                                          customerFm, product, accID,sUserId);
                }
            }else {
                 JOptionPane.showMessageDialog(null, "Order can't be modified","", JOptionPane.INFORMATION_MESSAGE);
            }
        }         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row            = jTable1.getSelectedRow();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(null, "Please select an order","",
                    JOptionPane.INFORMATION_MESSAGE);            
        }else{
            System.out.println("selected row is "+row);
            TableColumn column = jTable1.getColumn("Status");
            String status      = (String)jTable1.getValueAt(row, column.getModelIndex());
             column = jTable1.getColumn("UserID");
                String sUserId  = (String)jTable1.getValueAt(row, column.getModelIndex());
                System.out.println("sUserId"+sUserId);

            if(status.equalsIgnoreCase("Open") || status.equalsIgnoreCase("Modified"))
            {
                column = jTable1.getColumn("NestOrdNo");
                String nestOrdNo   = (String)jTable1.getValueAt(row, column.getModelIndex());
                System.out.println("In cancel order nestorder no "+nestOrdNo+" "+nc);
                nc.CancelOrder(this, nestOrdNo, null, null,sUserId);
                JOptionPane.showMessageDialog(null, "Request to cancel order is placed","",
                        JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Order can't be cancelled","",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
/*    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderHistory().setVisible(true);
            }
        });
    }*/

    public void run()
    {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
