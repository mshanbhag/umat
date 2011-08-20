// Class C8Connection.  Encapsulates connecting to a 
// Sybase CEP stream URL, and retrieving incoming rows. 
// There are two ways to use this class:
// 1) erive your connections from this one, overwrite
// the receiveRow() function, and you are done.
// OR
// 2) just use C8Connection as is, and pass a callaback function
//

package
{
    import flash.errors.*;
	import flash.events.*;
	import flash.net.Socket;
	import mx.utils.URLUtil;

    public class C8Connection extends Socket {
	
		// (Optional) callback function.
		// Note that since ActionScript 3.0 introduced
		// the notion of "bound methods", when we call
		// m_callback() the this pointer is automatically
		// set.  Very nice.
		private var m_callback:Function;	
	
	    public function C8Connection(streamURL:String, callback:Function=null) {

			m_callback = callback;

	        // Parse the URI
	    	var host:String = URLUtil.getServerName(streamURL);
	    	var port:uint = URLUtil.getPort(streamURL);
	    	var i:int = streamURL.indexOf("/Stream/");
	    	var object:String = streamURL.substr(i /* to the end */);
	    
	        // Initiate the parent Socket.
	        super(host, port);

			// add event listeners
	        addEventListener(Event.CLOSE, closeHandler);
	        addEventListener(Event.CONNECT, connectHandler);
	        addEventListener(IOErrorEvent.IO_ERROR, ioErrorHandler);
	        addEventListener(SecurityErrorEvent.SECURITY_ERROR, securityErrorHandler);
	        addEventListener(ProgressEvent.SOCKET_DATA, dataReader);

	        //connect("127.0.0.1", 6789);

			// Create a Request
	        
	        var request:String = 
	          "GET " + object + " HTTP/1.0\r\n" +
	          "Host: " + host + "\r\n" +
	          "X-C8-StreamFormat:CSV\r\n" +
	          "X-C8-StreamFormatOptions: TitleRow=false,TimestampColumn=true,TimestampColumnFormat=YYYY/MM/DD HH24:MI:SS\r\n\r\n"; 
	
			writeUTFBytes(request);
 
	    }

		// Overwrite this function.
		public function receiveRow(columns:Array):void {
	
		}
	

		// the buffer holds the data we receive
		public var m_buffer:String;
		public var m_bHeadersDone:Boolean=false;


		// The callback function which is called by the system
		// to receive data on the socket.
		private function dataReader(event:ProgressEvent):void{

	        //mytrace("socketDataHandler: " + event);

			var data:String = readUTFBytes(bytesAvailable);

 	       // append to the buffer.
    	    m_buffer += data;
        

	        while(1) { // iterate through the returned rows
	        
		        // do we have at least one full rows?
	        
	    	    var newline:int = m_buffer.indexOf("\r\n", 0);
	        	if(newline == -1)
	        		return;     // no, we do not.
       		        	
		        // Ok, we have a full row.  Extract it from the buffer
	        
		        var row:String = m_buffer.substr(0, newline);
	    	    m_buffer = m_buffer.substr(newline+2 /* to the end */); 	

				if(row == "") {
					// Headers are done!
					m_bHeadersDone = true;
					return;
				}

				if(!m_bHeadersDone)  // we are still processing headers
					return;

				var columns:Array = row.split(",");
				
				// Notify whoever is interested.
				receiveRow(columns);
				if(m_callback != null)
					m_callback(columns);
			}
		}

	    private function closeHandler(event:Event):void {
	        //mytrace("closeHandler: " + event);
	    }
	
	    private function connectHandler(event:Event):void {
	        //mytrace("connectHandler: " + event);
	    }
	
	    private function ioErrorHandler(event:IOErrorEvent):void {
	        //mytrace("ioErrorHandler: " + event);
	    }
	
	    private function securityErrorHandler(event:SecurityErrorEvent):void {
	        //mytrace("securityErrorHandler: " + event);
	    }
	

	}
   
}