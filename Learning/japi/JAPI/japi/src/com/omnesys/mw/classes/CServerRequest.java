package com.omnesys.mw.classes;


import java.io.Serializable;
import java.util.Vector;


public class CServerRequest implements Serializable {
    public int    iReqType = -1;
    public int    iDDInteractive = -1;
    public String sPortfolio = "MW";
    public String  sNewsTag = "N/A";
    public String oAccountId = null;
    public String sExchange = null;
    public Vector    v_symbol = new Vector();

} // class CServerRequest
