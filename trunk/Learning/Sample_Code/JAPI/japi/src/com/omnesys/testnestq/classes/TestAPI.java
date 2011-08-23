/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.omnesys.testnestq.classes;

import com.omnesys.nestq.classes.MultiLegUpdate;
import com.omnesys.nestq.classes.NestClient;
import com.omnesys.nestq.classes.NestControl;

import com.omnesys.nestq.classes.OrderReport;
import com.omnesys.nestq.classes.PosData;
import com.omnesys.nestq.classes.SymbolData;
import com.omnesys.nestq.constants.NestQConstants;
import com.omnesys.testnestq.gui.Funds;
import com.omnesys.testnestq.gui.GetClients;
import com.omnesys.testnestq.gui.GetLimits;
import com.omnesys.testnestq.gui.GetPositions;
import com.omnesys.testnestq.gui.HomePage;
import com.omnesys.testnestq.gui.Login;
import com.omnesys.testnestq.gui.LoginSuccessful;

import com.omnesys.testnestq.gui.OrderBook;
import com.omnesys.testnestq.gui.OrderHistoryPage;
import com.omnesys.testnestq.gui.PlaceMultiLegOrder;
import com.omnesys.testnestq.gui.PlaceOrder;
import com.omnesys.testnestq.gui.PositionBook;

import com.omnesys.testnestq.gui.TradeBook;
import com.omnesys.testnestq.gui.TradeHistoryPage;
import java.util.Vector;

/**
 *
 * @author Pankaj
 */
