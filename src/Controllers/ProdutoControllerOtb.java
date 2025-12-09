/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BEAN.ProdutoOtb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class ProdutoControllerOtb extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public ProdutoOtb getBean(int sel) {
        return (ProdutoOtb) lista.get(sel);
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

        ProdutoOtb produtosOtb = (ProdutoOtb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return produtosOtb.getIdProdutoOtb();
        }
        if (columnIndex == 1) {
            return produtosOtb.getNomeOtb();
        }
        if (columnIndex == 2) {
            return produtosOtb.getPrecoOtb();
        }
        if (columnIndex == 3) {
            return produtosOtb.getMarca();
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
            return "Preco";
        }
        if (column == 3) {
            return "Marca";
        }

        return "";
    }
;
}
