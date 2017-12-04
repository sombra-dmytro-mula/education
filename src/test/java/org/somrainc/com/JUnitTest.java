package org.somrainc.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.somrainc.com.utils.UtilUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitTest {

//    @Test
//    public void testChangeUsername() {
//        User
//    }

    // https://stackoverflow.com/questions/8204680/java-regex-email
    @Test
    public void checkIfEmailIsValid() {
        char[] incorrectSymbols = {'^', '&', '*', '-', '^'};
        String[] emails = {"#test@gmail.com", "test@#", "test@#gmail.com"};

        for (char incorrectSymbol : incorrectSymbols) {
            for (String email : emails) {
                email = email.replace('#', incorrectSymbol);
                boolean validEmail = UtilUser.isValidEmail(email.replace('#', incorrectSymbol));

                assertFalse("Invalid email detected: " + email, validEmail);
            }
        }
    }

    @Before
    public void setUp() {
        System.out.println("Preparing environment");
    }

    @Test
    public void doNothing() {
        System.out.println("[First] test is triggered");
    }

    @Test
    public void doNothing2() {
        System.out.println("[Second] test is triggered");
    }

    @After
    public void cleanUp() {
        System.out.println("Cleaning is triggered");
    }

}
