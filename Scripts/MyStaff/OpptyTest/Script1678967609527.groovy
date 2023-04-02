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

flag = objectType

if (objectType == 'Opportunities') {
    WebUI.click(findTestObject('OpportunityPage/Steps/Opportunities'))

    WebUI.click(findTestObject('OpportunityPage/Steps/NewButton' //WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddIPProductBtn'))
            ))
} else if (objectType == 'Accounts') {
    WebUI.callTestCase(findTestCase('MyStaff/AccountTab'), [('ParentAcName') : parentAcName, ('recRiskRating') : recRiskRating
            , ('CreditOutlook') : CreditOutlook, ('risk') : risk, ('credit') : credit], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OpportunityPage/AccountSelectTab/NewOpportunity'))
}

//String RecordType = 'SW & HW & Serv'
'Selecting Record Type Opportunity from Datafiles'
WebUI.click(findTestObject('OpportunityPage/Steps/IPRecordType', [('value') : RecordType]))

WebUI.click(findTestObject('OpportunityPage/continue'))

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probability, false)

WebUI.click(findTestObject('OpportunityPage/IFrames/ParentAcLookUp'))

WebUI.switchToWindowIndex(i = (i + 1))

'Typing Parent Account Name'
WebUI.setText(findTestObject('OpportunityPage/IFrames/TextInput'), parentAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))

'Typing Child account Name\r\n'
WebUI.setText(findTestObject('OpportunityPage/IFrames/ChildAcName'), childAcName)

WebUI.click(findTestObject('OpportunityPage/IFrames/CAccountNameLookup'))

WebUI.switchToWindowIndex(i = (i + 1))

WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

WebUI.switchToWindowIndex(i = (i - 1))


if (ExpectedCloseQuarter == ECQ1) {
} else if (ExpectedCloseQuarter == ECQ2) {
    WebUI.click(findTestObject('OpportunityPage/IFrames/ExpectedCloseQuarterLookUp'), FailureHandling.STOP_ON_FAILURE)

    WebUI.switchToWindowIndex(i = (i + 1))

    WebUI.setText(findTestObject('OpportunityPage/IFrames/TextInput'), ExpectedCloseQuarter)

    WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))

    WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))

    WebUI.switchToWindowIndex(i = (i - 1))
}

not_run: WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/ProbabilityHelpText'))

not_run: WebUI.check(findTestObject('OpportunityPage/CreateOpportunity/ProbabilityHelpTestCheck', [('Value') : probabilityHelpText]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

WebUI.verifyTextPresent(error, false)


'Common data for two opportunity record type have written from rows 16 to 22'
WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), tcvUsd)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TermMonths'), termMonths)

WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ProposedDiscount'), proposedDiscount)

WebUI.selectOptionByValue(findTestObject('Object Repository/OpportunityPage/status'), Status, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Region'), region, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), transactionType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/DealReviewType'), dealReviewType, false)

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMeur'), potentialMeur, false)

if (probability >= '30%') {
	if (RecordType == 'SW & HW & Serv') {
		WebUI.callTestCase(findTestCase('OpportunityPage/dataFieldsFor100PercentProbability'), [('probability') : probability, ('DealStartDate') : DealStartDate
				, ('SystemTcv') : SystemTcv, ('comittedSystemTCV') : comittedSystemTCV, ('CfdTcv') : CfdTcv, ('committedCfdTcv') : committedCfdTcv
				, ('potentialMea') : potentialMea, ('billingPlan') : billingPlan, ('serviceMargin') : serviceMargin, ('cashReceiptQ0') : cashReceiptQ0],
			FailureHandling.STOP_ON_FAILURE // WebUI.maximizeWindow()
			)
	} else if (RecordType == 'IP') {
		WebUI.selectOptionByLabel(findTestObject('OpportunityPage/CreateOpportunity/AxName'), axName, false)

		WebUI.click(findTestObject('OpportunityPage/IFrames/AxUserLookUp'))

		WebUI.switchToWindowIndex(i = (i + 1))
		
		WebUI.maximizeWindow()
		
		WebUI.clearText(findTestObject('OpportunityPage/IFrames/TextInput'))
		
		WebUI.setText(findTestObject('OpportunityPage/IFrames/TextInput'), AxUserName)
		
		WebUI.click(findTestObject('OpportunityPage/IFrames/Go'))
		
		WebUI.click(findTestObject('OpportunityPage/IFrames/ResultSelect'))
		
		WebUI.switchToWindowIndex(i = (i - 1))
		

		//WebUI.scrollToElement(findTestObject('OpportunityPage/CreateOpportunity/SearchAxUserName', [('Value') : AxUserName]), GlobalVariable.shortDelay, FailureHandling.OPTIONAL)

		//WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/SearchAxUserName', [('Value') : AxUserName]))

		//WebUI.switchToWindowIndex(i = (i - 1))
	}
}


