package co.uk.atlantis.dvsatestfinder.service;

import co.uk.atlantis.dvsatestfinder.enums.FinderEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FindAvailableTestService {


    FinderEnum finderEnum;

    // enter your detail and your test center or which test center u want
    String examDate = "Thursday 15 October 2020 9:19am";
    String licenceNum = "M....X";
    String referenceNum = "4....0";
    ArrayList chngTestCenterList = new ArrayList<>(Arrays.asList("Barnet","Chingford","Wood Green"));



    private List<String> availableSlotList;
    private List<List> allTestList = new ArrayList<>();

    private WebDriver driver;

    private WebElement licenceNumber;
    private WebElement referenceNumber;
    private WebElement loginButton;
    private WebElement radioBttnEarlyDateOption;
    private WebElement change_button;
    private WebElement drivingLicenceSubmit;
    private WebElement slotPicker;

    private WebElement chngTestCenterButton;
    private WebElement testCenterInput;
    private WebElement testCenterSubmitButton;
    private WebElement chooseTestCenter;
    private WebElement calenderPicker;
    private WebElement availableDate;

    private void openBrowser() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String todaysDate = dateFormat.format(new Date());

//		System.setProperty("webdriver.chrome.driver", "/Users/ahmetdogan/Downloads/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://driverpracticaltest.dvsa.gov.uk/login");
    }

    private void loginDetails(String strLicenceNumber, String strReferenceNumber) {
        licenceNumber = driver.findElement(By.id("driving-licence-number"));
        referenceNumber = driver.findElement(By.id("application-reference-number"));
        loginButton = driver.findElement(By.id("booking-login"));

        licenceNumber.sendKeys(strLicenceNumber);
        referenceNumber.sendKeys(strReferenceNumber);
        loginButton.click();
    }

    private void testChoice() {
        // find and click change button
        change_button = driver.findElement(By.id("date-time-change"));
        change_button.click();

        // Test Date - Car Test
        radioBttnEarlyDateOption = driver.findElement(By.id("test-choice-earliest"));
        radioBttnEarlyDateOption.click();

        // Test Date - Click Button
        drivingLicenceSubmit = driver.findElement(By.id("driving-licence-submit"));
        drivingLicenceSubmit.click();
    }

    private List<String> changeTestCenter(String testCenterPostCode) {
        chngTestCenterButton = driver.findElement(By.id("change-test-centre"));
        chngTestCenterButton.click();

        testCenterInput = driver.findElement(By.xpath("//*[@id=\"test-centres-input\"]"));
        testCenterInput.clear();
        testCenterInput.sendKeys(testCenterPostCode);
        testCenterSubmitButton = driver.findElement(By.xpath("//*[@id=\"test-centres-submit\"]"));
        testCenterSubmitButton.click();

        chooseTestCenter = driver.findElement(By.className("test-centre-details-link"));
        chooseTestCenter.click();

        return slotPicker(testCenterPostCode);
    }

    private List<String> slotPicker(String testCenterPostCode) {
        availableSlotList = new ArrayList<>();
        try {
            calenderPicker = driver.findElement(By.className("BookingCalendar-datesBody"));
            availableDate = calenderPicker.findElement(By.className("BookingCalendar-date--bookable"));
            availableDate.click();

            slotPicker = driver.findElement(By.className("SlotPicker-days"));
            List<WebElement> availableDateList = slotPicker.findElements(By.name("slotTime"));

            // Print the contents of each cells' available date and slot
            for (WebElement availableSlot : availableDateList) {
                if (!examDate.equals(availableSlot.getAttribute("data-datetime-label"))) {
                    availableSlotList.add(availableSlot.getAttribute("data-datetime-label"));
                }
            }
            return availableSlotList;
        } catch (NoSuchElementException e) {
            return Collections.singletonList(finderEnum.UNAVAILABLE_TEST_DATE+" at "+testCenterPostCode+" Test Center");
        }
    }

}
