package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorID")
    private int doctorID;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "HospitalID", referencedColumnName = "HospitalID")
    private Hospital hospital;

}