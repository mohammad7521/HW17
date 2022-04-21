package servletDemo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import servletDemo.Product;

public enum EnumSingleton {

    INSTANCE;

    public static SessionFactory sessionFactory;

    static {
        if (sessionFactory==null){
            var registry=new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            sessionFactory=new MetadataSources(registry)
                    .addAnnotatedClass(Product.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }
}
