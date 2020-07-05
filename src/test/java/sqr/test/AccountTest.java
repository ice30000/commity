package sqr.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sqr.dao.IAccountMap;
import sqr.domain.Account;

import java.io.InputStream;
import java.util.List;

/*
* 账户类测试
* */
public class AccountTest {
    private SqlSession sqlSession;
    private InputStream in;
    private IAccountMap accountMap;
    @Before
    public void init()throws Exception{
        //1、读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、创建sqlSession对象
        sqlSession = factory.openSession();
        //4、创建代理对象
        accountMap = sqlSession.getMapper(IAccountMap.class);
    }
    @After
    public void destory()throws Exception{
        //事务提交
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        //5、查询所有
        List<Account> accounts = accountMap.findAllAccount();
        for(Account a:accounts){
            System.out.println(a);
        }
    }

    @Test
    public void testFindAccountUser_2(){
        //5、查询所有 包含所有账户以及用户名和地址
        List<Account> accounts = accountMap.findAllAccountUser_2();
        for(Account a:accounts){
            System.out.println(a);
            System.out.println(a.getUser());
        }
    }
}
