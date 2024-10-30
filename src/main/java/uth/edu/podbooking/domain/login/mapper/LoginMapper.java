package uth.edu.podbooking.domain.login.mapper;

import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.login.dto.LoginRequest;
import uth.edu.podbooking.domain.login.dto.LoginRespone;


@Mapper(componentModel = "spring")
public interface LoginMapper {
    Account toAccount(LoginRequest loginRequest);
    LoginRespone toLoginRespone(Account account);
}
