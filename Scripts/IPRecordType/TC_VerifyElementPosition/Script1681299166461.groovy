import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.By as By
import org.openqa.selenium.Dimension as Dimension
import org.openqa.selenium.Point as Point
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver

'Verify that both elements are present on the page'
WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityOwner'), GlobalVariable.shortDelay, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'), GlobalVariable.shortDelay, 
    FailureHandling.STOP_ON_FAILURE)

OpportunityOwner = WebUiCommonHelper.findWebElement(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityOwner'), 
    GlobalVariable.shortDelay)

AxName = WebUiCommonHelper.findWebElement(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'), GlobalVariable.shortDelay)

'Get the Y position of each element'
Point positionOfOpportunityOwner = OpportunityOwner.getLocation()

Point positionOfAxName = AxName.getLocation()

'Verify that `AxName` is below `Opportunity Owner` in opportunity'
WebUI.verifyGreaterThan(positionOfAxName.getY(), positionOfOpportunityOwner.getY())

