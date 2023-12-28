package ru.nikanenkov.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.nikanenkov.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;


public class SearchEmployeePage {

    private SelenideElement fieldFind = $x("//div[contains(@class, 'controls-Render__placeholder')]");
    private SelenideElement fieldFindInput = $x("//input[contains(@class, 'controls-Field')]");

    private SelenideElement searchResults = $x("//div[contains(@class, 'Hint-ListWrapper_list')]");

    private SelenideElement emptyResults = $x("//div[contains(@data-qa, 'hint-EmptyView__title')]");

    private SelenideElement searchButton = $x("//div[contains(@class, 'Search__searchButton')]");

    private SelenideElement initialScreen = $x("//div[contains(@data-qa, 'row-expander')]");

    private SelenideElement clearField = $x("//div[contains(@title, 'Очистить')]");

    private SelenideElement errorField = $x("//span[contains(@class, 'controls-Misspell__text')]");

    private SelenideElement textErrorField = $x("//div[contains(@data-qa, 'Misspell__caption-content')]");

    public void searchOneElement(DataHelper.FirstElement firstElement) {
        fieldFindInput.val(firstElement.getFirstElement());
    }

    public void searchOneElementName(DataHelper.SecondElement secondElement) {
        fieldFindInput.val(secondElement.getSecondElement());
    }

    public void searchOneElementMiddleName(DataHelper.ThirdElement thirdElement) {
        fieldFindInput.val(thirdElement.getThirdElement());
    }

    public void searchOneElementEnter(DataHelper.FirstElement firstElement) {
        fieldFindInput.val(firstElement.getFirstElement() + Keys.ENTER);
    }

    public void searchOneElementButton(DataHelper.FirstElement firstElement) {
        fieldFindInput.val(firstElement.getFirstElement());
        searchButton.click();
    }


    public void searchSecondElementNameMiddleName(DataHelper.SecondElement secondElement,
                                                  DataHelper.ThirdElement thirdElement) {
        fieldFindInput.val(secondElement.getSecondElement() + " "
                + thirdElement.getThirdElement());
    }

    public void searchSecondElementSurnameName(DataHelper.FirstElement firstElement,
                                               DataHelper.SecondElement secondElement) {
        fieldFindInput.val(firstElement.getFirstElement() + " "
                + secondElement.getSecondElement());
    }

    public void searchSecondElementSurnameMiddleName(DataHelper.FirstElement firstElement,
                                                     DataHelper.ThirdElement thirdElement) {
        fieldFindInput.val(firstElement.getFirstElement() + " "
                + thirdElement.getThirdElement());
    }

    public void searchThirdElementSurnameNameMiddleName(DataHelper.FirstElement firstElement,
                                                        DataHelper.SecondElement secondElement,
                                                        DataHelper.ThirdElement thirdElement) {
        fieldFindInput.val(firstElement.getFirstElement() + " "
                + secondElement.getSecondElement() + " "
                + thirdElement.getThirdElement());
    }

    public void searchThirdElementNameMiddleNameSurname(DataHelper.SecondElement secondElement,
                                                        DataHelper.ThirdElement thirdElement,
                                                        DataHelper.FirstElement firstElement) {
        fieldFindInput.val(secondElement.getSecondElement() + " "
                + thirdElement.getThirdElement() + " " + firstElement.getFirstElement());
    }

    public void fieldFindHaveName() {
        fieldFind.shouldHave(Condition.text("Найти"), Duration.ofSeconds(20))
                .shouldBe(visible);
    }

