package uth.edu.podbooking.domain.booking.mapper;

import org.mapstruct.Mapper;

import uth.edu.podbooking.domain.booking.dto.BookingRequest;
import uth.edu.podbooking.domain.booking.dto.BookingResponse;
import uth.edu.podbooking.domain.booking.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toBooking(BookingRequest request);

    BookingResponse toBookingResponse(Booking booking);
}