if ((Status != 'Active') || 'Won') {
    if (RecordType == 'IP') {
        TestObject testObj4 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/WonLostReason')

        List<WebElement> elementsd = WebUI.findWebElements(testObj4, 10)

        println(elementsd.size())

        elementsd.get(2).click()

        WebUI.delay(2)

        WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddWonLostReasonBtn'))

        WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/LostReasonComment'), comment)
    }
}

'Condition statement is use for Record Type - IP  and print specific datas for it'
if (RecordType == 'IP') {
    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Foundry'), foundry, false)

    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Process'), process, false)

    'IP Product category element use for Record type-IP'
    TestObject testObj1 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/IPProductCategory')

    List<WebElement> elementsa = WebUI.findWebElements(testObj1, 10)

    println(elementsa.size())

    elementsa.get(1).click()

    WebUI.delay(2)

    WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddIPProductBtn'))

    'Competitor element use for Record type-IP'
    TestObject testObj2 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/Competitor')

    List<WebElement> elementsb = WebUI.findWebElements(testObj2, 10)

    println(elementsb.size())

    elementsb.get(1).click()

    WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddCompetitorBtn'))

    'Compelling Event IP is use for Record type - IP'
    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/CompellingEventIP'), compellingEventIP, false)
} else if (RecordType == 'SW & HW & Serv') {
    'Condition statement is use for Record Type - SW & HW & Serv   and print specific datas for it'
    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DefaultDiscount'), defaultDiscount)

    WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/LineLevelDiscount'), lineLevelDiscount, false)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), softwareTCV)

    WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), serviceTCV)

    'Condition statement is use for transaction type-Hardware - Lease & Hardware - 99 Year   and print specific datas for it'
    if ((transactionType == 'Hardware - 99 Year') || (transactionType == 'Hardware - Lease')) {
        WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/HwPlatform'), hwPlatform, false)

        WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Series'), series, false)

        WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/Domains'), domains)

        WebUI.setText(findTestObject('OpportunityPage/quantity'), quantity)

        WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/RequestedDeliveryDate'), ReqDeliveryDate)
    }
    
    'Condition statement is use for transaction Type - Cadence Cloud & Serv   and print specific datas for it'
    if ((transactionType == 'Cadence Cloud') || (transactionType == 'Serv')) {
        TestObject testObj = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/ServiceType')

        List<WebElement> elements = WebUI.findWebElements(testObj, 10)

        println(elements.size())

        elements.get(1).click()

        WebUI.click(findTestObject('Object Repository/OpportunityPage/CreateOpportunity/AddServiveTypeBtn'))
    }
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

'verification for newly created element'
not_run: WebUI.verifyElementVisible(findTestObject('OpportunityPage/verifyOpportunityName'), FailureHandling.OPTIONAL)

not_run: WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/OpportunityId'))

if (objectType == 'Accounts') {
    WebUI.callTestCase(findTestCase('MyStaff/AccountOpptyVerificationAfterCreation'), [('creditStatus') : creditStatus, ('recRiskRating') : recRiskRating], 
        FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.callTestCase(findTestCase('OpportunityPage/TC04_EditOpportunityPage'), [('ExOppty') : 'International Green Chip_Q1-2024_Cadence Cloud'
            , ('tcvUsd') : '70000', ('recRiskRating') : 'E', ('creditStatus') : 'Approved', ('serviceTCV') : '0', ('softwareTCV') : '70000'], 
        FailureHandling.STOP_ON_FAILURE)
} else if (objectType == 'Opportunities') {
    WebUI.callTestCase(findTestCase('MyStaff/OpptyVerificationAfterCreation'), [('creditStatus') : creditStatus], FailureHandling.STOP_ON_FAILURE)
}

if (creditStatus == 'Pending Credit Review') {
    WebUI.verifyElementVisible(findTestObject('OpportunityPage/CreateOpportunity/WarningMessage'))

    not_run: WebUI.verifyEqual(wrmessage, warnmessage /*if (objectType == 'Accounts') {
		WebUI.callTestCase(findTestCase('MyStaff/AccountOpptyVerificationAfterCreation'), [('creditStatus') : creditStatus, ('recRiskRating') : recRiskRating],
			FailureHandling.STOP_ON_FAILURE)
	
		not_run: WebUI.callTestCase(findTestCase('OpportunityPage/TC04_EditOpportunityPage'), [('ExOppty') : 'International Green Chip_Q1-2024_Cadence Cloud'
				, ('tcvUsd') : '70000', ('recRiskRating') : 'E', ('creditStatus') : 'Approved', ('serviceTCV') : '0', ('softwareTCV') : '70000'],
			FailureHandling.STOP_ON_FAILURE)
	} else if (objectType == 'Opportunities') {
		WebUI.callTestCase(findTestCase('MyStaff/OpptyVerificationAfterCreation'), [('creditStatus') : creditStatus], FailureHandling.STOP_ON_FAILURE)
	}*/ )
} else if (creditStatus != 'Pending Credit Review') {
    WebUI.verifyElementNotVisible(findTestObject('OpportunityPage/CreateOpportunity/WarningMessageNotVisible'))
}

not_run: st = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/StatusAfterOpptyCreation'))

not_run: WebUI.verifyEqual(st, Status)

