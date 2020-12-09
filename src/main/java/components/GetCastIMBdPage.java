package components;

import org.openqa.selenium.By;

public class GetCastIMBdPage {
    public static By seeFullCastButton= By.linkText("See full cast");
    public static By castTable= By.xpath ("//table[@class='cast_list']");
    public static By tableRows= By.tagName ("tr");
    public static By castName(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr[" + i + "]/td[2]/a");

    }

    public static By screenName(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]/a[1]");

    }

    public static By appearance(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]/a[2]");

    }
    public static By castNameForLastRows(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr[" + (i+1) + "]/td[2]/a");

    }
    public static By screenNameForLastRows(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+(i+1)+"]/td[4]");


    }
    public static By screenNameForRemaining(int i)
    {
        return By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]");

    }


}
