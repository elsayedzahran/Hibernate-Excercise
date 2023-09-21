package repositories;
import entities.Drug;
import entities.Patient;
import org.example.HibernateUtil;

import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DrugRepository {
    Session session = null;
    public List<Drug> getDrugsPrescribedByDoctor(int doctorId) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

//            String hql = "SELECT d FROM Drug d " +
//                         "JOIN d.patients p " +
//                         "WHERE p.doctor.doctorID = :doctorId";
//            List<Drug> drugs = session.createQuery(hql, Drug.class)
//                    .setParameter("doctorId", doctorId)
//                    .getResultList();
            var patients = session.createQuery("from Patient ", Patient.class).getResultList();
            var drugs = patients.stream()
                    .filter(patient -> patient.getDoctor().getDoctorID() == doctorId)
                    .flatMap(patient -> patient.getDrugs().stream())
                    .collect(Collectors.toList());

            session.getTransaction().commit();
            return drugs;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

}
