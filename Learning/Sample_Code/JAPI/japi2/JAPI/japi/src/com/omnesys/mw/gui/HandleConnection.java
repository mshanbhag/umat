package com.omnesys.mw.gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//import sun.*;
import sun.security.x509.IPAddressName;


import com.omnesys.mw.classes.*;
import com.omnesys.mw.constants.NESTconstants;
import com.omnesys.mw.frontend.StartUI;
import com.omnesys.mw.utils.*;
import com.sun.jndi.cosnaming.IiopUrl.Address;


/**
 * This Java J2SE 5.0 source code is in the public domain. You are free to use
 * and modify it as you wish, but it comes with absolutely no warrantee.
 */


import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * class illustrating IP Multicast by receiving simple text messages via
 * IP Multicast; use IPMulticastSender to send the messages.
 * 
 * @author Raveesha Joshi, 
 * 
 * 
 */
public class HandleConnection 
{

   ResourceBundle 	oResourceBundle ;
    // IP Multicast address to receive on.
    public static String MULTICAST_ADDRESS;
    public static  int MULTICAST_PORT ;
   
    // Size of receive buffer, in bytes. 
  //  public static  int BUFFER_SIZE = 2000048;
    
    public static  int BUFFER_SIZE = 2000048;

    //  IP Multicast Socket object to use.
    private MulticastSocket sock;

    // UDP Packet object to use for receiving message. 
    private DatagramPacket pack;

    //  Buffer to store received text in. 
    private byte[] receiveBuffer;
    
    private CNESTMktPiccb CNestMktData = null;
    //public CNESTMktPiccb CNestMktData = null;
    private CNESTIndexInfo IndexInfo   = null;
    private CNESTNewsInfo  CNewsInfo   = null;
    private CNESTDJNews    CdjNews     = null;
    private  static BufferedWriter BhavCpFile;
    private  static BufferedWriter MktPicFile;
    private  static BufferedWriter IndexInfoFile;
    private  static  BufferedWriter NewsInfoFile;
    private  static  BufferedWriter DJNewsFile;
    private  static String s_mktpic_output_file_name;
    private static String s_bhavcopy_output_file_name;
	private  static String s_Index_output_file_name;
	private  static String s_New_output_file_name;
	private  static String s_DJNews_output_file_name;
    private static  Vector oMktPic = new Vector();
    
    ClientNotifyThread   cLintTread =      new  ClientNotifyThread();
    //  Default constructor: sets up IP Multicast Receiving. 
    
    private static  long Packet_count =0;
    
    // count to check the recieved packets
    
    
    private  static ObjectInputStream   input_stream 	    = null;
	private  static ObjectOutputStream  out_stream  		= null;
	
	private  static Vector vec_nse_cm 			= new Vector();
	private  static Vector vec_bse_cm 			= new Vector();
	private  static Vector vec_nse_fo 			= new Vector();
	private  static Vector vec_mcx              = new Vector();
	private  static Vector vec_ncdex            = new Vector();
	private  static Vector vec_cds              = new Vector();
	
	//private  static String ReplaceOutputFileFlag ;
	private  static String s_UserName ;
	private  static String host_ip; 
	private  static String s_nse_output_file_name;
	private  static String s_bse_output_file_name;
	private  static String s_nfo_output_file_name;
	private  static String s_mcx_output_file_name;
	private  static String s_ncdex_output_file_name;
	private  static String s_cds_output_file_name;
	
	//private  static long l_last_traded_time_seconds ;
	
	private  static int i_port ;
	//private static  int UPDATE_FREQ = 5000;
	
