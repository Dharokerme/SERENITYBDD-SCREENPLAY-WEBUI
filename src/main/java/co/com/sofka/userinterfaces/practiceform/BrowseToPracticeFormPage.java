package co.com.sofka.userinterfaces.practiceform;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class BrowseToPracticeFormPage extends PageObject {

    public static final Target ELEMENTS = Target
            .the("Elements")
            .located(xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5"));

    public static final Target FORMS = Target
            .the("Form")
            .located(xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/span/div"));

    public static final Target PRACTICE_FORM = Target
            .the("Practice Form")
            .located(xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div/ul"));

    public static final Target FIRST_NAME = Target
            .the("First name")
            .located(id("firstName"));

    public static final Target LAST_NAME = Target
            .the("Last name")
            .located(id("lastName"));

    public static final Target GENDER_MALE = Target
            .the("Gender male")
            .located(xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));

    public static final Target GENDER_FEMALE = Target
            .the("Gender female")
            .located(xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));

    public static final Target GENDER_OTHER = Target
            .the("Gender other")
            .located(xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label"));

    public static final Target MOBILE = Target
            .the("Mobile")
            .located(id("userNumber"));

    public static final Target SUBMIT = Target
            .the("Submit")
            .located(id("submit"));

    public static final Target STUDENT_NAME_VALIDATION = Target
            .the("Student Name")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"));

    public static final Target GENDER_VALIDATION = Target
            .the("Gender")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]"));

    public static final Target MOBILE_VALIDATION = Target
            .the("Mobile")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]"));

    public static final Target DATE_OF_BIRTH_VALIDATION = Target
            .the("Date of birth")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]"));
}
