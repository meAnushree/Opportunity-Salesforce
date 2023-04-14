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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.shortDelay)

WebUI.setText(findTestObject('Sales/Common/Global/GlobalSearchBox'), Search)

WebUI.click(findTestObject('Sales/Common/Global/GlobalSearchBtn'))

WebUI.scrollToElement(findTestObject('Sales/Common/Profiles/People'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Common/Profiles/People'))

WebUI.click(findTestObject('Sales/Common/Steps/UserActionMenu'))

WebUI.delay(GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Common/Steps/UserDetail'))

'LogIn with the user Eric Suss'
WebUI.click(findTestObject('Sales/Common/Steps/LogInBtn'))

WebUI.delay(GlobalVariable.shortDelay)

'Click on "+" icon'
WebUI.click(findTestObject('Sales/Accounts/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/RecordType', [('type') : RecordType]))

WebUI.click(findTestObject('Sales/Common/Steps/ContinueBtn'))

WebUI.click(findTestObject('Sales/Common/IFrames/ParentAcLookUp'))

int window = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(window + 1)

'Set text in parent account name field'
WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), ParentAcName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

WebUI.switchToWindowIndex(window + 1)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AccountName'))

'Get the index of the present window'

//int window = WebUI.getWindowIndex()
'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), ChildAcName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter'), ECQ)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Status'), Status, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/TCV(USD)'), TcvUsd)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Term(Month)'), TermMonths)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ProposedDiscount'), ProposedDiscount)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DefaultDiscount'), DefaultDiscount)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/LineLevelDiscount'), LineLevelDiscount, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Region'), Region, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType'), TransactionType, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/DealReview'), DealReview, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/TermsAndCondition'), TermsCondition, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/MEU'), PotentialMeur, false)

'Condition statement is use for transaction Type - Cadence Cloud & Serv'
if ((TransactionType == 'Cadence Cloud') || (TransactionType == 'Serv')) {
    WebUI.selectOptionByValue(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/HwPlatform'), HwPlatform, 
        false)

    WebUI.selectOptionByValue(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/Series'), Series, false)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/ServiceType'), ServiceType, 
        false)

    WebUI.click(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/AddServiceTypeBtn'))

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/SoftwareTcvUsd'), SoftwareTCV)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ServicesTcvUsd'), ServiceTCV)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Domains'), Domains)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Quantity'), Quantity)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/RequestedDeliveryDate'), RequestedDeliveryDate)
}

'Condition statement is use for transaction Type - Hardware - 99 Year & Hardware - Lease'
if ((TransactionType == 'Hardware - 99 Year') || (TransactionType == 'Hardware - Lease')) {
    not_run: WebUI.selectOptionByLabel(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/ServiceType'), 
        ServiceType, false)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddServiceTypeBtn'))

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/HwPlatform'), HwPlatform, false)

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Series'), Series, false)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Domains'), Domains)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Quantity'), Quantity)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/RequestedDeliveryDate'), RequestedDeliveryDate)
}
Probability = Probability.replaceAll('%', '')
Probability = Integer.parseInt(Probability)
if (Probability >= 30) {
    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), DealStartDate)

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), BillingPlan, false)

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PaymentTerms'), PaymentTerms, false)

    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/CompellingEvent'), CompellingEvent, false)

    WebUI.click(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/AddCompellingEvent'))

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CashReceiptInQ0'), CashReceiptInQ0)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/SystemTcv'), SystemTcv)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedSystemTcv'), CommittedSystemTcv)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CfdTcv'), CfdTcv)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CommittedCfdTcv'), CommittedCfdTcv)
}

if (Probability >= 65) {
    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/RiskIssue'), RiskIssue, false)

    WebUI.click(findTestObject('Object Repository/Sales/Opportunity/CreateOpportunity/AddRiskIssueBtn'))

    WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMEA'), PotentialMEA, false)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ServiceMargin'), ServiceMargin)
}

if (Probability >= 100) {
    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ImpactWonLostReason'), WonLostReason)
}

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

OpportunityId = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityID'))

return OpportunityId

