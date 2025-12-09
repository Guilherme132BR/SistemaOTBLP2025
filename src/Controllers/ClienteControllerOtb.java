/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.ClienteOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class ClienteControllerOtb extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public ClienteOtb getBean(int row) {
        return (ClienteOtb) lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ClienteOtb clienteOtb = (ClienteOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return clienteOtb.getIdClienteOtb();
        }
        if (columnIndex == 1) {
            return clienteOtb.getNomeOtb();
        }
        if (columnIndex == 2) {
            return clienteOtb.getSobreNomeOtb();
        }
        if (columnIndex == 3) {
            return clienteOtb.getCpfotb();
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
            return "Sobrenome";
        }
        if (column == 2) {
            return "CPF";
        }

        return "";
    }

}

