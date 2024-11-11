package uth.edu.podbooking.domain.pod.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "type_pods")
public class TypePod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private TypePodName name;

    private int capacity;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

}
