/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ClienteOtb;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Guilherme132BR
 */
public class ClienteOtb_DAO extends DAO_Abstract {
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
        Criteria criteria = session.createCriteria(ClienteOtb.class);
        criteria.add(Restrictions.eq("IdClienteotb", id)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteOtb.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
    
         public List listNome(String NomeOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteOtb.class);
        criteria.add(Restrictions.like("NomeOtb", "%" + NomeOtb + "%"));
        List results = criteria.list();
        session.getTransaction().commit();
        return results;
    
    
}
     public List listFkUsuarios(int FkUsuarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteOtb.class);
        criteria.add(Restrictions.eq("UsuariosOtb", FkUsuarios));
        List results = criteria.list();
        session.getTransaction().commit();  
        return results;
     }    
    public List listNomeFkUsuarios(String NomeOtb, Object FkUsuarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClienteOtb.class);
        criteria.add(Restrictions.like("nomeOtb", "%" + NomeOtb + "%"));
        criteria.add(Restrictions.eq("UsuariosOtb", FkUsuarios));

        List results = criteria.list();
        session.getTransaction().commit();
        return results;
    
    
}
}
