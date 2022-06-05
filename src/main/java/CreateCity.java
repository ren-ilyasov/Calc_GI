import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateCity extends Page{

    @Override
    public void CreateInterface(JFrame main_GUI, JPanel main_panel) {
        //Окно приложения
        main_GUI.setTitle ("Новый город");
        main_GUI.setBounds(300,400,400,400);
        main_GUI.setResizable(false);

        //Надпись "Добавить город"
        JLabel label2 = new JLabel("Добавить город");
        label2.setBounds(120,70,200,30);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(label2);

        //Надпись "Коэффицент нового города"
        JLabel label3 = new JLabel("Коэффицент нового города");
        label3.setBounds(120,150,200,30);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(label3);

        //Текстовое поле "Добавить город"
        TextField city = new TextField("");
        city.setBounds(120, 100, 150, 30);
        city.setVisible(true);
        city.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(city);

        //Текстовое поле "Коэффицент нового города"
        TextField koef = new TextField("");
        koef.setBounds(120, 180, 150, 30);
        koef.setVisible(true);
        koef.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(koef);

        //Кнопка "Добавить"
        ActionListener actionCityKoef = e -> {
            try {
                Double koeF = Double.valueOf(koef.getText());
                Cities.addCityKoef(city.getText(), koeF);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(0);
        };
        JButton button_city = new JButton("Добавить");
        button_city.setBounds(120,250,150,50);
        button_city.setBackground(new Color(3, 8, 255));
        button_city.setForeground(Color.white);
        button_city.setFont(new Font("Times New Roman", Font.BOLD, 22));
        button_city.addActionListener(actionCityKoef);
        main_panel.add(button_city);
    }
}