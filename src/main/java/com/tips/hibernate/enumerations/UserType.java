package com.tips.hibernate.enumerations;

import org.springframework.context.annotation.Description;

@Description(value = "User Type Enumeration.")
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
