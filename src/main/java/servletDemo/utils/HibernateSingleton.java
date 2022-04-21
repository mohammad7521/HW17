package servletDemo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import servletDemo.Product;


public class HibernateSingleton {

    private HibernateSingleton() {}

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure() // goes and fetches configuration from hibernate.cfg.xml
                    .build();

            // registry is useful for creating Session factory is a heavyweight object.
            // SessionFactory is thread safe.
            // SessionFactory is immutable.

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Product.class)
                    .buildMetadata()
                    .buildSessionFactory();

        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Session getSession(){

        if (LazyHolder.INSTANCE.isClosed()){
            return LazyHolder.INSTANCE.openSession();
        }else return LazyHolder.INSTANCE.getCurrentSession();
    }
}
