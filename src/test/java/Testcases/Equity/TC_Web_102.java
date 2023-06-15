package Testcases.Equity;


import Utils.ReadConfig;
import WebUI_Contains_All_Info_WebDriver.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages_page_object_model.AdmnPageObject;
import pages_page_object_model.loginPageObjects;

import java.io.IOException;


public class TC_Web_102 extends TestBase {

    ReadConfig config;
    AdmnPageObject admnPageObject;
    pages_page_object_model.loginPageObjects loginPageObjects;

    @BeforeClass
    public void loadTestConfig() throws IOException {
        System.out.println(">>>>>>> BeforeClass");
        config = new ReadConfig();
        admnPageObject = new AdmnPageObject(driver);
        loginPageObjects = new loginPageObjects(driver);
    }


    @Test
    public void uploadPDFFile() throws InterruptedException, IOException {

        initReports("uploadPDFFile-TC_Web_102");
        admnPageObject.clickAdmin();
        infoLog("Selecting admin Segment");
        admnPageObject.selectClient();
        infoLog("Selecting client as yannis ");
        infoLog(" Uploading pdf -pdf_sample_data.pdf");
        admnPageObject.uploadPdfBrowseFile();
        admnPageObject.PDFError();

    }

}
