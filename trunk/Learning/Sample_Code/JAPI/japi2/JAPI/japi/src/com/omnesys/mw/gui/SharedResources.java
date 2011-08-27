package com.omnesys.mw.gui;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class SharedResources
{
	private static FileWriter	fLog	 = null;
	private static BufferedWriter out	  = null;
	private Calendar		    calendar  = null;
	static SharedResources oSharedResources = null;
	
	String				    sMonths[] = { "Jan",
			"Feb",
			"Mar",
			"Apr",
			"May",
			"Jun",
			"Jul",
			"Aug",
			"Sep",
			"Oct",
			"Nov",
			"Dec"				    };

	private SharedResources() throws Exception
	{
		calendar = Calendar.getInstance();
		fLog = new FileWriter("LOG" + calendar.get(Calendar.DATE)
						  + sMonths[calendar.get(Calendar.MONTH)]
						  + calendar.get(Calendar.YEAR)
						  + ".txt", true);
		out = new BufferedWriter(fLog);

	}// cons SharedResources()

	 public static void WriteToLog(String str)
	{
	 	
	 	
	   if (oSharedResources == null)
		
	 	{
	 		try{
				oSharedResources = new SharedResources();
			} 
	 		catch (Exception e1)
	 		{
				
				e1.printStackTrace();
				System.out.println("SharedResources-->exception:"+e1);
			}
	 	}
	 	
		try
		{
			synchronized(out)
			   {
				
				Date date = Calendar.getInstance().getTime();
				DateFormat d_formt = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
				out.write("\n" +d_formt.format(date) + " :: " + str.trim());
				out.newLine();
				out.flush();
			   }
		}
		catch (Exception e)
		{
			System.out.println("Critical :: Failed writing to log");
		}
       
	}// method WriteToLog()

}// SharedResources
