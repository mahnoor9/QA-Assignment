package components;

import org.openqa.selenium.By;

public class PostFlyerSignIn {

  public static By LoginPage= By.xpath("//span[text()='Login']");

   // public static By LoginPage= By.xpath("//div[@id='root']/div/header/div/div/nav/button[3]/span");
    public static By passwordField= By.name("password");
    public static By emailField= By.name("email");
    public static By loginButton= By.xpath ("//span[text()='Sign In']");


}
