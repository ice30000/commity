package sqr.dao;

import sqr.domain.User;

import java.util.List;

/*
* 映射接口
* */
public interface IUserMap {
    /*
    * 查询所有
    * */
    List<User> findAll();
    /*
    * 向数据库添加数据
    * */
    void saveUser(User user);
    /*
    *更新数据库用户
    **/
    void updateUser(User user);
    /*
    *根据Id删除数据库用户信息
    */
    void deleteId(Integer id);
    /*
    * 根据Id查询数据库用户信息
    * */
    public User findUserById(Integer userId);
    /*
     * 根据名称查询数据库用户信息
     * */
    public List<User> findUserByName(String username);
    /*
    * 查询用户数
    * */
    int findTotal();
    /*
    * 通过QueryVo中的条件查询
    * */

    /*
    * 通过条件查询用户
    * */
    List<User> findUserCondition(User user);
}
