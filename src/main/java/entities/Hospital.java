package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Hospital")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HospitalID")
    private int hospitalID;

    @Column(name = "HospitalName")
    private String hospitalName;

    @Column(name = "Address")
    private String address;
    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "hospital")
    private List<Patient> patients;

}