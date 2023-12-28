package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private SelenideElement loginField = $x("//*[@name='Login']");
    private SelenideElement button = $x("//div[contains(@class, 'controls-BaseButton')]");
    private SelenideElement passwordField = $x("//*[@name='Password']");


    public SearchEmployeePage authorization (DataHelper.Login login, DataHelper.Password password) {
        loginField.shouldHave(Condition.visible);
        loginField.val(login.getLogin());
        button.click();
        passwordField.val(password.getPassword());
        button.click();
        return new SearchEmployeePage();
    }
}
