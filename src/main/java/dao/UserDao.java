package dao;

import models.Auto;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

//import static utils.HibernateSessionFactoryUtil.*;

public class UserDao {

    public UserDao() {
    }

    public User findById(int id) throws HibernateException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }
    public void save(User user){
        Transaction tx1 = null;
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            tx1=session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }catch (Exception e){
            if (tx1!=null){
                tx1.rollback();
            }
            System.out.println("Fail");
        }
    }

    public void update(User user){
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete (User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class,id);
    }

    public List<User> findAll(){
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return users;
    }

}
