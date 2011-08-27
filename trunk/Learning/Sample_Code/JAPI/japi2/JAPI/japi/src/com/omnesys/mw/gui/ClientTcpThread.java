package com.omnesys.mw.gui;

import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import com.omnesys.mw.classes.CStreamData;
import com.omnesys.mw.constants.NESTconstants;
import java.io.ObjectInputStream;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ClientTcpThread extends Thread implements Observer
{
	public ArrayListImplementation oQueue;
	//CResponse				  objRes;
	
	ObjectInputStream obj_input1 ;
	String					sAccountId;

	public ClientTcpThread( ObjectInputStream obj_input)
	{
            obj_input1 = obj_input;
		oQueue = new ArrayListImplementation();
		this.start();
	}

	public void run()
	{
	// oQueue.addObserver(this);
            try{
		Object obj = obj_input1.readObject();
		while(obj != null)
                {
			//System.out.println("Adding to que - - - - - - ");
		        obj = obj_input1.readObject();
                 oQueue.add(obj);
                 NotifyClient();
		}
		} catch(Exception e)
                {
                    System.out.println("Exception while reading" +e);
		}
	}

	public void update(Observable oClient, Object obj)

	{
		// NotifyClient();
	}

	public void NotifyClient()
	{
		int  iQueueSize;
			try
			{
				iQueueSize = oQueue.size();
				if (iQueueSize > 0)
				{
					//objRes = (CResponse) oQueue.remove(iQueueSize - 1);
					CStreamData	data = (CStreamData) oQueue.remove(iQueueSize - 1);
					//CStreamData data = (CStreamData)objRes;		
				//	System.out.println("data imsg code ---------->"+data.iMsgCode);
			switch(data.iMsgCode)
			{
			case 201:
				HandleConnection.WriteToFile(data.oStreamObj);
				break;
			case 202:
				HandleConnection.WriteDJNewsToFile(data.oStreamObj);
				break;
		
				default:
                                     // System.out.println("data imsg code ---------->"+data.iMsgCode);
					//System.out.println("No matching Case for Write file");
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
