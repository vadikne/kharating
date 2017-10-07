import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class RunChain {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
    }
    public static void runChain(String csvPath, String xmlPath) throws IOException, SAXException, ParserConfigurationException {

        String csvFile=csvPath+"rating.csv";
        String khaCsvFile = csvPath+"kharkov.csv";

        AlterImportCsv.downFile(csvFile);
        DelQuest.main(csvPath,csvFile);
        MultiRename.multiRename(xmlPath, khaCsvFile); //обработали все XML, пополнили kharkov.csv
        List<Player> khaPlayers = AlterReadRateKha.alterKhaRate(khaCsvFile);
        List<CsvPlayer> csvPlayersList = AlterReadCSV.alterReadCSV(csvFile);
        List<FinalPlayer> fpList = AlterMergeFinal.finalMerge(khaPlayers, csvPlayersList);
        ExpToXLS.expToXLS(csvPath,fpList);
    }
}
