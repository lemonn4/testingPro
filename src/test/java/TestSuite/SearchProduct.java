package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;

public class SearchProduct extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		Utilities.clickObscuredElement(driver, By.className(HomeScreen.SEARCH_ICON_CLASS), By.xpath(HomeScreen.SEARCH_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
	}

	@Test()
	public void Tk_04_01() throws IOException {
		HomeScreen.searchProduct(driver,"", true);
	}

	@Test()
	public void Tk_04_02() throws IOException {
		HomeScreen.searchProduct(driver,"áo phao", true);
	}

	@Test()
	public void Tk_04_03() throws IOException {
		HomeScreen.searchProduct(driver,"áo sơ mi", true);
	}
	@Test()
	public void Tk_04_04() throws IOException {
		HomeScreen.searchProduct(driver,"trễ vai", true);
	}

	@Test()
	public void Tk_04_05() throws IOException {
		HomeScreen.searchProduct(driver,"máy tính", false);
	}
	@Test()
	public void Tk_04_06() throws IOException {
		HomeScreen.searchProduct(driver,"iiii", false);
	}


}
