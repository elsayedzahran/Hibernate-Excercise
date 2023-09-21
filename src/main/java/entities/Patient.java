package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PatientID")
    private int PatientID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Gender")
    private String Gender;
    @ManyToOne
    @JoinColumn(name = "HospitalID", referencedColumnName = "HospitalID")
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "DoctorID", referencedColumnName = "DoctorID")
    private Doctor doctor;
    @ManyToMany
    @JoinTable(name = "DrugPatient",
            joinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "PatientID"),
            inverseJoinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "DrugID"))
    private List<Drug> drugs;
}
