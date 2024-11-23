package uth.edu.podbooking.domain.booking.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.repository.AccountRepository;
import uth.edu.podbooking.domain.booking.dto.BookingRequest;
import uth.edu.podbooking.domain.booking.dto.BookingResponse;
import uth.edu.podbooking.domain.booking.entity.Booking;
import uth.edu.podbooking.domain.booking.entity.BookingStatus;
import uth.edu.podbooking.domain.booking.mapper.BookingMapper;
import uth.edu.podbooking.domain.booking.repository.BookingRepository;
import uth.edu.podbooking.domain.location.entity.Location;
import uth.edu.podbooking.domain.location.repository.LocationRepository;
import uth.edu.podbooking.domain.pod.entity.Pod;
import uth.edu.podbooking.domain.pod.repository.PodRepository;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;
import uth.edu.podbooking.domain.workspace.repository.WorkSpaceRepository;



@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final AccountRepository  accountRepository;
    private final BookingMapper bookingMapper;
    private final WorkSpaceRepository workspaceRepository;
    private final LocationRepository locationRepository;
    private final PodRepository podRepository;

    public BookingService(
        BookingRepository bookingRepository,
        BookingMapper bookingMapper,
        WorkSpaceRepository workspaceRepository,
        LocationRepository locationRepository,
        PodRepository podRepository,
        AccountRepository accountRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.workspaceRepository = workspaceRepository;
        this.locationRepository = locationRepository;
        this.podRepository = podRepository;
        this.accountRepository = accountRepository;
    }

  public BookingResponse createBooking(BookingRequest request) {
        // Lấy Workspace và Location từ database
        WorkSpace workspace = workspaceRepository.findById(request.getWorkspaceId())
                .orElseThrow(() -> new RuntimeException("Workspace không tồn tại"));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location không tồn tại"));

        // Lấy danh sách Pods từ database
        List<Pod> pods = podRepository.findAllById(request.getPodIds());
        if (pods.size() != request.getPodIds().size()) {
            throw new RuntimeException("Một hoặc nhiều Pods không tồn tại");
        }

        Account account = accountRepository.findById(request.getAccountId())
        .orElseThrow(() -> new RuntimeException("Account không tồn tại"));


        // Kiểm tra trùng giờ
        LocalDateTime startTime = request.getStartTime();
        LocalDateTime endTime = request.getEndTime();
        
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(startTime, endTime);
        if (!conflictingBookings.isEmpty()) {
            throw new RuntimeException("Giờ đặt phòng đã bị trùng với một hoặc nhiều Booking khác");
        }

        // Tạo Booking Entity từ Request
        Booking booking = bookingMapper.toBooking(request);
        booking.setWorkSpace(workspace);
        booking.setLocation(location);
        booking.setAccount(account);
        booking.setPods(new HashSet<>(pods));
        booking.setStatus(BookingStatus.PENDING); // Đặt trạng thái mặc định là PENDING

        // Lưu xuống database
        booking = bookingRepository.save(booking);

        // Trả về BookingResponse
        return bookingMapper.toBookingResponse(booking);
    }


    public BookingResponse getBookingById(Long id) {
        return this.bookingRepository.findById(id)
                .map(bookingMapper::toBookingResponse) // Chuyển Booking Entity thành BookingResponse
                .orElseThrow(() -> new RuntimeException("Booking không tồn tại với ID: " + id));
    }

      public List<BookingResponse> getAllBookings() {
        // Lấy tất cả các Booking từ database
        List<Booking> bookings = bookingRepository.findAll();

        // Chuyển đổi các Booking thành BookingResponse
        return bookings.stream()
                       .map(booking -> bookingMapper.toBookingResponse(booking))
                       .collect(Collectors.toList());
    }
    
}

