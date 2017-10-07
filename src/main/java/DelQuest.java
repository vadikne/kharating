import java.io.*;

/**
 * Created by owner on 06.09.2017.
 */
public class DelQuest {
    //public static void main(String[] args) {

    public static void main(String csvPath, String csvFile) {
        String tempFile=csvPath+"rating1.csv";
        BufferedReader buff = null;
        BufferedWriter buffOut = null;
            try {
                buff = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "windows-1251"));
                buffOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "cp1251"));
                while (true) {
                    String line = buff.readLine();
                    if (line == null) break;
                    String line1=line.replaceAll("\\?","" );
                    buffOut.write(line1+"\n");
                }
            }catch (IOException e){
                e.printStackTrace();
            } finally {
                try{
                    buff.close();
                    buffOut.flush();
                    buffOut.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            }
        AlterImportCsv.changeFile(csvFile,tempFile);
    }
}

