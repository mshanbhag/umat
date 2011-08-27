package com.omnesys.mw.utils;

import java.lang.Object.*;
import java.util.LinkedList;

//import com.omnesys.mw.foclasses.*;
import com.omnesys.mw.classes.*;


public  class   NESTconvert
{    
    public  static  int ByteToInt( byte[] inBytes, int iOffset )
    throws Exception
    {
        if( inBytes.length < ( iOffset + 4 ) )
        {
            throw new Exception( "Invalid size" );
        }
        
        int iOut = 0;
            
     	iOut  = ( inBytes[ iOffset + 3 ] + 256 ) % 256;
     	iOut  <<= 8;
     	iOut  |= ( inBytes[ iOffset + 2 ] + 256 ) % 256;
     	iOut  <<= 8;
     	iOut  |= ( inBytes[ iOffset + 1 ] + 256 ) % 256;
     	iOut  <<= 8;
     	iOut  |= ( inBytes[ iOffset ] + 256 ) % 256;
         	        
        return ( iOut );       
        
    }   //  method  ByteToInt()
    
    public  static  long ByteToLong( byte[] inBytes, int iOffset )
    throws Exception
    {
        if( inBytes.length < ( iOffset + 4 ) )
        {
            throw new Exception( "Invalid size" );
        }
        
        int lOut = 0;
        byte[] tempByte = new byte[4] ;
        tempByte[0]=inBytes[iOffset];
        tempByte[1]=inBytes[iOffset+1];
        tempByte[2]=inBytes[iOffset+2];
        tempByte[3]=inBytes[iOffset+3];
        
        
                 
      /*  lOut    = ( inBytes[ iOffset + 7 ] + 256 ) % 256;
        lOut    <<= 8;
        lOut    |= ( inBytes[ iOffset + 6 ] + 256 ) % 256;
        lOut    <<= 8;
        lOut   |= ( inBytes[ iOffset + 5 ] + 256 ) % 256;
        lOut    <<= 8;      
        lOut   |= ( inBytes[ iOffset + 4 ] + 256 ) % 256;
        lOut    <<= 8; */
        lOut   |= ( inBytes[ iOffset + 3 ] + 256 ) % 256;
        lOut    <<= 8;
        lOut   |= ( inBytes[ iOffset + 2 ] + 256 ) % 256;
        lOut    <<= 8;
        lOut   |= ( inBytes[ iOffset + 1 ] + 256 ) % 256;
        lOut    <<= 8;
        lOut   |= ( inBytes[ iOffset ] + 256 ) % 256;
        
        
        
      
        
        

        
        return((long) lOut );      
        
    }   //  method  ByteToLong()
        
    
  public  static  short   ByteToShort( byte[] inBytes, int iOffset )
    throws Exception
    {
        if ( inBytes.length < ( iOffset + 2 ) )
        {
            throw new Exception( "Invalid size" );
        }
        
        short sOut = 0;
            
     	sOut  = ( short ) ( ( inBytes[ iOffset + 1 ] + 256 ) % 256 );
     	sOut  <<= 8;
     	sOut  |= (short) ( ( inBytes[ iOffset ] + 256 ) % 256 );
         	        
        return ( sOut);
        
    }   //  method  ByteToShort()
    
    public  static  void    IntToByte(  int     iInt,
                                        int     iOffset,
                                        byte[]  bIntBuf )
    throws Exception
    {            
        bIntBuf[ iOffset + 0 ]  = ( byte ) ( iInt & 255 );
        iInt    >>= 8;           
        bIntBuf[ iOffset + 1 ]  = ( byte ) ( iInt & 255 );
        iInt    >>= 8;            
        bIntBuf[ iOffset + 2 ]  = ( byte ) ( iInt & 255 );
        iInt    >>= 8;           
        bIntBuf[ iOffset + 3 ]  = ( byte ) ( iInt & 255 );
        
    }   //  method  IntToByte()
    
