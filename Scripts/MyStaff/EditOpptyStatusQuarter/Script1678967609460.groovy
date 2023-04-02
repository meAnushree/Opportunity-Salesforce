import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Edit'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ExpectedCloseQuarterLookUp'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.setText(findTestObject('OpportunityPage/IFrames/TextInput'), ExpectedCloseQuarter)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

WebUI.selectOptionByValue(findTestObject('Object Repository/OpportunityPage/status'), Status, false)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), tcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), softwareTCV)

	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), serviceTCV)

if (recordType == 'IP') {
    TestObject testObj4 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/WonLostReason')

    List<WebElement> elementsd = WebUI.findWebElements(testObj4, 10)

    println(elementsd.size())

    elementsd.get(2).click()

    WebUI.delay(2)

    WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddWonLostReasonBtn'))

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/LostReasonComment'), comment)
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

cs = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/CreditStatus'))

WebUI.verifyEqual(cs, creditStatus)

