	// Publisher Short CCI and Long CCI to the line chart.
// Should be generalized to take in an array of StreamURIs
// and fields to graph

package
{
	import mx.collections.ArrayCollection;
	
	public class LineChartPublisher
	{
		private var m_shortCCIConnection:C8Connection;
		private var m_longCCIConnection:C8Connection;		
		private var m_Array:ArrayCollection;
		
		// Symbol selector
		private var m_Symbol:Object;  // TextInput object
		private var m_OldSymbol:String; // Prev value

		private var m_oldShort:Number;
		private var m_oldLong:Number;
		
		public function	LineChartPublisher(
			ShortCCIURL:String, 
			LongCCIURL:String, 			
			lineChartArray:ArrayCollection, 
			symbol:Object) // the symbol input, to control what we show
		{
			// Note: Even though we pass methods here, they are "bound methods"
			// When they are called, they have the context (the "this" pointer)
			// of the right object set.  The beauty of ActionScript 3.0.
			m_shortCCIConnection = new C8Connection(ShortCCIURL, shortCCICallBack);
			m_longCCIConnection = new C8Connection(LongCCIURL, longCCICallBack);
			
			m_Array = lineChartArray;
			m_Symbol = symbol;
		}

		public function shortCCICallBack(columns:Array):void {

			if(columns[1] != m_Symbol.text)  // not the symbol we care about
				return;  
	        	
        	var o:Object = new Object();
			o.longcci = m_oldLong;
	        o.shortcci = Number(columns[2]);

			m_oldShort = o.shortcci;
			
			ProcessValue(o);				
			
		}

		public function longCCICallBack(columns:Array):void {

			if(columns[1] != m_Symbol.text)  // not the symbol we care about
				return;  
        	
        	var o:Object = new Object();
			o.shortcci = m_oldShort;
	        o.longcci = Number(columns[2]);

			m_oldLong = o.longcci;

			ProcessValue(o);				
		
		}

		private function ProcessValue(o:Object):void {
			

			// Check if the Symbol changed:
			if(m_OldSymbol != m_Symbol.text) {
				m_Array.removeAll();
				m_OldSymbol = m_Symbol.text;	
			}
	        
	        m_Array.addItem(o);

			if(m_Array.length > 50)
				m_Array.removeItemAt(0); 
	    
		}
	}
}
