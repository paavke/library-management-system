package com.library.mappers;

import com.library.entities.Loan;
import com.library.dtos.LoanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { BookMapper.class, MemberMapper.class })
public interface LoanMapper {
    @Mapping(target = "loanDate", source = "loanDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "returnDate", source = "returnDate", dateFormat = "yyyy-MM-dd")
    LoanDTO toDTO(Loan loan);

    Loan toEntity(LoanDTO loanDTO);
}
