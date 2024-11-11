package uth.edu.podbooking.domain.pod.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pods")
public class Pod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String img;

    @Enumerated(EnumType.STRING)
    private PodRoomStatus status;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    // loại phòng
    @ManyToOne
    private TypePod type;

    // tiện nghi
    @ManyToMany
    @JoinTable(
            name = "pod_amenitiy",
            joinColumns = @JoinColumn(name = "pod_id"),
            inverseJoinColumns = @JoinColumn(name = "anmenity_id"))
    Set<Amenity> amenities;

    @ManyToMany
    @JoinTable(
            name = "workspace_pod",
            joinColumns = @JoinColumn(name = "pod_id"),
            inverseJoinColumns = @JoinColumn(name = "workspace_id"))
    Set<WorkSpace> workspaces;


}
