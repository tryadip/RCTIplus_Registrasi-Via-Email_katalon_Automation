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

import internal.GlobalVariable
import javassist.bytecode.stackmap.BasicBlock.Catch

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class Topage {
	/**
	 * Refresh browser
	 */

	@Keyword
	def toregisterpage() {
		try {
			WebUI.openBrowser("https://www.rctiplus.com/")
			WebUI.maximizeWindow()
			WebUI.click(findTestObject("Homepage/Button/btn_login"))
			WebUI.click(findTestObject("Loginpage/link/link_register"))
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markError("Element tidak ditemukan")
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
			e.printStackTrace()
		}
	}
	
	@Keyword
	def toregisterpage2() {
		try {
			CustomKeywords.'Topage.toregisterpage'()
			WebUI.setText(findTestObject("Registerpage/field/field_email"),findTestData("user").getValue(1, 1))
			WebUI.setText(findTestObject("Registerpage/field/field_pass"),findTestData("user").getValue(2, 1))
			WebUI.setText(findTestObject("Registerpage/field/field_repass"),findTestData("user").getValue(2, 1))
			CustomKeywords.'click.clickElement'(findTestObject("Registerpage/button/btn_next_register"))
			KeywordUtil.markPassed("Berhasil kehalaman register step 2")
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.markError("Tidak berhasil kehalaman register")
		}
	}

	
}