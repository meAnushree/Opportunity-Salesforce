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

'Condition statement is use for Record Type - IP  and print specific datas for it'
WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Foundry'), foundry, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Process'), process, false)

'IP Product category element use for Record type-IP'
TestObject testObj1 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/IPProductCategory')

List<WebElement> element = WebUI.findWebElements(testObj1, 10)

println(element.size())

element.get(1).click()

WebUI.delay(2)

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddIPProductBtn'))

'Competitor element use for Record type-IP'
TestObject testObj2 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/Competitor')

List<WebElement> elementsb = WebUI.findWebElements(testObj2, 10)

println(elementsb.size())

elementsb.get(1).click()

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddCompetitorBtn'))

'Compelling Event IP is use for Record type - IP'
WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/CompellingEventIP'), compellingEventIP, FailureHandling.OPTIONAL)

