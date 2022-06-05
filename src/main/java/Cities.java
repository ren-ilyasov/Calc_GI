import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Cities {
     public static Double[] koef = {1.0,1.4,3.0,1.8,1.3,1.2,1.9,1.2,2.5,1.7,1.7,1.8,4.0,1.1,1.6,1.8};
     static String[] items = {
            "Москва",
            "Санкт-Петербург",
            "Новосибирск",
            "Екатеринбург",
            "Казань",
            "Нижний Новгород",
            "Челябинск",
            "Самара",
            "Омск",
            "Ростов-на-Дону",
            "Уфа",
            "Краснодар",
            "Красноярск",
            "Воронеж",
            "Пермь",
            "Волгоград"
    };

    static File file;
    static FileWriter writer;
    public static HashMap<String, Double> cityKoef= new HashMap<>();

    public static void createFile () throws IOException {
        file = new File("Cities");
        if(file.createNewFile()){
            for(int i = 0; i< items.length; i++){
                cityKoef.put(items[i], koef[i]);
            }
            writer = new FileWriter(file);
            for (Map.Entry<String, Double> entry : cityKoef.entrySet()) {
                String city = entry.getKey();
                Double koef = entry.getValue();
                writer.write(city);
                writer.write("___");
                writer.write(koef.toString());
                writer.append('\n');
            }
            writer.flush();

        }
        else{
            writer = new FileWriter(file, true);
            readCityKoef();
        }
    }

    public static void readCityKoef() throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader read = new BufferedReader(reader);
        String line = read.readLine();
        while(line != null){
            String[] parts = line.split("___");
            Double koef = Double.valueOf(parts[1]);
            cityKoef.put(parts[0],koef);

            line = read.readLine();
        }
    }

    public static boolean addCityKoef(String newCity, Double newKoef) throws IOException {
        if (!checkPassword(newCity, newKoef)){
            writer.write(newCity);
            writer.write("___");
            writer.write(newKoef.toString());
            writer.append('\n');

            writer.flush();
            return true;
        }
        return false;
    }
    public static boolean checkPassword(String city, Double koef){
        Double trueCityKoef  = cityKoef.get(city);
        if (trueCityKoef == null){
            return false;
        }
        return trueCityKoef.equals(koef);
    }
}
