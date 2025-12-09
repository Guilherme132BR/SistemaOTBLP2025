/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.ComprasOtb;
import BEAN.ComprasProdutosOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class ComprasProdutosControllerOtb extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    

    
    public void addBean(ComprasProdutosOtb comprasProdutosOtb) {
            lista.add(comprasProdutosOtb);
            this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
            lista.remove(index);
            this.fireTableDataChanged();
    }
    
    public void updateBean(int index, ComprasProdutosOtb comprasProdutosOtb){
        lista.set(index, comprasProdutosOtb);
        this.fireTableDataChanged();
    }

    ;
    public ComprasProdutosOtb getBean(int row) {
        return (ComprasProdutosOtb) lista.get(row);
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

        ComprasProdutosOtb comprasProdutosOtb = (ComprasProdutosOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return comprasProdutosOtb.getIdComprasProdutosOtb();
        }
        if (columnIndex == 1) {
            return comprasProdutosOtb.getProdutootb();
        }
        if (columnIndex == 2) {
            return comprasProdutosOtb.getValorUnidadeOtb();
        }
        if (columnIndex == 3) {
            return comprasProdutosOtb.getTotalOtb();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Produtos";
        }
        if (column == 2) {
            return "Valor unitário";
        }
        if (column == 3) {
            return "Valor total";
        }

        return "";
    }
;
}
