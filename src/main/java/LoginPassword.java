import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginPassword {
    static HashMap<String,String> loginPassword= new HashMap<>();

    public static void createFile () throws IOException {
        loginPassword.put("GantsevKT","1234");
        loginPassword.put("KazantsevAV","7890");
        File file = new File("LoginPassword");
        if(file.createNewFile()){
            FileWriter writer = new FileWriter(file);
            for (Map.Entry<String, String> entry : loginPassword.entrySet()) {
                String login = entry.getKey();
                String password = entry.getValue();
                writer.write(login);
                writer.write("_____________");
                writer.write(password);
                writer.append('\n');
            }
            writer.flush();

        }
    }
    public static boolean checkPassword(String login, String password){
        String truePassword  = loginPassword.get(login);
        if (truePassword == null){
            return false;
        }
        return truePassword.equals(password);
    }
}
