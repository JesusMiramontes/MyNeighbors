package com.miramontes.myneighbors.model;

import java.util.Set;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house")
@ToString
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    @JoinColumn(name = "owner_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Owner owner;

    @OneToMany(mappedBy = "house")
    private Set<Visitor> visitors;
}
