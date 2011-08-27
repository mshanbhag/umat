package com.omnesys.mw.classes;

import  java.io.Serializable;
import  java.util.Vector;

public  class   CNESTMktPiccb  implements  Serializable
  {
	public  int        iTransCode                           =-1; 
	public String     sExchSeg                              ="";							
	public String     sSymbol                               ="";
	public short    siMarketType 							= 0; 
	public  long     lVolumeTradedToday 					= 0;
	public long     lLastTradedPrice 						= 0;   
	public String    sNetChangeIndicator                     ="";
	public long     lNetPriceChangeFromClosingPrice			= 0;
	public long     lLastTradeQuantity						= 0;   
	public long     lLastTradeTime							= 0;
	public long     lAverageTradePrice						= 0;
	public long     lNoofTrades								= 0;
	public short    siAuctionNumber							= 0;
	public Object     sRecordBuffer;
	public double   dTotalBuyQuantity						= 0;
	public double   dTotalSellQuantity						= 0;
	public double   dTotalTradevalue						= 0;
	public long     lClosingPrice							= 0; 
	public long     lOpenPrice								= 0;   
	public long     lHighPrice								= 0;   
	public long     lLowPrice								= 0; 
	
	public long     lYearlyLowPrice                         = 0;      
    public long     lYearlyHighPrice						= 0;

	public long     lLowerCircuitLimit						= 0;
	public long     lUpperCircuitLimit						= 0;
	public String     sExchFeedTime                         ="";    
	public long     lSecondsSinceBoe						= 0;
	public long     lUsecs									= 0;

        public long   lOpenIntereset                              = 0;
   }   //  class  CNestMktPiccb   