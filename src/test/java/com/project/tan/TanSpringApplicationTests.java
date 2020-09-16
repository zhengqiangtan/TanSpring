//package com.project.tan;
//
//import com.project.tan.entity.dao.UserMapper;
//import com.project.tan.entity.dto.UserDTO;
//import com.project.tan.entity.model.User;
//import com.project.tan.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springfamework.test.context.junit4.SpringRunner;
//
///**
// * 单元测试用例（记得打开IDEA junit插件）
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TanSpringApplication.class)
//class TanSpringApplicationTests {
//
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	UserMapper userMapper;
//
//	@Test
//	public void testUserService() {
//		UserDTO userById = userService.getUserById(1L);
//		System.out.println(userById.toString());
//	}
//
//
//	@Test
//	public void testSql(){
////		User user = userMapper.findUserById(2L);
////		System.out.println("Test select: " + user.toString());
////
////
////		int deleteUser = userMapper.deleteUser((long) 3);
////		System.out.println("Test delete:" + deleteUser);
////
////		User user1 = User.builder().id(1L).name("Testing").email("888880000@qq.com").build();
////		int updateById = userMapper.updateById(user1);
////		System.out.println("Test update: " + updateById);
//
//
//		User user2 = User.builder().name("测试3").age(15).email("8111112341@qq.com").build();
//		int insert = userMapper.insertUser(user2);
//		System.out.println("Test inset: " + insert);
//
//
//	}
//
//}
