// This class populates the HLOC (High/Low/Open/Close chart 

package
{
	import mx.collections.ArrayCollection;

	
	public class HLOCChartPublisher extends C8Connection
	{
		private var m_Array:ArrayCollection;
		private var m_Symbol:Object;  // TextInput object
		private var m_OldSymbol:String; // Prev value
		
		public function	HLOCChartPublisher(
			streamURL:String, 
			hlocChartArray:ArrayCollection, 
			symbol:Object) // the symbol input, to control what we show
		{
			super(streamURL);
			
			m_Array = hlocChartArray;
			m_Symbol = symbol;
		}

	
	
		// Overwrites parent's receiveRow().
		// Called when we have a new Row on the connection.
		override public function receiveRow(columns:Array):void {
		
		
			// remember, we are 0-based
			// and the 0-th column is the timestamp
	   		var symbol:String = columns[1]; 

			if(symbol != m_Symbol.text)  // not the symbol we care about
				return;  

			// Check if the Symbol changed:
			if(m_OldSymbol != m_Symbol.text) {
				m_Array.removeAll();
				m_OldSymbol = m_Symbol.text;	
			}

	   		var high:Number = Number(columns[2]);
	   		var low:Number = Number(columns[3]);
	   		var close:Number = Number(columns[4]);
				 
			if(high == 0 || low == 0 || close == 0) // bad values
				return;
				   		   		
			// This is how you create the type of the object
			// expected by ArrayCollectin.
			// You can add any name-value pair to an Object. 
			
	        var o:Object = new Object();
	        o.high = high;
	        o.low = low;
	        o.close = close;
	        
	        m_Array.addItem(o);

			if(m_Array.length > 50)
				m_Array.removeItemAt(0); 
	    
		}
	}
}