// This class populates the column chart with price and number of trades
// information for the first 10 stocks.  

// WARNING:
// The term "column" is overloaded here:
// it refers to columns of the ColumnChart (mx.charts.ColumnChart) and
// it refers to the columns (fields) of a C8 row.

package
{
	import mx.collections.ArrayCollection;
	
	public class ColumnChartPublisher extends C8Connection
	{
		private var m_Array:ArrayCollection;
		
		public function	ColumnChartPublisher(streamURL:String, columnChartArray:ArrayCollection) {
			super(streamURL);
			
			m_Array = columnChartArray;
				
		}
	
	
		// Overwrites parent's receiveRow().
		// Called when we have a new Row on the connection.
		override public function receiveRow(columns:Array):void {
			
			// remember, we are 0-based
			// and the 0-th column is the timestamp	   		
			var symbol:String = columns[1];  
	   		var high:Number = Number(columns[2]);
	   		var low:Number = Number(columns[3]);
	   		var close:Number = Number(columns[4]);
			var ntrades:Number = Number(columns[5]);
				   		   		
			if(close == 0)
				return;   // input files have some bad data with 0s.
				   		   		
			// This is how you create the type of the object
			// expected by ArrayCollectin.
			// You can add any name-value pair to an Object. 
			
	        var o:Object = new Object();
	        o.symbol = symbol;
	        o.high = high;
	        o.low = low;
	        o.close = close;
	        o.ntrades = ntrades;
	        
	        var i:int;
	        
	        for(i=0;i<m_Array.length;i++) {
				var s:String = m_Array[i].symbol;
				// Find an update the price	        	
	        	if(s == symbol) {
	        		m_Array.setItemAt(o, i);
	        		return;
	        	}
	        }

	        // Did not find this symbol.  Add it in.

			if(m_Array.length > 10)
				return;  // display only 10 symbols, or it does not look good :)
	        
	        m_Array.addItem(o);
 	
	    
		}
	}
}