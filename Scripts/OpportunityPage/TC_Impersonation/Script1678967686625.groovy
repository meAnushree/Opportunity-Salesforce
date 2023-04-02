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

not_run: WebUI.setText(findTestObject('OpportunityPage/Impersonation/SearchUser'), '2_2 AX')

not_run: WebUI.click(findTestObject('OpportunityPage/convertToClassic'))

'Click on `+` icon from home page'
WebUI.click(findTestObject('OpportunityPage/Impersonation/AllTab'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/ChatterTab'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/People'))

'Add text in search box in all people page'
WebUI.setText(findTestObject('OpportunityPage/Impersonation/SearchPeople'), user)

'Create custom xpath'
String xpath = ((findTestObject('OpportunityPage/Impersonation/SelectPeople').findPropertyValue('xpath') + '//a[text()=\'') + 
user) + '\']'

println(xpath)

TestObject username = new TestObject('objectName')

username.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.delay(GlobalVariable.shortDelay)

'Click on user `Evelyn Puchta` from people page'
WebUI.click(username)

WebUI.delay(GlobalVariable.shortDelay)

WebUI.click(findTestObject('OpportunityPage/Impersonation/UserActionMenu'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/UserDetail'))

WebUI.click(findTestObject('OpportunityPage/Impersonation/LogInUser'))

