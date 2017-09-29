import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AlterMergeFinal {


 //// public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
 ////     String khaCsvFile = "D:\\\\down\\\\csv\\\\kharkov.csv";
 ////     List<Player> khaPlayers= AlterReadRateKha.alterKhaRate(khaCsvFile);
 ////     String csvFile="D:\\\\down\\\\rating.csv";
 ////     List<CsvPlayer> csvPlayersList=AlterReadCSV.alterReadCSV(csvFile);

 ////     List <FinalPlayer>fpList=finalMerge(khaPlayers, csvPlayersList);
 ////     for (FinalPlayer pl:fpList) System.out.println(pl.toString());
 ////     ExpToXLS.expToXLS(fpList);
 //// }

    public static List finalMerge(List <Player>khaPlayers, List <CsvPlayer>csvPlayersList) {
        List<FinalPlayer> finalPlayerList = new ArrayList<>(1300);
        for (Player khaPlayer:khaPlayers){

            for (CsvPlayer csvPlayer:csvPlayersList){
                if (khaPlayer.getName().toString().equals(csvPlayer.getName().toString()) &&
                        csvPlayer.getTown().toString().contains(khaPlayer.getLocation())){
                    FinalPlayer player = new FinalPlayer();
                    player.setName(csvPlayer.getName());
                    player.setTown(csvPlayer.getTown());
                    player.setCups(csvPlayer.getCups());
                    player.setGames(csvPlayer.getGames());
                    player.setRating(csvPlayer.getRating());
                    player.setDelta(csvPlayer.getDelta());
                    player.setDate(csvPlayer.getDate());
                    finalPlayerList.add(player);
                }
            }
        }
        Collections.sort(finalPlayerList);
        int i=1;
        for (FinalPlayer fp:finalPlayerList)fp.setNumber(i++);
        return finalPlayerList;
    }
}