import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class MathModel {
    public static Double sumkoef = null;
    public static Integer price(String item_selected1, String item_selected2, int weight) {
         sumkoef=Cities.cityKoef.get(item_selected1)+Cities.cityKoef.get(item_selected2);
        if(sumkoef>2.0 &&sumkoef<=4.0){
            sumkoef/=2;
        }
        else if(sumkoef>4.0 &&sumkoef<=5.0){
            sumkoef/=2.5;
        }
        else if(sumkoef>5.0) {
            sumkoef /= 3.5;
        }

        if (weight > 68000 || weight == 0) {
            JOptionPane.showMessageDialog(null,
                    "Введите целое число от 1 до 68000 включительно",
                    "Неверно введены значения!",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
        //Расчёт коэффициентов для веса груза
        if(weight>0 &&weight<=500.0){
            weight*=24;
        }
        else if(weight>500.0 &&weight<=1000.0){
            weight*=23;
        }
        else if(weight>1000.0 &&weight<=2000.0){
            weight*=22;
        }
        else if(weight>2000.0) {
            weight *= 21;
        }
        if(weight<2000){
            weight=2000;
            JOptionPane.showMessageDialog(null,
                    "Минимальная стоимость услуги 2000 рублей\nБез учета тарифа",
                    "Замечание",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        weight*=sumkoef;
        return weight;

    }
}
