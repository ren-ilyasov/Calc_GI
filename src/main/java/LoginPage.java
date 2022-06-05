import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPage {

    public LoginPage(){
        //Окно приложения
        JFrame main_GUI = new JFrame("Login");
        main_GUI.setTitle ("Авторизация");
        main_GUI.setBounds(300,400,400,400);
        main_GUI.setResizable(false);

        //Панель для добавления элементов
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setBackground(new Color(224, 230, 245));
        main_GUI.add(main_panel);

        //Надпись "Имя пользователя"
        JLabel label2 = new JLabel("Имя пользователя");
        label2.setBounds(120,70,200,30);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(label2);

        //Надпись "Пароль пользователя"
        JLabel label3 = new JLabel("Пароль пользователя");
        label3.setBounds(120,150,200,30);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        main_panel.add(label3);

        //Текстовое поле "Логин"
        {
            TextField Login = new TextField("");
            Login.setBounds(120, 100, 150, 30);
            Login.setVisible(true);
            Login.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(Login);
        }

        //Текстовое поле "Пароль"
        {
            TextField Password = new TextField("");
            Password.setBounds(120, 180, 150, 30);
            Password.setVisible(true);
            Password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(Password);
        }

        //Кнопка "ВХОД"
        ActionListener actionLogin = e -> {
            MainPage mainPage = new MainPage();
            main_GUI.setVisible(false);
        };
        JButton button_login = new JButton("ВХОД");
        button_login.setBounds(120,250,150,50);
        button_login.setBackground(new Color(255, 147, 3));
        button_login.setForeground(Color.white);
        button_login.setFont(new Font("Times New Roman", Font.BOLD, 22));
        button_login.addActionListener(actionLogin);
        main_panel.add(button_login);

        main_GUI.setVisible(true);
        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
