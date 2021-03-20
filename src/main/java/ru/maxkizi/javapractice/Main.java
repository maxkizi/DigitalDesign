package ru.maxkizi.javapractice;

import ru.maxkizi.javapractice.exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        UnpackerString unpacker = new UnpackerString();
        try {
            System.out.println(unpacker.unpackString("5[xc]3[zs]zzx"));

        } catch (SpaceException e2) {
            System.out.println("Ошибка ввода: строка не должна содержать пробелы");
        } catch (NotLatinLettersException e1) {
            System.out.println("Ошибка ввода: допустимы тоько буквы латинского алфавита");
        } catch (BracketException e4) {
            System.out.println("Ошибка ввода: после цифры долна стоять открывающаяся скобка '['");
        } catch (DoubleBracketException e3) {
            System.out.println("Ошибка ввода: проверьте открывающиеся/закрывающиеся скобки");
        } catch (MyValidationException e) {
        }
    }
}


