package uth.edu.podbooking.domain.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import uth.edu.podbooking.domain.booking.dto.BookingRequest;
import uth.edu.podbooking.domain.booking.dto.BookingResponse;
import uth.edu.podbooking.domain.booking.service.BookingService;


@RestController
@Data
@AllArgsConstructor

@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

   @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest request) {
        BookingResponse response = bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBooking(@PathVariable Long id) {
        BookingResponse booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

 
    @GetMapping
    public ResponseEntity<List<BookingResponse>> list() {
        // Lấy tất cả các BookingResponse từ service
        List<BookingResponse> bookingResponses = bookingService.getAllBookings();

        // Nếu không có booking nào, trả về mã 204 No Content
        if (bookingResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Trả về danh sách BookingResponse với mã trạng thái 200 OK
        return ResponseEntity.ok(bookingResponses);
    }
    
}
