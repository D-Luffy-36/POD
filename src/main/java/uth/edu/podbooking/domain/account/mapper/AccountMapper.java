package uth.edu.podbooking.domain.account.mapper;


import org.mapstruct.Mapper;

import uth.edu.podbooking.domain.account.dto.AccountDTO;
import uth.edu.podbooking.domain.account.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account accountDTOToAccount(AccountDTO accountDTO);
    AccountDTO accountToAccountDTO(Account account);
}
