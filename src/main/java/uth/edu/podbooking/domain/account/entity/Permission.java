package uth.edu.podbooking.domain.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    private boolean active_flag;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
