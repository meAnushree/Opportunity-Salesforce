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

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), DealStartDate)

TestObject testObj = findTestObject('Opportunity/compellingEvent')

List<WebElement> elements = WebUI.findWebElements(testObj, 10)

println(elements.size())

elements.get(1).click()

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddCompellingEvent'))

TestObject testObja = findTestObject('Sales/Opportunity/CreateOpportunity/RiskIssue')

List<WebElement> elementse = WebUI.findWebElements(testObja, 10)

println(elementse.size())

elementse.get(1).click()

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddRiskIssueBtn'))

WebUI.setText(findTestObject('Opportunity/SystemTCV'), SystemTcv)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedSystemTcv'), ComittedSystemTCV)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CfdTcv'), CfdTcv)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedCfdTcv'), CommittedCfdTcv)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMEA'), PotentialMea, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), BillingPlan, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ServiceMargin'), ServiceMargin)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CashReceiptInQ0'), CashReceiptQ0)
