package com.tips.hibernate.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {

    PRAVNO_LICE("legal"),
    FIZICKO_LICE("individual");

    private final String enumValue;

    UserType(final String value) {
        this.enumValue = value;
    }

    public String enumValue() {
        return enumValue;
    }

    @JsonCreator
    public static UserType fromText(String text)
    {
        for (UserType userType : UserType.values())
        {
            if (userType.enumValue().equalsIgnoreCase(text)) {
                return userType;
            }
        }
        throw new IllegalArgumentException();
    }
}
