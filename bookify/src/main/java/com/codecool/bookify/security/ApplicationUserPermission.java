package com.codecool.bookify.security;

public enum ApplicationUserPermission {
    APPOINTMENT_READ("appointment:read"),
    APPOINTMENT_WRITE("appointment:write"),
    CATEGORY_READ("category:read"),
    CATEGORY_WRITE("category:write"),
    COMPANY_READ("company:read"),
    COMPANY_WRITE("company:write"),
    COMPANY_DETAIL_READ("company_detail:read"),
    COMPANY_DETAIL_WRITE("company_detail:write"),
    ROLE_READ("role:read"),
    ROLE_WRITE("role:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_RATE_READ("user_rate:read"),
    USER_RATE_WRITE("user_rate:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
