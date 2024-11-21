package uth.edu.podbooking.domain.account.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uth.edu.podbooking.domain.location.entity.Location;


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
    @Column(unique=true)
    private String phone;

    @Column(nullable = false, unique=true)
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
