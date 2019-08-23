package fankitc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fankick.reportutils.ReportUtils;

import fankick.utilities.PropertyUtils;

public class Fancje extends ReportUtils {

	@Test
	public void main() {
		getMethodName();
		Comment("Loading url");
		loadUrl(Url);
		Comment("Entering EmailId");
		sendKeysByName(Email, PropertyUtils.getServerValue(ValidEmailId));
		Comment("Entering Password");
		sendKeysByName(Password, PropertyUtils.getServerValue(ValidPassword));
		Comment("Clicking on login button");
		clickByXpath(LoginButton);
		navigateUrl(Navigate);
		clickByXpath(CreateContest);
		clickByXpath(Globbalselect);
		clickByXpath(DropdDownselect);
		clickByCssSelector(SelectCategory);
		clickByXpath(Category);
		clickByCssSelector(ContestCategory);
		clickByXpath(ContestType);
		clickByCssSelector(Series);
		clickByXpath(SeriesType);
		clickByCssSelector(SubContest);
		clickByXpath(SubContestType);
		clickByCssSelector(SelectApp);
		clickByCssSelector(SelectFankick);
		clickByCssSelector(SelectToggle);
		//sendKeysByXPath(MatchNo, ValidNumber);

		//sendKeysByXPath(NumberOfQuestion, "4");

		setDateAndTime("//input[@placeholder='Select Start Date']", "2019-08-22 12:00:00");

	}

	private void setDateAndTime(String type, String date_time) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getElement(getDriver().findElement(By.xpath(type)));
		js.executeScript("arguments[0].setAttribute('value', '" + date_time + "')", element);
	}

}
