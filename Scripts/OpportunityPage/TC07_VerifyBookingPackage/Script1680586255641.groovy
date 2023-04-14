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

'This will navigate home page to profile page'
WebUI.callTestCase(findTestCase('Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Get value from excel file'
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/OpportunityCreate/Profiles/ProfileName', 'Administrator', 'Type')

systemAdministrator = findTestData('OpportunityCreate/Profiles/ProfileName').getValue('Profile', user)

'Clicking on `Sytem Administrator Custom` profile '
WebUI.callTestCase(findTestCase('Common/TC_Impersonation'), [('profileList') : systemAdministrator], FailureHandling.STOP_ON_FAILURE)

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/WonStatusOpportunity'))

WebUI.callTestCase(findTestCase('OpportunityPage/TC_CreateBookingPackage'), [('flowType') : 'Standard', ('actualCloseQuarter') : 'Q1-2023'
        , ('actualTransactionType') : '99-YR/Other', ('var') : 'No', ('currency') : 'INR', ('tsCs') : 'N/A', ('sap') : '100'
        , ('bookedDate') : '3/30/2023'], FailureHandling.STOP_ON_FAILURE)

