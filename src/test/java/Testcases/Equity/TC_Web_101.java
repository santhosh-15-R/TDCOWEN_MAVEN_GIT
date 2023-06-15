package Testcases.Equity;


import Utils.ReadConfig;
import Utils.ReadExcel;
import WebUI_Contains_All_Info_WebDriver.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import pages_page_object_model.AdmnPageObject;
import pages_page_object_model.loginPageObjects;

import java.io.IOException;


public class TC_Web_101 extends TestBase {

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
    public void uploadCSVFile() throws InterruptedException, IOException {

        initReports("uploadCSVFile-TC_Web_101");
        admnPageObject.clickAdmin();
        infoLog("Selecting admin Segment");
        admnPageObject.selectClient();
        infoLog("Selecting client as yannis ");
        infoLog(" Uploading csv -2021_trade_data_DuplicateRow");
        admnPageObject.uploadBrowseFile();
        stepPass("2021_trade_data_DuplicateRow uploaded Successfully");
        admnPageObject.validateFileupload("2021_trade_data_DuplicateRow.csv","tier_1_admin@qa.com");
        stepPass("Error status ");


    }

}
