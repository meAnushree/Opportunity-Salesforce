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

not_run: WebUI.click(findTestObject('null', [('Value') : ExOppty]))

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Edit'))

WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Probability'), probability, false)

if (objectType == 'Opportunities') {
	'Add text in term months field in opportunity edit page'
	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TermMonths'), termMonths)

	'Add text in proposed discount field in opportunity edit page'
	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ProposedDiscount'), proposedDiscount)

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/Region'), region, false)

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/TransactionType'), transactionType, false)

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/DealReviewType'), dealReviewType, false)

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMeur'), potentialMeur, false)

	if (transactionType == 'IP - Tensilica') {
		TestObject testObj3 = findTestObject('Object Repository/OpportunityPage/CreateOpportunity/IPTensilicaProductCategory')

		List<WebElement> elementsc = WebUI.findWebElements(testObj3, 10)

		println(elementsc.size())

		elementsc.get(1).click()

		WebUI.delay(2)

		WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddIPTensilicaProductBtn'))
	}
} else if (objectType == 'Accounts') {
	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/TcvUsd'), tcvUsd)

	if (recordType == 'SW & HW & Serv') {
		WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/SoftwareTcvUsd'), softwareTCV)

		WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ServicesTcvUsd'), serviceTCV)
	}
}

if ((probability >= '30%') || '65%') {
	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/DealStartDate'), DealStartDate)

	TestObject testObj = findTestObject('OpportunityPage/compellingEvent')

	List<WebElement> elements = WebUI.findWebElements(testObj, 10)

	println(elements.size())

	elements.get(1).click()

	WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddCompellingEvent'))

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/BillingPlan'), billingPlan, false)

	WebUI.setText(findTestObject('OpportunityPage/SystemTCV'), SystemTcv)

	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/ComittedSystemTcv'), comittedSystemTCV)

	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/CfdTcv'), CfdTcv)

	WebUI.setText(findTestObject('OpportunityPage/CreateOpportunity/CommittedCfdTcv'), committedCfdTcv)

	TestObject testObja = findTestObject('OpportunityPage/CreateOpportunity/RiskIssue')

	List<WebElement> elementse = WebUI.findWebElements(testObja, 10)

	println(elementse.size())

	elementse.get(1).click()

	WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/AddRiskIssueBtn'))

	WebUI.selectOptionByValue(findTestObject('OpportunityPage/CreateOpportunity/PotentialMEA'), potentialMea, false)
}

WebUI.click(findTestObject('OpportunityPage/CreateOpportunity/Save'))

WebUI.delay(GlobalVariable.mediumDelay)

if (objectType == 'Opportunities') {
	cs = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/CreditStatus'))

	WebUI.verifyEqual(cs, creditStatus)
} else if (objectType == 'Accounts') {
	cs = WebUI.getText(findTestObject('OpportunityPage/OpportunityCreditStatus/CreditStatus'))

	WebUI.verifyEqual(cs, creditStatus)

	rrr = WebUI.getText(findTestObject('OpportunityPage/CreateOpportunity/RecRiskRating'))

	WebUI.verifyEqual(rrr, recRiskRating)
}


