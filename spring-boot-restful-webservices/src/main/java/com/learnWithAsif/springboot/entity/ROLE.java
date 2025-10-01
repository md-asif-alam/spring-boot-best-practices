package com.learnWithAsif.springboot.entity;

import lombok.Getter;

import java.util.Set;


@Getter
public enum ROLE {
    ROLE_ADMIN(Set.of(Permission.READ,Permission.WRITE,Permission.DELETE)),
    ROLE_USER(Set.of(Permission.READ));

    private final Set<Permission> permissions;

    ROLE(Set<Permission> permissions) {
        this.permissions = permissions;
    }

}
