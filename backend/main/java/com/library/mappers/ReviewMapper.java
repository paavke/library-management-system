package com.library.mappers;

import com.library.entities.Review;
import com.library.dtos.ReviewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toDTO(Review review);
    Review toEntity(ReviewDTO reviewDTO);
}
