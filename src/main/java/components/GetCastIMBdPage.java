package components;

import org.openqa.selenium.By;

public class GetCastIMBdPage {
    public static By seeFullCastButton= By.linkText("See full cast");
    public static By castTable= By.xpath ("//table[@class='cast_list']");
    public static By tableRows= By.tagName ("tr");

}
