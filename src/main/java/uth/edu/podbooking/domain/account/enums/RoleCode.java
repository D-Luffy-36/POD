package uth.edu.podbooking.domain.account.enums;

public enum RoleCode {
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    STAFF_AT_LOCATION("ROLE_STAFF_AT_LOCATION"),
    USER("ROLE_USER"),
    GUEST("ROLE_GUEST");

    private final String code;

    RoleCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
