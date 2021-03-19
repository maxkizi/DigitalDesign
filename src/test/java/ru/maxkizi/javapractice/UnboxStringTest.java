package ru.maxkizi.javapractice;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.maxkizi.javapractice.UnboxString;
import ru.maxkizi.javapractice.exceptions.MyValidationException;


public class UnboxStringTest {


    //Нет вложенности
    @Test
    public void unpackString1() throws MyValidationException {
        String actual = new UnboxString("3[ab]cd2[e]fg").unpackString();
        String expected = "abababcdeefg";
        Assert.assertEquals(expected, actual);
    }

    //Проверка на одну вложенность
    @Test
    public void unpackString2() throws MyValidationException {
        String actual = new UnboxString("3[2[a]xy]zv").unpackString();
        String expected = "aaxyaaxyaaxyzv";
        Assert.assertEquals(expected, actual);
    }

    //Проверка на две вложенности
    @Test
    public void unpackString3() throws MyValidationException {
        String actual = new UnboxString("3[2[2[a]xy]]zv").unpackString();
        String expected = "aaxyaaxyaaxyaaxyaaxyaaxyzv";
        Assert.assertEquals(expected, actual);
    }

    //двузначный множитель: 12[xy]
    @Test
    public void unpackingString4() throws MyValidationException {
        String actual = new UnboxString("12[a2[b]]").unpackString();
        String expected = "abbabbabbabbabbabbabbabbabbabb";
        Assert.assertEquals(expected, actual);
    }

    //строка не требующая распаковки
    @Test
    public void clearString() throws MyValidationException {
        String actual = new UnboxString("abc").unpackString();
        String expected = "abc";
        Assert.assertEquals(expected, actual);
    }
}