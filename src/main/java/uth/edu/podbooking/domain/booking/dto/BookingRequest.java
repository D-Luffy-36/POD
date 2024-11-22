package uth.edu.podbooking.domain.booking.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingRequest {
    private Long workspaceId; // ID của Workspace
    private Long locationId; // ID của Location
    private Long accountId; // ID của Account (người dùng đặt phòng)
    private Double price; // Giá của Booking
    private LocalDateTime startTime; // Thời gian bắt đầu
    private LocalDateTime endTime; // Thời gian kết thúc
    private List<Long> podIds; // Danh sách ID các Pods được đặt
}
