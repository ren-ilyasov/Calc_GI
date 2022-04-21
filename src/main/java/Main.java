import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        JFrame main_GUI = new JFrame("Victory");
        main_GUI.setTitle ("Calc_GI");
        main_GUI.setBounds(100,100,1150,600);
        main_GUI.setResizable(false);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_GUI.add(main_panel);

        JLabel label1 = new JLabel("Откуда");
        label1.setBounds(150,210,100,30);
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        main_panel.add(label1);

        JLabel label2 = new JLabel("Куда");
        label2.setBounds(350,210,100,30);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        main_panel.add(label2);

        JLabel label3 = new JLabel("Вес, кг");
        label3.setBounds(550,210,100,30);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        main_panel.add(label3);

        JLabel label4 = new JLabel("Объём, м3");
        label4.setBounds(750,210,100,30);
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        main_panel.add(label4);

        JLabel label5 = new JLabel("ПРОСТОЙ КАЛЬКУЛЯТОР ДЛЯ РАСЧЕТА СТОИМОСТИ ПЕРЕВОЗКИ ГРУЗА");
        label5.setBounds(150,170,800,30);
        label5.setAlignmentX(Component.CENTER_ALIGNMENT);
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        main_panel.add(label5);

        String[] items = {
                "Уфа",
                "Абакан",
                "Урюпинск"
        };
        JComboBox<String> combo_tarif = new JComboBox<>(items);
        combo_tarif.setSelectedItem(0);
        combo_tarif.setBounds(150,240,150,30);
        combo_tarif.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        ActionListener actionListener = e -> {

        };

        combo_tarif.setBackground(new Color(154,132,223));
        combo_tarif.addActionListener(actionListener);
        main_panel.add(combo_tarif);

        //Выпадающий список 2
        {
            String[] items2 = {
                    "Уфа",
                    "Абакан",
                    "Урюпинск"
            };
            JComboBox<String> combo_tarif2 = new JComboBox<>(items2);
            combo_tarif2.setSelectedItem(0);
            combo_tarif2.setBounds(350, 240, 150, 30);
            combo_tarif2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            ActionListener actionListener2 = e -> {

            };
            combo_tarif2.setBackground(new Color(154, 132, 223));
            combo_tarif2.addActionListener(actionListener2);
            main_panel.add(combo_tarif2);
        }

        //Вывод результата
        {
            JLabel labelOutput = new JLabel("Результат:");
            labelOutput.setBounds(30, 300, 250, 30);
            labelOutput.setVisible(false);
            labelOutput.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            main_panel.add(labelOutput);
        }

        //Текстовое поле "Вес"
        {
            TextField weight = new TextField("Введите вес (КГ)");
            weight.setBounds(550, 240, 150, 30);
            weight.setVisible(true);
            weight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(weight);
        }

        //Текстовое поле "Объём"
        {
            TextField volume = new TextField("Длина, Ширина, Высота (см)");
            volume.setBounds(750, 240, 240, 30);
            volume.setVisible(true);
            volume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(volume);
        }

        JButton button_create = new JButton("РАССЧИТАТЬ СТОИМОСТЬ");
        button_create.setBounds(350,290,350,50);
        button_create.setBackground(new Color(255, 147, 3));
        button_create.setForeground(Color.white);
        button_create.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        ActionListener actionListener3 = e -> {

        };
        button_create.addActionListener(actionListener3);
        main_panel.add(button_create);

        main_GUI.setVisible(true);
        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
