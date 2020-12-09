package components;

import org.openqa.selenium.By;

public class PostFlyerSignUp {
    public static By notAUserYetButton= By.linkText("Not a user yet?");
    public static By firstNameField= By.name("first_name");
    public static By lastNameField= By.name("last_name");
    public static By emailField= By.name("email");
    public static By passwordField= By.name("password");
    public static By confirmPasswordField= By.name("confirm_password");
    public static By signUpButton= By.xpath ("(button[text()='Sign Up'])");

}
