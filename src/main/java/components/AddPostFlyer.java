package components;

import org.openqa.selenium.By;

public class AddPostFlyer {

    public static By titleText = (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/h6"));
    public static By titleField= By.name("title");
    public static By detailsField= By.name("details");
    public static By phoneField= By.name("phone");
    public static By addressField= By.name("address");
    public static By submitButton= By.xpath("//div[@id='root']/div/header/div/div/nav/button[3]/span");

}
