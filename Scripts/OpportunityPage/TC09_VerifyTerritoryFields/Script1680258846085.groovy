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

WebUI.comment('TC174.01')

WebUI.callTestCase(findTestCase('OpportunityPage/TC01_LogIn'), [('url') : url, ('email') : email, ('password') : password
        , ('environment') : environment], FailureHandling.STOP_ON_FAILURE)

'This will navigate home page to profile page'
WebUI.callTestCase(findTestCase('OpportunityPage/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Get value from excel file'
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/OpportunityCreate/Profiles', 'Sales Operations Clone', 
    'Type')

salesOp = findTestData('OpportunityCreate/Profiles').getValue('Profile', user)

'Clicking on `Sytem Administrator Custom` profile '
WebUI.callTestCase(findTestCase('OpportunityPage/Common/TC_Impersonation'), [('profileList') : salesOp], FailureHandling.STOP_ON_FAILURE)


WebUI.comment('TC174.02, TC174.03')

'Create a new opportunity in the same parent account'
WebUI.callTestCase(findTestCase('OpportunityPage/TC_CreateOpportunities'), [('accountName') : accountName, ('tcv') : tcv
        , ('term') : term, ('proposedDiscount') : proposedDiscount, ('defaultDiscount') : defaultDiscount, ('lineLevelDiscount') : lineLevelDiscount
        , ('region') : region, ('transactionType') : transactionType1, ('dealReview') : dealReview, ('meu') : meu], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC174.03')

oportunityName = WebUI.getText(findTestObject('OpportunityPage/EditOpportunityPage/NewOpportunityCreated'))

WebUI.verifyTextPresent(oportunityName, false)

