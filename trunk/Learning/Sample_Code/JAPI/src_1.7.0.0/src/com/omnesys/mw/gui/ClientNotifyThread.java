package com.omnesys.mw.gui;



import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;



import com.omnesys.mw.classes.CStreamData;
import com.omnesys.mw.constants.NESTconstants;


/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ClientNotifyThread extends Thread implements Observer
{

	public ArrayListImplementation oQueue;
	//CResponse				  objRes;
	
	
	String					sAccountId;

	public ClientNotifyThread()
	{
		oQueue = new ArrayListImplementation();
		this.start();

	}

	public void run()
	{
		
		// oQueue.addObserver(this);
		NotifyClient();

	}

	public void update(Observable oClient, Object obj)

	{

		// NotifyClient();

	}

	public void NotifyClient()
	{

		int					   iQueueSize;
		
			try
			{
				iQueueSize = oQueue.size();
				if (iQueueSize > 0)
				{
					//objRes = (CResponse) oQueue.remove(iQueueSize - 1);
					CStreamData	data = (CStreamData) oQueue.remove(iQueueSize - 1);
					
					//CStreamData data = (CStreamData)objRes;		
					//System.out.println("-----------------code code"+data.iMsgCode);
			switch(data.iMsgCode)
			{
			case NESTconstants.NEST_MKTPIC:
				HandleConnection.WriteMktPicToFile(data.oStreamObj);
				break;
				
			case NESTconstants.NEST_INDEX_INFO:
				HandleConnection.WriteIndexInfoToFile(data.oStreamObj);
				
				break;
			case NESTconstants.NEST_NEWS_INFO:
				HandleConnection.WriteNewsToFile(data.oStreamObj);
				
				break;
				
			case NESTconstants.NEST_DJ_NEWS_INFO:
				HandleConnection.WriteDJNewsToFile(data.oStreamObj);
				
				break;
				
			case NESTconstants.NEST_BHAV_COPY:
				HandleConnection.WriteBhavCopyToFile(data.oStreamObj);
				break;
				
				default:
					System.out.println("UDP No matching Case for Write file");
			
			
			} //end if switch
					

				}

			}
			catch (Exception ex)
			{
				System.out.println("Throwing Exception in ClientNotifyThread");
              ex.printStackTrace();
			}

		

		
	}

	

}
