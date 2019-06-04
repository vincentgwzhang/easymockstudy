package personal.study.extertal_outofmemory;

import junit.framework.TestCase;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class UserServiceTest extends TestCase{

	private UserDao userDao;
	private UserService userService = new UserService();

	public void testRegisterUser() {
		User user = new User();
		user.type = "vip";
		userDao = createMock(UserDao.class);
		expect(userDao.insertUser(user)).andReturn(true);
		replay(userDao);
		userService.setUserDao(userDao);
		assertEquals(true, userService.registerUser(user));
		verify(userDao);
	}

}