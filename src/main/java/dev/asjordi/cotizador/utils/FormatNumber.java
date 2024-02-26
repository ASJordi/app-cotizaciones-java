package dev.asjordi.cotizador.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class FormatNumber {
    
    public static double roundTo2DecimalPlaces(double number) {
      return BigDecimal.valueOf(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
    } 
    
}
