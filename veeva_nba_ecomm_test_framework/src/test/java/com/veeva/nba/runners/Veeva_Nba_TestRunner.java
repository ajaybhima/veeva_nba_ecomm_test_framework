package com.veeva.nba.runners;

import com.veeva.nba.utils.TestBase;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@SearchTests",
        plugin = {"pretty","html:target/cucumber-reports/CucumberTestReport.html"}
)
public class Veeva_Nba_TestRunner {

    TestNGCucumberRunner testNGCucumberRunner;

    TestBase testBase;

    @BeforeClass (alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    public void testBeforeMethod(){
        testBase = new TestBase();
        testBase.startBrowser();
    }

    @Test(groups = "cucumber",description = "Test Cucumber Runner",dataProvider = "senarios")
    public void runCucumberTest(PickleWrapper pickleWrapper, FeatureWrapper features){
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] senarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod(alwaysRun = true)
    public void testAfterMethod(ITestResult res){

        if(res.getStatus() == ITestResult.FAILURE){
            testBase.takeScreenshotOnTestFailure("FirstTest");
        }
        //testBase.closeBrowser();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        testNGCucumberRunner.finish();
    }
}
