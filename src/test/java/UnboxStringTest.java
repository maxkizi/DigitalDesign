
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.maxkizi.javapractice.UnboxString;


public class UnboxStringTest {
    private static UnboxString unpacker;

    @BeforeClass
    public static void init() {
        unpacker = new UnboxString();
    }

    @Test
    public void multipleString() {
        Assert.assertTrue(unpacker.multipleString("3[abc]").equals("abcabcabc"));
        Assert.assertTrue(unpacker.multipleString("12[abc]").equals("abcabcabcabcabcabcabcabcabcabcabcabc"));
    }

    //Нет вложенности
    @Test
    public void unpackString1()   {
        String actual = unpacker.unpackString("3[ab]cd2[e]fg");
        String expected = "abababcdeefg";
        Assert.assertEquals(expected, actual);
    }

    //Проверка на одну вложенность
    @Test
    public void unpackString2()   {
        String actual = unpacker.unpackString("3[2[a]xy]zv");
        String expected = "aaxyaaxyaaxyzv";
        Assert.assertEquals(expected, actual);
    }

    //Проверка на две вложенности
    @Test
    public void unpackString3()   {
        String actual = unpacker.unpackString("3[2[2[a]xy]]zv");
        String expected = "aaxyaaxyaaxyaaxyaaxyaaxyzv";
        Assert.assertEquals(expected, actual);
    }

    //двузначный множитель: 12[xy]
    @Test
    public void unpackingString4()  {
        String actual = unpacker.unpackString("10[a2[b]]");
        String expected = "abbabbabbabbabbabbabbabbabbabb";
        Assert.assertEquals(expected, actual);
    }

   

    

}