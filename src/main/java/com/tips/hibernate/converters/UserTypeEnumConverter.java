package com.tips.hibernate.converters;

import com.tips.hibernate.enumerations.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeEnumConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType userType) {
        return userType.enumValue();
    }

    @Override
    public UserType convertToEntityAttribute(String s) {
        return UserType.fromText(s);
    }
}
