import com.devfoFikiCar.main;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class decimalTest {
    @Rule
    public final SystemOutRule systemOut = new SystemOutRule().enableLog();

    @Test
    public void classicDecimal() {
        main m = new main();
        String[] t = {"./scripts/tests/decimal/decimalTest1.fclang"};
        main.main(t);
        Assert.assertEquals("======================================\nBeginning of FCLang execution: \n" +
                "======================================\n12.56\n======================================\n" +
                "Successful execution.\n======================================\n", systemOut.getLog());
    }

    @Test
    public void intermediateDecimal() {
        main m = new main();
        String[] t = {"./scripts/tests/decimal/decimalTest2.fclang"};
        main.main(t);
        Assert.assertEquals("======================================\nBeginning of FCLang execution: \n" +
                "======================================\n3.14\n======================================\n" +
                "Successful execution.\n======================================\n", systemOut.getLog());
    }

    @Test
    public void advanceDecimal() {
        main m = new main();
        String[] t = {"./scripts/tests/decimal/decimalTest3.fclang"};
        main.main(t);
        Assert.assertEquals("======================================\nBeginning of FCLang execution: \n" +
                "======================================\n5.75\n======================================\n" +
                "Successful execution.\n======================================\n", systemOut.getLog());
    }
}