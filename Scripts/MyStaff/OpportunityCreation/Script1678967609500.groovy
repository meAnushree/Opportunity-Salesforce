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

WebUI.setText(findTestObject('OpportunityPage/LogInPage/UserName'), Email)

WebUI.setText(findTestObject('OpportunityPage/LogInPage/Password'), Password)

WebUI.click(findTestObject('OpportunityPage/LogInPage/SignInBtn'))

/*if(type=='lightning') {

WebUI.click(findTestObject('OpportunityPage/clickSetting'))
WebUI.click(findTestObject('OpportunityPage/LogInPage/SwitchToClassic'))
}*/
WebUI.click(findTestObject('OpportunityPage/LogInPage/InternalCosSupportAdmin'))

WebUI.click(findTestObject('OpportunityPage/LogInPage/LogOut'))

WebUI.click(findTestObject('OpportunityPage/LogInPage/Environment', [('Value') : sForceType]))

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.click(findTestObject('OpportunityPage/Impersonation/AllTab'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/ChatterTab'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/People'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/User', [('Value') : user]))

WebUI.click(findTestObject('OpportunityPage/Impersonation/UserActionMenu'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/UserDetail'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/LogInUser'))

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/Steps/NewButton'))

//String RecordType = 'SW & HW & Serv'
'Selecting Record Type Opportunity from Datafiles'
WebUI.click(findTestObject('OpportunityPage/Steps/IPRecordType', [('value') : RecordType]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Continue'))

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), Probability, false)

WebUI.click(findTestObject('OpportunityPage/IFrames/ParentAcLookUp'))

WebUI.switchToWindowIndex(i = (i + 1))

'Typing Parent Account Name'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ParentAcName'), ParentAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

'Typing Child account Name\r\n'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ChildAcName'), ChildAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/CAccountNameLookup'))

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

if (ExpectedCloseQuarter == ECQ) {
    WebUI.click(findTestObject('OpportunityPage/IFrames/ExpectedCloseQuarterLookUp'), FailureHandling.STOP_ON_FAILURE)

    WebUI.switchToWindowIndex(i = (i + 1))

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SetTextExpectedCloseQuarter'), ExpectedCloseQuarter)

    WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

    WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

    WebUI.switchToWindowIndex(i = (i - 1))
}

'Common data for two opportunity record type have written from rows 16 to 22'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), TcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TermMonths'), TermMonths)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ProposedDiscount'), ProposedDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Status'), Status, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Region'), Region, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), TransactionType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/DealReviewType'), DealReviewType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMeur'), PotentialMeur, false)

if (Probability >= '30%') {
    if (RecordType == 'SW & HW & Serv') {
        WebUI.callTestCase(findTestCase('OpportunityPage/dataFieldsFor100PercentProbability'), [('probability') : Probability, ('DealStartDate') : DealStartDate
                , ('SystemTcv') : SystemTcv, ('comittedSystemTCV') : ComittedSystemTCV, ('CfdTcv') : CfdTcv, ('committedCfdTcv') : CommittedCfdTcv
                , ('potentialMea') : PotentialMea, ('billingPlan') : BillingPlan, ('serviceMargin') : ServiceMargin, ('cashReceiptQ0') : cashReceiptQ0], 
            FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DefaultDiscount'), DefaultDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/LineLevelDiscount'), LineLevelDiscount, false)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), SoftwareTcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), ServicesTcvUsd)

'Condition statement is use for transaction type-Hardware - Lease & Hardware - 99 Year   and print specific datas for it'
if ((TransactionType == 'Hardware - 99 Year') || (TransactionType == 'Hardware - Lease')) {
    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/HwPlatform'), HwPlatform, false)

    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Series'), Series, false)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Domains'), Domains)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Quantity'), Quantity)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/RequestedDeliveryDate'), RequestedDeliveryDate)
}

'Condition statement is use for transaction Type - Cadence Cloud & Serv   and print specific datas for it'
if ((TransactionType == 'Cadence Cloud') || (TransactionType == 'Serv')) {
    TestObject testObj = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/ServiceType')

    List<WebElement> elements = WebUI.findWebElements(testObj, 10)

    println(elements.size())

    elements.get(1).click()

    WebUI.click(findTestObject('OpportunityPage/Add'))
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

String cs = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/CreditStatus'))

if (CreditStatus == 'Not Applicable') {
    CreditStatus = ' '
}

WebUI.verifyEqual(cs, CreditStatus)

