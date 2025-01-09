package com.github.edurbs.laloja.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum PersonType implements EnumClass<String> {

    NATURAL("N"),
    LEGAL("J");

    private final String id;

    PersonType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PersonType fromId(String id) {
        for (PersonType at : PersonType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}