/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.UsuarioOtb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Guilherme132BR
 */
public class UsuarioOtb_DAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(UsuarioOtb.class);
        criteria.add(Restrictions.eq("IdUsuarioOtb", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuarioOtb.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }

     public List listDataNasc(Date DataNascOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuarioOtb.class);
        criteria.add(Restrictions.eq("dataNascOtb", DataNascOtb ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;   
    
}

    public List listNome(String NomeOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuarioOtb.class);
        criteria.add(Restrictions.gt("nomeOtb", NomeOtb));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public List listDataNascNome(Date DataNascOtb, String NomeOtb) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuarioOtb.class);
        criteria.add(Restrictions.eq("DatanascOtb", DataNascOtb));
        criteria.add(Restrictions.gt("NomeOtb", NomeOtb));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
        public UsuarioOtb LoginUsuario(String login, String senha) {
        session.beginTransaction();

        Query query = session.createQuery("FROM UsuarioOtb WHERE NomeOtb = :nomeotb AND Senhaotb = :senhaotb");
        query.setParameter("nomeotb", login);
        query.setParameter("senhaotb", senha);

        UsuarioOtb usuarioOtb = (UsuarioOtb) query.uniqueResult();

        session.getTransaction().commit();

        return usuarioOtb;
    }

}
