package uth.edu.podbooking.domain.booking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uth.edu.podbooking.domain.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b JOIN FETCH b.pods WHERE b.id = :id")
    Booking findByIdWithPods(@Param("id") Long id);

    Booking findByWorkSpace_IdAndLocation_Id(Long workSpaceId, Long locationId);

    Booking findByWorkSpaceId(Long workspaceId);

    @Query("SELECT b FROM Booking b WHERE (b.startTime BETWEEN :startTime AND :endTime) OR (b.endTime BETWEEN :startTime AND :endTime)")
    List<Booking> findConflictingBookings(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
