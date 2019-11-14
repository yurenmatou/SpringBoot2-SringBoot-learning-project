package com.vincent.springbootmybatis;

import com.vincent.springbootmybatis.model.Account;
import com.vincent.springbootmybatis.model.User;
import com.vincent.springbootmybatis.mapper.UserMapper;
import com.vincent.springbootmybatis.model.UserSexEnum;
import com.vincent.springbootmybatis.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 共同点
 * @Resource 和@Autowired都可以作为注入属性的修饰，在接口仅有单一实现类时，两个注解的修饰效果相同，可以互相替换，不影响使用。
 *
 * 不同点
 * @Resource 是Java自己的注解，@Resource有两个属性是比较重要的，分是name和type；Spring将@Resource注解的name属性解析为bean的名字，
 * 而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。
 * 如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
 * @Autowired 是spring的注解，是spring2.5版本引入的，Autowired只根据type进行注入，不会去匹配name。
 * 如果涉及到type无法辨别注入对象时，那需要依赖@Qualifier或@Primary注解一起来修饰。
 *
 */
@SpringBootTest
class SpringBootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;


//    @Autowired
    @Resource
    private AccountService accountService;


    @Test
    void contextLoads() {

    }


    @Test
    void testService() {
        List<Account> accountList = accountService.findAccountList();
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(accountList.get(i).getName());
        }
    }


    @Test
    void insert() {
        userMapper.insert(new User("aa", "123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "123456", UserSexEnum.MAN));
    }

    @Test
    void select() {
        List<User> userList = userMapper.getAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("name--" + userList.get(i).userName);
        }
    }

    @Test
    void getOne() {
        User user = userMapper.getOne(5L);
        if (null != user) {
            System.out.println(user.userName);
        }
    }

    @Test
    void update() {
        User user = new User("bb", "123456", UserSexEnum.WOMAN, 11);
        int count = userMapper.update(user);
        System.out.println("更新数据条数：" + count);
    }

    @Test
    void delete() {
        int count = userMapper.delete(11L);
        System.out.println("删除数据条数：" + count);
    }

}
