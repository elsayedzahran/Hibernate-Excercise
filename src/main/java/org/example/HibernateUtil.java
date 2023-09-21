package org.example;

import entities.Doctor;
import entities.Drug;
import entities.Hospital;
import entities.Patient;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory factory;
    private HibernateUtil(){}
    public static synchronized SessionFactory getSessionFactory(){
        if (factory == null){
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Doctor.class)
                    .addAnnotatedClass(Hospital.class)
                    .addAnnotatedClass(Drug.class)
                    .addAnnotatedClass(Patient.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}
