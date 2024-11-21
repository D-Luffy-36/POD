package uth.edu.podbooking.domain.account.enums;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    STAFF_AT_LOCATION("ROLE_STAFF_AT_LOCATION"),
    CUSTOMER("ROLE_CUSTOMER");

    private final String code;

    Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
