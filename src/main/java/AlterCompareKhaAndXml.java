import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class AlterCompareKhaAndXml {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
      //  main();
    }

    public static void main(String xmlFile, String khaCsvFile) throws IOException, SAXException, ParserConfigurationException {
        List<Player> playerList=ImportXml.impXml(xmlFile);
        List<Player> khaPlayers=AlterReadRateKha.alterKhaRate(khaCsvFile);
        List<Player> newPlayers = new ArrayList<>();

       for (Player playerXml : playerList){
         boolean b=false;
           for (Player khPlayer:khaPlayers){

             if (playerXml.getName().toString().equals(khPlayer.getName().toString())){
                 b=true;
                 continue;
             }
         }
         if (!b) newPlayers.add(playerXml);
       }
       OutputStream os = new FileOutputStream(khaCsvFile,true);
       for (Player pl : newPlayers) {
           String string = ";"+pl.getName() + ";" + pl.getRegion()+", "+pl.getLocation()+"\n";
           os.write( string.getBytes("Cp1251") );
       }
       os.close();
    }
}
