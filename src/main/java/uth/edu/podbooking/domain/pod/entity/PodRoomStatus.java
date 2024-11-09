package uth.edu.podbooking.domain.pod.entity;

public enum  PodRoomStatus {
    AVAILABLE, // có sẵn
    OCCUPIED, // đang có người sử dụng
    RESERVED, // đã đặt
    IN_MAINTENANCE, // đang bao tri
    CLEANING, // đang dọn dẹp
    OFFLINE ;// Ngoại tuyến
}
