package extent__generate_report;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    public static String screenshotFolderPath;

    public static ExtentReports getInstance(String reportPath) {

        if (extent == null) {
            String fileName = "Report.html";
            Date date = new Date();
            String folderName = date.toString().replace(":", "_").replace(" ", "_");
            new File(reportPath + "/ExtentReports/" + folderName + "/screenshots").mkdirs();
            reportPath = reportPath + "/ExtentReports/" + folderName + "/";
            screenshotFolderPath = reportPath + "screenshots/";
            createInstance(reportPath + fileName);
        }
        return extent;
    }


    public void writeToReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    private static ExtentReports createInstance(String fileName) {

        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        return extent;
    }


}