    public  static  void    LongToByte( long    lInt,
                                        int     iOffset,
                                        byte[]  bLongBuf )
    throws Exception
    {            
        bLongBuf[ iOffset + 0 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;           
        bLongBuf[ iOffset + 1 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;            
        bLongBuf[ iOffset + 2 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;           
        bLongBuf[ iOffset + 3 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;                   
        bLongBuf[ iOffset + 4 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;           
        bLongBuf[ iOffset + 5 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;            
        bLongBuf[ iOffset + 6 ]  = ( byte ) ( lInt & 255 );
        lInt    >>= 8;           
        bLongBuf[ iOffset + 7 ]  = ( byte ) ( lInt & 255 );
        
        
    }   //  method  IntToByte()    
    
    public  static  void    ShortToByte(    short   siShort,
                                            int     iOffset,
                                            byte[]  bShortBuf    )
    throws Exception
    {            
        bShortBuf[ iOffset + 0 ]  = ( byte ) ( siShort & 255 );
        siShort    >>= 8;           
        bShortBuf[ iOffset + 1 ]  = ( byte ) ( siShort & 255 );
        
    }   //  method  ShortToByte()
    
    public  static  void    DoubleToByte(   double  dDouble,
                                            int     iOffset,
                                            byte[]  bDoubleBuf  )
    throws Exception
    { 
        //long    lValue  =   ( long ) dDouble;
        long      lValue  = Double.doubleToLongBits(dDouble);  
        
        bDoubleBuf[ iOffset + 0 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 1 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;            
        bDoubleBuf[ iOffset + 2 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 3 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 4 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 5 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 6 ]  = ( byte ) ( lValue & 255 );
        lValue    >>= 8;           
        bDoubleBuf[ iOffset + 7 ]  = ( byte ) ( lValue & 255 );
        
    }   //  method  DoubleToByte()
    
    public  static  double  ByteToDouble( byte[] inBytes, int iOffset )
    throws Exception
    {   
             
        if( inBytes.length < ( iOffset + 8 ) )
        {
            throw new Exception( "Invalid size" );
        }
        
        long lOut = 0;
                    
     	lOut    = ( inBytes[ iOffset + 7 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut    |= ( inBytes[ iOffset + 6 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 5 ] + 256 ) % 256;
     	lOut    <<= 8;     	
     	lOut   |= ( inBytes[ iOffset + 4 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 3 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 2 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 1 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset ] + 256 ) % 256;
     	
        double dOut = Double.longBitsToDouble( lOut );
        
        return( dOut );  
        
    }   //  method  ByteToDouble
    
    
    public  static  long  ByteToLongLong( byte[] inBytes, int iOffset )
    throws Exception
    {   
             
        if( inBytes.length < ( iOffset + 8 ) )
        {
            throw new Exception( "Invalid size" );
        }
        
        long lOut = 0;
                    
     	lOut    = ( inBytes[ iOffset + 7 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut    |= ( inBytes[ iOffset + 6 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 5 ] + 256 ) % 256;
     	lOut    <<= 8;     	
     	lOut   |= ( inBytes[ iOffset + 4 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 3 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 2 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset + 1 ] + 256 ) % 256;
     	lOut    <<= 8;
     	lOut   |= ( inBytes[ iOffset ] + 256 ) % 256;
     	
     //   double dOut = Double.longBitsToDouble( lOut );
        
        return( lOut );  
        
    }   //  method  ByteToDouble
    
    public  static  String  ByteToString( byte inBytes[],int iOffset,int iLength )
    {
        String  oResult =   null;
        
        oResult =   new String( inBytes,iOffset,iLength );
        iLength =   oResult.indexOf( '\0' );
        if( iLength != -1 )
            oResult =   new String( inBytes,iOffset,iLength );
        
        return( oResult );
        
    }   //  method  ByteToString()
    
  
   
    
}   //  class   NESTconvert