package uth.edu.podbooking.domain.workspace.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uth.edu.podbooking.domain.location.entity.Location;
import uth.edu.podbooking.domain.pod.entity.Pod;


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

    // workspace sẽ có các phòng
    @ManyToMany
    @OrderBy("id ASC")
    @JoinTable(
            name = "workspace_pod",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "pod_id"))
    private Set<Pod> pods;

    @ManyToMany()
    @JoinTable(
            name = "workspace_location",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;

}
