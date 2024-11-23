package uth.edu.podbooking.domain.booking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import uth.edu.podbooking.domain.booking.dto.BookingRequest;
import uth.edu.podbooking.domain.booking.dto.BookingResponse;
import uth.edu.podbooking.domain.booking.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
  
    @Mapping(source = "account.fullName", target = "customerName")
    @Mapping(source = "account.email", target = "customerEmail")
    BookingResponse toBookingResponse(Booking booking);

    Booking toBooking(BookingRequest request);
}