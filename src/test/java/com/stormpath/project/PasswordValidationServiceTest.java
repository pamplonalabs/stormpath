
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stormpath.project.PasswordValidationService;

public class PasswordValidationServiceTest extends TestCase {
    private PasswordValidationService passwordValidationService;

    public PasswordValidationServiceTest(String testName) {
        super(testName);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");

        passwordValidationService = ctx.getBean(PasswordValidationService.class);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PasswordValidationServiceTest.class);
    }

    public void testPositives() {


        boolean b;
        String[] ls = {"stormpath1", "s7r0mp47h", "security8", "saltnhash11", "five5", "twelve123456"};

        for (String s : ls) {
            b = passwordValidationService.checkPassword(s);
            assertTrue(b);
        }
    }


    public void testNegatives() {

        boolean b;
        String[] ls = {"appLe1", "98765", "oranGes12", "42", "111011010111", "StormPath", "sp15", "saltsalt123",
                "stormstorm77", "1abcdabcd2", "pathSt45", "spstrompathstormpath", "", "A"};

        for (String s : ls) {
            b = passwordValidationService.checkPassword(s);
            assertFalse(b);
        }
    }


}
