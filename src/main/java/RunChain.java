import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class RunChain {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        ///String csvFile="D:\\\\down\\\\rating.csv";
        AlterImportCsv.downFile(FinalStatic.csvFile);
        DelQuest delQuest=new DelQuest();
        delQuest.main();
        MultiRename.multiRename(); //обработали все XML, пополнили kharkov.csv

        String khaCsvFile = "D:\\\\down\\\\csv\\\\kharkov.csv";
        List<Player> khaPlayers= AlterReadRateKha.alterKhaRate(khaCsvFile);
        List<CsvPlayer> csvPlayersList=AlterReadCSV.alterReadCSV(FinalStatic.csvFile);
        List <FinalPlayer>fpList=AlterMergeFinal.finalMerge(khaPlayers, csvPlayersList);
        ExpToXLS.expToXLS(fpList);
    }
}
