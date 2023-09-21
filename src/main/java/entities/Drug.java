package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Drug")
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DrugID")
    private int DrugID;
    @Column(name = "DrugName")
    private String DrugName;
    @Column(name = "Description")
    private String Description;
    @ManyToMany
    @JoinTable(name = "DrugPatient",
            joinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "DrugID"),
            inverseJoinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "PatientID"))
    private List<Patient> patients;
}
