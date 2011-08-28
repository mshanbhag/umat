package com.omnesys.mw.frontend;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.omnesys.mw.constants.NESTconstants;
import com.omnesys.mw.frontend.StartUI;
import com.omnesys.mw.gui.HandleConnection;
import com.sun.crypto.provider.JceKeyStore;


public class StartUI extends JFrame {
    boolean btree = false;
    JLabel jlSubscribe = new JLabel("Subscribe");
    JLabel jlUnsubscribe = new JLabel("Unsubscribe");
    JLabel jlSubFile = new JLabel("SubScribe File");
    JLabel jlUnsubFile = new JLabel("Unsubscribe File");
    JButton jbSubscribe = new JButton("SubScribe");
    JButton jbUnsubscribe = new JButton("UnSubScribe");
    JTextField jtSub = new JTextField();
    JTextField jtUnSub = new JTextField();
    JTextField jtSubFile = new JTextField();
    JTextField jtUnSubFile = new JTextField();
    JPanel jpSubScribePanel = new JPanel();
    JPanel jpUnScribePanel = new JPanel();
    JPanel jpFileSubPanel = new JPanel();
    JPanel jpFileUnSubPanel = new JPanel();
    JPanel jpBottomPanel = new JPanel(new BorderLayout());
    JPanel jMainPanel = new JPanel(new BorderLayout());
    JComboBox jcSub = new JComboBox();
    JComboBox jcUnSub = new JComboBox();
    JComboBox jcFileSub = new JComboBox();
    JComboBox jcFileUnSub = new JComboBox();
    public Vector oExcVec = new Vector();
    JButton jbSubopen = new JButton("Choose");
    JButton jbUnSubopen = new JButton("Choose");
    JButton jbSubscribeFile = new JButton("SubScribe");
    JButton jbUnsubscribeFile = new JButton("UnSubScribe");
    JFileChooser jfChoose1 = new JFileChooser();
    JFileChooser jfChoose2 = new JFileChooser();
    boolean bFileChoosenSub = false;
    boolean bFileChoosenUnSub = false;
    File file1;
    File file2;
    HandleConnection handl;

    // JFileChooser jSubFile = new JFileChooser();
    // JFileChooser jUnSubFile = new JFileChooser();
    StartUI() {
        super();
        try {
            setLocation(150, 100);
            FrameInit();
            this.show();
            try {
                handl = new HandleConnection(this);
                // HandleConnection.Initiate();
            } catch (Exception e) {}
            this.setVisible(true);
        } catch (Exception e) {}
    }

    public static void main(String[] oArgs) {
        StartUI oMain = new StartUI();
    }

    void Dispose() {
        System.exit(0);
        this.dispose();
    }

    void setPanelSize() {
        this.setSize(new Dimension(550, 280));
        jpSubScribePanel.setPreferredSize(new Dimension(550, 50));
        jpUnScribePanel.setSize(new Dimension(550, 50));
        jpFileSubPanel.setSize(new Dimension(550, 50));
        jpFileUnSubPanel.setSize(new Dimension(550, 50));
        jMainPanel.setSize(new Dimension(550, 250));
        jpBottomPanel.setSize(new Dimension(550, 150));
        jlSubscribe.setPreferredSize(new Dimension(90, 20));
        jlUnsubscribe.setPreferredSize(new Dimension(100, 20));
        jbSubscribe.setPreferredSize(new Dimension(120, 20));
        jbUnsubscribe.setPreferredSize(new Dimension(120, 20));
        jtSub.setPreferredSize(new Dimension(120, 20));
        jtUnSub.setPreferredSize(new Dimension(120, 20));
        jtSubFile.setPreferredSize(new Dimension(120, 20));
        jtUnSubFile.setPreferredSize(new Dimension(120, 20));
        jfChoose1.setPreferredSize(new Dimension(420, 300));
        jfChoose2.setPreferredSize(new Dimension(420, 300));
    }

