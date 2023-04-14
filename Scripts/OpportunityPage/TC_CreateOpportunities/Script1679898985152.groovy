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

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/RecordType', [('type') : RecordType]))

WebUI.click(findTestObject('Sales/Common/Steps/ContinueBtn'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AccountName'))

int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), AccountName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter'), ECQ)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/TCV(USD)'), TCV)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Term(Month)'), TermMonth)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ProposedDiscount'), ProposedDiscount)

not_run: WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DefaultDiscount'), DefaultDiscount)

not_run: WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/LineLevelDiscount'), LineLevelDiscount, 
    false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Region'), Region, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType'), TransactionType, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/DealReview'), DealReview, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/MEU'), MEU, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Foundry'), Foundry, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Process'), Proces, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Competitor'), Competitor, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddCompetitorBtn'))

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/IPProductCategory'), IPProductCategory,
	false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddIPProductBtn'))

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/CompellingEventIP'), CompellingEventIP, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/SaveBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Verify that after entering all the required field values, page will save without any error'
WebUI.verifyElementVisible(findTestObject('Sales/Opportunity/CreateOpportunity/SavePage'), FailureHandling.STOP_ON_FAILURE)

