import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateLoginPassword extends Page{

    @Override
    public void CreateInterface(JFrame main_GUI, JPanel main_panel) {
            //Окно приложения
            main_GUI.setTitle ("Создание нового логиа и пароля");
            main_GUI.setBounds(300,400,400,400);
            main_GUI.setResizable(false);

            //Надпись "Новое имя пользователя"
            JLabel label2 = new JLabel("Новое имя пользователя");
            label2.setBounds(120,70,200,30);
            label2.setAlignmentX(Component.CENTER_ALIGNMENT);
            label2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(label2);

            //Надпись "Новый пароль пользователя"
            JLabel label3 = new JLabel("Новый пароль пользователя");
            label3.setBounds(120,150,200,30);
            label3.setAlignmentX(Component.CENTER_ALIGNMENT);
            label3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(label3);

            //Текстовое поле "Новый логин"
            TextField login = new TextField("");
            login.setBounds(120, 100, 150, 30);
            login.setVisible(true);
            login.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(login);

            //Текстовое поле "Новый пароль"
            TextField password = new TextField("");
            password.setBounds(120, 180, 150, 30);
            password.setVisible(true);
            password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(password);

            //Кнопка "СОЗДАТЬ"
            ActionListener actionLogin = e -> {
                if (!LoginPassword.checkPassword(login.getText(), password.getText())){
                    MainPage mainPage = new MainPage();
                    main_GUI.setVisible(false);

                }

            };
            JButton button_login = new JButton("СОЗДАТЬ");
            button_login.setBounds(120,250,150,50);
            button_login.setBackground(new Color(3, 255, 7));
            button_login.setForeground(Color.white);
            button_login.setFont(new Font("Times New Roman", Font.BOLD, 22));
            button_login.addActionListener(actionLogin);
            main_panel.add(button_login);
        }
}
