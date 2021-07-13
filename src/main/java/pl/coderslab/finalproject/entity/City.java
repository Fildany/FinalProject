package pl.coderslab.finalproject.entity;

import javax.persistence.*;

@Entity
@Table(name="miasta")
public class City {
    @Id
    private int id;
    @Column(name = "nazwa")
    private String name;
    @ManyToOne
    @JoinColumn(name = "woj_id")
    private Voivodeship voivodeship;

}
