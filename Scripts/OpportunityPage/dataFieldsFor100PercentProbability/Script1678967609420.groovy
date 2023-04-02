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

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DealStartDate'), DealStartDate)

TestObject testObj = findTestObject('OpportunityPage/compellingEvent')

List<WebElement> elements = WebUI.findWebElements(testObj, 10)

println(elements.size())

elements.get(1).click()

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddCompellingEvent'))

TestObject testObja = findTestObject('OpportunityPage/CreateOpportunity/RiskIssue')

List<WebElement> elementse = WebUI.findWebElements(testObja, 10)

println(elementse.size())

elementse.get(1).click()

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddRiskIssueBtn'))

WebUI.setText(findTestObject('OpportunityPage/SystemTCV'), SystemTcv)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ComittedSystemTcv'), comittedSystemTCV)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/CfdTcv'), CfdTcv)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/CommittedCfdTcv'), committedCfdTcv)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMEA'), potentialMea, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/BillingPlan'), billingPlan, false)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServiceMargin'), serviceMargin)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/CashReceiptInQ0'), cashReceiptQ0)
