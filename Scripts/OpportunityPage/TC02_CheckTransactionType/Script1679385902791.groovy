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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

if (transactionType == 'Cadence Cloud') {
    WebUI.callTestCase(findTestCase('OpportunityPage/TC_Impersonation'), [('user') : 'Puchta, Evelyn'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.comment('TC114, TC115')

WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

WebUI.click(findTestObject('OpportunityPage/Steps/NewButton'))

WebUI.click(findTestObject('OpportunityPage/Steps/IPRecordType', [('value') : recordType]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Continue'))

String xpath = ('//td[@class=\'dataCol\' and contains(.,\'' + recordType) + '\')]'

println(xpath)

TestObject typeOfRecord = new TestObject('objectName')

typeOfRecord.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.verifyElementVisible(typeOfRecord, FailureHandling.OPTIONAL)

WebUI.verifyOptionPresentByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), transactionType, false, 
    GlobalVariable.shortDelay)
