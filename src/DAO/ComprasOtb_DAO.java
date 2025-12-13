/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ComprasOtb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Guilherme132BR
 */
public class ComprasOtb_DAO extends DAO_Abstract{
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
        Criteria criteria = session.createCriteria(ComprasOtb.class);
        criteria.add(Restrictions.eq("idComprasOtb", id)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasOtb.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
    
         public List listData(Date dataComprasOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasOtb.class);
        criteria.add(Restrictions.eq("dataComprasOtb", dataComprasOtb ));
        List results = criteria.list();
        session.getTransaction().commit();
        return results;
    
    
}
     public List listValor(Double totalOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasOtb.class);
        criteria.add(Restrictions.ge("totalOtb", totalOtb));
        List results = criteria.list();
        session.getTransaction().commit();  
        return results;
     }    
    public List listDataValor(Date dataComprasOtb, Double totalOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComprasOtb.class);
        criteria.add(Restrictions.eq("dataComprasOtb", dataComprasOtb ));        
        criteria.add(Restrictions.ge("totalOtb", totalOtb));

        List results = criteria.list();
        session.getTransaction().commit();
        return results;
    
}

}

