import javax.swing.*;
import java.awt.*;

public class LoginPage {

    public LoginPage(){
        //Окно приложения
        JFrame main_GUI = new JFrame("Login");
        main_GUI.setTitle ("Авторизация");
        main_GUI.setBounds(300,300,400,400);
        main_GUI.setResizable(false);

        //Панель для добавления элементов
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setBackground(new Color(224, 230, 245));
        main_GUI.add(main_panel);

        main_GUI.setVisible(true);
        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        {
            TextField Login = new TextField("");
            Login.setBounds(120, 100, 150, 30);
            Login.setVisible(true);
            Login.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(Login);
        }
        {
            TextField Password = new TextField("");
            Password.setBounds(120, 180, 150, 30);
            Password.setVisible(true);
            Password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(Password);
        }
    }

}
