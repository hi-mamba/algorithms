package space.mamba.coding.interviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mamba
 * @date 2020/9/12 09:59
 */
public class No49_StringToIntegerTest {
    
    @Test
    private void strToInteger() {
        No49_StringToInteger obj = new No49_StringToInteger();
        Assertions.assertEquals(obj.strToInteger(null), 0);
        Assertions.assertEquals(obj.strToInteger(""), 0);
        Assertions.assertEquals(obj.strToInteger(" "), 0);
        Assertions.assertEquals(obj.strToInteger("    "), 0);
        Assertions.assertEquals(obj.strToInteger("--123321"), 0);
        Assertions.assertEquals(obj.strToInteger("++123321"), 0);
        Assertions.assertEquals(obj.strToInteger("-123321"), -123321);
        Assertions.assertEquals(obj.strToInteger("12345"), 12345);
        Assertions.assertEquals(obj.strToInteger("+54321"), 54321);
    }
}
