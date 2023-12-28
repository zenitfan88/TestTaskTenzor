package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.AuthorizationPage;
import ru.netology.page.SearchEmployeePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataHelper.*;


public class SearchEmployeeTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUpp() {
        open("https://fix-online.sbis.ru/page/staff-list");
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();

    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void testSearchFieldHasName() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();

        searchEmployeePage.fieldFindHaveName();
    }

    @Test
    void testSearchFieldClickableAndInputPossible() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        var surname = DataHelper.getInputIsPossible();

        searchEmployeePage.fieldFindHaveName();
        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.fieldClick();
    }

    @Test
    void testEnteringCyrillicCharacters() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getSurnameValidCyrillic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.enteringCyrrilic();
    }

    @Test
    void testEnteringLatinicCharacters() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getSurnameValidLatinic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.enteringLatinic();
    }

    @Test
    void testEnteringNumber() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getSurnameNumber();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.enteringNumber();
    }

    @Test
    void testEnteringSpecialSymbol() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getSurnameSpecialSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.noImput();
    }

    @Test
    void testEnteringEmoji() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getSurnameEmoji();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.noImput();
    }

    @Test
    void testForcedKeySearchEnter() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getOneSymbol();

        searchEmployeePage.searchOneElementEnter(surname);
        searchEmployeePage.findSymbol();
    }

    @Test
    void testForcedKeySearchButton() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getOneSymbol();

        searchEmployeePage.searchOneElementButton(surname);
        searchEmployeePage.findSymbol();
    }

    @Test
    void testАutomaticSearchThreeSymbol() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getThreeSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findThreeSymbol();
    }

    @Test
    void testChangingTheSearchResultsDeleteFourOrMoreSymbol() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getFourSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findSymbolDeleteFourBackspace();
    }

    @Test
    void testChangingTheSearchResultsDeletThreeOrLessSymbol() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getThreeSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findSymbolDeleteThreeBackspace();
    }

    @Test
    void testChangingTheSearchResultsClearField() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getThreeSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findSymbolClearingField();
    }

    @Test
    void testFindEmptyFieldWithEnter() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getEmptyField();

        searchEmployeePage.searchOneElementEnter(surname);
        searchEmployeePage.findEmptyFieldWithEnter();
    }

    @Test
    void testFindEmptyFieldWithButton() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = DataHelper.getEmptyField();

        searchEmployeePage.searchOneElementButton(surname);
        searchEmployeePage.findEmptyFieldWithEnter();
    }

    @Test
    void testFindSurnameNameMiddleNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findSurnameNameMiddleNameCyrillic();
    }

    @Test
    void testFindSurnameNameMiddleNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var name = getNameValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findSurnameNameMiddleNameLatinic();
    }

    @Test
    void testFindNameMiddleNameSurnameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchThirdElementNameMiddleNameSurname(name, middleName, surname);
        searchEmployeePage.findNameMiddleNameSurnameCyrillic();
    }

    @Test
    void testFindNameMiddleNameSurnameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var name = getNameValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchThirdElementNameMiddleNameSurname(name, middleName, surname);
        searchEmployeePage.findNameMiddleNameSurnameLatinic();
    }

    @Test
    void testFindNameMiddleNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getNameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchSecondElementNameMiddleName(name, middleName);
        searchEmployeePage.findNameMiddleNameCyrillic();
    }

    @Test
    void testFindNameMiddleNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getNameValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchSecondElementNameMiddleName(name, middleName);
        searchEmployeePage.findNameMiddleNameLatinic();
    }

    @Test
    void testFindSurnameNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameValidCyrillic();

        searchEmployeePage.searchSecondElementSurnameName(surname, name);
        searchEmployeePage.findSurnameNameCyrillic();
    }

    @Test
    void testFindSurnameNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var name = getNameValidLatinic();

        searchEmployeePage.searchSecondElementSurnameName(surname, name);
        searchEmployeePage.findSurnameNameLatinic();
    }

    @Test
    void testFindSurnameMiddleNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchSecondElementSurnameMiddleName(surname, middleName);
        searchEmployeePage.findSurnameMiddleNameCyrillic();
    }

    @Test
    void testFindSurnameMiddleNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchSecondElementSurnameMiddleName(surname, middleName);
        searchEmployeePage.findSurnameMiddleNameLatinic();
    }

    @Test
    void testFindSurnameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findSurnameCyrillic();
    }

    @Test
    void testFindDoubleSurnameDashCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getDoubleSurnameDashValidCyrillic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findDoubleSurnameDashCyrillic();
    }

    @Test
    void testFindSurnameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findSurnameLatinic();
    }

    @Test
    void testFindDoubleSurnameDashLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getDoubleSurnameDashValidLatinic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findDoubleSurnameDashLatinic();
    }

    @Test
    void testFindNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getNameValidCyrillic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findNameCyrillic();
    }

    @Test
    void testFindDoubleNameDashCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getDoubleNameDashValidCyrillic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findDoubleNameDashCyrillic();
    }

    @Test
    void testFindDoubleNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getDoubleNameValidCyrillic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findDoubleNameCyrillic();
    }

    @Test
    void testFindNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getNameValidLatinic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findNameLatinic();
    }

    @Test
    void testFindDoubleNameDashLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getDoubleNameDashValidCLatinic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findDoubleNameDashLatinic();
    }



    @Test
    void testFindDoubleNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getDoubleNameValidCLatinic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.findDoubleNameLatinic();
    }

    @Test
    void testFindMiddleNameCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var middleName = getMiddleNameLatinic();

        searchEmployeePage.searchOneElementMiddleName(middleName);
        searchEmployeePage.findMiddleNameCirillic();
    }

    @Test
    void testFindMiddleNameLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var middleName = getMiddleNameLatinic();

        searchEmployeePage.searchOneElementMiddleName(middleName);
        searchEmployeePage.findMiddleNameLatinic();
    }

    @Test
    void testFindSurnameNameMiddleNameLetterIo() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();


        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameLetterIo();
        var name = getNameLetterIo();
        var middleName = getMiddleNameLetterIo();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findEmployeeLetterIo();
    }

    @Test
    void testFindSurnameNameMiddleNameLowercase() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameLowercase();
        var name = getNameLowercase();
        var middleName = getMiddleNameLowercase();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findSurnameNameMiddleNameCyrillic();
    }

    @Test
    void testFindSurnameNameMiddleNameUppercase() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameUppercase();
        var name = getNameUppercase();
        var middleName = getMiddleNameUppercase();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findSurnameNameMiddleNameCyrillic();
    }

    @Test
    void testFindSurnameNameMiddleNameDifferencase() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameDifferencase();
        var name = getNameDifferencase();
        var middleName = getMiddleNameDifferencase();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.findSurnameNameMiddleNameCyrillic();
    }

    @Test
    void testFindPartDoubleSurnameDashCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getPartDoubleSurnameDashValidCyrillic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findDoubleSurnameDashCyrillic();
    }

    @Test
    void testFindPartDoubleSurnameDashLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getPartDoubleSurnameDashValidLatinic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.findDoubleSurnameDashLatinic();
    }

    @Test
    void testFindSurnameNotValidCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameNotValidCyrillic();
        var name = getNameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testFindNameNotValidCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameNotValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testFindMiddleNameNotValidCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameValidCyrillic();
        var middleName = getMiddleNameNotValidCyrillic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testFindSurnameNotValidLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameNotValidLatinic();
        var name = getNameValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testFindNameNotValidLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var name = getNameNotValidLatinic();
        var middleName = getMiddleNameValidLatinic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testFindMiddleNameNotValidLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidLatinic();
        var name = getNameValidLatinic();
        var middleName = getMiddleNameNotValidLatinic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.emptyResults();
    }

    @Test
    void testInsertCtrlV() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameValidCyrillic();
        var name = getNameValidCyrillic();
        var middleName = getMiddleNameValidCyrillic();

        searchEmployeePage.searchThirdElementSurnameNameMiddleName(surname, name, middleName);
        searchEmployeePage.insertCtrlV();
    }

    @Test
    void testDelete() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getFourSymbol();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.delete();
    }

    @Test
    void testNameCyrillicAndLatinic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var name = getNameCyrillicAndLatinic();

        searchEmployeePage.searchOneElementName(name);
        searchEmployeePage.nameCyrillicAndLatinic();
    }

    @Test
    void testErrorCyrillicOnTheEnglish() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameCyrillicOnTheEnglish();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.errorCyrillicOnTheEnglish();
    }

    @Test
    void testErrorCLatinicOnTheCyrillic() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSurnameLatinicOnTheCyrillic();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.errorLatinicOnTheCyrillic();
    }

    @Test
    void testErrorFindSpaces() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        var surname = getSpaces();

        searchEmployeePage.searchOneElement(surname);
        searchEmployeePage.fillingSpaces();
    }

    @Test
    void testSearchFieldHasMaxLength() {
        var login = DataHelper.getLoginValidation();
        var password = DataHelper.getPasswordValidation();

        var authorizationPage = new AuthorizationPage();
        authorizationPage.authorization(login, password);

        var searchEmployeePage = new SearchEmployeePage();
        searchEmployeePage.fieldFindHaveName();

        searchEmployeePage.fieldFindInputHaveMaxLength();
    }

}


