package testnestq;

import com.omnesys.testnestq.gui.HomePage;
import java.awt.EventQueue;

public class Main
{

    public Main()
    {
    } 

    public static void main(String args[])
    {
    	
    //	/-Dnest_property.file.path=./NESTResources.properties 
        //-Dreq_property.file.path=./RequestName.properties
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new HomePage()).setVisible(true);
            }

        });
    }
}
