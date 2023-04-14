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
import org.openqa.selenium.WebElement as WebElement

not_run: WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(GlobalVariable.shortDelay)

if (WebUI.verifyElementVisible(findTestObject('Sales/Common/ProfilePageSteps/UserDropdown'), FailureHandling.OPTIONAL )) {
    'LogIn with `Eric Suss` user'
    WebUI.callTestCase(findTestCase('OpportunityPage/TC_Impersonation'), [('Search') : 'Eric Suss'], FailureHandling.STOP_ON_FAILURE)
}

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

//int window = WebUI.getWindowIndex()
'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), ChildAcName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ExpectedCloseQuarter'), ECQ)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Region'), Region, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/TermsAndCondition'), TermsCondition, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/TCV(USD)'), TcvUsd)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Term(Month)'), TermMonths)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ProposedDiscount'), ProposedDiscount)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType'), TransactionType, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/DealReviewType'), DealReviewType, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Status'), Status, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMeur'), PotentialMeur, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Foundry'), Foundry, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Process'), Proces, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Competitor'), Competitor, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddCompetitorBtn'))

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/CompellingEventIP'), CompellingEventIP, false)

if (TransactionType == 'IP') {
    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/IPProductCategory'), IPProductCategory, 
        false, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddIPProductBtn'))
}

if (TransactionType == 'IP - Tensilica') {
    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/IPTensilicaProductCategory'), IPTensilicaProductCategory, 
        false, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddIPTensilicaProductBtn'))
}

Probability = Probability.replaceAll('%', '')

Probability = Integer.parseInt(Probability)

if (Probability >= 30) {
    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), DealStartDate)

    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), BillingPlan, false)

    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/PaymentTerms'), PaymentTerms, false)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/CashReceiptInQ0'), CashReceiptInQ0)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'))

    'Switch the window '
    WebUI.switchToWindowIndex(window + 1)

    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), AxName)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

    WebUI.switchToWindowIndex(window + 1)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

    WebUI.switchToWindowIndex(window)

    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/EndProductSegment'), EndProductSegment, 
        false, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddEndProductSegmentBtn'))
}

if (Probability >= 50) {
    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMEA'), PotentialMEA, false)
}

if (Probability >= 100) {
    WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/ImpactWonLostReason'), WonLostReason)

    WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/WonOrLoss'), WonOrLoss, false, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddWonOrLossbtn'))
}

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

not_run: OpportunityId = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityID'))

not_run: return OpportunityId

