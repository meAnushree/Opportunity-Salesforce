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
WebUI.scrollToElement(findTestObject('OpportunityPage/EditOpportunityPage/BookingPackageBtn'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('OpportunityPage/EditOpportunityPage/BookingPackageBtn'))

WebUI.click(findTestObject('OpportunityPage/Steps/ContinueBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Create new booking package'
WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/FlowType'), flowType, false)

WebUI.setText(findTestObject('OpportunityPage/EditOpportunityPage/ActualCloseQuarter'), actualCloseQuarter)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/ActualTransactionType'), actualTransactionType, 
    false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/VAR'), var, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/Currency'), currency, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/Ts-Cs'), tsCs, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/EditOpportunityPage/Status'), status, false)

WebUI.setText(findTestObject('OpportunityPage/EditOpportunityPage/AddSAP'), sap)

WebUI.setText(findTestObject('OpportunityPage/EditOpportunityPage/AddBookedDate'), bookedDate)

WebUI.click(findTestObject('OpportunityPage/EditOpportunityPage/SaveBtn'))

'Verify that new booking package is created'
String bookingPackageName = WebUI.getText(findTestObject('OpportunityPage/EditOpportunityPage/BookingPackageName'))

WebUI.verifyTextPresent(bookingPackageName, false)