    void addPanels() {
        jpSubScribePanel.add(jlSubscribe);
        jpSubScribePanel.add(jtSub);
        jpSubScribePanel.add(jcSub);
        jpSubScribePanel.add(jbSubscribe);
        jpUnScribePanel.add(jlUnsubscribe);
        jpUnScribePanel.add(jtUnSub);
        jpUnScribePanel.add(jcUnSub);
        jpUnScribePanel.add(jbUnsubscribe);
        jpFileSubPanel.add(jlSubFile);
        jpFileSubPanel.add(jcFileSub);
        jpFileSubPanel.add(jtSubFile);
        jpFileSubPanel.add(jbSubopen);
        jpFileSubPanel.add(jbSubscribeFile);
        jpFileUnSubPanel.add(jlUnsubFile);
        jpFileUnSubPanel.add(jcFileUnSub);
        jpFileUnSubPanel.add(jtUnSubFile);
        jpFileUnSubPanel.add(jbUnSubopen);
        jpFileUnSubPanel.add(jbUnsubscribeFile);
        jMainPanel.add(jpSubScribePanel, "North");
        jMainPanel.add(jpUnScribePanel, "Center");
        jpBottomPanel.add(jpFileSubPanel, "North");
        jpBottomPanel.add(jpFileUnSubPanel, "Center");
        jMainPanel.add(jpBottomPanel, "South");
        this.setResizable(false);
        this.setTitle("java_udp_reciever --1.7.0.0 -- SubScribe -- Unsubscribe ");
        this.getContentPane().add(jMainPanel);
    }

    public void SubscribeForSingleScrip() {
        String sToken = jtSub.getText().trim();
        String sExc = jcSub.getSelectedItem().toString();

        if (sToken == null || sExc == null || sToken.equals("")
                || sExc.equals("")) {} else {
            handl.subscribeSingle(sToken, sExc);
            jtSub.setText("");
        }
    }

    public void UnSubscribeForSingleScrip() {
        String sToken = jtUnSub.getText().trim();
        String sExc = jcUnSub.getSelectedItem().toString();

        if (sToken == null || sExc == null || sToken.equals("")
                || sExc.equals("")) {} else {
            handl.UnSubscribeSingle(sToken, sExc);
            jtUnSub.setText("");
        }
    }

