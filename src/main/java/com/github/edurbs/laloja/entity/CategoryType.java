package com.github.edurbs.laloja.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum CategoryType implements EnumClass<String> {

    ASSET("asset"),
    LIABILITIES("liabilities"),
    EQUITY("equity"),
    REVENUE("revenue"),
    COGS("cogs"),
    EXPENSES("expenses");

    private final String id;

    CategoryType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CategoryType fromId(String id) {
        for (CategoryType at : CategoryType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}