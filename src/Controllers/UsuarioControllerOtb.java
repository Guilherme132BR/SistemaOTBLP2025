/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.UsuarioOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class UsuarioControllerOtb extends AbstractTableModel {
    
     List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public UsuarioOtb getBean(int row) {
        return (UsuarioOtb) lista.get(row);
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

        UsuarioOtb usuarioOtb = (UsuarioOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuarioOtb.getIdUsuarioOtb();
        }
        if (columnIndex == 1) {
            return usuarioOtb.getNomeOtb();
        }
        if (columnIndex == 2) {
            return usuarioOtb.getApelidoOtb();
        }
        if (columnIndex == 3) {
            return usuarioOtb.getCpfOtb();
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
            return "apelido";
        }
        if (column == 3) {
            return "cpf";
        }

        return "";
    }
    
}
