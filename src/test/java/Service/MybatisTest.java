package Service;

import com.Bean.User;
import com.Dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class MybatisTest {
    private SqlSession session;
    private InputStream in;
    private IUserDao userDao;
    /**
     * 入门案例
     * @param args
     */
    @Before
    public void begin() throws Exception{
        //1.读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao=session.getMapper(IUserDao.class);
        //3.2使用工厂创建dao对象
//        return new UserDaoImpl(factory);
    }
    @After
    public void end() throws Exception{
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public  void main()throws Exception {
        //1.读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper(IUserDao.class);

        //3.2使用工厂创建dao对象
       // IUserDao userDao=new UserDaoImpl(factory);

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
//        session.close();
//        in.close();
        end();
    }
    @Test
    public void testSave() throws Exception {
//        User user=new User();
//        user.setUsername("方懋建");
//        user.setAddress("你心里");
//        user.setBirthday(new Date());
//        user.setSex("男");
//        userDao.saveUser(user);
        List<User> users = userDao.findAll();
        for(User usera : users){
            System.out.println(usera);
        }

    }
}
