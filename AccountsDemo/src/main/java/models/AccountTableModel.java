/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.accountsdemo.Entry;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Orax Solution Provider +923219598676
 */
public class AccountTableModel extends AbstractTableModel {

    private final List<Entry> entries;
    private final String column[];
    private int serial = 1;
    private final SimpleDateFormat dateFormat;

    public AccountTableModel() {
        this.column = new String[]{"No", "Date", "User", "Description", "Debit", "Credit"};
        this.entries = new ArrayList<>();
        dateFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm a");
    }

    public AccountTableModel(List<Entry> entries) {
        this.column = new String[]{"No", "Date", "User", "Description", "Debit", "Credit"};
        this.entries = entries;
        dateFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm a");
    }

    public String[] getColumn() {
        return column;
    }

    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entry e;
        if (rowIndex > -1 && rowIndex < entries.size()) {
            e = entries.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return serial;
                case 1:
                    return dateFormat.format(e.getCreateDate());
                case 2:
                    return e.getUser();
                case 3:
                    return e.getDescription();
                case 4:
                    if (e.getAccountType() == 1) {
                        return e.getAmount();
                    }
                    return "";
                case 5:
                    if (e.getAccountType() == 2) {
                        return e.getAmount();
                    }
                    return "";
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Entry e;
        if (rowIndex > -1 && rowIndex < entries.size()) {
            e = entries.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    serial++;
                    break;
                case 1:
                    e.setCreateDate((Date) aValue);
                    break;
                case 2:
                    e.setUser(aValue.toString());
                    break;
                case 3:
                    e.setDescription(aValue.toString());
                    break;
                case 4:
                    if (e.getAccountType() == 1) {
                        e.setAmount((float) aValue);
                    }
                case 5:
                    if (e.getAccountType() == 2) {
                        e.setAmount((float) aValue);
                    }
                    break;
                default:
            }
        }
    }

    public void addRow(Entry e) {
        entries.add(e);
        fireTableDataChanged();
    }

    public void removeAll() {
        entries.clear();
        fireTableDataChanged();
        serial = 1;
    }

}
