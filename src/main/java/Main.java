import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Массив городов для рассчета
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
            "Красноярск",
            "Воронеж",
            "Пермь",
            "Волгоград"
    };

    static String last_item_selected1 = items[0];
    static JComboBox<String> combo_tarif;

    static String last_item_selected2 = items[1];
    static JComboBox<String> combo_tarif2;

    static TextField weight;

    static TextField volume;

    static JLabel labelOutput;

    public static void main(String[] args){
        //Окно приложения
        JFrame main_GUI = new JFrame("Victory");
        main_GUI.setTitle ("Calc_GI");
        main_GUI.setBounds(100,100,1150,600);
        main_GUI.setResizable(false);

        //Панель для добавления элементов
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setBackground(new Color(224, 230, 245));
        main_GUI.add(main_panel);

        //Надпись "Откуда"
        JLabel label1 = new JLabel("Откуда");
        label1.setBounds(100,210,100,30);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        main_panel.add(label1);

        //Надпись "Куда"
        JLabel label2 = new JLabel("Куда");
        label2.setBounds(350,210,100,30);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        main_panel.add(label2);

        //Надпись "Вес, кг"
        JLabel label3 = new JLabel("Вес, кг");
        label3.setBounds(600,210,100,30);
        label3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        main_panel.add(label3);

        //Надпись "Объём, м3"
        JLabel label4 = new JLabel("Объём, м3");
        label4.setBounds(800,210,120,30);
        label4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        main_panel.add(label4);

        //Надпись "Длина, Ширина, Высота"
        JLabel label6 = new JLabel("[Длина Ширина Высота] (через пробел)");
        label6.setBounds(800,270,300,30);
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        main_panel.add(label6);

        //Надпись "Калькулятор"
        JLabel label5 = new JLabel("ПРОСТОЙ КАЛЬКУЛЯТОР ДЛЯ РАСЧЕТА СТОИМОСТИ ЖД ПЕРЕВОЗОК");
        label5.setBounds(100,170,900,30);
        label5.setAlignmentX(Component.CENTER_ALIGNMENT);
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        main_panel.add(label5);

        //Выпадающий список
        combo_tarif = new JComboBox<>(items);
        combo_tarif.setSelectedItem(last_item_selected1);
        combo_tarif.setBounds(100,240,200,30);
        combo_tarif.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        ActionListener actionListener = e -> {
            String selected_item1 = (String) combo_tarif.getSelectedItem();
            String selected_item2 = (String) combo_tarif2.getSelectedItem();

            //Проверка на выбор одинаковых городов
            assert selected_item1 != null;
            if (selected_item1.equals(selected_item2)){
                JOptionPane.showMessageDialog(null,
                        "Доставка в тот же город не производится",
                        "Неверно указан город!",
                        JOptionPane.WARNING_MESSAGE);

                combo_tarif.setSelectedItem(last_item_selected1);
                combo_tarif2.setSelectedItem(last_item_selected2);
            }
            else{
                last_item_selected1 = selected_item1;
                last_item_selected2 = selected_item2;
            }
        };

        combo_tarif.setBackground(new Color(255, 255, 255));
        combo_tarif.addActionListener(actionListener);
        main_panel.add(combo_tarif);


        //Выпадающий список 2
        {
            combo_tarif2 = new JComboBox<>(items);
            combo_tarif2.setSelectedItem(last_item_selected2);
            combo_tarif2.setBounds(350, 240, 200, 30);
            combo_tarif2.setFont(new Font("Times New Roman", Font.ITALIC, 18));

            combo_tarif2.setBackground(new Color(255, 255, 255));
            combo_tarif2.addActionListener(actionListener);
            main_panel.add(combo_tarif2);
        }

        //Вывод результата
        {
            labelOutput = new JLabel("Результат:");
            labelOutput.setBounds(300, 380, 750, 50);
            labelOutput.setVisible(false);
            labelOutput.setFont(new Font("Times New Roman", Font.ITALIC, 32));
            main_panel.add(labelOutput);
        }

        //Текстовое поле "Вес"
        {
            weight = new TextField("");
            weight.setBounds(600, 240, 150, 30);
            weight.setVisible(true);
            weight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(weight);
        }

        //Текстовое поле "Объём"
        {
            volume = new TextField("");
            volume.setBounds(800, 240, 240, 30);
            volume.setVisible(true);
            volume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            main_panel.add(volume);
        }

        //Кнопка "РАССЧИТАТЬ СТОИМОСТЬ"
        JButton button_create = new JButton("РАССЧИТАТЬ СТОИМОСТЬ");
        button_create.setBounds(350,320,400,50);
        button_create.setBackground(new Color(255, 147, 3));
        button_create.setForeground(Color.white);
        button_create.setFont(new Font("Times New Roman", Font.BOLD, 22));
        //Проверка введённых значений
        ActionListener actionListener3 = e -> {
            if (check_volume_format(volume.getText())){
                String[] nums = volume.getText().split(" ");
                int[] edges = {1572, 276, 326};

                float triple = 1;

                for (int i = 0; i < 3; i++){
                    int value = Integer.parseInt(nums[i]);

                    //Ограничение по размерам
                    if (value > edges[i] || value == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Длина до 1573 см \n Ширина до 277 см \n Высота до 327 см ",
                                "Неверно введены значения!",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else{
                        triple*=value;
                    }

                }

                //Груз слишком большой
                triple/=1000000;
                volume.setText(String.format("%.2f",triple));
                if (triple>140.0){
                    JOptionPane.showMessageDialog(null,
                            "Вагон не вмещает груз",
                            "Неверно введены значения!",
                            JOptionPane.WARNING_MESSAGE);
                }
                //Груз слишком маленький
                else if(triple<1.0 ){
                    JOptionPane.showMessageDialog(null,
                            "Груз менее 1 кубического метра\nОтправляются по почте",
                            "Замечание",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            //Неверно введены значения
            else{
                JOptionPane.showMessageDialog(null,
                        "Длина до 1573 см \nШирина до 277 см \nВысота до 327 см ",
                        "Неверно введены значения!",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Коэффициенты для городов
            Double[] koef = {1.0,1.4,3.0,1.8,1.3,1.2,1.9,1.2,2.5,1.7,1.7,4.0,1.1,1.6,1.8};

            //Алгоритм расчёта коэффициентов
            int item_selected1 = Arrays.asList(items).indexOf(last_item_selected1);
            int item_selected2 = Arrays.asList(items).indexOf(last_item_selected2);
            double Sum=koef[item_selected1]+koef[item_selected2];
            if(Sum>2.0 &&Sum<=4.0){
                Sum/=2;
            }
            else if(Sum>4.0 &&Sum<=5.0){
                Sum/=2.5;
            }
            else if(Sum>5.0) {
                Sum /= 3.5;
            }

            //Проверка введённых значений веса
            if (check_weight_format(weight.getText())){
                int value = Integer.parseInt(weight.getText());
                if (value > 68000 || value == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Введите целое число от 1 до 68000 включительно",
                            "Неверно введены значения!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //Расчёт коэффициентов для веса груза
                if(value>0 &&value<=500.0){
                    value*=24;
                }
                else if(value>500.0 &&value<=1000.0){
                    value*=23;
                }
                else if(value>1000.0 &&value<=2000.0){
                    value*=22;
                }
                else if(value>2000.0) {
                    value *= 21;
                }
                    if(value<2000){
                        value=2000;
                        JOptionPane.showMessageDialog(null,
                                "Минимальная стоимость услуги 2000 рублей\nБез учета тарифа",
                                "Замечание",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                //Формула расчёта стоимости железнодорожной перевозки
                value*=Sum;
                labelOutput.setText("Итоговая стоимость: "+ value +" рублей");
                labelOutput.setVisible(true);

                //Ввод данных для создания PDF-документа
                try {
                    CreatePDF pdf = new CreatePDF("PDF.pdf", BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI, false));
                    Document document = pdf.getDocument();
                    document.open();

                    document.addTitle("Result report");

                    pdf.addText(document,"Ship coefficient: " + Sum, 18,true);

                    pdf.addText(document,"Weight: " + weight.getText() + " Kg", 18,true);

                    pdf.addText(document,"Volume: " + volume.getText() + " m3", 18,true);

                    pdf.addText(document,"Result: " + value + " rubbles", 18,true);

                    document.close();
                }
                catch (DocumentException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            //Проверка введённых данных веса груза
            else{
                JOptionPane.showMessageDialog(null,
                        "Введите целое число от 1 до 68000 включительно",
                        "Неверно введены значения!",
                        JOptionPane.WARNING_MESSAGE);
            }
        };
        button_create.addActionListener(actionListener3);
        main_panel.add(button_create);

        main_GUI.setVisible(true);
        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Проверка формата вводимых данных (Объём)
    public static boolean check_volume_format(String volume){
        String regex ="\\d{1,4}\\s\\d{1,3}\\s\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(volume);
        return matcher.matches();
    }

    //Проверка формата вводимых данных (Вес)
    public static boolean check_weight_format(String weight){
        String regex ="\\d{1,5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(weight);
        return matcher.matches();
    }
}
