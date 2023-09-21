package org.example;

import entities.Doctor;
import entities.Drug;
import entities.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.DoctorRepository;
import repositories.DrugRepository;
import repositories.PatientRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DoctorRepository doctorRepository = new DoctorRepository();
        List<Doctor> doctors = doctorRepository.getDoctorsInHospital(1);
        for (var doctor : doctors){
            System.out.println(doctor.getName());
        }


        PatientRepository patientRepository = new PatientRepository();
        List<Patient> patients = patientRepository.getPatientsForDoctor(1);
        for (var patient : patients){
            System.out.println(patient.getName());
        }


        DrugRepository drugRepository = new DrugRepository();
        List<Drug> drugs = drugRepository.getDrugsPrescribedByDoctor(1);
        for (var drug : drugs){
            System.out.println(drug.getDrugName());
        }

    }
}