import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        JFrame main_GUI = new JFrame("Victory");
        main_GUI.setTitle ("Calc_GI");
        main_GUI.setBounds(500,400,400,500);
        main_GUI.setResizable(false);
        main_GUI.setVisible(true);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        main_GUI.add(main_panel);

        JLabel laba_info = new JLabel("Надпись");
        laba_info.setBounds(60,0,300,30);
        main_panel.add(laba_info);

        String[] items = {
                "Уфа",
                "Абакан",
                "Урюпинск"
        };
        JComboBox<String> combo_tarif = new JComboBox<>(items);
        combo_tarif.setSelectedItem(0);
        combo_tarif.setBounds(30,40,150,30);
        ActionListener actionListener = e -> {

        };
        combo_tarif.setBackground(new Color(154,132,223));
        combo_tarif.addActionListener(actionListener);
        main_panel.add(combo_tarif);
    }
}
