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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Edit'))

WebUI.comment('TC126')

WebUI.verifyElementVisible(findTestObject('Sales/Opportunity/CreateOpportunity/SystemPriceBookCheckbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Sales/Opportunity/CreateOpportunity/SystemPriceBookCheckbox'), FailureHandling.STOP_ON_FAILURE)

//message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/OpportunityCreate/Messages', 'System Price Text', 'Condition')
//
//HelpText = findTestData('OpportunityCreate/Messages').getValue('Message', message)
WebUI.mouseOver(findTestObject('Sales/Opportunity/CreateOpportunity/SystemPriceBookHoverText'))

'Get text from system price book help section'
String helptext = WebUI.getText(findTestObject('Sales/Opportunity/EditOpportunityPage/hover'))

'Verify the help section text'
WebUI.verifyEqual(helptext, systemHoverText)

String priceBook = WebUI.getText(findTestObject('Sales/Opportunity/EditOpportunityPage/SystemPriceBookBelowCloud', [('value') : systemPriceBook]))

WebUI.verifyEqual(priceBook, systemPriceBook)

println(priceBook)

WebUI.comment('TC127')

WebUI.check(findTestObject('Sales/Opportunity/CreateOpportunity/SystemPriceBookCheckbox'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

//message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/OpportunityCreate/Messages', 'Invalid Data', 'Condition')
//
//errorMsg = findTestData('OpportunityCreate/Messages').getValue('Message', message)
WebUI.verifyTextPresent(error, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Edit'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/SystemPriceBookCheckbox'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

