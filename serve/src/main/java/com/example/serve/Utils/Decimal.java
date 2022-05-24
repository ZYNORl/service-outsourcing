package com.example.serve.Utils;

import java.math.BigDecimal;

public class Decimal {
    public static void main(String[] args) {
        System.out.println(Decimal.getDecimals());
    }
    public static double  getDecimals(){
        BigDecimal cha = new BigDecimal(Math.random()*(5f-2.0f)+2.0f);
        return cha.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
