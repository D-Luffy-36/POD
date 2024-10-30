package uth.edu.podbooking.domain.auth.mapper;

import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.auth.dto.request.LoginRequest;
import uth.edu.podbooking.domain.auth.dto.respone.LoginRespone;


@Mapper(componentModel = "spring")
public interface LoginMapper {
    Account toAccount(LoginRequest loginRequest);
    LoginRespone toLoginRespone(Account account);
}
