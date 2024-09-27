package com.veeva.nba.runners;

import com.veeva.nba.utils.TestBase;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@BackendAPITest",
        plugin = {"pretty","html:target/cucumber-reports/CucumberTestReport.html"}
)
public class Veeva_Backend_TestRunner {

    TestNGCucumberRunner testNGCucumberRunner;



    @BeforeClass (alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }



    @Test(groups = "cucumber",description = "Test Cucumber Runner",dataProvider = "senarios")
    public void runCucumberTest(PickleWrapper pickleWrapper, FeatureWrapper features){
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] senarios(){
        return testNGCucumberRunner.provideScenarios();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        testNGCucumberRunner.finish();
    }
}
