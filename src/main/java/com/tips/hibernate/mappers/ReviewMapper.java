package com.tips.hibernate.mappers;

import com.tips.hibernate.dto.ReviewCustomDTO;
import com.tips.hibernate.dto.ReviewDTO;
import com.tips.hibernate.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Description;

@Description(value = "Review Mapper Definitions.")
@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO reviewEntityToReviewDTO(Review review);

    @Mappings(value = {
        @Mapping(source = "id", target = "identifier"),
        @Mapping(source = "comment", target = "comm")
    })
    ReviewCustomDTO reviewEntityToReviewCustomDTO(Review review);
}
