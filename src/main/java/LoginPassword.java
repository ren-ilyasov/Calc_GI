
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginPassword {
    static File file;
    static FileWriter writer;
    static HashMap<String,String> loginPassword= new HashMap<>();

    public static void createFile () throws IOException {
        loginPassword.put("GantsevKT","1234");
        loginPassword.put("KazantsevAV","7890");
        file = new File("LoginPassword");
        if(file.createNewFile()){
            writer = new FileWriter(file);
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
        else{
            writer = new FileWriter(file, true);
            readPassword();
        }
    }

    public static void readPassword() throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader read = new BufferedReader(reader);
        String line = read.readLine();
        while(line != null){
            String[] parts = line.split("_____________");

            loginPassword.put(parts[0],parts[1]);

            line = read.readLine();
        }
    }

    public static boolean addPassword(String newLogin, String newPassword) throws IOException {
        if (!checkPassword(newLogin, newPassword)){
            writer.write(newLogin);
            writer.write("_____________");
            writer.write(newPassword);
            writer.append('\n');

            writer.flush();
            return true;
        }
        return false;
    }
    public static boolean checkPassword(String login, String password){
        String truePassword  = loginPassword.get(login);
        if (truePassword == null){
            return false;
        }
        return truePassword.equals(password);
    }
}
