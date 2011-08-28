package com.omnesys.mw.classes;


import java.io.Serializable;
import java.util.Vector;


public class CNESTDJNews implements Serializable {
    public int      iTransCode = -1;
    public String   sNewsMessagetype = "N/A";
    public String   sSource = "N/A";
    public String   sNewshotindicator = "N/A";
    public long      iAccessionnumber = -1;
    public int     iGmtdate = -1;
    public int     iGMTtime = -1;
    public int     iExpirymessagecount = -1;
    public String   sExpirymessagelist = "N/A";
    public String   sActioncode = "N/A";
    public int      iRefSeqNumber = -1;
    public int      iNewsSeqNumber = -1;
    public int      iNewsTagLength = -1;
    public int 	    inewslength = -1;
    public Vector   oNewsTag = new Vector();
    public String   sNewsHeadLines = "N/A";
    public String   sNewsStory = "N/A";
}
