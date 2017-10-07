import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class MultiRename {
    public static void main(String []args) throws ParserConfigurationException, SAXException, IOException {
       // multiRename();
        }
        public static void multiRename(String pathName,String khaCsvFile) throws ParserConfigurationException, SAXException, IOException {
    File[] filesList;

    File newFile= new File(pathName+ File.separator+"1.xml");
        if (newFile.exists()){
        AlterImportCsv.delFile(newFile.toString());
    }
    File filesPath = new File(pathName);
    filesList = filesPath.listFiles();
    for(int i=0; i<filesList.length; i++) {
        System.out.println(filesList[i].getName());
        filesList[i].renameTo(newFile);
        AlterCompareKhaAndXml.main(newFile.toString(),khaCsvFile);
        AlterImportCsv.delFile(newFile.toString());
        }
    }
    }


