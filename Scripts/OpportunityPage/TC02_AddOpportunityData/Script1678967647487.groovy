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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('OpportunityPage/TC_Impersonation'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.shortDelay)

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/Steps/NewButton'))

WebUI.comment('TC116')

//String RecordType = 'SW & HW & Serv'
'Selecting record type opportunity from data file'
WebUI.click(findTestObject('OpportunityPage/Steps/IPRecordType', [('value') : recordType]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Continue'))

WebUI.acceptAlert()

WebUI.comment('TC119')

'Verify default value of status field in opportunity creation page'
WebUI.verifyOptionSelectedByValue(findTestObject('OpportunityPage/CreateOpportunity/Status'), status, false, GlobalVariable.shortDelay)

def closequarter = WebUI.getAttribute(findTestObject('OpportunityPage/CreateOpportunity/CloseQuarter'), 'value')

'Verify default input value in expected close quarter field'
WebUI.verifyEqual(closequarter, expectedCloseQuarter, FailureHandling.CONTINUE_ON_FAILURE)

'Verify default value of probability field'
WebUI.verifyOptionSelectedByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probability, false, GlobalVariable.shortDelay)

def closedate = WebUI.getAttribute(findTestObject('OpportunityPage/CreateOpportunity/CloseDate'), 'value')

'Verify default value of close date field'
WebUI.verifyEqual(closedate, cDate, FailureHandling.CONTINUE_ON_FAILURE)

'Verify default value of terms and condition field'
WebUI.verifyOptionSelectedByLabel(findTestObject('OpportunityPage/CreateOpportunity/TermsAndCondition'), termCon, false, GlobalVariable.shortDelay)

owner = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/OpportunityOwner'))

'Verify default value of opportunity owner field'
WebUI.verifyEqual(owner, oppOwner)

//WebUI.verifyElementVisible(findTestObject('OpportunityPage/CreateOpportunity/SystemPriceBookCheckbox'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyElementClickable(findTestObject('OpportunityPage/CreateOpportunity/SystemPriceBookCheckbox'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.mouseOver(findTestObject('OpportunityPage/CreateOpportunity/SystemPriceBookHoverText'))
//
//systempricetext = WebUI.getText(findTestObject('OpportunityPage/CreateOpportunity/SystemPriceBookHoverText'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyEqual(systempricetext, sytemHoverText)
WebUI.click(findTestObject('OpportunityPage/IFrames/ParentAcLookUp'))

int window = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(window + 1)

'Add text parent account name field'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ParentAcName'), parentAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(window)

'Add text child account name field'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ChildAcName'), childAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/CAccountNameLookup'))

WebUI.switchToWindowIndex(window + 1)

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(window)

if (expectedCloseQuarter == ECQ) {
    WebUI.click(findTestObject('OpportunityPage/IFrames/ExpectedCloseQuarterLookUp'), FailureHandling.STOP_ON_FAILURE)

    WebUI.switchToWindowIndex(window + 1)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SetTextExpectedCloseQuarter'), expectedCloseQuarter)

    WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

    WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

    WebUI.switchToWindowIndex(window)
}

WebUI.comment('TC120')

'Add text in tcv(usd) field'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), tcvUsd)

'Add text in term months field'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TermMonths'), termMonths)

'Add text in proposed discount field'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ProposedDiscount'), proposedDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Status'), status, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Region'), region, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), transactionType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/DealReviewType'), dealReviewType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMeur'), potentialMeur, false)

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

WebUI.callTestCase(findTestCase('OpportunityPage/TC_VerifyErrorMessage'), [('message') : error], FailureHandling.STOP_ON_FAILURE)

if (probability >= '30%') {
    if (recordType == 'SW & HW & Serv') {
        WebUI.callTestCase(findTestCase('OpportunityPage/dataFieldsFor100PercentProbability'), [('probability') : probability
                , ('DealStartDate') : dealStartDate, ('SystemTcv') : systemTcv, ('comittedSystemTCV') : cComittedSystemTCV
                , ('CfdTcv') : cfdTcv, ('committedCfdTcv') : committedCfdTcv, ('potentialMea') : potentialMea, ('billingPlan') : billingPlan
                , ('serviceMargin') : serviceMargin, ('cashReceiptQ0') : cashReceiptQ0], FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DefaultDiscount'), defaultDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/LineLevelDiscount'), lineLevelDiscount, false)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), softwareTcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), servicesTcvUsd)

'Condition statement is use for transaction type-Hardware - Lease & Hardware - 99 Year   and print specific datas for it'
if ((transactionType == 'Hardware - 99 Year') || (transactionType == 'Hardware - Lease')) {
    WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

    WebUI.verifyTextPresent(error, false)

    WebUI.comment('TC118')

    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/HwPlatform'), hwPlatform, false)

    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Series'), series, false)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Domains'), domains)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Quantity'), quantity)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/RequestedDeliveryDate'), requestedDeliveryDate)

    if (board == 'Not Applicable') {
        board = ' '
    }
    
    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Board'), board)
}

'Condition statement is use for transaction Type - Cadence Cloud & Serv   and print specific datas for it'
if ((transactionType == 'Cadence Cloud') || (transactionType == 'Serv')) {
    TestObject testObj = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/ServiceType')

    List<WebElement> elements = WebUI.findWebElements(testObj, 10)

    println(elements.size())

    elements.get(1).click()

    WebUI.click(findTestObject('OpportunityPage/Add'))
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

WebUI.comment('TC121')

String oppName = (((parentAcName + '_') + ECQ) + '_') + transactionType

opName = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/OpportunityName'))

'Verify opportunity name after creation'
WebUI.verifyEqual(opName, oppName, FailureHandling.CONTINUE_ON_FAILURE)

