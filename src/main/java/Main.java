import java.io.IOException;

public class Main {


    public static void main(String[] args){
        try {
            LoginPassword.createFile();
            Cities.createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginPage loginPage = new LoginPage();
    }

}
