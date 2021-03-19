package ru.maxkizi.javapractice;


import org.junit.Test;
import ru.maxkizi.javapractice.exceptions.*;


import static org.junit.Assert.*;

public class ValidatorTest {

    //в строке содержатся только латинские буквы
    @Test(expected = NotLatinLettersException.class)
    public void onlyLatinLettersTest() throws NotLatinLettersException {
        new Validator("4[vn]я2[zъ]").latinLettersValidation();
    }
    //нарушение пар скобок
    @Test(expected = DoubleBracketException.class)
    public void doubleBracketsTest() throws DoubleBracketException {
        new Validator("5[df]zx]").doubleBracketValidation();
    }

    //отсутсвие скобки после цифры
    @Test(expected = BracketException.class)
    public void bracketTest() throws BracketException {
        new Validator("12[a2[b]]").digitBracketValidation();
    }

    //наличие пробела
    @Test(expected = SpaceException.class)
    public void spaceExceptionTest() throws SpaceException {
        new Validator("5 [xc] 3[zs]zz x").spaceValidation();
    }

    //тест валидации
    @Test()
    public  void testValidation() throws MyValidationException {
        new Validator("2[a]xc2[fd]").fullValidation();

    }

}