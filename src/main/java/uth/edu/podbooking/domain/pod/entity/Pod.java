package uth.edu.podbooking.domain.pod.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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


}
