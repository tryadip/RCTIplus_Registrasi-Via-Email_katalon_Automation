import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class verify {
	/**
	 * Refresh browser
	 */


	@Keyword
	def verifyemailelement() {
		try {
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_email"), 0)
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_pass"), 0)
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_repass"), 0)
			WebUI.verifyElementNotVisible(findTestObject("Registerpage/button/btn_next_register"))
			KeywordUtil.markPassed("Semua element sudah muncul")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markError("Element tidak ada")
		}
	}

	@Keyword
	def verifytext(String text) {
		try {
			WebUI.verifyTextPresent(text, false)
			KeywordUtil.markPassed("Text present")
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.markError("Text not present")
		}
	}
	
	@Keyword
	def verifyregisterstep2() {
		try {
			WebUI.verifyElementPresent(findTestObject("Register2page/field/field_fullname"), 0)
			WebUI.verifyElementPresent(findTestObject("Register2page/field/field_birthdate"), 0)
			WebUI.verifyElementPresent(findTestObject("Register2page/field/gender"), 0)
			WebUI.verifyElementNotVisible(findTestObject("Register2page/button/btn_next"))
		} catch (Exception e) {
			e.printStackTrace()
		}
	} 

	@Keyword
	def verifynumberelement() {
		try {
			WebUI.verifyElementPresent(findTestObject("Registerpage/button/dropdown_countrycode"), 0)
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_phone_number"), 0)
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_pass_phone"), 0)
			WebUI.verifyElementPresent(findTestObject("Registerpage/field/field_repass_phone"), 0)
			WebUI.verifyElementNotVisible(findTestObject("Registerpage/button/btn_next_register"))
			KeywordUtil.markPassed("Semua element sudah muncul")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markError("Element tidak ada")
		}
	}

	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}