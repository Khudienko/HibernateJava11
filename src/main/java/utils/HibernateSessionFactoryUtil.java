package utils;

import models.Auto;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
//import javax.imageio.spi.ServiceRegistry;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null){
            try{
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
                settings.put(Environment.URL,"jdbc:mysql://localhost:3306/test_hibernate");
                settings.put(Environment.USER,"root");
                settings.put(Environment.PASS,"");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL,"true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
                settings.put(Environment.HBM2DDL_AUTO,"create-drop");
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Auto.class);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory=configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Exeption " + e);
            }
        }
        return sessionFactory;
    }
}
