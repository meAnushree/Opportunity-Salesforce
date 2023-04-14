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
import groovy.json.JsonOutput as JsonOutput
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/RecordType', [('type') : 'IP']))

WebUI.click(findTestObject('Sales/Common/Steps/ContinueBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Clear dafult text of `Opportunity Name` field'
WebUI.clearText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityName'))

'Clear dafult text of `Expected Close Quarter` field'
WebUI.clearText(findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter'))

'Clear dafult text of `Close Date` field'
WebUI.clearText(findTestObject('Sales/Opportunity/CreateOpportunity/CloseDate'))

'Save the opportunity without filling any data'
WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'Get value from excel file'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'ErrMsg',
	'Condition')

ErrorMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

'Verify that an error comes up for blank `Account Name` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/AccountName')
        , ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify that an error comes up for blank a `Opportunity Name` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityName')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank a `Expected Close ` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank a `TcvUsd` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/TCV(USD)')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `TermMonth` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/Term(Month)')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `Region` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/Term(Month)')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `Transaction Type` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `Deal Review Type` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/DealReviewType')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `Proposed Discount` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/ProposedDiscount')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

'Verify an error comes up for blank `Close Date` field'
WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/CloseDate')
	, ('value') : value, ('ErrMsg') : ErrorMsg], FailureHandling.STOP_ON_FAILURE)

