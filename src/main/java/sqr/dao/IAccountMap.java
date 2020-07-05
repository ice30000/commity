package sqr.dao;

import sqr.domain.Account;

import java.util.List;

public interface IAccountMap {
    /*
    * 账户查询所有
    * */
    List<Account> findAllAccount();
    /*
    * 查询所有账户，同时获取当前账户的所属用户信息
    * */
    List<Account> findAllAccountUser_2();
    Account findAccountById(Integer id);
}
