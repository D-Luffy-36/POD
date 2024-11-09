package uth.edu.podbooking.domain.workspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uth.edu.podbooking.domain.location.entity.Location;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workspaces")
public class WorkSpace {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany()
    @JoinTable(
            name = "workspace_location",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;

}
