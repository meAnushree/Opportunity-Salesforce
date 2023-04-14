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

'Scroll to `New Booking Package` button'
WebUI.scrollToElement(findTestObject('Sales/Opportunity/EditOpportunityPage/BookingPackageBtn'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/BookingPackageBtn'))

WebUI.click(findTestObject('Sales/Common/Steps/ContinueBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Create new booking package'
WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/FlowType'), flowType, false)

WebUI.setText(findTestObject('Sales/Opportunity/EditOpportunityPage/ActualCloseQuarter'), actualCloseQuarter)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/ActualTransactionType'), actualTransactionType, 
    false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/VAR'), var, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/Currency'), currency, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/Ts-Cs'), tsCs, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/EditOpportunityPage/Status'), status, false)

WebUI.setText(findTestObject('Sales/Opportunity/EditOpportunityPage/AddSAP'), sap)

WebUI.setText(findTestObject('Sales/Opportunity/EditOpportunityPage/AddBookedDate'), bookedDate)

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/SaveBtn'))

'Verify that new booking package is created'
String bookingPackageName = WebUI.getText(findTestObject('Sales/Opportunity/EditOpportunityPage/BookingPackageName'))

WebUI.verifyTextPresent(bookingPackageName, false)

