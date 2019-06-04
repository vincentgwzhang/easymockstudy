package personal.study.extertal_outofmemory;

public class UserService {

	private UserDao userDao;

	public boolean registerUser(User user) {
		if(user.type.equals("vip")) {
			return userDao.insertUser(user);
		} else {
			System.out.println("Only VIP user can be registered");
			return false;
		}
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
