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

WebUI.click(findTestObject('Sales/Common/Steps/Opportunities'))

WebUI.click(findTestObject('Sales/Common/Steps/NewButton'))

'TC115 - Opportunity record type check here, type should be SW, HW & Serv.'
WebUI.click(findTestObject('Sales/Common/Steps/RecordTypeOpportunity', [('value') : recordType]))

WebUI.click(findTestObject('Sales/Opportunity/CreateOpportunity/Continue'))

'Custom xpath for record type'
String xpath = ('//td[@class=\'dataCol\' and contains(.,\'' + recordType) + '\')]'

println(xpath)

TestObject typeOfRecord = new TestObject('objectName')

typeOfRecord.addProperty('xpath', ConditionType.EQUALS, xpath)

'Check record type'
WebUI.verifyElementVisible(typeOfRecord, FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

