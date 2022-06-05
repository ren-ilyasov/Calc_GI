import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        TextField login = new TextField("");
        login.setBounds(120, 100, 150, 30);
        login.setVisible(true);
        login.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(login);

        //Текстовое поле "Коэффицент нового города"
        TextField password = new TextField("");
        password.setBounds(120, 180, 150, 30);
        password.setVisible(true);
        password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(password);

        //Кнопка "Добавить"
        ActionListener actionLogin = e -> {
            MainPage mainPage = new MainPage();
            main_GUI.setVisible(false);
        };
        JButton button_login = new JButton("Добавить");
        button_login.setBounds(120,250,150,50);
        button_login.setBackground(new Color(3, 8, 255));
        button_login.setForeground(Color.white);
        button_login.setFont(new Font("Times New Roman", Font.BOLD, 22));
        button_login.addActionListener(actionLogin);
        main_panel.add(button_login);
    }
}