import java.io.IOException;

public class Main {


    public static void main(String[] args){
        try {
            Cities.createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MainPage mainPage = new MainPage();
    }

}
