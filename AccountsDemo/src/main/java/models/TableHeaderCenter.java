/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Umar Rehman
 */
public class TableHeaderCenter extends DefaultTableCellRenderer {

    private JLabel cell;

    public TableHeaderCenter() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, column);
        cell = (JLabel) c;
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setText(value.toString());
        cell.setBackground(Color.ORANGE);
        cell.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        cell.setFocusable(true);
        return cell;
    }

}
