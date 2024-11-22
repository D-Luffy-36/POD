package uth.edu.podbooking.domain.booking.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.location.entity.Location;
import uth.edu.podbooking.domain.pod.entity.Pod;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Double price;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private BookingStatus status;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp //Tự động gán giá trị thời gian hiện tại (CURRENT_TIMESTAMP) vào cột mỗi khi bản ghi được cập nhật.
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable=false)
    private Account account;


    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable=false)
    private WorkSpace workSpace;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToMany
    @JoinTable(
        name = "booking_pod",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "pod_id")
    )
    private Set<Pod> pods = new HashSet<>();

}


