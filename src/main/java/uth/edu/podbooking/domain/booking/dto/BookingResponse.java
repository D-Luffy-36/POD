package uth.edu.podbooking.domain.booking.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.pod.dto.response.PodRespone;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookingResponse {
    private String customerName; // Tên của khách hàng
    private String customerEmail; // Email của khách hàng

    private Long bookingId; // ID của Booking
    private String status; // Trạng thái của Booking
    private Double price; // Giá của Booking
    private LocalDateTime startTime; // Thời gian bắt đầu
    private LocalDateTime endTime; // Thời gian kết thúc
    private WorkSpaceResponse workspace; // Thông tin Workspace
    private LocationResponse location; // Thông tin Location
    private List<PodRespone> pods; // Danh sách Pods được đặt
}
