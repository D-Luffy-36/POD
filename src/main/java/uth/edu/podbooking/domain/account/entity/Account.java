package uth.edu.podbooking.domain.account.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.util.Date;

@Data
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
}
