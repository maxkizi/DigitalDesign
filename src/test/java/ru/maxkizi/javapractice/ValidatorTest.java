package ru.maxkizi.javapractice;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.maxkizi.javapractice.exceptions.NotLatinLettersException;

import static org.junit.Assert.*;

public class ValidatorTest {
    Validator validator;



    //в строке содержатся только латинские буквы
    @Test(expected = NotLatinLettersException.class)
    public void onlyLatinLettersTest(){
        new Validator("4[vn]я2[zъ]");
    }

}