import javax.swing.*;
import java.awt.*;

public abstract class Page {
    public Page(){
        //Окно приложения
        JFrame main_GUI = new JFrame();

        //Панель для добавления элементов
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setBackground(new Color(224, 230, 245));
        main_GUI.add(main_panel);

        CreateInterface(main_GUI, main_panel);

        main_GUI.setVisible(true);
        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public abstract void CreateInterface(JFrame main_GUI, JPanel main_panel);
}
