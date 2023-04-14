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

not_run: WebUI.click(findTestObject('null', [('Value') : exOppty]))

WebUI.comment('TC122, TC123')

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Edit'))

WebUI.selectOptionByValue(findTestObject('null'), transactionType, false)

WebUI.comment('TC124')

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), probability, false)

if ((probability >= '30%') || '65%') {
    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), dealStartDate)

    TestObject testObj = findTestObject('Opportunity/CreateOpportunity/compellingEvent')

    List<WebElement> elements = WebUI.findWebElements(testObj, 10)

    println(elements.size())

    elements.get(1).click()

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddCompellingEvent'))

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), billingPlan, false)

    WebUI.setText(findTestObject('Opportunity/CreateOpportunity/SystemTCV'), systemTcv)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedSystemTcv'), comittedSystemTCV)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CfdTcv'), cfdTcv)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedCfdTcv'), committedCfdTcv)

    TestObject testObja = findTestObject('Sales/Opportunity/CreateOpportunity/RiskIssue')

    List<WebElement> elementse = WebUI.findWebElements(testObja, 10)

    println(elementse.size())

    elementse.get(1).click()

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddRiskIssueBtn'))

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMEA'), potentialMea, false)
}

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

