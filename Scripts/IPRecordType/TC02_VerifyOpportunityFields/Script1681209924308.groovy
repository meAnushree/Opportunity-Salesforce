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

not_run: WebUI.callTestCase(findTestCase('Common/TC_LogIn'), [('url') : 'https://cadence.oktapreview.com/', ('email') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234', ('environment') : 'SBX'], FailureHandling.STOP_ON_FAILURE)

'TC76.02 Verify all mandatory fields'
WebUI.callTestCase(findTestCase('IPRecordType/TC_CheckRequiredFields'), [('value') : 'div[@class=\'requiredInput\']'], FailureHandling.STOP_ON_FAILURE)




'TC76.03, TC80.02 Fill all the required fields'
WebUI.callTestCase(findTestCase('OpportunityPage/TC_IPOpportunity'), [('User') : 'Eric Suss', ('RecordType') : 'IP', ('ParentAcName') : ParentAcName
        , ('ChildAcName') : ChildAcName, ('ECQ') : ECQ, ('Probability') : Probability, ('Region') : Region, ('TermsCondition') : 'STD'
        , ('TcvUsd') : TcvUsd, ('TermMonths') : TermMonths, ('ProposedDiscount') : ProposedDiscount, ('TransactionType') : TransactionType
        , ('DealReviewType') : DealReviewType, ('Status') : 'Active', ('PotentialMeur') : PotentialMeur, ('IPProductCategory') : IPProductCategory
        , ('IPTensilicaProductCategory') : IPTensilicaProductCategory, ('Foundry') : '--None--', ('Proces') : '--None--'
        , ('Competitor') : Competitor, ('CompellingEventIP') : '--None--', ('DealStartDate') : DealStartDate, ('BillingPlan') : '--None--'
        , ('PaymentTerms') : '--None--', ('CashReceiptInQ0') : CashReceiptInQ0, ('AxName') : AxName, ('EndProductSegment') : EndProductSegment
        , ('PotentialMEA') : '--None--', ('WonLostReason') : WonLostReason, ('WonOrLoss') : WonOrLoss], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Sales/Opportunity/CreateOpportunity/Probability'), Probability2, false)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/DealStartDate'), DealStartDate)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'TC76.05, TC96.03 Verify that `Foundry` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'FoundryErrMsg', 
    'Condition')

FoundryMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/Foundry')
        , ('value') : value, ('ErrMsg') : FoundryMsg], FailureHandling.STOP_ON_FAILURE)

'TC76.06, TC96.03 Verify that `Process` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'ProcessErrMsg', 
    'Condition')

ProcessMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/Process')
        , ('value') : value, ('ErrMsg') : ProcessMsg], FailureHandling.STOP_ON_FAILURE)

'TC96.03, TC112, TC113 Verify that `Process` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'EndProductErrMsg', 
    'Condition')

EndProductMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/EndProductSegment')
        , ('value') : value, ('ErrMsg') : EndProductMsg], FailureHandling.STOP_ON_FAILURE)

'TC77.02, TC96.03 Verify that `IP Product Category` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'IPProductCategoryErrMsg', 
    'Condition')

IPMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/IPProductCategory')
        , ('value') : value, ('ErrMsg') : IPMsg], FailureHandling.STOP_ON_FAILURE)

'TC96.03 Verify that `BillingPlan` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'BillingErrMsg', 
    'Condition')

BillingMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan')
        , ('value') : value, ('ErrMsg') : BillingMsg], FailureHandling.STOP_ON_FAILURE)

'TC76.07, TC96.03 Verify that `Competitor` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'CompetitorErrMsg', 
    'Condition')

CompetitorMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/Competitor')
        , ('value') : value, ('ErrMsg') : CompetitorMsg], FailureHandling.STOP_ON_FAILURE)

'TC76.08, TC96.03 Verify that `Compelling Event IP` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'CompellingEventIpErrMsg', 
    'Condition')

EventIPMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/CompellingEventIP')
        , ('value') : value, ('ErrMsg') : EventIPMsg], FailureHandling.STOP_ON_FAILURE)

'Add the value in foundry field'
WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Foundry'), Foundry, false)

'Add the value in process field'
WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Process'), Proces, false)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/EndProductSegment'), EndProductSegment, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddEndProductSegmentBtn'))

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/IPProductCategory'), IPProductCategory2, false, 
    FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddIPProductBtn'))

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/BillingPlan'), BillingPlan, false)

'Add the value in competitor field'
WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/Competitor'), Competitor2, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddCompetitorBtn'))

'Add the value in compelling event ip field'
WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/CompellingEventIP'), CompellingEventIP, false)

'TC78.02 Change the transaction type'
WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/TransactionType'), TransactionType2, false)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'TC78.03 Verify that `IP Tensilica Product Category` field comes up with an error'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/Sales/OpportunityCreate/Messages', 'IPTensilicaCategoryErrMsg', 
    'Condition')

IPTensilicaMsg = findTestData('Sales/OpportunityCreate/Messages').getValue('Message', message)

WebUI.callTestCase(findTestCase('Common/TC_VerifyField'), [('testObj') : findTestObject('Sales/Opportunity/CreateOpportunity/IPTensilicaProductCategory')
        , ('value') : value, ('ErrMsg') : IPTensilicaMsg], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Sales/Opportunity/CreateOpportunity/IPTensilicaProductCategory'), IPTensilicaProductCategory2, 
    false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AddIPTensilicaProductBtn'))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/AxNameLookupBtn'))

int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

WebUI.setText(findTestObject('Sales/Opportunity/CreateOpportunity/Lookup'), AxName)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/GoButton'))

WebUI.switchToWindowIndex(window + 1)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/LookupResult'))

WebUI.switchToWindowIndex(window)

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Save'))

'Get the opportunity name after creation'
Name = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpptyNameAfterCreation'))

OpportunityName = ((((ParentAcName + '_') + ECQ) + '_') + TransactionType2)

'TC94.02 Verify opportunity name should be combination of parent account, ecq, transaction type'
WebUI.verifyEqual(Name, OpportunityName)

'Get the opportunity id after creation'
OpportunityId = WebUI.getText(findTestObject('Sales/Opportunity/CreateOpportunity/OpportunityID'))

return OpportunityId

