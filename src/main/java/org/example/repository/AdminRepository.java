package org.example.repository;

import org.example.model.Admin;
import org.example.model.User;
import org.example.util.HibernateDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminRepository {
    private final SessionFactory sessionFactory = HibernateDb.getSessionFactory();

    public void save(Admin admin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
        session.close();
    }
    public Admin findById(Long id){
        Session session = sessionFactory.openSession();
        Admin admin = session.get(Admin.class,id);
        session.close();
        return admin;
    }
    public List<Admin> findAll(){
        Session session = sessionFactory.openSession();
        Query<Admin> query = session.createQuery("select a from Admin a");
        List<Admin> list = query.list();
        session.close();
        return list;
    }
    public void update(Long id, Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Admin admin1 = session.get(Admin.class, id);
        admin1.setPassword(admin.getPassword());
        admin1.setLogin(admin.getLogin());
        session.update(admin1);
        transaction.commit();
        session.close();
    }
    public void deleteById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Admin admin = session.get(Admin.class,id);
        session.delete(admin);
        transaction.commit();
        session.close();
    }
    public void deleteAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete from Admin");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
