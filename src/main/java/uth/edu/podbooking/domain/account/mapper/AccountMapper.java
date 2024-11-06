package uth.edu.podbooking.domain.account.mapper;

import org.mapstruct.Mapper;


import uth.edu.podbooking.domain.account.dto.request.AccountRequest;
import uth.edu.podbooking.domain.account.dto.response.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account toAccount(AccountRequest accountRequest);

  AccountResponse toAccountResponse(Account account);



  List<AccountResponse> toAccountResponseList(List<Account> accounts);
}
