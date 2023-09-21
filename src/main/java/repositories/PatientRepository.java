package repositories;

import entities.Doctor;
import entities.Drug;
import entities.Patient;
import org.example.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository {
    Session session = null;
    public List<Patient> getPatientsForDoctor(int doctorId) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            // Use HQL to retrieve patients associated with the specified doctor
//            String hql = "SELECT p FROM Patient p " +
//                    "WHERE p.doctor.doctorID = :doctorId";
//
//            List<Patient> patients = session.createQuery(hql, Patient.class)
//                    .setParameter("doctorId", doctorId)
//                    .getResultList();
            List<Patient> patients = session.createQuery("from Patient ", Patient.class).getResultList();
            patients = patients.stream()
                    .filter(patient -> patient.getDoctor().getDoctorID() == doctorId)
                    .collect(Collectors.toList());

            session.getTransaction().commit();
            return patients;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return new ArrayList<Patient>();
    }

}
