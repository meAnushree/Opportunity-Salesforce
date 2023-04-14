package checkFieldIsRequired

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.Calendar as Calendar
import java.util.Locale as Locale
import java.text.SimpleDateFormat

import internal.GlobalVariable

public class Date {
	@Keyword
	private static String getLastDayOfQuarter() {
		LocalDate localDate = LocalDate.now()
		LocalDate lastDayOfQuarter = localDate.with(localDate.getMonth().firstMonthOfQuarter())
				.with(TemporalAdjusters.firstDayOfMonth()).plusMonths(2)
				.with(TemporalAdjusters.lastDayOfMonth())

		String date = lastDayOfQuarter.format(DateTimeFormatter.ofPattern("M/dd/yyyy"))
		println(date)
		return date
	}
}
