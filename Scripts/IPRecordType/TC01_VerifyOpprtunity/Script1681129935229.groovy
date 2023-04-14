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

WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(GlobalVariable.shortDelay)

WebUI.callTestCase(findTestCase('Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Get value from excel file'
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/Profiles/ProfileDetails', 'Sales Operations Clone', 
    'Type')

opClone = findTestData('Sales/Profiles/ProfileDetails').getValue('Profile', user)

'Clicking on `2_5 - Sales OperationsClone` profile '
WebUI.callTestCase(findTestCase('Common/TC_Impersonation'), [('profileList') : opClone], FailureHandling.STOP_ON_FAILURE)

'TC80 User can fill the data in this fields'
WebUI.callTestCase(findTestCase('OpportunityPage/TC_IPOpportunity'), [('User') : 'Eric Suss', ('RecordType') : 'IP', ('ParentAcName') : ParentAcName
        , ('ChildAcName') : ChildAcName, ('ECQ') : ECQ, ('Probability') : Probability, ('Region') : Region, ('TermsCondition') : TermsCondition
        , ('TcvUsd') : TcvUsd, ('TermMonths') : TermMonths, ('ProposedDiscount') : ProposedDiscount, ('TransactionType') : TransactionType
        , ('DealReviewType') : DealReviewType, ('Status') : Status, ('PotentialMeur') : PotentialMeur, ('IPProductCategory') : IPProductCategory
        , ('IPTensilicaProductCategory') : IPTensilicaProductCategory, ('Foundry') : Foundry, ('Proces') : Proces, ('Competitor') : Competitor
        , ('CompellingEventIP') : CompellingEventIP, ('DealStartDate') : '2023/4/6', ('BillingPlan') : BillingPlan, ('PaymentTerms') : PaymentTerms
        , ('CashReceiptInQ0') : CashReceiptInQ0, ('AxName') : AxName, ('EndProductSegment') : EndProductSegment, ('PotentialMEA') : PotentialMEA
        , ('WonLostReason') : WonLostReason, ('WonOrLoss') : WonOrLoss], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sales/Opportunity/EditOpportunityPage/EditBtn'))

'TC 1.03 Change the value of probability'
WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability1, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), DealStartDate)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), BillingPlan, false)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/PotentialMEA'), PotentialMEA, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/EndProductSegment'), EndProductSegment, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddEndProductSegmentBtn'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'TC1, TC96.02 Verify that `AX Name` comes up with an error'
WebUI.verifyElementVisible(findTestObject('Sales/Opportunity/EditOpportunityPage/AXUserErrMsg', [('message') : AXError]))

'TC 1.04 Change the value of probability'
WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability2, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'TC1, TC96.02 Verify that `AX Name` comes up with an error'
WebUI.verifyElementVisible(findTestObject('Sales/Opportunity/EditOpportunityPage/AXUserErrMsg', [('message') : AXError]))

'TC99.02 Verify AX Name field is visible'
WebUI.verifyElementVisible(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'))

int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'TC 1.06, TC2.01 Set the AX Name in opportunity'
WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), AxName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

WebUI.switchToWindowIndex(window + 1)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

'TC107.03 Verify foundry field has NA option'
WebUI.verifyOptionPresentByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Foundry'), FoundryValue, false, GlobalVariable.shortDelay, 
    FailureHandling.STOP_ON_FAILURE)

'TC 74.02 Verify all the transaction type of IP record type opportunity'
WebUI.callTestCase(findTestCase('Common/TC_CheckFieldsOptions'), [('COLUMN') : 'Process', ('XPATH') : 'Sales/Opportunity/CreateOpportunity/Process'], FailureHandling.STOP_ON_FAILURE)

'TC108.04, TC109.03 Verify all the process options of IP record type opportunity'
WebUI.callTestCase(findTestCase('Common/TC_CheckFieldsOptions'), [('COLUMN') : 'TransactionTypeIP', ('XPATH') : 'Sales/Opportunity/CreateOpportunity/TransactionType'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'Get the opportunity id after creating a new opportunity'
OpportunityId = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityID'))

'Return the value of opportunity id'
return OpportunityId

