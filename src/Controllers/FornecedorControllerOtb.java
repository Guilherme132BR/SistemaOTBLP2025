/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.FornecedorOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class FornecedorControllerOtb extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public FornecedorOtb getBean(int sel) {
        return (FornecedorOtb) lista.get(sel);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        FornecedorOtb fornecedorOtb = (FornecedorOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return fornecedorOtb.getIdFornecedorOtb();
        }
        if (columnIndex == 1) {
            return fornecedorOtb.getNomeOtb();
        }
        if (columnIndex == 2) {
            return fornecedorOtb.getCpfotb();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "id";
        }
        if (column == 1) {
            return "nome";
        }
        if (column == 2) {
            return "CPF";
        }

        return "";
    }
;
}
