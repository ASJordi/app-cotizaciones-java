package dev.asjordi.cotizador.utils;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class TableFilter {
    
    public static void applyFilter(JTable table, JRadioButton rb) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(rb.getText().trim()));
    }
    
    public static void applyFilter(JTable table, JRadioButton rb, int index) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(rb.getText().trim(), index));
    }
    
    public static void applyFilter(JTable table, JTextField txt) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(txt.getText().toLowerCase().trim()));
    }
    
    public static void applyFilter(JTable table, JTextField txt, int index) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(txt.getText().trim(), index));
    }
    
}