    /*
     * public void SubscribeForFile() {
     * 
     * }
     * 
     * public void UnSubscribeForFile() {
     * 
     * }
     */
    public void FrameInit() {
        try {
            oExcVec.add("nse_cm");
            oExcVec.add("bse_cm");
            oExcVec.add("nse_fo");
            oExcVec.add("mcx_fo");
            oExcVec.add("ncx_fo");
            oExcVec.add("cde_fo");
            jcSub = new JComboBox(oExcVec);
            jcUnSub = new JComboBox(oExcVec);
            jcFileSub = new JComboBox(oExcVec);
            jcFileUnSub = new JComboBox(oExcVec);
            setPanelSize();
            addPanels();
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    Dispose();
                }
            });
            jbUnsubscribeFile.addActionListener(
                    new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Vector oScripVec = new Vector();

                    // System.out.println("coming in Unsubscribe File Data ------------");
                    if (bFileChoosenUnSub) {
                        try {
                            BufferedReader in = new BufferedReader(
                                    new FileReader(file2));
                            String str;
                            String s_nse_file_data = "";

                            while ((str = in.readLine()) != null) {
                                if (str.length() != 0) {
                                    if (s_nse_file_data.length() == 0) {
                                        s_nse_file_data = str;
                                    } else {
                                        s_nse_file_data = s_nse_file_data.concat(
                                                str);
                                    }
                                }
                            }
                            in.close();
                            if (s_nse_file_data.length() != 0) {
                                if (s_nse_file_data != null) {
                                    StringTokenizer s_Token = new StringTokenizer(
                                            s_nse_file_data, ",");

                                    while (s_Token.hasMoreTokens()) {
                                        oScripVec.add(s_Token.nextToken());
                                    }
                                }
                            }
                            String Exc = jcFileUnSub.getSelectedItem().toString();

                            if (oScripVec.size() != 0 && Exc != null) {
                                if (Exc.equals("nse_cm")) {
                                    Exc = "NSE";
                                } else if (Exc.equals("bse_cm")) {
                                    Exc = "BSE";
                                } else if (Exc.equals("nse_fo")) {
                                    Exc = "NFO";
                                } else if (Exc.equals("mcx_fo")) {
                                    Exc = "MCX";
                                } else if (Exc.equals("ncx_fo")) {
                                    Exc = "NCDEX";
                                } else if (Exc.equals("cde_fo")) {
                                    Exc = "CDS";
                                }
                                handl.sentRequestToServerUnSubscribe(
                                        NESTconstants.UN_SUB_ALL_GIVEN_TOKENS,
                                        Exc, oScripVec);
                            }
                        } catch (Exception e32) {
                            System.out.println(
                                    "Error :: ==> Error file not found :: ==>"
                                            + e32);
                        }
                        bFileChoosenUnSub = false;
                        jtUnSubFile.setText("");
                    }

                }

            });
            jbSubscribeFile.addActionListener(
                    new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Vector oScripVec = new Vector();

                    if (bFileChoosenSub) {
                        try {
                            BufferedReader in = new BufferedReader(
                                    new FileReader(file1));
                            String str;
                            String s_nse_file_data = "";

                            while ((str = in.readLine()) != null) {
                                if (str.length() != 0) {
                                    if (s_nse_file_data.length() == 0) {
                                        s_nse_file_data = str;
                                    } else {
                                        s_nse_file_data = s_nse_file_data.concat(
                                                str);
                                    }
                                }
                            }
                            in.close();
                            if (s_nse_file_data.length() != 0) {
                                if (s_nse_file_data != null) {
                                    StringTokenizer s_Token = new StringTokenizer(
                                            s_nse_file_data, ",");

                                    while (s_Token.hasMoreTokens()) {
                                        oScripVec.add(s_Token.nextToken());
                                    }
                                }
                            }
                            String Exc = jcFileSub.getSelectedItem().toString();

                            if (oScripVec.size() != 0 && Exc != null) {
                                if (Exc.equals("nse_cm")) {
                                    Exc = "NSE";
                                } else if (Exc.equals("bse_cm")) {
                                    Exc = "BSE";
                                } else if (Exc.equals("nse_fo")) {
                                    Exc = "NFO";
                                } else if (Exc.equals("mcx_fo")) {
                                    Exc = "MCX";
                                } else if (Exc.equals("ncx_fo")) {
                                    Exc = "NCDEX";
                                } else if (Exc.equals("cde_fo")) {
                                    Exc = "CDS";
                                }
                                handl.sentRequestToServerSubscribe(
                                        NESTconstants.SUB_ALL_GIVEN_TOKENS, Exc,
                                        oScripVec);
                            }
                        } catch (Exception e32) {
                            System.out.println(
                                    "Error :: ==> Error file not found :: ==>"
                                            + e32);
                        }

                        bFileChoosenSub = false;
                        jtSubFile.setText("");
                    }

                }

            });

            jbSubopen.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    // jfChoose1.showOpenDialog(StartUI.this);
                    int returnVal = jfChoose1.showOpenDialog(StartUI.this);

                    // System.out.println(JFileChooser.APPROVE_OPTION+"<<----------returnVal------------->>>"+returnVal);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        // System.out.println("coming in Aprove Option 0000000000 --------------");
                        file1 = jfChoose1.getSelectedFile();
                        bFileChoosenSub = true;
                        jtSubFile.setText(file1.getName());
                        // This is where a real application would open the file.
                    } else {}
                }

            });
            jbUnSubopen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // jfChoose2.showOpenDialog(StartUI.this);
                    int returnVal = jfChoose2.showOpenDialog(StartUI.this);

                    // TODO Auto-generated method stub
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        file2 = jfChoose2.getSelectedFile();
                        bFileChoosenUnSub = true;
                        jtUnSubFile.setText(file2.getName());
                    }
                }
            });
            jbSubscribe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SubscribeForSingleScrip();
                    // TODO Auto-generated method stub
                }
            });
            jbUnsubscribe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    UnSubscribeForSingleScrip();
                    // TODO Auto-generated method stub
                }
            });
        } catch (Exception ex) {}
    }
}
