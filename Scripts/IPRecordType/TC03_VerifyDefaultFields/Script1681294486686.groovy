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
import org.apache.commons.lang.time.DateUtils as DateUtils
import org.openqa.selenium.Keys as Keys
import java.time.LocalDate as LocalDate
import java.util.Calendar as Calendar
import java.util.Locale as Locale

not_run: WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/RecordType', [('type') : RecordType]))

WebUI.click(findTestObject('Sales/Common/Steps/ContinueBtn'))

'TC79.03 Verify `Status` field has default value `Active`'
WebUI.verifyOptionPresentByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Status'), Status, false, GlobalVariable.shortDelay)

'Get the the quarter'
LocalDate currentDate = LocalDate.now()

Calendar cal = Calendar.getInstance(Locale.US)

int month = cal.get(Calendar.MONTH)

int year = cal.get(Calendar.YEAR)

int quarter = (month / 3) + 1

'Concate the quarter value with current year'
CloseQuarter = ((('Q' + quarter) + '-') + year)

TestObject element = findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter')

'Get the default value of expected close quarter'
String ECQ = WebUI.getAttribute(element, 'value')

'TC79.04Verify default value and current quarter value is equal'
WebUI.verifyEqual(CloseQuarter, ECQ)

'TC79.05 Verify `Probability` field has default value `10%`'
WebUI.verifyOptionPresentByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability, false, 
    GlobalVariable.shortDelay)

'Get the last date of current quarter and verify with close date of opportunity'
def LastDate = CustomKeywords.'checkFieldIsRequired.Date.getLastDayOfQuarter'()

TestObject element2 = findTestObject('Sales/Opportunity/CreateOpportunity/CloseDate')

'Get the default value of close date field'
String CloseDate = WebUI.getAttribute(element2, 'value')

'TC79.06 Verify that default value and last date of current quarter is equal'
WebUI.verifyEqual(LastDate, CloseDate)

'TC79.07Verify `Terms and Condition` field has default value `STD`'
WebUI.verifyOptionPresentByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/TermsAndCondition'), TermsAndCondition, 
    false, GlobalVariable.shortDelay)

UserName = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/DropdownName'))

OwnerName = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityOwner'))

'TC79.08 Verify opportunity owner name is equal with the login user'
WebUI.verifyEqual(UserName, OwnerName)

'TC79.09 Verify `Quota Credit Exception` field is not checked'
WebUI.verifyElementNotChecked(findTestObject('Sales/Opportunity/CreateOpportunity/QuotaCreditException'), GlobalVariable.shortDelay)

'TC98.01 Verify AxName is present below the opportunity owner'
WebUI.callTestCase(findTestCase('IPRecordType/TC_VerifyElementPosition'), [:], FailureHandling.STOP_ON_FAILURE)

