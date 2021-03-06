package com.newsproutsmedia.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vets")
public class Vet extends Person {

    // make sure to initialize sets with "new" and type of set, otherwise you'll end up with problems
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name="vet_id"),
            inverseJoinColumns = @JoinColumn(name="specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();


}
