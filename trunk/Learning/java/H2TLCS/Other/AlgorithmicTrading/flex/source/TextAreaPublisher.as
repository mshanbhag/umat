// ActionScript file

package
{
	import mx.collections.ArrayCollection;

	
	public class TextAreaPublisher extends C8Connection
	{
		private var m_textArea:Object;
		
		public function TextAreaPublisher(
			streamURL:String, 
			textArea:Object) // the symbol input, to control what we show
		{
			super(streamURL);

			m_textArea = textArea;
			
	    	m_textArea.htmlText = "";
  					
		}

	
	
		// Overwrites parent's receiveRow().
		// Called when we have a new Row on the connection.
		override public function receiveRow(columns:Array):void {
		
			// remember, we are 0-based
			// and the 0-th column is the timestamp
			var t:String = columns[0];
			var alertType:String = columns[1];
	   		var symbol:String = columns[2]; 
			var newmsg:String;
			
			if(alertType=="Buy") {
				newmsg = "<font color=\"#00FF00\">" + t + " ALERT: Buy " 
				         + symbol + "!</font><br>";
			} else {
				newmsg = "<font color=\"#FF0000\">" + t + " ALERT: Sell " 
				         + symbol + "!</font><br>";
			}
			m_textArea.htmlText = newmsg + m_textArea.htmlText;
				   		   		
		}
	}
}