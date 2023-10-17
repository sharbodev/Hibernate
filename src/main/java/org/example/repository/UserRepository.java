package org.example.repository;

import org.example.model.User;
import org.example.util.HibernateDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    private final SessionFactory sessionFactory = HibernateDb.getSessionFactory();

    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
    public User findById(Long id){
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
    public List<User> findAll(){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("select a from User a");
        List<User> list = query.list();
        session.close();
        return list;
    }
    public void update(Long id, User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user1 = session.get(User.class, id);
        user1.setName(user.getName());
        session.update(user1);
        transaction.commit();
        session.close();
        System.out.println("updated");
    }
    public void deleteById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        transaction.commit();
        session.close();
    }
    public void deleteAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete from User");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
