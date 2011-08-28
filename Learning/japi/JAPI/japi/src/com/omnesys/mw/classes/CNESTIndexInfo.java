package com.omnesys.mw.classes;


import java.io.Serializable;


public class CNESTIndexInfo  implements  Serializable {
    public int       iTransCode = -1; // value 1002
    public int       iValue = -1;
    public int       iOpenIndex = -1;
    public int       iCloseIndex = -1;
    public String    SIndexName = "N/A";
    public String    SExchSeg = "N/A";
    ;
    public String    SExchFeedTime = "N/A";
    ;
    public long      lSecondsSinceBoe = -1;
    public long      lUsecs = -1;
}
