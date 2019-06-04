package personal.study.iteye;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;
public class BaseTest {
	@Test
	public void testBaseDao(){
		//1、创建mock对象，以接口形式创建
		BaseDao baseDaoMock= EasyMock.createMock(BaseDao.class);
		//2、设定参预期和返回，查询预期值得到所设定的预期结果
		EasyMock.expect(baseDaoMock.queryById("111")).andReturn("abin");
		//3、结束录制
		EasyMock.replay(baseDaoMock);
		//比较service调用的值是否与设定的值相同
		BaseService baseService=new BaseService();
		baseService.setDao(baseDaoMock);
		String result=baseService.carryQuery("111");
		System.out.println("result="+result);
		TestCase.assertNotNull(result);
		TestCase.assertEquals("abin",result);
		//4、回放录制
		EasyMock.verify(baseDaoMock);
	}
}