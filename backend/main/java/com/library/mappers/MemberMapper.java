package com.library.mappers;

import com.library.entities.Member;
import com.library.dtos.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    MemberDTO toDTO(Member member);
    Member toEntity(MemberDTO memberDTO);
}
