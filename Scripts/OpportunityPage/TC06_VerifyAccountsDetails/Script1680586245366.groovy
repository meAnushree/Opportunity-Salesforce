import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.swing.text.Position as Position
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
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/Profiles/ProfileDetails', 'Administrator', 'Type')

systemAdministrator = findTestData('Sales/Profiles/ProfileDetails').getValue('Profile', user)

'Clicking on `Sytem Administrator Custom` profile '
WebUI.callTestCase(findTestCase('Common/TC_Impersonation'), [('profileList') : systemAdministrator], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/FirstSearchResult'))

'Click on parent account from the child account'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/ParentAccount(EditPage)'))

WebUI.scrollToElement(findTestObject('Sales/Accounts/EditAccountPage/NewLegalBtn'), GlobalVariable.shortDelay)

'TC153, Verify that `New Legal Commitment` button is present'
WebUI.verifyElementVisible(findTestObject('Sales/Accounts/EditAccountPage/NewLegalBtn'), FailureHandling.STOP_ON_FAILURE)

'TC155.01, TC164.02 Create a new base legal agreement in the parent account'
WebUI.click(findTestObject('Sales/Accounts/EditAccountPage/NewLegalBtn'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

WebUI.selectOptionByValue(findTestObject('Sales/Accounts/EditAccountPage/AgreementType'), type, false)

WebUI.selectOptionByValue(findTestObject('Sales/Accounts/EditAccountPage/AgreementStatus'), status, false)

WebUI.setText(findTestObject('Sales/Accounts/EditAccountPage/AgreementComment'), comment)

WebUI.selectOptionByValue(findTestObject('Sales/Accounts/EditAccountPage/TermStatus'), termStatus, false)

WebUI.setText(findTestObject('Sales/Accounts/EditAccountPage/TermComment'), comment)

WebUI.click(findTestObject('Sales/Accounts/EditAccountPage/SaveCloseBtn'))

WebUI.switchToWindowIndex(window)

WebUI.refresh()

WebUI.delay(GlobalVariable.shortDelay)

WebUI.waitForElementPresent(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'), GlobalVariable.mediumDelay)

'TC155.02, TC164.01 Create a new opportunity in the same parent account'
WebUI.callTestCase(findTestCase('OpportunityPage/TC_CreateOpportunities'), [('accountName') : accountName, ('tcv') : tcv
        , ('term') : term, ('proposedDiscount') : proposedDiscount, ('defaultDiscount') : defaultDiscount, ('lineLevelDiscount') : lineLevelDiscount
        , ('region') : region, ('transactionType') : transactionType1, ('dealReview') : dealReview, ('meu') : meu], FailureHandling.STOP_ON_FAILURE)

'TC166.03 Verify that after create a opportunity `SAP#` field is present on the page'
WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/EditOpportunityPage/SAPField'), GlobalVariable.shortDelay)

'Verify that after create a opportunity `Booked Date` field is present on the page'
WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/EditOpportunityPage/BookedDate'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/EditBtn'))

'TC164.03 Change `Transaction Type` in the opportunity after creating'
WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType'), transactionType, false)

'Verify that after the changes opportunity successfully saved'
WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/SaveBtn'))

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

'Open an existing opportunity'
WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/FirstOpportunityResult'))

WebUI.delay(GlobalVariable.shortDelay)

WebUI.scrollToElement(findTestObject('Sales/Opportunity/EditOpportunityPage/BaseLegalStatus'), GlobalVariable.shortDelay)

'TC157.02 Verify that `Base Legal Agreement` only present in the read only mode'
WebUI.verifyElementNotPresent(findTestObject('Sales/Accounts/EditAccountPage/NewLegalBtn'), GlobalVariable.shortDelay)


//'Verify that there is no `base legal agreement` is not present'
//WebUI.verifyNotMatch(baseLegalStatus, 'Base Legal Status', false)

WebUI.callTestCase(findTestCase('OpportunityPage/TC_VerifyElementPosition'), [:], FailureHandling.STOP_ON_FAILURE)

'TC166.02 Verify that after create a opportunity `SAP#` field is present on the page'
WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/EditOpportunityPage/SAPField'), GlobalVariable.shortDelay)

'Verify that after create a opportunity `Booked Date` field is present on the page'
WebUI.verifyElementPresent(findTestObject('Sales/Opportunity/EditOpportunityPage/BookedDate'), GlobalVariable.shortDelay)

'TC167.01 Create a booking package'
WebUI.callTestCase(findTestCase('OpportunityPage/TC_CreateBookingPackage'), [('flowType') : 'Standard', ('actualCloseQuarter') : 'Q1-2023'
        , ('actualTransactionType') : '99-YR/Other', ('var') : 'No', ('currency') : 'INR', ('tsCs') : 'N/A', ('sap') : '100'
        , ('bookedDate') : '3/30/2023'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/OpportunitySavePage'))

