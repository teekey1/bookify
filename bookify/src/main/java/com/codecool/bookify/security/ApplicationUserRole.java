package com.codecool.bookify.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.codecool.bookify.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    OWNER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(APPOINTMENT_READ,
            APPOINTMENT_WRITE,
            CATEGORY_READ,
            CATEGORY_WRITE,
            COMPANY_READ,
            COMPANY_WRITE,
            COMPANY_DETAIL_READ,
            COMPANY_DETAIL_WRITE,
            ROLE_READ,
            ROLE_WRITE,
            USER_READ,
            USER_WRITE,
            USER_RATE_READ,
            USER_RATE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