public class TestAPI  extends NestClient
{    java.text.DecimalFormat df=new java.text.DecimalFormat("0.00");
    @Override
    public int FillReport(com.omnesys.nestq.classes.FillReport arg0) {

        System.out.println("Fill Report>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+arg0.sStatus);

        return 0;
    }

    @Override
    public int GetAllSymbols(Object arg0, SymbolData arg1,String sUserMsg) {
        HomePage.symbolData.add(arg1);
//        System.out.print(arg1.sTrdSymbol);
        if(arg1.sTrdSymbol != null && arg1.sTrdSymbol.length() > 0)
            HomePage.listSymbols.add(arg1.sTrdSymbol);
        return 0;
    }

    @Override
    public int GetAllSymbolsEnd(Object arg0, String arg1,String sUserMsg) {
        
        
        System.out.println("sUserMsg in getallsymbolsend"+sUserMsg);
        if(arg0 instanceof PlaceOrder)
        {
            System.out.println("calling initsymbol of placeorder");
            HomePage.placeOrder.initSymbols();
        }
        if(arg0 instanceof PlaceMultiLegOrder)
        {
            System.out.println("calling initsymbol of place multileg order");
           // HomePage.placeMLOrder.initSymbols();
        }
        if(arg0 instanceof GetPositions)
        {
            System.out.println("calling initsymbol of Get positions order");
            HomePage.getPositions.initSymbols();
        }
        return 0;
    }

    @Override
    public int GetAllSymbolsStart(Object arg0, String arg1,String sUserMsg) {
        System.out.println("First response of symbols");
        HomePage.listSymbols = new Vector();
        HomePage.symbolData  = new Vector();
        HomePage.listSymbols.add("Scrip names");
        return 0;
    }

    @Override
    public int GetClients(Object arg0, com.omnesys.nestq.classes.Clients arg1,String sUserMsg) {
        
        HomePage.GetClientsBook.add(arg1);
         return 0;
    }

    @Override
    public int GetClientsEnd(Object arg0,String sUserMsg) {
          System.out.println("end response of clients");

           HomePage.GetClientsPage = new GetClients(HomePage.GetClientsBook);
       return 0;
    }

    @Override
    public int GetClientsStart(Object arg0,String sUserMsg) {
        System.out.println("start response of clients");
         HomePage.GetClientsBook = new Vector();

       return 0;
    }

    @Override
    public int GetExchanges(Object arg0, String arg1,String sUserMsg) {
        System.out.println("exchange: "+arg1);
        HomePage.listExchanges.add(arg1);
        return 0;
    }

    @Override
    public int GetExchangesEnd(Object arg0,String sUserMsg) {
      
        System.out.println("end of response getexchange "+HomePage.listExchanges.size());
        if(arg0 instanceof PlaceOrder)
        {
            System.out.println("calling init exchange of placeorder "+HomePage.placeOrder);
            HomePage.placeOrder.initExchanges();
        }
        else if(arg0 instanceof PlaceMultiLegOrder)
        {
            System.out.println("calling init exchange of place multileg rder");
           // HomePage.placeMLOrder.initExchanges();
        }
        else if(arg0 instanceof GetPositions)
        {
            System.out.println("calling init exchange of get symbols rder");
            HomePage.getPositions.initExchanges();
        }
        return 0;
    }

    @Override
    public int GetExchangesStart(Object arg0,String sUserMsg) {
        System.out.println("First response of exchange");
        HomePage.listExchanges = new Vector();
        return 0;
    }

    @Override
    public int GetPositions(Object arg1,PosData arg0,String sUserMsg) {
        System.out.println("pos data received");
        

        HomePage.positionshistory.add(arg0);
        return 0;
    }

    @Override
    public int LoginResponse(Object arg0, String arg1, short arg2)
    {

        System.out.println("----------arg0-----------"+arg0);
        System.out.println("----------arg1-----------"+arg1);
        System.out.println("----------arg2-----------"+arg2);
        System.out.println("Client login response");
        NestControl nc = HomePage.nc;
                //(NestControl)vector.get(1);
        NestClient nestClient = HomePage.nestClient;//(NestClient)vector.get(0);
        
        if(arg2 == NestQConstants.LOGIN_SUCCESSFUL)
        {
            System.out.println("Login Successful in API");
            LoginSuccessful ls = new LoginSuccessful(nc, nestClient);
        }
        else
        {
            System.out.println("Login Failed");
            Login lgn = new Login(arg1);//, nc, nestClient);
        }
        return 0;
    }

    @Override
    public int LogoutResponse(Object arg0, short arg1) {
        return 0;
    }

    @Override
    public int MultiLegOrderUpdate(com.omnesys.nestq.classes.OrderUpdate arg0, MultiLegUpdate arg1) {



         System.out.println("OrderNumber>>>>>>>>>>>>>>>>>>>>>>>>>>>"+arg0.sNestOrdNum);
         System.out.println("Status>>>>>>>>>>>>>>>>>>>>>>>>>>>"+arg0.sStatus);
         System.out.println("Text>>>>>>>>>>>>>>>>>>>>>>>>>>>"+arg0.sText);
        return 0;
    }    

    @Override
    public int OrderHistory(Object arg0, com.omnesys.nestq.classes.OrderHistory arg1,String sUserMsg)
    {
        HomePage.orderHistory.add(arg1);
        return 0;
    }

    @Override
    public int OrderHistoryEnd(Object arg0,String sUserMsg) {
      
        System.out.println("Order history end msg received");
        HomePage.orderHistoryPage = new OrderHistoryPage(HomePage.orderHistory);        
        return 0;
    }

    @Override
    public int OrderHistoryStart(Object arg0,String sUserMsg) {
        HomePage.orderHistory = new Vector();
        System.out.println("Order history start msg received");
        
        return 0;
    }

    @Override
    public int OrderUpdate(com.omnesys.nestq.classes.OrderUpdate arg0) {
      //HomePage.placeOrder.jLabelNestOrderNumber.setText("NEST ORDER N0:"+arg0.sNestOrdNum);
       return 0;
    }

    @Override
    public int TradeHistory(Object arg0, com.omnesys.nestq.classes.FillReport arg1,String sUserMsg) {
        HomePage.fillReport.add(arg1);
        return 0;
    }

    @Override
    public int TradeHistoryEnd(Object arg0,String sUserMsg) {
       
        System.out.println("Trade histroy end msg removed");
        HomePage.tradeHistoryPage = new TradeHistoryPage(HomePage.fillReport);
        return 0;
    }

    @Override
    public int TradeHistoryStart(Object arg0,String sUserMsg) {
         
        HomePage.fillReport = new Vector();
        System.out.println("Trade history start msg received");
        return 0;
    }

    @Override
    public int GetLimits(com.omnesys.nestq.classes.Limits limit,String sUserMsg) {
       
               HomePage.getLimits.jLabelLedger.setText("Ledger Balance    "+limit.sLedger_Balance);
               HomePage.getLimits.jLabelBooked.setText("Booked P/L    "+df.format((limit.d_REALIZED_MTOM_PRSNT)));
               HomePage.getLimits.jLabelNotional.setText("Notional P/L    "+df.format((limit.d_UNREALIZED_MTOM_PRSNT)));
               HomePage.getLimits.jLabelMargin.setText("Total Margin    "+(limit.d_MARGIN_USED_PRSNT));
               HomePage.getLimits.jLabelPayin.setText("Pay In"+limit.d_payin_amount);
       
       
        return 0;
    }

    @Override
    public int UpdatePayinResponse(Object clientData, String text,String sUserMsg) {

        System.out.println("Response of lIMIT"+text);
        HomePage.funds.jLabelFunds.setText("UPDATE IN LIMITS "+text);
        
        return 0;
    }

    

    @Override
    public int GetPositionsStart(Object clientData, String sUserMsg) {
        System.out.println("GET POSITIONS START RESPONSE");
        HomePage.positionshistory=new Vector();
        return 0;
    }

    @Override
    public int GetPositionsEnd(Object clientData, String sUserMsg) {
       System.out.println("GET POSITIONS END RESPONSE");
       HomePage.positionHistoryPage=new PositionBook(HomePage.positionshistory);
       return 0;
    }

    @Override
    public int PositionConvrtResponse(Object clientData, String text, String sUserMsg) {
         System.out.println("text"+text);
         HomePage.TradeBookPage.jLabel2.setText("Convertion"+text);

       
       return 0;
    }

    @Override
    public int TradeBookResponse(Object clientData, com.omnesys.nestq.classes.FillReport fillReport, String sUserMsg) {
        HomePage.Trade.add(fillReport);
        return 0;
    }

    @Override
    public int TradeBookResponseStart(Object clientData, String sUserMsg) {
        HomePage.Trade = new Vector();
        System.out.println("Trade history start msg received");
        return 0;
    }

    @Override
    public int TradeBookResponseEnd(Object clientData, String sUserMsg) {
         System.out.println("Trade histroy end msg removed");
        HomePage.TradeBookPage = new TradeBook(HomePage.Trade);
        return 0;
    }

    @Override
    public int OrderBookResponse(Object clientData, com.omnesys.nestq.classes.OrderReport orderReport, String sUserMsg) {
        HomePage.Order.add(orderReport);
        return 0;
    }

    @Override
    public int OrderBookResponseStart(Object clientData, String sUserMsg) {
        HomePage.Order = new Vector();
        System.out.println("Order Book history start msg received");
        return 0;
    }

    @Override
    public int OrderBookResponseEnd(Object clientData, String sUserMsg) {
       System.out.println("Order Book histroy end msg removed");
        HomePage.OrderBookPage = new OrderBook(HomePage.Order);
        return 0;
    }

    @Override
    public int DisconnectionFunction(String Error) {
        System.out.println("Error----------------"+Error);
       return 0;
    }

    @Override
    public int VersionDetails(String Version) {
        System.out.println("Version"+Version);
        //HomePage.arg1.VersionLabel.setText("Application Version"+Version);
        return 0;
    }

    
   
}
