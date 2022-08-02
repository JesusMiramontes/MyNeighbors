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
@Builder
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

    public Integer visitorsCount() {
        return visitors.size();
    }

    public Owner getOwner() {
        if (null == owner) owner = new Owner();
        return owner;
    }
}
