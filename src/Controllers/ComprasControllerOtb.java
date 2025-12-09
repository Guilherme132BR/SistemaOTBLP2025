/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.ComprasOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class ComprasControllerOtb extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }
    
    public ComprasOtb getBean(int linha) {
        return (ComprasOtb) lista.get(linha);
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
       ComprasOtb comprasOtb = (ComprasOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return comprasOtb.getIdComprasOtb();
        }
        if (columnIndex == 1) {
            return comprasOtb.getDataComprasOtb();
        }
        if (columnIndex == 2) {
            return comprasOtb.getTotalotb();
        }
        if (columnIndex == 3) {
            return comprasOtb.getFornecedorotb();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID da Compra";
        }
        if (columnIndex == 1) {
            return "Data da Compra";
        }
        if (columnIndex == 2) {
            return "Valor total da Compra";
        }
        if (columnIndex == 3) {
            return "Fornecedores";
        }
        
        return "";
    }
;
}
