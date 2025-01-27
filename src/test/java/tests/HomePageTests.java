package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomePageTests  extends BaseTest {

    @Test
    public void testOpenHomePage() {
        // გახსენი საიტი
        System.out.println("საიტი გაიხსნა: " + driver.getTitle());
    }

    @Test(dependsOnMethods = "testOpenHomePage")
    public void testLogin() {
        // ლოგინი
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]")));
        userIcon.click();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder=' '])[1]")));
        emailField.sendKeys("mkhalvashi2@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        passwordField.sendKeys("batumi2025");
        WebElement loginButton = driver.findElement(By.xpath("(//button[contains(@type,'button')])[2]"));
        loginButton.click();
        System.out.println("ავტორიზაცია წარმატებით დასრულდა");
    }



@Test
    public void testRegistration() {

    // ვებ გვერდის გახსნა
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    // აიკონის დაჭერა
    WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]//*[name()='svg']")));
    userIcon.click();

    //  რეგისტრაციის ღილაკის დაჭერა
    WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn--md btn--link btn--filled')]")));
    registerButton.click();

    // სახელი
    WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'register-modal__grid')]//div[1]//div[1]//input[1]")));
    firstNameField.sendKeys("მაია");

    // გვარი
    WebElement lastNameField = driver.findElement(By.xpath("//div[contains(@class,'register-modal__grid')]//div[2]//div[1]//input[1]"));
    lastNameField.sendKeys("ხალვაში");

    // ტელეფონი
    WebElement phoneField = driver.findElement(By.xpath("//input[contains(@data-mask,'+############')]"));
    phoneField.sendKeys("593797191");

    // ელ. ფოსტა
    WebElement emailField = driver.findElement(By.xpath("//div[contains(@class,'modal register-modal')]//div[3]//div[1]//input[1]"));
    emailField.sendKeys("khalvashim@gmail.com");

    // პაროლი
    WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[1]/div[2]/form/div[4]/div/input"));
    passwordField.sendKeys("batumi@2025");

    // პაროლის გამეორება
    WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[1]/div[2]/form/div[5]/div/input"));
    confirmPasswordField.sendKeys("batumi@2025");

    // ვეთანხმები წესებს და პირობებს
    WebElement termsCheckbox = driver.findElement(By.xpath("//span[@class='checkbox__mark']"));
    termsCheckbox.click();

    // რეგისტრაციის ღილაკი
    WebElement finalRegisterButton = driver.findElement(By.xpath("//body/div[@id='app']/header[contains(@class,'header')]/div[contains(@class,'modal register-modal')]/div[contains(@class,'modal__content')]/div[contains(@class,'modal__body')]/form[contains(@autocomplete,'off')]/button[1]"));
    finalRegisterButton.click();

    System.out.println("რეგისტრაცია წარმატებით დასრულდა");

}


    @Test(dependsOnMethods = "testLogin")
    public void testAddProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // საძიებო ველის მოძებნა და პროდუქტის ძიება
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header__col header-search__col']//input[@id='header-search']")));
        searchField.sendKeys("კრემი"); // შეიყვანე პროდუქტისთვის რელევანტური სიტყვა
        searchField.sendKeys(Keys.RETURN);

        // პირველი შედეგის დალოდება და არჩევა
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ziaja - ზიაია თხის რძის დღის კრემი + თვალის კრემი ')]")));
        firstProduct.click();
        System.out.println("პროდუქტის გვერდი წარმატებით გაიხსნა");

        // "კალათაში დამატება" ღილაკზე დაჭერა
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn--primary product-single__cart-btn']")));
        addToCartButton.click();
        System.out.println("პროდუქტი წარმატებით დაემატა კალათაში");

       //როვა ვაჭერთ "კალათაში დამატება" გადავყავართ დალოგინებაზე
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder=' '])[1]")));
        emailField.sendKeys("khalvashim@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='password'])[1]")));
        passwordField.sendKeys("batumi@2025");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
        loginButton.click();
        System.out.println("წარმატებით შევიდა სისტემაში");

    // ქალაქის არჩევა ჩამონათვალიდან
        WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modal__title'])[1]")));  // ან თქვენი XPath
        cityDropdown.click();

        WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'ბათუმი')])[1]")));  // თქვენი კონკრეტული ქალაქის XPath
        cityOption.click();
        System.out.println("ქალაქი წარმატებით შეირჩა");

    // ვალიდაციის შეტყობინების დადასტურება
        WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'notification')]")));
        Assert.assertTrue(validationMessage.isDisplayed(), "Validation message not displayed");
        System.out.println("პროდუქტი წარმატებით დაემატა კალათაში");

    // კალათის ღილაკზე დაჭერა
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn--md btn--primary btn--filled-inverted header__cart']")));
        cartButton.click();

    // კალათაში პროდუქტის შემოწმება
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='router-link-active router-link-exact-active product__title'])[1]")));
        Assert.assertTrue(cartItem.isDisplayed(), "Cart item not displayed");
        System.out.println("კალათაში პროდუქტი წარმატებით ჩანს");

    }

}

