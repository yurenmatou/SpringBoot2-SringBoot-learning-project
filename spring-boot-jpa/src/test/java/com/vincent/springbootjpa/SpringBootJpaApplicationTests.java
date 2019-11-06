package com.vincent.springbootjpa;

import com.vincent.springbootjpa.bean.User;
import com.vincent.springbootjpa.bean.UserDetail;
import com.vincent.springbootjpa.bean.UserInfo;
import com.vincent.springbootjpa.dao.UserDetailRepository;
import com.vincent.springbootjpa.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootJpaApplicationTests {


    @Resource
    private UserRepository repository;
    @Resource
    private UserDetailRepository userDetailRepository;

    @Autowired
    private com.vincent.springbootjpa.service.UserService userService;

    @Test
    void contextLoads() {
    }

    //    @Test
    void saveAllUserDetail() {
        List<UserDetail> userDetails = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            UserDetail userDetail = new UserDetail();
            userDetail.setId(i + 1L);
            userDetail.setUserId(5L - i);
            userDetail.setAge(i + 10);
            userDetail.setStatus(new Random().nextInt(1) + "");
            userDetail.setHobby("这是一个测试" + (i + 1));
            userDetails.add(userDetail);
        }
        userDetailRepository.saveAll(userDetails);
    }

    @Test
    void findUserWithUserDetail() {
//        System.out.println(userDetailRepository.findUser("这是一个测试1"));
//        System.out.println(userDetailRepository.findUserWithUserDetail());

        List<UserInfo> userInfoList = userDetailRepository.findUserWithUserDetail("是");
        if (null != userInfoList && userInfoList.size() > 0) {
            for (int i = 0; i < userInfoList.size(); i++) {
                System.out.println(userInfoList.get(i).getHobby());
            }
        }
    }

    //    @Test
    void saveUser() {
        for (int i = 4; i < 7; i++) {
            User user1 = new User("小丽" + i, "123456", "10086" + i + "@qq.com", "兔斯基" + i, System.currentTimeMillis() + "");
            userService.saveUser(user1);
        }
    }

    //    @TestQ
    void findUser() {
        System.out.println(userService.findUser("小丽1"));
    }

    @Test
    void findUserPager() {
        Sort orders = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 10, orders);
        List<User> userList = repository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUserName());
        }

        Page<User> userPage0 = repository.findUserLists(pageable);
        Page<User> userPage = repository.findByNickName("aa", pageable);
        List<User> userList1 = userPage.getContent();
        List<User> userList2 = userPage0.getContent();

        for (int i = 0; i < userPage.getContent().size(); i++) {
            System.out.println(userPage.getContent().get(i).getUserName());
        }

        User user = repository.findByUserNameOrEmail("aa", "aa@126.com");
        User user2 = repository.findByUserName("aa");
        Page<User> userPage2 = repository.findRoomUidsByIdPageable(1, pageable);
//        User user2 = repository.findFirstByOrderByUsernameAsc();
        Page<User> userPage3 = repository.queryFirst10ById(1, pageable);
        Slice<User> userPage4 = repository.findTop3ById(1, pageable);
        List<User> userPage5 = repository.findFirst10ById(1, orders);
        List<User> userPage6 = repository.findTop10ById(1, pageable);
        Page<User> userPage7 = repository.findByUsername("aa", pageable);
        Slice<User> userPage8 = repository.findByUserNameAndEmail("aa", "aa@126.com", pageable);
        User user3 = repository.findByEmail("aa@126.com");
        int modifyById = repository.modifyById("cc",3L);
        repository.deleteById(1L);
    }

}
