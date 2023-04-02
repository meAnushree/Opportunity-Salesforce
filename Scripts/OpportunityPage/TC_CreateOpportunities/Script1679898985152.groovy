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
WebUI.click(findTestObject('OpportunityPage/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/Steps/NewButton'))

WebUI.click(findTestObject('OpportunityPage/Steps/ContinueBtn'))

WebUI.click(findTestObject('OpportunityPage/NewOpportunityCreation/AccountName'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('OpportunityPage/NewOpportunityCreation/lookup'), accountName)

WebUI.click(findTestObject('OpportunityPage/NewOpportunityCreation/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('OpportunityPage/NewOpportunityCreation/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.setText(findTestObject('OpportunityPage/NewOpportunityCreation/TCV(USD)'), tcv)

WebUI.setText(findTestObject('OpportunityPage/NewOpportunityCreation/Term(Month)'), term)

WebUI.setText(findTestObject('OpportunityPage/NewOpportunityCreation/ProposedDiscount'), proposedDiscount)

WebUI.setText(findTestObject('OpportunityPage/NewOpportunityCreation/DefaultDiscount'), defaultDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/NewOpportunityCreation/LineLevelDiscount'), lineLevelDiscount, false )

WebUI.selectOptionByValue(findTestObject('OpportunityPage/NewOpportunityCreation/Region'), region ,false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/NewOpportunityCreation/TransactionType'), transactionType ,false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/NewOpportunityCreation/DealReview'), dealReview ,false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/NewOpportunityCreation/MEU'), meu, false)

WebUI.click(findTestObject('OpportunityPage/NewOpportunityCreation/SaveBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Verify that after entering all the required field values, page will save without any error'
WebUI.verifyElementVisible(findTestObject('OpportunityPage/NewOpportunityCreation/SavePage'), FailureHandling.STOP_ON_FAILURE)

