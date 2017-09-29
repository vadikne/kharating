import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class MultiRename {
    public static void main(String []args) throws ParserConfigurationException, SAXException, IOException {
       multiRename();
        }
        public static void multiRename() throws ParserConfigurationException, SAXException, IOException {
    File[] filesList;
    String pathName="D:\\\\down\\\\xml\\\\";
    File newFile= new File(pathName+"1.xml");
        if (newFile.exists()){
        AlterImportCsv.delFile(newFile.toString());
    }
    File filesPath = new File(pathName);
    filesList = filesPath.listFiles();
    for(int i=0; i<filesList.length; i++) {
        System.out.println(filesList[i].getName());
        filesList[i].renameTo(newFile);
        AlterCompareKhaAndXml.main();
        AlterImportCsv.delFile(newFile.toString());
        }
    }
    }


