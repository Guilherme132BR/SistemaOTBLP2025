/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ComprasOtb;
import BEAN.ComprasProdutosOtb;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Guilherme132BR
 */
public class ComprasProdutosOTB_DAO extends DAO_Abstract{
    @Override
    public void insert(Object object) {
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
    session.beginTransaction();
    session.flush();
    session.clear();
    session.update(object);
    session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
    session.beginTransaction(); 
    session.flush();
    session.clear();
    session.delete(object);
    session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasProdutosOtb.class);
        criteria.add(Restrictions.eq("IdComprasProdutosOtb", id)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasProdutosOtb.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
    
        public List listProdutos(ComprasOtb comprasOtb){
       session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasProdutosOtb.class);
        criteria.add( Restrictions.eq("comprasOtb", comprasOtb));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

}
