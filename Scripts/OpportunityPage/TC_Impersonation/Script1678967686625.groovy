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

WebUI.setText(findTestObject('Sales/Common/Global/GlobalSearchBox'), Search)

WebUI.click(findTestObject('Sales/Common/Global/GlobalSearchBtn'))

WebUI.scrollToElement(findTestObject('Sales/Common/Profiles/People'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Common/Profiles/People'))

WebUI.waitForElementClickable(findTestObject('Sales/Common/Steps/UserActionMenu'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Common/Steps/UserActionMenu'))

WebUI.delay(GlobalVariable.shortDelay)

WebUI.waitForElementClickable(findTestObject('Sales/Common/Steps/UserDetail'), GlobalVariable.shortDelay)

WebUI.click(findTestObject('Sales/Common/Steps/UserDetail'))

'LogIn with the user Eric Suss'
WebUI.click(findTestObject('Sales/Common/Steps/LogInBtn'))

