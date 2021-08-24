/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountsdemo;

import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Orax Solution Provider +923219598676
 */
public class Utils {

    public static NumberFormatter numberFormatter() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        return formatter;
    }

}
