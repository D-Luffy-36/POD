package uth.edu.podbooking.domain.location.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;

@Entity
@Table(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;


    @ManyToMany(mappedBy = "locations")
    private Set<WorkSpace> workspaces = new HashSet<>();
}
