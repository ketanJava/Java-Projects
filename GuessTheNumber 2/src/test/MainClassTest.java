import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {
    MainClass mainClass;

    @BeforeAll
   public static void beforeAll(){
        System.out.println("In before all...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In before each...");
        mainClass =  new MainClass();
    }

    @DisplayName("Test createNum Method")
    @Test
    void getRandNum() {
        assertEquals(15, mainClass.getRandNum(15), "createNum method failed...");
    }

    @DisplayName("Test getNum Method")
    @Test
    void getInputNum() {
        assertEquals(7, mainClass.getInputNum(7), "getNum method failed...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("In after each...");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("In after all...");
    }
}