package ru.netology.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class Login {
        String login;
    }

    public static Login getLoginValidation() {
        return new Login("newfix");
    }

    @Value
    public static class Password {
        String password;
    }

    public static Password getPasswordValidation() {
        return new Password("123qwerty");
    }

    @Value
    public static class Initials {
        String initials;
    }

    public static Initials getUnderliningText() {
        return new Initials("сабака");
    }


    public static Initials getEmoji() {
        return new Initials("✅✌");
    }

    public static Initials getNameForDeleteFourSymbols() {
        return new Initials("Ивано");
    }

    public static Initials getNameForDeleteFriSymbols() {
        return new Initials("Ива");
    }


    @Value
    public static class FirstElement {
        String firstElement;
    }

    public static FirstElement getInputIsPossible() {
        return new FirstElement("йцукен");
    }

    public static FirstElement getSurnameValidCyrillic() {
        return new FirstElement("Филиппов");
    }

    public static FirstElement getSurnameValidLatinic() {
        return new FirstElement("Ivanov");
    }

    public static FirstElement getDoubleSurnameDashValidCyrillic() {
        return new FirstElement("Иванов-Смирнов");
    }

    public static FirstElement getPartDoubleSurnameDashValidCyrillic() {
        return new FirstElement("-Смирнов");
    }

    public static FirstElement getDoubleSurnameDashValidLatinic() {
        return new FirstElement("Ivanov-Sidorov");
    }

    public static FirstElement getPartDoubleSurnameDashValidLatinic() {
        return new FirstElement("-Sidorov");
    }

    public static FirstElement getSurnameNotValidCyrillic() {
        return new FirstElement("Мкртчян");
    }

    public static FirstElement getSurnameNotValidLatinic() {
        return new FirstElement("Mkrtchyan");
    }


    public static FirstElement getSurnameLetterIo() {
        return new FirstElement("Алёшко");
    }

    public static FirstElement getSurnameLowercase() {
        return new FirstElement("филиппов");
    }

    public static FirstElement getSurnameUppercase() {
        return new FirstElement("ФИЛИППОВ");
    }

    public static FirstElement getSurnameDifferencase() {
        return new FirstElement("ФиЛиПпОв");
    }

    public static FirstElement getSurnameCyrillicOnTheEnglish() {
        return new FirstElement("Abkbggjd");
    }

    public static FirstElement getSurnameLatinicOnTheCyrillic() {
        return new FirstElement("Ыьшктщм");
    }

    public static FirstElement getSurnameNumber() {
        return new FirstElement("123");
    }

    public static FirstElement getSurnameSpecialSymbol() {
        return new FirstElement("\"!`/_+*<>\\\"\\\\=.,^%$#@\"");
    }

    public static FirstElement getSurnameEmoji() {
        return new FirstElement("✅✌");
    }

    public static FirstElement getOneSymbol() {
        return new FirstElement("а");
    }

    public static FirstElement getThreeSymbol() {
        return new FirstElement("Вла");
    }

    public static FirstElement getFourSymbol() {
        return new FirstElement("qwer");
    }

    public static FirstElement getEmptyField() {
        return new FirstElement("");
    }

    public static FirstElement getSpaces() {
        return new FirstElement("     ");
    }


    @Value
    public static class SecondElement {
        String secondElement;
    }

    public static SecondElement getNameValidCyrillic() {
        return new SecondElement("Иван");
    }

    public static SecondElement getNameCyrillicAndLatinic() {
        return new SecondElement("Ивaн");
    }

    public static SecondElement getNameNotValidCyrillic() {
        return new SecondElement("Гильберт");
    }

    public static SecondElement getNameNotValidLatinic() {
        return new SecondElement("Gilbert");
    }

    public static SecondElement getNameLowercase() {
        return new SecondElement("иван");
    }

    public static SecondElement getNameUppercase() {
        return new SecondElement("ИВАН");
    }

    public static SecondElement getNameDifferencase() {
        return new SecondElement("ИвАн");
    }

    public static SecondElement getNameValidLatinic() {
        return new SecondElement("Ivan");
    }

    public static SecondElement getDoubleNameValidCyrillic() {
        return new SecondElement("Анна Мария");
    }

    public static SecondElement getDoubleNameDashValidCyrillic() {
        return new SecondElement("Анна-Мария");
    }

    public static SecondElement getDoubleNameValidCLatinic() {
        return new SecondElement("Anna Marija");
    }

    public static SecondElement getDoubleNameDashValidCLatinic() {
        return new SecondElement("Anna-Marija");
    }

    public static SecondElement getNameLetterIo() {
        return new SecondElement("Артём");
    }


    @Value
    public static class ThirdElement {
        String thirdElement;
    }

    public static ThirdElement getMiddleNameValidCyrillic() {
        return new ThirdElement("Геннадьевич");
    }

    public static ThirdElement getMiddleNameNotValidCyrillic() {
        return new ThirdElement("Гильбертович");
    }


    public static ThirdElement getMiddleNameLowercase() {
        return new ThirdElement("геннадьевич");
    }

    public static ThirdElement getMiddleNameUppercase() {
        return new ThirdElement("ГЕННАДЬЕВИЧ");
    }

    public static ThirdElement getMiddleNameDifferencase() {
        return new ThirdElement("ГеНнАдЬеВиЧ");
    }

    public static ThirdElement getMiddleNameValidLatinic() {
        return new ThirdElement("Ivanovich");
    }

    public static ThirdElement getMiddleNameNotValidLatinic() {
        return new ThirdElement("Gilbertovich");
    }

    public static ThirdElement getMiddleNameLatinic() {
        return new ThirdElement("Sergeevich");
    }

    public static ThirdElement getMiddleNameLetterIo() {
        return new ThirdElement("Артёмович");
    }
}
