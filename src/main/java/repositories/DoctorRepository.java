package repositories;

import entities.Doctor;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.util.*;
import java.util.stream.Collectors;


public class DoctorRepository {
    Session session = null;
    public List<Doctor> getDoctorsInHospital(int hospitalId) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Doctor> doctors =(List<Doctor>) session.createQuery("From Doctor").getResultList();
            doctors= doctors.stream().filter( doctor -> doctor.getHospital()
                    .getHospitalID() == hospitalId).collect(Collectors.toList());

            session.getTransaction().commit();
            return doctors;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }

        return Collections.emptyList();
    }

}