    public void fieldClick() {
        fieldFindInput.shouldHave(attribute("value", "йцукен"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void enteringCyrrilic() {
        fieldFindInput.shouldHave(attribute("value", "Филиппов"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void enteringLatinic() {
        fieldFindInput.shouldHave(attribute("value", "Ivanov"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void enteringNumber() {
        fieldFindInput.shouldHave(attribute("value", "123"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void noImput() {
        fieldFindInput.shouldHave(attribute("value", ""), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSymbol() {
        searchResults.shouldHave(text("а"), Duration.ofSeconds(5));
    }

    public void findThreeSymbol() {
        searchResults.shouldHave(text("Вла"), Duration.ofSeconds(5));
    }

    public void findSymbolDeleteFourBackspace() {
        searchResults.shouldHave(text("qwer"), Duration.ofSeconds(5));
        fieldFindInput.click();
        fieldFindInput.sendKeys(Keys.BACK_SPACE);
        searchResults.shouldHave(text("qwe"), Duration.ofSeconds(5));
    }

    public void findSymbolDeleteThreeBackspace() {
        searchResults.shouldHave(text("Вла"), Duration.ofSeconds(5));
        initialScreen.shouldNot(visible);
        fieldFindInput.click();
        fieldFindInput.sendKeys(Keys.BACK_SPACE);
        initialScreen.shouldBe(visible);
    }

    public void findSymbolClearingField() {
        searchResults.shouldHave(text("Вла"), Duration.ofSeconds(5));
        initialScreen.shouldNot(visible);
        clearField.click();
        initialScreen.shouldBe(visible);
    }

    public void findEmptyFieldWithEnter() {
        initialScreen.shouldBe(visible);
    }

    public void findSurnameNameMiddleNameCyrillic() {
        searchResults.shouldHave(text("Филиппов Иван Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameNameMiddleNameLatinic() {
        searchResults.shouldHave(text("Ivanov Ivan Ivanovich"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameMiddleNameSurnameCyrillic() {
        searchResults.shouldHave(text("Иван Геннадьевич Филиппов"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameMiddleNameSurnameLatinic() {
        searchResults.shouldHave(text("Ivan Ivanovich Ivanov"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameMiddleNameCyrillic() {
        searchResults.shouldHave(text("Иван Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameMiddleNameLatinic() {
        searchResults.shouldHave(text("Ivan Ivanovich"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameNameCyrillic() {
        searchResults.shouldHave(text("Филиппов Иван"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameNameLatinic() {
        searchResults.shouldHave(text("Ivanov Ivan"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameMiddleNameCyrillic() {
        searchResults.shouldHave(text("Филиппов Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameMiddleNameLatinic() {
        searchResults.shouldHave(text("Ivanov Ivanovich"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameCyrillic() {
        searchResults.shouldHave(text("Филиппов"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findSurnameLatinic() {
        searchResults.shouldHave(text("Ivanov"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleSurnameDashCyrillic() {
        searchResults.shouldHave(text("Иванов-Смирнов"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleSurnameDashLatinic() {
        searchResults.shouldHave(text("Ivanov-Sidorov"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameCyrillic() {
        searchResults.shouldHave(text("Иван"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleNameDashCyrillic() {
        searchResults.shouldHave(text("Анна-Мария"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleNameCyrillic() {
        searchResults.shouldHave(text("Анна Мария"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findNameLatinic() {
        searchResults.shouldHave(text("Ivan"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleNameDashLatinic() {
        searchResults.shouldHave(text("Anna-Marija"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findDoubleNameLatinic() {
        searchResults.shouldHave(text("Anna Marija"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findMiddleNameCirillic() {
        searchResults.shouldHave(text("Филиппов Иван Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findMiddleNameLatinic() {
        searchResults.shouldHave(text("Ivanov-Sidorov Ivan Sergeevich"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void findEmployeeLetterIo() {
        searchResults.shouldHave(text("Алёшко Артём Артёмович"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void emptyResults() {
        emptyResults.shouldHave(text("Не найдено ни одной записи"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void insertCtrlV() {
        fieldFindInput.click();
        fieldFindInput.sendKeys(Keys.CONTROL + "A");
        fieldFindInput.sendKeys(Keys.CONTROL + "X");
        fieldFindInput.sendKeys(Keys.CONTROL + "V");
        fieldFindInput.shouldHave(attribute("value", "Филиппов Иван Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
        searchResults.shouldHave(text("Филиппов Иван Геннадьевич"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void delete() {
        fieldFindInput.click();
        fieldFindInput.sendKeys(Keys.ARROW_LEFT);
        fieldFindInput.sendKeys(Keys.DELETE);
        fieldFindInput.shouldHave(attribute("value", "qwe"), Duration.ofSeconds(5))
                .shouldBe(visible);
        searchResults.shouldHave(text("qwe"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void nameCyrillicAndLatinic() {
        emptyResults.shouldHave(text("Не найдено ни одной записи"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void errorCyrillicOnTheEnglish() {
        errorField.shouldHave(text("Возможно, вы имели в виду"), Duration.ofSeconds(5))
                .shouldBe(visible);
        textErrorField.shouldHave(text("Филиппов"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void errorLatinicOnTheCyrillic() {
        errorField.shouldHave(text("Возможно, вы имели в виду"), Duration.ofSeconds(5))
                .shouldBe(visible);
        textErrorField.shouldHave(text("Smirnov"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void fillingSpaces() {
        emptyResults.shouldHave(text("Задан пустой поисковый запрос"), Duration.ofSeconds(5))
                .shouldBe(visible);
    }

    public void fieldFindInputHaveMaxLength() {
        fieldFindInput.shouldNotHave(attribute("maxlength", ""),
                Duration.ofSeconds(5));
    }

}
