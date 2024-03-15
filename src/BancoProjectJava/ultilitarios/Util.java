package BancoProjectJava.ultilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Util {

    static NumberFormat formatValue = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double value){
        return  formatValue.format(value);
    }
}
