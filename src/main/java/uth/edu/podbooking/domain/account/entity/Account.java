package uth.edu.podbooking.domain.account.entity;

import jakarta.persistence.*;
import lombok.*;
import uth.edu.podbooking.domain.location.entity.Location;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    private String lastName;
    private String fullName;
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private String img;
    private double points;
    private Boolean isActive;
    private Date created;
    private Date updated;
    // vip_id

    // location_id
    @OneToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    // role
    @ManyToMany()
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
