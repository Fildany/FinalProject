package pl.coderslab.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "woje")
public class Voivodeship {
    @Id
    private int id;
    @Column(name = "nazwa")
    private String name;

}
