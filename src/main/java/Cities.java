import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cities {
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
    public static void createFile () throws IOException {
        File file = new File("Cities");
        if(file.createNewFile()){
            FileWriter writer = new FileWriter(file);
            // запись каждого города
            for (String item:items){
                writer.write(item);
                writer.append('\n');

            }

            writer.flush();

        }
    }
}