	private  static boolean b_nse_file_read ;
	private  static boolean b_bse_file_read ;
	private  static boolean b_nfo_file_read ;
	private  static boolean b_mcx_file_read ;
	private  static boolean b_ncdex_file_read;
	private  static boolean b_cds_file_read;
	
	
    
    
    public static void PutSubscription()
	{
		try
		{
			
			ResourceBundle	oResourceBundle = ResourceBundle.getBundle("UDPConfig");
			
			if(oResourceBundle.getString("SUBSCRIBE").trim().equals("YES"))
			{
			String s_FilePath  				= oResourceBundle.getString("FilePathForToken");
			s_UserName						= oResourceBundle.getString("UserName");
			s_UserName = s_UserName.trim();
			 
			//Establishing socket Connection 
		     host_ip  		= oResourceBundle.getString("host_ip").trim();
		     
		     i_port 		= (int)Integer.parseInt(oResourceBundle.getString("host_port").toString().trim());
		     
		     //System.out.println( "i_port ========> " +i_port);
		    
		     
			 
		     Socket socket   = new Socket(host_ip.trim(), i_port);
		    
		     
		     out_stream 		= new ObjectOutputStream(socket.getOutputStream());
		     
		     input_stream 	= new ObjectInputStream(socket.getInputStream());

             ClientTcpThread   cLintTread =      new  ClientTcpThread(input_stream);
             
		     Date  c_date 	= new Date();
			
                    System.out.println(" ");
                    System.out.println("******************************************************");
	            System.out.println("*                                                    *");
	            System.out.println("      Welcome to Market Feed Data Application ");
	            System.out.println("*     Omnesys Technologies Pvt. Ltd., Bangalore      *");
	            System.out.println("*     Version : 1.7.0.0                              *");
	            System.out.println("*                                                    *");
	            System.out.println("   StartTimeDate: " +c_date.toString()+"");
	            System.out.println("******************************************************");
	            System.out.println( "Success -> " + i_port + " : Port has been Locked" );
	            System.out.println(" ");
			
	            
	           
	            
	            
	            b_nse_file_read = ReadFileNSE(oResourceBundle,s_FilePath);
	            b_bse_file_read = ReadFileBSE(oResourceBundle,s_FilePath);
	            b_nfo_file_read = ReadFileNFO(oResourceBundle,s_FilePath);
	            b_mcx_file_read = ReadFileMCX(oResourceBundle,s_FilePath);
	            b_ncdex_file_read = ReadFileNCDEX(oResourceBundle,s_FilePath);
	            b_cds_file_read = ReadFileCDS(oResourceBundle,s_FilePath);
	            
	            System.out.println( "b_nse_file_read ========> " +b_nse_file_read);
	            //System.out.println( "b_bse_file_read ========> " +b_bse_file_read);
	            //System.out.println( "b_nfo_file_read ========> " +b_nfo_file_read);
	            //System.out.println("b_cds_file_read ===========>" +b_cds_file_read);
	            
	            CServerRequest oReqName 		= new CServerRequest();
			    oReqName.iReqType 				= 0;
			    oReqName.oAccountId 			= s_UserName;
			    String   s_Portfolio			= "NSE";
			    oReqName.sPortfolio 			= s_Portfolio;     
			    oReqName.iDDInteractive 		= 1;
			    out_stream.writeObject(oReqName);
			    out_stream.flush();
			    
			    SubscribeforDJNews(oResourceBundle);
	            
	           if( b_nse_file_read == true || b_nse_file_read == true || b_nfo_file_read == true 
	        		   					   || b_mcx_file_read == true || b_ncdex_file_read == true || b_cds_file_read == true)
	           {
	           			
							//Connecting User streamer 
					       
						    
						    SharedResources.WriteToLog("|--------------------java_udp_reciever------------------------------------|");
						    SharedResources.WriteToLog("|                                                                         |");
						    SharedResources.WriteToLog("|                    Powered by OMNE(r)                                   |");
						    SharedResources.WriteToLog("|                                                                         |");
						    SharedResources.WriteToLog("|                    Version  :: 1.7.0.0                                 |");
						    SharedResources.WriteToLog("|                                                                         |");
                                                    SharedResources.WriteToLog("|                   "+c_date.toString()+"                          |");
						    SharedResources.WriteToLog("|-------------------------------------------------------------------------|");
						    SharedResources.WriteToLog("Process Connected to Streamer Server With user Id  :: ====>"+s_UserName);
						    SharedResources.WriteToLog("Process Connected to Streamer Server IP 		   :: ====>"+host_ip);
						    SharedResources.WriteToLog("Process Connected to Streamer Server Port		   :: ====>"+i_port);
						    SharedResources.WriteToLog("Connected .........................");
						    if(b_nse_file_read == true )
						    {
						    	
						    	sentRequestToServerSubscribe(478,"NSE",vec_nse_cm);
						    	b_nse_file_read = false;
						    }
						    
						    if(b_bse_file_read == true)
						    {
						    	
						    	sentRequestToServerSubscribe(478,"BSE",vec_bse_cm);
						    	
						    	b_bse_file_read  = false;
						    }
						    if(b_nfo_file_read == true)
						    {
						    	sentRequestToServerSubscribe(478,"NFO",vec_nse_fo);
						    	
						    	b_nfo_file_read = false;
						    }

						    if(b_mcx_file_read == true)
						    {
						    	sentRequestToServerSubscribe(478,"MCX",vec_mcx);
						    	b_mcx_file_read = false;
						    }
						    if(b_ncdex_file_read == true)
						    {
						    	sentRequestToServerSubscribe(478,"NCDEX",vec_ncdex);
						    	
						    	b_ncdex_file_read  = false;
						    }
						    if(b_cds_file_read == true)
						    {
						    	sentRequestToServerSubscribe(478,"CDS",vec_cds);
						    	
						    	b_cds_file_read = false;
						    }
						    
			
	           }
	          
	           else
	           {
	           	
	           		System.out.println("Error :: ==> Token files missing file names(NSE_FO_INPUT.txt | NSE_FO_INPUT.txt | BSE_EQ_INPUT.txt ) " );
	           		  }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			    System.out.println( "Error :: ==> Critical -> Selected Port is Busy , Can't Continue on Port : "  +e);   
			  	
		}
		
	}
    
    public HandleConnection(StartUI stui)
    {
    	Initiate();
    	
    }
    public HandleConnection()
    {
    	oResourceBundle = ResourceBundle.getBundle("UDPConfig");
    	try
    	{
    		String sBufr_size = oResourceBundle.getString("UDP_BUFFER_SIZE").trim();
    		if((sBufr_size!= null) && (!sBufr_size.equals("")))
    			BUFFER_SIZE=Integer.parseInt(sBufr_size); 
    		System.out.println("Buffer Size -----------"+BUFFER_SIZE);
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Missing Resource BUFFER_SIZE ------ Defaulted to 2MB ---- "+ex.toString());
    	}
        receiveBuffer = new byte[BUFFER_SIZE];
        MULTICAST_ADDRESS=oResourceBundle.getString("MULTI_CAST_ADRESS").trim(); 
        MULTICAST_PORT  = Integer.parseInt(oResourceBundle.getString("MULTICAST_PORT").trim());
        System.out.println("MulticastAdderss-->"+MULTICAST_ADDRESS);
        System.out.println("Multicast Port->"+MULTICAST_PORT);
        
        System.out.println("******************************************************");
        System.out.println("*                                                    *");
        System.out.println("      Welcome to Market Feed UDP Reciever Application ");
        System.out.println("*     Omnesys Technologies Pvt. Ltd., Bangalore      *");
        System.out.println("*     Version : 1.7.0.0                             *");
        System.out.println("*     "+MULTICAST_ADDRESS+":"+MULTICAST_PORT+"       *");
        System.out.println("*                                                    *");
        System.out.println("******************************************************");
        
        try 
        { 
        	 sock = new MulticastSocket(MULTICAST_PORT);
            pack = new DatagramPacket( receiveBuffer, receiveBuffer.length);
            sock.joinGroup( InetAddress.getByName( MULTICAST_ADDRESS ));
            writeMKTPicFile();
            writeDataToFile();
            WriteNewsLog();
            WriteDJNewsLog();
            WriteBhavCopyFile();
        }
        catch( Exception e )
        {
            System.out.println( "Exception in creating Socket or Packet: " + e.toString() );
            e.printStackTrace();
        }
    }

    private void writeDataToFile() 
    {
    	s_Index_output_file_name = oResourceBundle.getString("IndexOutPutFileName").trim();
		
    	try
    	{
    		IndexInfoFile =  new BufferedWriter(new FileWriter(s_Index_output_file_name));
    		StringBuffer sbi  = new StringBuffer();
    		
    	 sbi.append("iTransCode");
   		 sbi.append("|");
   		 sbi.append("iValue");
		 sbi.append("|");
		 sbi.append("iOpenIndex");
		 sbi.append("|");
		 sbi.append("iCloseIndex");
		 sbi.append("|");
		 sbi.append("SIndexName");
		 sbi.append("|");
		 sbi.append("SExchSeg");
		 sbi.append("|");
		 sbi.append("SExchFeedTime");
		 sbi.append("|");
		 sbi.append("lSecondsSinceBoe");
		 sbi.append("|");
		 sbi.append("lUsecs");
		 sbi.append("|");
		 IndexInfoFile.write(sbi.toString());
		 IndexInfoFile.flush();
		 IndexInfoFile.newLine();
		 IndexInfoFile.flush();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
		// TODO Auto-generated method stub
		
	}
    
    public void WriteBhavCopyFile()
    {
    	
    	

    	s_bhavcopy_output_file_name = oResourceBundle.getString("BHAVCopyOutPutFileName").trim();
		
    	try
    	{
		BhavCpFile 			 = new BufferedWriter(new FileWriter(s_bhavcopy_output_file_name));
    	StringBuffer sb = new StringBuffer();
    	
    	

    	
		 sb.append("iTransCode");
		 sb.append("|");
		 sb.append("sExchSeg");
		 sb.append("|");
		 sb.append("sSymbol");
		 sb.append("|");
		 sb.append("lVolumeTradedToday");
		 sb.append("|");
		 sb.append("AverageTradePrice");
		 sb.append("|");
		 sb.append("lNoofTrades");
		 sb.append("|");
		 sb.append("dTotalTradevalue");
		 sb.append("|");
		 sb.append("lClosingPrice");
		 sb.append("|");
		 
		 
		 sb.append("lOpenPrice");
		 sb.append("|");
		 
		 sb.append("lHighPrice");
		 sb.append("|");
		 
		 sb.append("lLowPrice");
		 sb.append("|");
		 
		 sb.append("lPrevClosingPrice");
		 sb.append("|");
		 
		/* sb.append("sRecordBuffer");
		 sb.append(",");*/
		 
		 sb.append("lYearlyLowPrice");
		 sb.append("|");
		 
		 sb.append("lYearlyHighPrice");
		 sb.append("|");
		 
		 sb.append("lHighestOpenInterest");
		 sb.append("|");
		 
		 sb.append("lLowestOpenInterest");
		 sb.append("|");
		 
		 sb.append("ExchFeedTime");
		 sb.append("|");
		 
		 sb.append("lSecondsSinceBoe");
		 sb.append("|");
		 
		 sb.append("lUsecs");
		 sb.append("|");
		 
		 

         sb.append("lOpenInterest");
		 sb.append("|");
		
		 
		 
		 
		 BhavCpFile.write(sb.toString());
		 BhavCpFile.flush();
		 BhavCpFile.newLine();
		 BhavCpFile.flush();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
		// TODO Auto-generated method stub
		
	
    }

	public  void writeMKTPicFile()
         {
		s_mktpic_output_file_name = oResourceBundle.getString("MKTOutPutFileName").trim();
		
    	try
    	{
    		MktPicFile 			 = new BufferedWriter(new FileWriter(s_mktpic_output_file_name));
    	StringBuffer sb = new StringBuffer();
    	
    	
    	
		 sb.append("iTransCode");
		 sb.append("|");
		 sb.append("sExchSeg");
		 sb.append("|");
		 sb.append("sSymbol");
		 sb.append("|");
		 sb.append("siMarketType");
		 sb.append("|");
		 sb.append("lVolumeTradedToday");
		 sb.append("|");
		 sb.append("lLastTradedPrice");
		 sb.append("|");
		 sb.append("sNetChangeIndicator");
		 sb.append("|");
		 sb.append("lNetPriceChangeFromClosingPrice");
		 sb.append("|");
		 sb.append("lLastTradeQuantity");
		 sb.append("|");
		 
		 
		 sb.append("lLastTradeTime");
		 sb.append("|");
		 
		 sb.append("lAverageTradePrice");
		 sb.append("|");
		 
		 sb.append("lNoofTrades");
		 sb.append("|");
		 
		 sb.append("siAuctionNumber");
		 sb.append("|");
		 
		/* sb.append("sRecordBuffer");
		 sb.append(",");*/
		 
		 sb.append("dTotalBuyQuantity");
		 sb.append("|");
		 
		 sb.append("dTotalSellQuantity");
		 sb.append("|");
		 
		 sb.append("dTotalTradevalue");
		 sb.append("|");
		 
		 sb.append("lClosingPrice");
		 sb.append("|");
		 
		 sb.append("lOpenPrice");
		 sb.append("|");
		 
		 sb.append("lHighPrice");
		 sb.append("|");
		 
		 sb.append("lLowPrice");
		 sb.append("|");
		 
		 sb.append("lYearlyHighValue");
		 sb.append("|");
		 
		 sb.append("lYearlyLowValue");
		 sb.append("|");
		 
		 sb.append("lLowerCircuitLimit");
		 sb.append("|");
		 
		 sb.append("lUpperCircuitLimit");
		 sb.append("|");
		 
		 sb.append("sExchFeedTime");
		 sb.append("|");
		 
		 sb.append("lSecondsSinceBoe");
		 sb.append("|");
		 
		 sb.append("lUsecs");
		 sb.append("|");

         sb.append("lOpenIntereset");
		 sb.append("|");
		
		 sb.append("mbpinfo.lQuantity 1");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 1");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 1");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 1");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 2");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 2");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 2");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 2");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 3");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 3");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 3");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 3");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 4");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 4");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 4");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 4");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 5");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 5");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 5");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 5");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 6");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 6");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 6");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 6");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 7");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 7");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 7");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 7");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 8");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 8");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 8");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 8");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 9");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 9");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 9");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 9");
		 sb.append("|");
		 
		 
		 sb.append("mbpinfo.lQuantity 10");
		 sb.append("|");
		 sb.append("mbpinfo.lPrice 10");
		 sb.append("|");
		 sb.append("mbpinfo.siNumberOfOrders 10");
		 sb.append("|");
		 sb.append("mbpinfo.siBbBuySellFlag 10");
		 sb.append("|");
		 
		 
		 
		 MktPicFile.write(sb.toString());
		 MktPicFile.flush();
		 MktPicFile.newLine();
		 MktPicFile.flush();
		 
		 System.out.println("writing to file is done ------------------------>>>>");
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
		// TODO Auto-generated method stub
		
	}
	
	private void WriteNewsLog()
	{
		s_New_output_file_name = oResourceBundle.getString("NEWSOutPutFileName");
		try
		{
			
			
			NewsInfoFile 			 = new BufferedWriter(new FileWriter(s_New_output_file_name));
	    	StringBuffer sb = new StringBuffer();
	    	
			 sb.append("iTransCode");
			 sb.append("|");
			 sb.append("NewsMsg");
			 sb.append("|");
			 sb.append("sExchSeg");
			 sb.append("|");
			 sb.append("lSecondsSinceBoe");
			 sb.append("|");
			 sb.append("lUsecs");
			 sb.append("|");
			 
			 NewsInfoFile.write(sb.toString());
			 NewsInfoFile.flush();
			 NewsInfoFile.newLine();
			 NewsInfoFile.flush();
			
		}
		catch(Exception ex)
		{
			
		}
		
		
	}
	
	
	private void WriteDJNewsLog()
	{
		s_DJNews_output_file_name = oResourceBundle.getString("DJOutPutFileName");
		try
		{
			
			
			DJNewsFile 			 = new BufferedWriter(new FileWriter(s_DJNews_output_file_name));
	    	StringBuffer sb = new StringBuffer();
	    	
	    	
	    	    	
			 sb.append("TransCode");
			 sb.append("|");
			 sb.append("Source");
			 sb.append("|");
			 sb.append("Newshotindicator");
			 sb.append("|");
			 sb.append("Accessionnumber");
			 sb.append("|");
			 sb.append("Gmtdate");
			 sb.append("|");
			 sb.append("GMTtime");
			 sb.append("|");
			 sb.append("Expirymessagecount");
			 sb.append("|");
			 sb.append("Expirymessagelist");
			 sb.append("|");
			 sb.append("Actioncode");
			 sb.append("|");
			 sb.append("RefSeqNumber");
			 sb.append("|");
			 sb.append("NewsSeqNumber");
			 sb.append("|");
			 sb.append("NewsTagLength");
			 sb.append("|");
			 sb.append("Newslength");
			 sb.append("|");
			 sb.append("Newstag");
			 sb.append("|");
			 sb.append("Newsheadlines");
			 sb.append("|");
			 sb.append("NewsStory");
			 sb.append("|");
			 
			 DJNewsFile.write(sb.toString());
			 DJNewsFile.flush();
			 DJNewsFile.newLine();
			 DJNewsFile.flush();
			
		}
		catch(Exception ex)
		{
			
		}
		
		
	}
    
    

	/**
     * Receives one IP Multicast message, prints it on screen, and resets buffer
     * so it's ready to receive again.
     */
    private void receiveMessage() {
        try {
        	
        	sock.setTimeToLive(1);
        	//System.out.println("Waiting for packet to Recieve");
        	
            sock.receive( pack );
            Packet_count++;
            //System.out.println("Packet Length"+pack.getLength());
            
           //System.out.println("Yes...! Finally i got the packet");
            int NEST_FeedType_Constant = NESTconvert.ByteToInt(receiveBuffer,0);
            System.out.println("-------------------NEST_FeedType_Constant------------------------>>>"+NEST_FeedType_Constant);
            switch(NEST_FeedType_Constant)
            {
            case NESTconstants.NEST_BHAV_COPY:
            	CStreamData  data6 = new CStreamData();
            	CNESTBhavCopy  Cnestbhavcp= new CNESTBhavCopy();
            	Cnestbhavcp = NestBhavCpyConvert(receiveBuffer);
            	
            	try
                {
            		 System.out.println("-------------------"+Cnestbhavcp.sExchSeg);
            		 System.out.println("-------------------"+Cnestbhavcp.sSymbol);
                }
            	catch(Exception ex111)
            	{
            		ex111.printStackTrace();
            	}
            	
            	data6.iMsgCode = NESTconstants.NEST_BHAV_COPY;
                data6.oStreamObj = Cnestbhavcp;
                cLintTread.oQueue.add(data6);
            	
            	break;
            case NESTconstants.NEST_MKTPIC:
            	CStreamData  data1 = new CStreamData();
            	CNestMktData = new CNESTMktPiccb();
            	CNestMktData= NestMktPiccbConvert(receiveBuffer);
            	 try
                 {
                 /*	System.out.println("NestMktPiccb.iTransCode---------------------->"+CNestMktData.iTransCode);
                 	System.out.println("CNestMktData.sExchSeg------------------------->"+CNestMktData.sExchSeg);
                 	System.out.println("CNestMktData.sSymbol-------------------------->"+CNestMktData.sSymbol);
                 	System.out.println("CNestMktData.siMarketType--------------------->"+CNestMktData.siMarketType);
                 	System.out.println("CNestMktData.lVolumeTradedToday--------------->"+CNestMktData.lVolumeTradedToday);
                 	System.out.println("CNestMktData.lLastTradedPrice----------------->"+CNestMktData.lLastTradedPrice);
                 	System.out.println("CNestMktData.sNetChangeIndicator-------------->"+CNestMktData.sNetChangeIndicator);
                 	System.out.println("CNestMktData.lNetPriceChangeFromClosingPrice-->"+CNestMktData.lNetPriceChangeFromClosingPrice);
                 	System.out.println("CNestMktData.lLastTradeQuantity--------------->"+CNestMktData.lLastTradeQuantity);
                 	System.out.println("CNestMktData.lLastTradeTime-------------------->"+CNestMktData.lLastTradeTime);
                 	System.out.println("CNestMktData.lAverageTradePrice---------------->"+CNestMktData.lAverageTradePrice);
                 	
                 	System.out.println("CNestMktData.lNoofTrades----------------------->"+CNestMktData.lNoofTrades);
                 	//System.out.println("++++++++++++++++++=");
                 	
                 	System.out.println("CNestMktData.siAuctionNumber-------------------->"+CNestMktData.siAuctionNumber);
                    //System.out.println("CNestMktData.sRecordBuffer--------------------->"+CNestMktData.sRecordBuffer);
                    System.out.println("CNestMktData.dTotalBuyQuantity------------------>"+CNestMktData.dTotalBuyQuantity);
                 	System.out.println("CNestMktData.dTotalSellQuantity----------------->"+CNestMktData.dTotalSellQuantity);
                 	System.out.println("CNestMktData.dTotalTradevalue------------------->"+CNestMktData.dTotalTradevalue);
                 	System.out.println("CNestMktData.lClosingPrice---------------------->"+CNestMktData.lClosingPrice);
                 	System.out.println("CNestMktData.lOpenPrice------------------------->"+CNestMktData.lOpenPrice);
                 	System.out.println("CNestMktData.lHighPrice------------------------->"+CNestMktData.lHighPrice);
                 	System.out.println("CNestMktData.lLowPrice-------------------------->"+CNestMktData.lLowPrice);
                 	System.out.println("CNestMktData.lLowerCircuitLimit------------------>"+CNestMktData.lLowerCircuitLimit);
                 	System.out.println("CNestMktData.lUpperCircuitLimit------------------>"+CNestMktData.lUpperCircuitLimit);
                 	System.out.println("CNestMktData.sExchFeedTime----------------------->"+CNestMktData.sExchFeedTime);
                 	System.out.println("CNestMktData.lSecondsSinceBoe-------------------->"+CNestMktData.lSecondsSinceBoe);
                 	System.out.println("CNestMktData.lUsecs------------------------------>"+CNestMktData.lUsecs); */
                 	
                 	
                 	
                 	
                 }
                 catch(Exception ex)
                 {
                 	ex.printStackTrace();
                 }
                 data1.iMsgCode = NESTconstants.NEST_MKTPIC;
                 data1.oStreamObj = CNestMktData;
                 cLintTread.oQueue.add(data1);
                 
                 
                 break;
                 
            case NESTconstants.NEST_INDEX_INFO:
            	CStreamData  data2 = new CStreamData();
            	IndexInfo = new CNESTIndexInfo();
            	IndexInfo = NestIndexInfoConvert(receiveBuffer);
            	/*System.out.println("IndexInfo.iTransCode------->"+IndexInfo.iTransCode);
            	System.out.println("IndexInfo.iValue----------->"+IndexInfo.iValue);
            	System.out.println("IndexInfo.iOpenIndex------->"+IndexInfo.iOpenIndex);
            	System.out.println("IndexInfo.iCloseIndex------>"+IndexInfo.iCloseIndex);
            	System.out.println("IndexInfo.SIndexName------->"+IndexInfo.SIndexName);
            	System.out.println("IndexInfo.SExchSeg--------->"+IndexInfo.SExchSeg);
            	System.out.println("IndexInfo.SExchFeedTime---->"+IndexInfo.SExchFeedTime);
            	System.out.println("IndexInfo.lSecondsSinceBoe->"+IndexInfo.lSecondsSinceBoe);
            	System.out.println("IndexInfo.lUsecs----------->"+IndexInfo.lUsecs); */
            	data2.iMsgCode = NESTconstants.NEST_INDEX_INFO;
                data2.oStreamObj = IndexInfo;
                cLintTread.oQueue.add(data2);
            	break;
            	
            case NESTconstants.NEST_NEWS_INFO:
            	CStreamData  data3 = new CStreamData();
            	CNewsInfo = new CNESTNewsInfo();
            	CNewsInfo = NestNewsInfoConvert(receiveBuffer);
            	data3.iMsgCode = NESTconstants.NEST_NEWS_INFO;
                data3.oStreamObj = CNewsInfo;
                cLintTread.oQueue.add(data3);
            	break;
        	
            case NESTconstants.NEST_DJ_NEWS_INFO:
            	CStreamData  data4 = new CStreamData();
            	CdjNews = new CNESTDJNews( );
            	CdjNews = NestDJNewsInfoConvert(receiveBuffer);
            	data4.iMsgCode = NESTconstants.NEST_DJ_NEWS_INFO;
                data4.oStreamObj = CdjNews;
                cLintTread.oQueue.add(data4);
            	break;
            	
                 
                 default :
                	 System.out.println("Default NEST_Feed_constant---Not Matching with any case------------------->"+NEST_FeedType_Constant);
            	
            }

            cLintTread.NotifyClient();
            //System.out.println("");
            pack.setLength( receiveBuffer.length );
        } 
        catch( Exception e ) 
        {
            System.out.println( "Exception in receiving packet: " + e.getMessage() );
            e.printStackTrace();
        }
        
        
    }
    
    

    /**
     * Repeatedly receives simple IP Multicast messages from the specified port
     * and address.
     * 
     * @param args Arguments are ignored.
     */
    public static void main( String[] args ) 
    {
    	
    	Initiate();
    }
    
    public static void Initiate()
    {
    	PutSubscription();
    	HandleConnection receiver = new HandleConnection();
    	 

        while( true )
        {
        	
            receiver.receiveMessage();
            System.out.println("Number of Packets recieved --->"+Packet_count);
        }
    }
    public static CNESTBhavCopy NestBhavCpyConvert(byte[] ScripMaster)
    {

   	    int  iIndex          =   4;
        CNESTBhavCopy cNestBhav = new CNESTBhavCopy();
        //CNESTMBPInfo   mbpinfo      ;
        
        try
        {
        
    	cNestBhav.iTransCode = NESTconvert.ByteToInt(ScripMaster , 0);
   	 
    	cNestBhav.sExchSeg =  NESTconvert.ByteToString(ScripMaster,iIndex,10);
        
        
    	cNestBhav.sSymbol  =   NESTconvert.ByteToString(ScripMaster,iIndex+10,25);
        
        
    	cNestBhav.lVolumeTradedToday = NESTconvert.ByteToLong(ScripMaster,iIndex+36);
        	
    	cNestBhav.lAverageTradePrice = NESTconvert.ByteToLong(ScripMaster,iIndex+40);
        	
    	cNestBhav.lNoofTrades = NESTconvert.ByteToLong(ScripMaster,iIndex+44);
        	
        cNestBhav.dTotalTradevalue = NESTconvert.ByteToDouble(ScripMaster,iIndex+48);
        
        cNestBhav.lClosingPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+56);
        
        cNestBhav.lOpenPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+60);
        
        cNestBhav.lHighPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+64);
        
        cNestBhav.lLowPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+68);
        
        cNestBhav.lPrevClosingPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+72);
        
        cNestBhav.lYearlyLowPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+76);
        
        cNestBhav.lYearlyHighPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+80);
        
        cNestBhav.lHighestOpenInterest = NESTconvert.ByteToLong(ScripMaster,iIndex+84);
        
        cNestBhav.lLowestOpenInterest = NESTconvert.ByteToLong(ScripMaster,iIndex+88);
        
        cNestBhav.sExchFeedTime = NESTconvert.ByteToString(ScripMaster,iIndex+92,25);
        
        
        cNestBhav.lSecondsSinceBoe =NESTconvert.ByteToLong(ScripMaster,iIndex+120);
        
        
        cNestBhav.lUsecs = NESTconvert.ByteToLong(ScripMaster,iIndex+124);
        
        cNestBhav.lOpenInterest = NESTconvert.ByteToLong(ScripMaster,iIndex+128);
        
        
          }
        catch(Exception ex)
        {
       	 ex.printStackTrace();
        }
        
        return (cNestBhav);
   
    	
    }
    public  static CNESTMktPiccb NestMktPiccbConvert( byte[]  ScripMaster)
    {
    	 int  iIndex          =   4;
         CNESTMktPiccb NestMktPiccb = new CNESTMktPiccb();
         CNESTMBPInfo   mbpinfo      ;
         
         try
         {
         
        NestMktPiccb.iTransCode = NESTconvert.ByteToInt(ScripMaster , 0);
        	 
         NestMktPiccb.sExchSeg =  NESTconvert.ByteToString(ScripMaster,iIndex,10);
         
         
         NestMktPiccb.sSymbol  =   NESTconvert.ByteToString(ScripMaster,iIndex+10,25);
         
         
         NestMktPiccb.siMarketType = NESTconvert.ByteToShort(ScripMaster,iIndex+36);
         
         
         NestMktPiccb.lVolumeTradedToday = NESTconvert.ByteToLong(ScripMaster,iIndex+40);
         
         NestMktPiccb.lLastTradedPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+44);
         
         NestMktPiccb.sNetChangeIndicator = NESTconvert.ByteToString(ScripMaster,iIndex+48,1);
         
         NestMktPiccb.lNetPriceChangeFromClosingPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+52);
         
         NestMktPiccb.lLastTradeQuantity = NESTconvert.ByteToLong(ScripMaster,iIndex+56);
         
         NestMktPiccb.lLastTradeTime = NESTconvert.ByteToLong(ScripMaster,iIndex+60);
         
         NestMktPiccb.lAverageTradePrice = NESTconvert.ByteToLong(ScripMaster,iIndex+64);
         
         NestMktPiccb.lNoofTrades = NESTconvert.ByteToLong(ScripMaster,iIndex+68);
         
         NestMktPiccb.siAuctionNumber = NESTconvert.ByteToShort(ScripMaster,iIndex+72);
         
         
         Vector ombpinfo = new Vector();
         
         
         for(int i=0;i<10;i++)
         {
        	 mbpinfo = new CNESTMBPInfo();
        	  mbpinfo = ProcessOutMBPInfo(ScripMaster , (iIndex+(i*12)+74));
        	/* System.out.println("-------------------MBPInfo--"+i+"------------------");
        	 System.out.println("mbpinfo.lquantity------------>"+mbpinfo.lQuantity); 
        	 System.out.println("mbpinfo.lPrice--------------->"+mbpinfo.lPrice);
        	 System.out.println("mbpinfo.siNumberOfOrders----->"+mbpinfo.siNumberOfOrders);
        	 System.out.println("mbpinfo.siBbBuySellFlag------>"+mbpinfo.siBbBuySellFlag);
        	 System.out.println("-----------------------------------------------");*/
        	  
        	 ombpinfo.add(mbpinfo);		
        	  
        	 
         }
         
        
      
         NestMktPiccb.sRecordBuffer =(Object) ombpinfo;
         NestMktPiccb.dTotalBuyQuantity = NESTconvert.ByteToDouble(ScripMaster,iIndex+196);
         NestMktPiccb.dTotalSellQuantity = NESTconvert.ByteToDouble(ScripMaster,iIndex+204);
         NestMktPiccb.dTotalTradevalue = NESTconvert.ByteToDouble(ScripMaster,iIndex+212);
         NestMktPiccb.lClosingPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+220);
         NestMktPiccb.lOpenPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+224);
         NestMktPiccb.lHighPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+228);
         NestMktPiccb.lLowPrice = NESTconvert.ByteToLong(ScripMaster,iIndex+232);
         
         NestMktPiccb.lYearlyLowPrice    = NESTconvert.ByteToLong(ScripMaster,iIndex+236);                     
         NestMktPiccb.lYearlyHighPrice	= NESTconvert.ByteToLong(ScripMaster,iIndex+240);
         
         
         NestMktPiccb.lLowerCircuitLimit = NESTconvert.ByteToLong(ScripMaster,iIndex+244);
         NestMktPiccb.lUpperCircuitLimit = NESTconvert.ByteToLong(ScripMaster,iIndex+248);
         NestMktPiccb.sExchFeedTime = NESTconvert.ByteToString(ScripMaster,iIndex+252,25);
         NestMktPiccb.lSecondsSinceBoe = NESTconvert.ByteToLong(ScripMaster,iIndex+280);
         NestMktPiccb.lUsecs = NESTconvert.ByteToLong(ScripMaster,iIndex+284);
         NestMktPiccb.lOpenIntereset = NESTconvert.ByteToLong(ScripMaster,iIndex+288);
         }
         catch(Exception ex)
         {
        	 ex.printStackTrace();
         }
         
         return (NestMktPiccb);
    }
    
    public static CNESTMBPInfo  ProcessOutMBPInfo(byte[] MBPbytes , int index)
    {
    	CNESTMBPInfo MBPinformation = new CNESTMBPInfo();
    	try
    	{
    	MBPinformation.lQuantity = NESTconvert.ByteToLong(MBPbytes , index);
    	MBPinformation.lPrice = NESTconvert.ByteToLong(MBPbytes , index+4);
    	MBPinformation.siNumberOfOrders =NESTconvert. ByteToShort(MBPbytes , index+8);
    	MBPinformation.siBbBuySellFlag = NESTconvert.ByteToShort(MBPbytes , index+10);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
		return MBPinformation;
    	
    	
    }
    
    
    public  static CNESTDJNews NestDJNewsInfoConvert(byte[] NewsBytes)
    {

    	char somechar = 2;
    	CNESTDJNews DJ_News_Info = new CNESTDJNews(); 
    	try
    	{
    		DJ_News_Info.iTransCode           = NESTconvert.ByteToInt(NewsBytes, 0);
    		
    		String sTranscode  = NESTconvert.ByteToString(NewsBytes, 0, 4);
    		
    		//System.out.println("------------------------------------------------------------------------------");
    		System.out.println("DJ_News_Info.iTransCode----->"+DJ_News_Info.iTransCode);
    		
    		DJ_News_Info.sNewsMessagetype              = NESTconvert.ByteToString(NewsBytes, 4, 1);
    		//System.out.println("DJ_News_Info.sNewsMessagetype--------->"+DJ_News_Info.sNewsMessagetype);
    		
    		DJ_News_Info.sSource              = NESTconvert.ByteToString(NewsBytes, 5, 25);
    		//System.out.println("DJ_News_Info.sSource--------->"+DJ_News_Info.sSource);
    		
    		
    		DJ_News_Info.sNewshotindicator    = NESTconvert.ByteToString(NewsBytes, 30 , 1);
    		//System.out.println("DJ_News_Info.sNewshotindicator--------->"+DJ_News_Info.sNewshotindicator);
    		DJ_News_Info.iAccessionnumber     = NESTconvert.ByteToLongLong(NewsBytes, 32);
    		
    		
    		
    		
    		//System.out.println("DJ_News_Info.iAccessionnumber--------->"+DJ_News_Info.iAccessionnumber);
    		DJ_News_Info.iGmtdate 		      = NESTconvert.ByteToInt(NewsBytes, 40);
    		//System.out.println("DJ_News_Info.iGmtdate --------->"+DJ_News_Info.iGmtdate );
    		DJ_News_Info.iGMTtime             = NESTconvert.ByteToInt(NewsBytes, 44);
    		//System.out.println("DJ_News_Info.iGMTtime--------->"+DJ_News_Info.iGMTtime);
    		DJ_News_Info.iExpirymessagecount  = NESTconvert.ByteToInt(NewsBytes, 48);
    		//System.out.println("DJ_News_Info.iExpirymessagecount--------->"+DJ_News_Info.iExpirymessagecount);
    		DJ_News_Info.sExpirymessagelist   = NESTconvert.ByteToString(NewsBytes,52 ,20);
    		//System.out.println("DJ_News_Info.sExpirymessagelist--------->"+DJ_News_Info.sExpirymessagelist);
    		DJ_News_Info.sActioncode          = NESTconvert.ByteToString(NewsBytes,72 ,2);
    		//System.out.println("DJ_News_Info.sActioncode --------->"+DJ_News_Info.sActioncode );
    		DJ_News_Info.iRefSeqNumber        = NESTconvert.ByteToInt(NewsBytes,76 );
    		//System.out.println("DJ_News_Info.iRefSeqNumber--------->"+DJ_News_Info.iRefSeqNumber);
    		//DJ_News_Info.sNewstag             = NESTconvert.ByteToString(NewsBytes,80,5);
    		//System.out.println("DJ_News_Info.sNewstag  --------->"+DJ_News_Info.sNewstag  );.
    		DJ_News_Info.iNewsSeqNumber       = NESTconvert.ByteToInt(NewsBytes,80 );
    		
    		DJ_News_Info.iNewsTagLength      = NESTconvert.ByteToInt(NewsBytes,84 );
    		
    		
    		//System.out.println("DJ_News_Info.iNewsSeqNumber --------->"+DJ_News_Info.iNewsSeqNumber );
    		DJ_News_Info.inewslength          = NESTconvert.ByteToInt(NewsBytes,88 );
    		// System.out.println("DJ_News_Info.inewslength--------->"+DJ_News_Info.inewslength);
    		String sNews_tag = NESTconvert.ByteToString(NewsBytes,92 , DJ_News_Info.iNewsTagLength );
    		//DJ_News_Info.sNewsTag             =
    		
    		//SharedResources.WriteToLog("---------sNews_tag--------"+sNews_tag);
    		
    		
    		String[] tag_temp = sNews_tag.split(String.valueOf(somechar));
    		for(int icount =0; icount < tag_temp.length ; icount++)
    			DJ_News_Info.oNewsTag.add(tag_temp[icount]);
    		
    		try
    		{
    			//System.out.println(DJ_News_Info.inewslength+"- - - - -DJ_News_Info.iNewsTagLength- - - - - - - "+DJ_News_Info.iNewsTagLength);
    			
    		    String News_Headlines   = NESTconvert.ByteToString(NewsBytes,92+DJ_News_Info.iNewsTagLength ,DJ_News_Info.inewslength);
    		
    		    SharedResources.WriteToLog("---------News_Headlines--------"+News_Headlines);
    		
    		
    		String[] temp = News_Headlines.split(String.valueOf(somechar));
    		
    		try
    		{
    		if(temp.length > 0)	
    		DJ_News_Info.sNewsHeadLines = temp[0];
    		if(temp.length > 1)
    		DJ_News_Info.sNewsStory = temp[1];
    		}
    		catch(Exception ex)
    		{
    			ex.printStackTrace();
    		}
    		}
    		catch (StringIndexOutOfBoundsException e)
    		{
    			//e.printStackTrace();
    			SharedResources.WriteToLog("---------------INDEX Error START------------");
    			//System.out.println((92+DJ_News_Info.iNewsTagLength)+"---------------INDEX Error START------------"+(BUFFER_SIZE-1));
    			String News_Headlines1   = NESTconvert.ByteToString(NewsBytes,92+DJ_News_Info.iNewsTagLength ,(BUFFER_SIZE-(92+DJ_News_Info.iNewsTagLength)));
    			SharedResources.WriteToLog("News_HeadLines"+News_Headlines1);
    			//System.out.println("--------------INDEX Error END------------");
    			SharedResources.WriteToLog("--------------INDEX Error END------------");
				// TODO: handle exception
			}
    		
    		//SharedResources.WriteToLog("---------J_News_Info.sNewsHeadLines--------"+DJ_News_Info.sNewsHeadLines);
    		
    		//SharedResources.WriteToLog("---------J_News_Info.sNewsStory--------"+DJ_News_Info.sNewsStory);
    		
    		//System.out.println("DJ_News_Info.sHeadLines--------->"+DJ_News_Info.sNewsHeadLines);
    		//System.out.println("DJ_News_Info.sNewsStory--------->"+DJ_News_Info.sNewsStory);
    		//System.out.println("------------------------------------------------------------------------------\n");
    		/*System.out.println("DJ_News_Info.iTransCode----->"+DJ_News_Info.iTransCode);
    		System.out.println("DJ_News_Info.sSource--------->"+DJ_News_Info.sSource);
    		System.out.println("DJ_News_Info.sNewshotindicator--------->"+DJ_News_Info.sNewshotindicator);
    		System.out.println("DJ_News_Info.iAccessionnumber--------->"+DJ_News_Info.iAccessionnumber);
    		System.out.println("DJ_News_Info.iGmtdate --------->"+DJ_News_Info.iGmtdate );
    		System.out.println("DJ_News_Info.iGMTtime--------->"+DJ_News_Info.iGMTtime);
    		System.out.println("DJ_News_Info.iExpirymessagecount--------->"+DJ_News_Info.iExpirymessagecount);
    		System.out.println("DJ_News_Info.sExpirymessagelist--------->"+DJ_News_Info.sExpirymessagelist);
    		System.out.println("DJ_News_Info.sActioncode --------->"+DJ_News_Info.sActioncode );
    		System.out.println("DJ_News_Info.iRefSeqNumber--------->"+DJ_News_Info.iRefSeqNumber);
    		System.out.println("DJ_News_Info.sNewstag  --------->"+DJ_News_Info.sNewstag  );
    		System.out.println("DJ_News_Info.iNewsSeqNumber --------->"+DJ_News_Info.iNewsSeqNumber );
    		System.out.println("DJ_News_Info.inewslength--------->"+DJ_News_Info.inewslength);
    		System.out.println("DJ_News_Info.sNewsheadlineStory--------->"+DJ_News_Info.sNewsheadlineStory); */
    		
    		
    		
    		
    	}
    	catch(Exception ex)
    	{
    		
    		ex.printStackTrace();
    	}
    	return DJ_News_Info;
    
    	
    }
    
    public  static CNESTNewsInfo NestNewsInfoConvert(byte[] NewsBytes)
    {

    	CNESTNewsInfo News_Info = new CNESTNewsInfo(); 
    	try
    	{
    		News_Info.iTransCode = NESTconvert.ByteToInt(NewsBytes, 0);
    		News_Info.sNewsMsg  = NESTconvert.ByteToString(NewsBytes, 4, 256);
    		News_Info.sExchSeg = NESTconvert.ByteToString(NewsBytes, 260 , 10);
    		News_Info.lSecondsSinceBoe = NESTconvert.ByteToLong(NewsBytes, 272);
    		News_Info.lUsecs = NESTconvert.ByteToLong(NewsBytes, 276);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return News_Info;
    
    	
    }
    
    public static CNESTIndexInfo NestIndexInfoConvert(byte[] IndexBytes)
    {
    	CNESTIndexInfo Ind_Info = new CNESTIndexInfo(); 
    	try
    	{
    	Ind_Info.iTransCode = NESTconvert.ByteToInt(IndexBytes, 0);
    	Ind_Info.iValue  = NESTconvert.ByteToInt(IndexBytes, 4);
    	Ind_Info.iOpenIndex = NESTconvert.ByteToInt(IndexBytes, 8);
    	Ind_Info.iCloseIndex = NESTconvert.ByteToInt(IndexBytes, 12);
    	Ind_Info.SIndexName = NESTconvert.ByteToString(IndexBytes, 16, 100);
    	Ind_Info.SExchSeg = NESTconvert.ByteToString(IndexBytes, 116, 10);
    	Ind_Info.SExchFeedTime = NESTconvert.ByteToString(IndexBytes,126, 25);
    	Ind_Info.lSecondsSinceBoe = NESTconvert.ByteToLong(IndexBytes, 152);
    	Ind_Info.lUsecs    = NESTconvert.ByteToLong(IndexBytes,156);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return Ind_Info;
    }

	public static void WriteMktPicToFile(Object MktObj) 
	{
		CNESTMktPiccb MktPicToFile = (CNESTMktPiccb)MktObj;

 		
		StringBuffer sb = new StringBuffer();
        try
        {
        	sb.append(MktPicToFile.iTransCode);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sExchSeg);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sSymbol);
   		 sb.append("|");
   		 sb.append(MktPicToFile.siMarketType);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lVolumeTradedToday);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradedPrice);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sNetChangeIndicator);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lNetPriceChangeFromClosingPrice);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradeQuantity);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradeTime);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lAverageTradePrice);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lNoofTrades);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.siAuctionNumber);
                 sb.append("|");
   		
   		 sb.append(MktPicToFile.dTotalBuyQuantity);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.dTotalSellQuantity);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.dTotalTradevalue);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lClosingPrice);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lOpenPrice);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lHighPrice);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lLowPrice);
   		 sb.append("|");
   		 
   		sb.append(MktPicToFile.lYearlyHighPrice);
  		 sb.append("|");
  		 
  		sb.append(MktPicToFile.lYearlyLowPrice);
  		 sb.append("|");
   		 
   		 
   		 
   		 sb.append(MktPicToFile.lLowerCircuitLimit);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lUpperCircuitLimit);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.sExchFeedTime);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lSecondsSinceBoe);
   		 sb.append("|");
   		 
   		 sb.append(MktPicToFile.lUsecs);
   		 sb.append("|");

         sb.append(MktPicToFile.lOpenIntereset);
   		 sb.append("|");
   		 
   	
   		Vector oMbpInfo = (Vector)MktPicToFile.sRecordBuffer;
       	 
       	 CNESTMBPInfo  mbpinfoToFile = new CNESTMBPInfo();
       	mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(0);
   		 sb.append(mbpinfoToFile.lQuantity);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.lPrice);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.siNumberOfOrders);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.siBbBuySellFlag);
   		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(1); 
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(2);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
  		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(3);
   		 
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(4);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(5);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(6);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(7);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
  		 
  		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(8);
   		 
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
   		 
   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(9); 
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");
  		 
	 		 //StringBuffer sb = new StringBuffer();
			
			 
			 MktPicFile.write(sb.toString());
			 MktPicFile.flush();
			 MktPicFile.newLine();
			 MktPicFile.flush();
			
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		System.out.println("Excepiton->"+ex.toString());
	}
	

		
		
	}
	
	public static void WriteBhavCopyToFile(Object BhavObj)
	{
		CNESTBhavCopy cBhavcp = (CNESTBhavCopy)BhavObj;
		StringBuffer sbn = new StringBuffer();
		try
		{
			sbn.append(cBhavcp.iTransCode);
			sbn.append("|");
			sbn.append(cBhavcp.sExchSeg);
			sbn.append("|");
			sbn.append(cBhavcp.sSymbol);
			sbn.append("|");
			sbn.append(cBhavcp.lVolumeTradedToday);
			sbn.append("|");
			sbn.append(cBhavcp.lAverageTradePrice);
			sbn.append("|");
			sbn.append(cBhavcp.lNoofTrades);
			sbn.append("|");
			sbn.append(cBhavcp.dTotalTradevalue);
			sbn.append("|");
			sbn.append(cBhavcp.lClosingPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lOpenPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lHighPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lLowPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lPrevClosingPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lYearlyLowPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lYearlyHighPrice);
			sbn.append("|");
			sbn.append(cBhavcp.lHighestOpenInterest);
			sbn.append("|");
			sbn.append(cBhavcp.lLowestOpenInterest);
			sbn.append("|");
			sbn.append(cBhavcp.sExchFeedTime);
			sbn.append("|");
			sbn.append(cBhavcp.lSecondsSinceBoe);
			sbn.append("|");
			sbn.append(cBhavcp.lUsecs);
			sbn.append("|");
			sbn.append(cBhavcp.lOpenInterest);
			sbn.append("|");
			
			 BhavCpFile.write(sbn.toString());
			 BhavCpFile.flush();
			 BhavCpFile.newLine();
			 BhavCpFile.flush();
		}
		catch(Exception ex)
		{
			
		}
		sbn = null ;
		cBhavcp = null ;
		
	}
	
	public static void WriteDJNewsToFile(Object  NewsObj)
	{
		CNESTDJNews NewsInfoToFile = (CNESTDJNews)NewsObj;
		StringBuffer sbn = new StringBuffer();
		
		try
		{
			 sbn.append(NewsInfoToFile.iTransCode);
	   		 sbn.append("|");
	   		 sbn.append(NewsInfoToFile.sSource);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sNewshotindicator);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iAccessionnumber);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iGmtdate);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iGMTtime);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iExpirymessagecount);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sExpirymessagelist);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sActioncode);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iRefSeqNumber);
			 sbn.append("|");
			 //sbn.append(NewsInfoToFile.sNewstag);
			 //sbn.append("|");
			 sbn.append(NewsInfoToFile.iNewsSeqNumber);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.iNewsTagLength);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.inewslength);
			 sbn.append("|");
			 for(int icnt =0 ; icnt < NewsInfoToFile.oNewsTag.size(); icnt++ )
			 {
			 sbn.append(" NewsTag["+icnt+"].");	 
		     sbn.append(NewsInfoToFile.oNewsTag.get(icnt));
			 }
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sNewsHeadLines);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sNewsStory);
			 sbn.append("|");
			 
			 DJNewsFile.write(sbn.toString());
			 DJNewsFile.flush();
			 DJNewsFile.newLine();
			 DJNewsFile.flush();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		sbn = null ;
		NewsInfoToFile = null ;
		
	}

	public static void WriteNewsToFile(Object  NewsObj)
	{
		CNESTNewsInfo NewsInfoToFile = (CNESTNewsInfo)NewsObj;
		StringBuffer sbn = new StringBuffer();
		
		try
		{
			 sbn.append(NewsInfoToFile.iTransCode);
	   		 sbn.append("|");
	   		 sbn.append(NewsInfoToFile.sNewsMsg);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.sExchSeg);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.lSecondsSinceBoe);
			 sbn.append("|");
			 sbn.append(NewsInfoToFile.lUsecs);
			 sbn.append("|");
			 
			 NewsInfoFile.write(sbn.toString());
			 NewsInfoFile.flush();
			 NewsInfoFile.newLine();
			 NewsInfoFile.flush();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		sbn = null ;
		NewsInfoToFile = null ;
		
	}
	
	public static void WriteIndexInfoToFile(Object IndexObj) 
	{
		CNESTIndexInfo IndexInfoToFile = (CNESTIndexInfo)IndexObj;
		StringBuffer sbi = new StringBuffer();
		try
		{
			 sbi.append(IndexInfoToFile.iTransCode);
	   		 sbi.append("|");
	   		 sbi.append(IndexInfoToFile.iValue);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.iOpenIndex);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.iCloseIndex);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.SIndexName);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.SExchSeg);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.SExchFeedTime);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.lSecondsSinceBoe);
			 sbi.append("|");
			 sbi.append(IndexInfoToFile.lUsecs);
			 sbi.append("|");
			 
			 IndexInfoFile.write(sbi.toString());
			 IndexInfoFile.flush();
			 IndexInfoFile.newLine();
			 IndexInfoFile.flush();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static boolean ReadFileNSE(ResourceBundle oResourceBundle, String s_FilePath)
	{
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"NSE_EQ_INPUT.txt"));
	     
			
	        	 String str;
	        	 String s_nse_file_data ="";   		
	        	 	while ((str = in.readLine()) != null  ) {
	        	 		
	        	 		if(str.length()!=0) 
	    				{
	        	 			if(s_nse_file_data.length() == 0)
	        	 			{
	        	 				s_nse_file_data = str;
	        	 			}
	        	 			else
	        	 			{
	        	 				s_nse_file_data = s_nse_file_data.concat(str);
	        	 			}
	        	 		}
	    			}
	    		    in.close();
	    		   
	    		    if(s_nse_file_data.length()!= 0 )
	    		    {
	    		    	if(s_nse_file_data != null)
	    		    	{
				    		    	StringTokenizer s_Token = new  StringTokenizer(s_nse_file_data,",");
				    		          while(s_Token.hasMoreTokens())
				    		          {
				    		          	 //System.out.println("s_Token " +s_Token.nextToken());
				    		          	vec_nse_cm.add(s_Token.nextToken());
				    		          }
	    		    	}
		    		}
	    		    
	    		    if(vec_nse_cm.size() != 0)
	    		    {
	    		    	return true; 
	    		    }
	    		    else
	    		    {
	    		    	return false; 
	    		    }
		   } catch (Exception e) {
		   			System.out.println("Error :: ==> Error file (NSE_EQ_INPUT.txt) not found :: ==>" +e);
		   			return false;
		   	}	    
	} //end of 	reading NSE_EQ_INPUT.txt and adding it to vector vec_nse_cm
	
	
	//Reading NSE_FO_INPUT.txt and adding it to vector vec_nse_fo
	public static boolean ReadFileNFO(ResourceBundle oResourceBundle, String s_FilePath)
	{
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"NSE_FO_INPUT.txt"));
	     
	        	 String str;
	        	 String s_nfo_file_data ="";   		
	        	 while ((str = in.readLine()) != null  ) {
        	 		
        	 		if(str.length()!=0) 
    				{
        	 			if(s_nfo_file_data.length() == 0)
        	 			{
        	 				s_nfo_file_data = str;
        	 			}
        	 			else
        	 			{
        	 				s_nfo_file_data = s_nfo_file_data.concat(str);
        	 			}
        	 		}
    			}
    		    in.close();
    		   
    		    if(s_nfo_file_data.length()!= 0 )
    		    {
    		    	if(s_nfo_file_data != null)
    		    	{
			    		    	StringTokenizer s_Token = new  StringTokenizer(s_nfo_file_data,",");
			    		    
			    		    	 while(s_Token.hasMoreTokens())
			    		          {
			    		          	vec_nse_fo.add(s_Token.nextToken());
			    		          }
    		    	}
	    		}
    		    
    		    if(vec_nse_fo.size() != 0)
    		    {
    		    	return true; 
    		    }
    		    else
    		    {
    		    	return false; 
    		    }
	 		   } catch (Exception e) {
		   			System.out.println(" Error :: ==> Error file (NSE_FO_INPUT.txt) not found :: ==>" +e);
		   			return false;
		   	}	    
	} //end of 	reading NSE_FO_INPUT.txt and adding it to vector vec_nse_cm
	
	
	//	Reading BSE_EQ_INPUT.txt and adding it to vector vec_bse_cm
	public static boolean ReadFileBSE(ResourceBundle oResourceBundle, String s_FilePath	)
	{
		
		try {
	     
			BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"BSE_EQ_INPUT.txt"));
	     
			 String str;
	    	 String s_bse_file_data ="";   		
        	 while ((str = in.readLine()) != null  ) {
    	 		
    	 		if(str.length()!=0) 
				{
    	 			if(s_bse_file_data.length() == 0)
    	 			{
    	 				s_bse_file_data = str;
    	 			}
    	 			else
    	 			{
    	 				s_bse_file_data = s_bse_file_data.concat(str);
    	 			}
    	 		}
			}
		    in.close();
		   
		    if(s_bse_file_data.length()!= 0 )
		    {
		    	if(s_bse_file_data != null)
		    	{
		    		    	StringTokenizer s_Token = new  StringTokenizer(s_bse_file_data,",");
		    		    
		    		    	 while(s_Token.hasMoreTokens())
		    		          {
		    		          	vec_bse_cm.add(s_Token.nextToken());
		    		          }
		    	}
    		}
		    
		    if(vec_bse_cm.size() != 0)
		    {
		    	return true; 
		    }
		    else
		    {
		    	return false; 
		    }
	    		    
		   } catch (Exception e) {
		   			System.out.println(" Error :: ==> Error file (NSE_FO_INPUT.txt) not found :: ==>" +e);
		   			return false;
		   	}	    
	}
	// end of handleResponses
	
	public static boolean ReadFileMCX(ResourceBundle oResourceBundle, String s_FilePath)
	{
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"MCX_INPUT.txt"));
	     
	        	 String str;
	        	 String s_mcx_file_data ="";   		
	        	 while ((str = in.readLine()) != null  ) {
        	 		
        	 		if(str.length()!=0) 
    				{
        	 			if(s_mcx_file_data.length() == 0)
        	 			{
        	 				s_mcx_file_data = str;
        	 			}
        	 			else
        	 			{
        	 				s_mcx_file_data = s_mcx_file_data.concat(str);
        	 			}
        	 		}
    			}
    		    in.close();
    		   
    		    if(s_mcx_file_data.length()!= 0 )
    		    {
    		    	if(s_mcx_file_data != null)
    		    	{
			    		    	StringTokenizer s_Token = new  StringTokenizer(s_mcx_file_data,",");
			    		    
			    		    	 while(s_Token.hasMoreTokens())
			    		          {
			    		          	vec_mcx.add(s_Token.nextToken());
			    		          }
    		    	}
	    		}
    		    
    		    if(vec_mcx.size() != 0)
    		    {
    		    	return true; 
    		    }
    		    else
    		    {
    		    	return false; 
    		    }
	 		   } catch (Exception e) 
	 		   {
		   			System.out.println(" Error :: ==> Error file (MCX_INPUT.txt) not found :: ==>" +e);
		   			return false;
	 		   }	    
	} //end of 	reading NSE_FO_INPUT.txt and adding it to vector vec_mcx
	
	public static boolean ReadFileNCDEX(ResourceBundle oResourceBundle, String s_FilePath)
	{
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"NCDEX_INPUT.txt"));
	     
	        	 String str;
	        	 String s_ncdex_file_data ="";   		
	        	 while ((str = in.readLine()) != null  ) {
        	 		
        	 		if(str.length()!=0) 
    				{
        	 			if(s_ncdex_file_data.length() == 0)
        	 			{
        	 				s_ncdex_file_data = str;
        	 			}
        	 			else
        	 			{
        	 				s_ncdex_file_data = s_ncdex_file_data.concat(str);
        	 			}
        	 		}
    			}
    		    in.close();
    		   
    		    if(s_ncdex_file_data.length()!= 0 )
    		    {
    		    	if(s_ncdex_file_data != null)
    		    	{
			    		    	StringTokenizer s_Token = new  StringTokenizer(s_ncdex_file_data,",");
			    		    
			    		    	 while(s_Token.hasMoreTokens())
			    		          {
			    		          	vec_ncdex.add(s_Token.nextToken());
			    		          }
    		    	}
	    		}
    		    
    		    if(vec_ncdex.size() != 0)
    		    {
    		    	return true; 
    		    }
    		    else
    		    {
    		    	return false; 
    		    }
	 		   } catch (Exception e) 
	 		   {
		   			System.out.println(" Error :: ==> Error file (NCDEX_INPUT.txt) not found :: ==>" +e);
		   			return false;
	 		   }	    
	} //end of 	reading NSE_FO_INPUT.txt and adding it to vector vec_nse_cm
	
	public static boolean ReadFileCDS(ResourceBundle oResourceBundle, String s_FilePath)
	{
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(s_FilePath.trim()+"CDS_INPUT.txt"));
	     
	        	 String str;
	        	 String s_cds_file_data ="";   		
	        	 while ((str = in.readLine()) != null  ) 
	        	 {
        	 		if(str.length()!=0) 
    				{
        	 			if(s_cds_file_data.length() == 0)
        	 			{
        	 				s_cds_file_data = str;
        	 			}
        	 			else
        	 			{
        	 				s_cds_file_data = s_cds_file_data.concat(str);
        	 			}
        	 		}
    			}
    		    in.close();
    		   
    		    if(s_cds_file_data.length()!= 0 )
    		    {
    		    	if(s_cds_file_data != null)
    		    	{
			    		    	StringTokenizer s_Token = new  StringTokenizer(s_cds_file_data,",");
			    		    
			    		    	 while(s_Token.hasMoreTokens())
			    		          {
			    		          	vec_cds.add(s_Token.nextToken());
			    		          }
    		    	}
	    		}
    		    
    		    if(vec_cds.size() != 0)
    		    {
    		    	return true; 
    		    }
    		    else
    		    {
    		    	return false; 
    		    }
	 		   } catch (Exception e) 
	 		   {
		   			System.out.println(" Error :: ==> Error file (CDS_INPUT.txt) not found :: ==>" +e);
		   			return false;
	 		   }	    
	} //end of 	reading NSE_FO_INPUT.txt and adding it to vector vec_nse_cm
	
	
	public static void SubscribeforDJNews(ResourceBundle oRes)
	{
		
		try
		{  
		  CServerRequest oReqNameDj = new CServerRequest();
		  oReqNameDj.sExchange 		= "bse_cm";
		  
		  oReqNameDj.oAccountId 		= s_UserName;
		  oReqNameDj.iDDInteractive 	= 1;
		  
		  
		  oReqNameDj.sPortfolio = (String)oRes.getString("NEST_SCRIP_CODE").trim(); 
		  oReqNameDj.sNewsTag   = (String)oRes.getString("NEST_DJ_NEWS_TAG").trim();
		  
		  
		  	
		  
		  if(oReqNameDj.sPortfolio.trim().equals("")&& oReqNameDj.sNewsTag.trim().equals(""))
		  {
			  oReqNameDj.iReqType =  482;
		  }
		  else if(!oReqNameDj.sPortfolio.trim().equals("")&& oReqNameDj.sNewsTag.trim().equals(""))
		  {
			  oReqNameDj.iReqType = 483;
		  }
		  else if(oReqNameDj.sPortfolio.trim().equals("")&& !oReqNameDj.sNewsTag.trim().equals(""))
		  {
			  oReqNameDj.iReqType = 484;
		  }
		  else
		  {
			  oReqNameDj.iReqType = 485;  
		  }
		  
		  System.out.println("oReqNameDj.sPortfolio - - - - -"+oReqNameDj.sPortfolio);
		  System.out.println("oReqNameDj.sNewsTag   - - - - -"+oReqNameDj.sNewsTag);
		  System.out.println("oReqNameDj.iReqType   - - - - -"+oReqNameDj.iReqType);
		 
		  
		  
	        try 
	        {
	        	out_stream.writeObject(oReqNameDj);
	        	out_stream.flush();
	        }
	        catch (IOException e) 
	        {   
	            e.printStackTrace();
	        }
	        
		}
		catch(Exception e)
		{
			System.out.println("Error :: Exception in sentRequestToServerSubscribe ===>" +e);
		}
	        
	}

	//function to send  subscribe tokens to Streamer
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	public static void UnSubScribe(String exc, String sToken)
	{
		int iReq
		try
		{
			 CServerRequest oReqNamense = new CServerRequest();
			  oReqNamense.sExchange 		= s_Exchange;
			  oReqNamense.iReqType			= i_RequestId;
			  oReqNamense.oAccountId 		= s_UserName;
			  oReqNamense.iDDInteractive 	= 1;
			
			  //System.out.println("s_Exchange" +s_Exchange);
			  for(int i=0; i<v_token_vect.size(); i++)
			  {
			  	//System.out.println(v_token_vect.get(i));
			  	oReqNamense.v_symbol.add(v_token_vect.get(i));
			  }
			  
			  
		        try {
		        	out_stream.writeObject(oReqNamense);
		        	out_stream.flush();
		        } catch (IOException e) {
		            
		            e.printStackTrace();
		        }
			
		}
		catch(Exception exx)
		{
			System.out.println("Error :: Exception in sentRequestToServerSubscribe ===>" +exx);
		}
	} 
	
	 *
	 *
	 */
	public static void UnSubscribeSingle(String sTok, String Exc)
	{
		CServerRequest oRequest = new CServerRequest();
		
		if(Exc.equals("nse_cm"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_NSE_MBO_MBP_INFO;
		}
		else if(Exc.equals("bse_cm"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_BSE_MBO_MBP_INFO;
		}
		else if(Exc.equals("nse_fo"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_NSE_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("mcx_fo"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_MCX_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("ncx_fo"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_NCX_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("cde_fo"))
		{
			oRequest.iReqType = NESTconstants.UNSUB_CFO_MBO_MBP_INFO;
		}
		oRequest.iDDInteractive = 1;
		
		oRequest.sPortfolio = sTok;
		
		oRequest.oAccountId = s_UserName;
		
		 try 
		   {
	        	out_stream.writeObject(oRequest);
	        	out_stream.flush();
	        } 
		 catch (IOException e)
	        {
	            
	            e.printStackTrace();
	        }
	}
	public static void subscribeSingle(String sTok, String Exc)
	{
		CServerRequest oRequest = new CServerRequest();
		
		if(Exc.equals("nse_cm"))
		{
			oRequest.iReqType = NESTconstants.NSE_MBO_MBP_INFO;
		}
		else if(Exc.equals("bse_cm"))
		{
			oRequest.iReqType = NESTconstants.BSE_MBO_MBP_INFO;
		}
		else if(Exc.equals("nse_fo"))
		{
			oRequest.iReqType = NESTconstants.NSE_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("mcx_fo"))
		{
			oRequest.iReqType = NESTconstants.MCX_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("ncx_fo"))
		{
			oRequest.iReqType = NESTconstants.NCX_FO_MBO_MBP_INFO;
		}
		else if(Exc.equals("cde_fo"))
		{
			oRequest.iReqType = NESTconstants.CFO_MBO_MBP_INFO;
		}
		oRequest.iDDInteractive = 1;
		
		oRequest.sPortfolio = sTok;
		
		oRequest.oAccountId = s_UserName;
		
		 try 
		   {
	        	out_stream.writeObject(oRequest);
	        	out_stream.flush();
	        } 
		 catch (IOException e)
	        {
	            
	            e.printStackTrace();
	        }
	}
	
	public static void sentRequestToServerSubscribe(int i_RequestId,String s_Exchange,Vector v_token_vect)
	{
		
		try{
			
		  
		  CServerRequest oReqNamense = new CServerRequest();
		  oReqNamense.sExchange 		= s_Exchange;
		  oReqNamense.iReqType			= i_RequestId;
		  oReqNamense.oAccountId 		= s_UserName;
		  oReqNamense.iDDInteractive 	= 1;
		
		  //System.out.println("s_Exchange" +s_Exchange);
		  for(int i=0; i<v_token_vect.size(); i++)
		  {
		  	//System.out.println(v_token_vect.get(i));
		  	oReqNamense.v_symbol.add(v_token_vect.get(i));
		  }
		  
		  
	        try {
	        	out_stream.writeObject(oReqNamense);
	        	out_stream.flush();
	        } catch (IOException e) {
	            
	            e.printStackTrace();
	        }
	        
		}
		catch(Exception e)
		{
			System.out.println("Error :: Exception in sentRequestToServerSubscribe ===>" +e);
		}
	        
	}
	
	public static void sentRequestToServerUnSubscribe(int i_RequestId,String s_Exchange,Vector v_token_vect)
	{
		
		try{
			
		  
		  CServerRequest oReqNamense = new CServerRequest();
		  oReqNamense.sExchange 		= s_Exchange;
		  oReqNamense.iReqType			= i_RequestId;
		  oReqNamense.oAccountId 		= s_UserName;
		  oReqNamense.iDDInteractive 	= 1;
		
		  //System.out.println("s_Exchange" +s_Exchange);
		  for(int i=0; i<v_token_vect.size(); i++)
		  {
		  	//System.out.println("Unsubscribe for ------->>>>"+v_token_vect.get(i));
		  	oReqNamense.v_symbol.add(v_token_vect.get(i));
		  }
		  
		  
	        try {
	        	out_stream.writeObject(oReqNamense);
	        	out_stream.flush();
	        } catch (IOException e) {
	            
	            e.printStackTrace();
	        }
	        
		}
		catch(Exception e)
		{
			System.out.println("Error :: Exception in sentRequestToServerSubscribe ===>" +e);
		}
	        
	}
		

        public static void WriteToFile(Object MktObj)
	{
		CNESTMktPiccb MktPicToFile = (CNESTMktPiccb)MktObj;


		StringBuffer sb = new StringBuffer();
        try
        {
        	sb.append(MktPicToFile.iTransCode);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sExchSeg);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sSymbol);
   		 sb.append("|");
   		 sb.append(MktPicToFile.siMarketType);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lVolumeTradedToday);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradedPrice);
   		 sb.append("|");
   		 sb.append(MktPicToFile.sNetChangeIndicator);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lNetPriceChangeFromClosingPrice);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradeQuantity);
   		 sb.append("|");
   		 sb.append(MktPicToFile.lLastTradeTime);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lAverageTradePrice);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lNoofTrades);
   		 sb.append("|");

   		 sb.append(MktPicToFile.siAuctionNumber);
                 sb.append("|");

   		 sb.append(MktPicToFile.dTotalBuyQuantity);
   		 sb.append("|");

   		 sb.append(MktPicToFile.dTotalSellQuantity);
   		 sb.append("|");

   		 sb.append(MktPicToFile.dTotalTradevalue);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lClosingPrice);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lOpenPrice);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lHighPrice);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lLowPrice);
   		 sb.append("|");
   		 
   		sb.append(MktPicToFile.lYearlyHighPrice);
 		 sb.append("|");
 		 
 		sb.append(MktPicToFile.lYearlyLowPrice);
 		 sb.append("|");

   		 sb.append(MktPicToFile.lLowerCircuitLimit);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lUpperCircuitLimit);
   		 sb.append("|");

   		 sb.append(MktPicToFile.sExchFeedTime);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lSecondsSinceBoe);
   		 sb.append("|");

   		 sb.append(MktPicToFile.lUsecs);
   		 sb.append("|");

                 sb.append(MktPicToFile.lOpenIntereset);
   		 sb.append("|");


   		Vector oMbpInfo = (Vector)MktPicToFile.sRecordBuffer;

                CNESTMBPInfo  mbpinfoToFile = new CNESTMBPInfo();
                mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(0);
   		 sb.append(mbpinfoToFile.lQuantity);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.lPrice);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.siNumberOfOrders);
   		 sb.append("|");
   		 sb.append(mbpinfoToFile.siBbBuySellFlag);
   		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(1);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(2);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(3);

   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(4);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(5);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(6);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(7);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");


   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(8);

   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

   		mbpinfoToFile  = (CNESTMBPInfo)oMbpInfo.get(9);
   		sb.append(mbpinfoToFile.lQuantity);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.lPrice);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siNumberOfOrders);
  		 sb.append("|");
  		 sb.append(mbpinfoToFile.siBbBuySellFlag);
  		 sb.append("|");

	 		 //StringBuffer sb = new StringBuffer();


			 MktPicFile.write(sb.toString());
			 MktPicFile.flush();
			 MktPicFile.newLine();
			 MktPicFile.flush();

	}
	catch(Exception ex)
	{
            ex.printStackTrace();
		System.out.println("Excepiton->"+ex.toString());
	}




	}




}

	
	