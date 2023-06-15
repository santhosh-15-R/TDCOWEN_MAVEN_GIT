package Utils;
//This class is for writing script to fetch the excel datas
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File file = new File("./src/test/resources/propfiles_(store_property_files)/config.properties");
        System.out.println(">>>>> ReadConfig");
        try {
            FileInputStream fis = new FileInputStream(file);
            this.pro = new Properties();
            this.pro.load(fis);
        } catch (Exception var3) {
            System.out.println("exception is" + var3.getMessage());
        }

    }

    public String chromepath() {
        String path = pro.getProperty("chromePath");
        return path;
    }

    /*public String getExcelpath() {
        String path = pro.getProperty("excelPath");
        return path;
    }*/

    public String getLog4jProFile() {
        String path = pro.getProperty("log4j");
        return path;
    }

    public String edgePath() {
        String path = pro.getProperty("edgePath");
        return path;
    }

    public String getUrl() {
        String url = pro.getProperty("TDCOWEN-url");
        return url;
    }
    public String getuserID() {
        String Userid = pro.getProperty("userId");
        return Userid;
    }
    public String getPassword() {
        String Password = pro.getProperty("password");
        return Password;
    }

    public String csvFile() {
        String filePath = pro.getProperty("filePath");
        return filePath;
    }


}

