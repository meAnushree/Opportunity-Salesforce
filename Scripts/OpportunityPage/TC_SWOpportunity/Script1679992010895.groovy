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


WebUI.click(findTestObject('OpportunityPage/AccountPageSteps/AllTab'))

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/Steps/NewButton'))

'Selecting Record Type Opportunity from Datafile'
WebUI.click(findTestObject('OpportunityPage/Steps/IPRecordType'))

WebUI.click(findTestObject('OpportunityPage/Steps/ContinueBtn'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ParentAcLookUp'))

int window = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(window + 1)

'Set text in parent account name field'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ParentAcName'), parentAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))
WebUI.switchToWindowIndex(window + 1)


WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(window)

WebUI.click(findTestObject('OpportunityPage/IFrames/CAccountNameLookup'))

WebUI.switchToWindowIndex(window + 1)

'Set text child account name field'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ParentAcName'), childAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))
WebUI.switchToWindowIndex(window + 1)

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(window)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probability, false)

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

'Common data for two opportunity record type have written from rows 16 to 22'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), tcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TermMonths'), termMonths)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ProposedDiscount'), proposedDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Region'), region, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), transactionType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/DealReviewType'), dealReviewType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMeur'), potentialMeur, false)

'Condition statement is use for Record Type - SW & HW & Serv   and print specific datas for it'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DefaultDiscount'), defaultDiscount)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/LineLevelDiscount'), lineLevelDiscount, false)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), softwareTCV)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), serviceTCV)

'Condition statement is use for transaction Type - Cadence Cloud & Serv   and print specific datas for it'
if ((transactionType == 'Cadence Cloud') || (transactionType == 'Serv')) {
    TestObject testObj = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/ServiceType')

    List<WebElement> elements = WebUI.findWebElements(testObj, 10)

    println(elements.size())

    elements.get(1).click()

    WebUI.click(findTestObject('Object Repository/OpportunityPage/CreateOpportunity/AddServiveTypeBtn'))
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

'verification for newly created element'
WebUI.verifyElementVisible(findTestObject('OpportunityPage/verifyOpportunityName'), FailureHandling.OPTIONAL)

id = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/OpportunityId'))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Edit'))

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probSelectAfterOpptyCreation, 
    false)

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/EOpptySelect', [('Value') : eOppty]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Edit'))

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probSelectAfterOpptyCreation, 
    false)

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

