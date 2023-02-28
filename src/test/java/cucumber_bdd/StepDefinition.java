package cucumber_bdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {

	String path = "E:\\InterviewQuestion\\InfosysAssignment2\\src\\main\\java\\resources\\data.properties";
	File file = new File(path);

	@Test(priority = 1)
	@When("^Applicatin Type is Single$")
	public void applicatin_type_is_single() throws Throwable {

		PageFactory.initElements(driver, this);
		Thread.sleep(3000);
		WebElement single = driver.findElement(By.xpath("//label[normalize-space()='Single']"));
		single.click();

	}

	@Test(priority = 2)
	@And("^Enter Number of dependants$")
	public void enter_number_of_dependants() throws Throwable {
		Select numberOfDepDropDown = new Select(
				driver.findElement(By.xpath("//select[@title='Number of dependants']")));
		numberOfDepDropDown.selectByIndex(1);
	}

	@Test(priority = 3)
	@And("^Click on Home to live in$")
	public void click_on_home_to_live_in() throws Throwable {
		WebElement homeToLiveIn = driver.findElement(By.xpath("//label[normalize-space()='Home to live in']"));
		homeToLiveIn.isSelected();
	}

	@Test(priority = 4)
	@And("^Enter the annual income$")
	public void enter_the_annual_income() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement annualIncome = driver.findElement(By.xpath(
				"//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[1]//div[1]//input[1]"));
		annualIncome.clear();
		annualIncome.sendKeys(prop.getProperty("annualIncomeText"));
	}

	@Test(priority = 5)
	@And("^Enter the other income$")
	public void enter_the_other_income() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement otherIncome = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/input"));
		otherIncome.sendKeys(prop.getProperty("otherIncomeText"));
	}

	@Test(priority = 6)
	@And("^Enter the Monthly living expenses$")
	public void enter_the_monthly_living_expenses() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement livingExpense = driver.findElement(By.xpath("//input[@id='expenses']"));
		livingExpense.sendKeys(prop.getProperty("monthlyLivingExpensesText"));

	}

	@Test(priority = 7)
	@And("^Enter the Current home loan monthly repayments$")
	public void enter_the_current_home_loan_monthly_repayments() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement homeLoan = driver.findElement(By.xpath("//input[@id='otherloans']"));
		homeLoan.sendKeys(prop.getProperty("currentHomeLoanMonthlyRepaymentsText"));
	}

	@Test(priority = 8)
	@And("^Enter the Other loan monthly repayments$")
	public void enter_the_other_loan_monthly_repayments() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement otherLoan = driver.findElement(By.xpath("//input[@id='otherloans']"));
		otherLoan.sendKeys(prop.getProperty("otherLoanMonthlyRepaymentsText"));
	}

	@Test(priority = 9)
	@And("^Enter the Other monthly commitments$")
	public void enter_the_other_monthly_commitments() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement otherCommitments = driver.findElement(By.xpath("//input[@aria-describedby='q3q4i1 q3q4i2']"));
		otherCommitments.sendKeys(prop.getProperty("otherMonthlyCommitmentsText"));
	}

	@Test(priority = 10)
	@And("^Enter the Total credit card limits$")
	public void enter_the_total_credit_card_limits() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement creditCardLimits = driver.findElement(By.xpath("//input[@id='credit']"));
		creditCardLimits.sendKeys(prop.getProperty("totalCreditCardLimitsText"));
	}

	@Test(priority = 11)
	@And("^Click the button Work out how much I could borrow$")
	public void click_the_button_work_out_how_much_i_could_borrow() {
		WebElement btnBorrowCalculater = driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']"));
		btnBorrowCalculater.click();
	}

    @FindBy(xpath = "(//button[@class='start-over'])[2]")
	public WebElement startOverButton;

	@Test(priority = 12)
	@And("^Clears the form details$")
	public void clears_the_form_details() throws Throwable {
		PageFactory.initElements(driver, this);
		Thread.sleep(3000);
		WebElement startOverButton = driver.findElement(By.xpath("//button[@class='start-over']/span"));
		startOverButton.click();
		System.out.println("Start over button is clicked all fields are reset");
	}

	@Test(priority = 13)
	@When("^Enter only $1 for Living expenses$")
	public void enter_only_1_for_living_expenses() throws Throwable {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement livingExpense = driver.findElement(By.xpath("//input[@id='expenses']"));
		livingExpense.sendKeys(prop.getProperty("monthlyLivingExpensesText1"));
	}

	@Test(priority = 14)
	@Then("^Click the button Work out how much I could borrow and validate the message$")
	public void click_the_button_work_out_how_much_i_could_borrow_and_validate_the_message() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		WebElement btnBorrowCalculater = driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']"));
		btnBorrowCalculater.click();

		WebElement validationMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Based on the details you')]"));
		validationMessage.isDisplayed();
	}
}
