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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(Url)

WebUI.setText(findTestObject('Sales/Common/LogInPage/UserName'), Email)

WebUI.setText(findTestObject('Sales/Common/LogInPage/Password'), Password)

WebUI.click(findTestObject('Sales/Common/LogInPage/SignInBtn'))

/*if(type=='lightning') {

WebUI.click(findTestObject('Opportunity/clickSetting'))
WebUI.click(findTestObject('Sales/Common/LogInPage/SwitchToClassic'))
}*/
WebUI.click(findTestObject('Sales/Common/LogInPage/InternalCosSupportAdmin'))

WebUI.click(findTestObject('Sales/Common/LogInPage/LogOut'))

WebUI.click(findTestObject('Sales/Common/LogInPage/Environment', [('Value') : sForceType]))

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.click(findTestObject('Sales/Common/Impersonation/AllTab'))

WebUI.click(findTestObject('Sales/Common/Impersonation/ChatterTab'))

WebUI.click(findTestObject('Sales/Common/Impersonation/People'))

WebUI.click(findTestObject('Sales/Common/Impersonation/User', [('Value') : user]))

WebUI.click(findTestObject('Sales/Common/Impersonation/UserActionMenu'))

WebUI.click(findTestObject('Sales/Common/Impersonation/UserDetail'))

WebUI.click(findTestObject('Sales/Common/Impersonation/LogInUser'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

//String RecordType = 'SW & HW & Serv'
'Selecting Record Type Opportunity from Datafiles'
WebUI.click(findTestObject('Sales/Common/Steps/IPRecordType', [('value') : RecordType]))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Continue'))

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability, false)

WebUI.click(findTestObject('Sales/Common/IFrames/ParentAcLookUp'))

WebUI.switchToWindowIndex(i = (i + 1))

'Typing Parent Account Name'
WebUI.setText(findTestObject('Sales/Common/IFrames/ParentAcName'), ParentAcName)

WebUI.click(findTestObject('Sales/Common/IFrames/Go'))

WebUI.click(findTestObject('Sales/Common/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

'Typing Child account Name\r\n'
WebUI.setText(findTestObject('Sales/Common/IFrames/ChildAcName'), ChildAcName)

WebUI.click(findTestObject('Sales/Common/IFrames/CAccountNameLookup'))

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.click(findTestObject('Sales/Common/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

if (ExpectedCloseQuarter == ECQ) {
    WebUI.click(findTestObject('Sales/Common/IFrames/ExpectedCloseQuarterLookUp'), FailureHandling.STOP_ON_FAILURE)

    WebUI.switchToWindowIndex(i = (i + 1))

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/SetTextExpectedCloseQuarter'), ExpectedCloseQuarter)

    WebUI.click(findTestObject('Sales/Common/IFrames/Go'))

    WebUI.click(findTestObject('Sales/Common/IFrames/ResultSelect'))

    WebUI.switchToWindowIndex(i = (i - 1))
}

'Common data for two opportunity record type have written from rows 16 to 22'
WebUI.setText(findTestObject('null'), TcvUsd)

WebUI.setText(findTestObject('null'), TermMonths)

WebUI.setText(findTestObject('null'), ProposedDiscount)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Status'), Status, false)

WebUI.selectOptionByValue(findTestObject('null'), Region, false)

WebUI.selectOptionByValue(findTestObject('null'), TransactionType, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/DealReviewType'), DealReviewType, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMeur'), PotentialMeur, false)

if (Probability >= '30%') {
    if (RecordType == 'SW & HW & Serv') {
        WebUI.callTestCase(findTestCase('OpportunityPage/dataFieldsFor100PercentProbability'), [('probability') : Probability, ('DealStartDate') : DealStartDate
                , ('SystemTcv') : SystemTcv, ('comittedSystemTCV') : ComittedSystemTCV, ('CfdTcv') : CfdTcv, ('committedCfdTcv') : CommittedCfdTcv
                , ('potentialMea') : PotentialMea, ('billingPlan') : BillingPlan, ('serviceMargin') : ServiceMargin, ('cashReceiptQ0') : cashReceiptQ0], 
            FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.setText(findTestObject('null'), DefaultDiscount)

WebUI.selectOptionByValue(findTestObject('null'), LineLevelDiscount, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/SoftwareTcvUsd'), SoftwareTcvUsd)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ServicesTcvUsd'), ServicesTcvUsd)

'Condition statement is use for transaction type-Hardware - Lease & Hardware - 99 Year   and print specific datas for it'
if ((TransactionType == 'Hardware - 99 Year') || (TransactionType == 'Hardware - Lease')) {
    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/HwPlatform'), HwPlatform, false)

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Series'), Series, false)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Domains'), Domains)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Quantity'), Quantity)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/RequestedDeliveryDate'), RequestedDeliveryDate)
}

'Condition statement is use for transaction Type - Cadence Cloud & Serv   and print specific datas for it'
if ((TransactionType == 'Cadence Cloud') || (TransactionType == 'Serv')) {
    TestObject testObj = findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/ServiceType')

    List<WebElement> elements = WebUI.findWebElements(testObj, 10)

    println(elements.size())

    elements.get(1).click()

    WebUI.click(findTestObject('Opportunity/Add'))
}

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

String cs = WebUI.getText(findTestObject('Sales/Opportunity/OpportunityCreditStatus/CreditStatus'))

if (CreditStatus == 'Not Applicable') {
    CreditStatus = ' '
}

WebUI.verifyEqual(cs, CreditStatus)

