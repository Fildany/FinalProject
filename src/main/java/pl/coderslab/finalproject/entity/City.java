package pl.coderslab.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="miasta")
public class City {
    @Id
    private Integer id;
    @Column(name = "nazwa")
    private String name;
    @ManyToOne
    @JoinColumn(name = "woj_id")
    private Voivodeship voivodeship;

}
