import static org.junit.jupiter.api.Assertions.*;

class MainTest1 {

    @org.junit.jupiter.api.Test
    void check_volume_format1() {
        if (Main.check_volume_format("123")){
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void check_volume_format2() {
        if (Main.check_volume_format("123 123")){
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void check_volume_format3() {
        if (!Main.check_volume_format("123 123 123")){
            fail();
        }
    }
}