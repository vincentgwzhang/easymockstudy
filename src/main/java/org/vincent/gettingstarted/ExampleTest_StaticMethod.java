package org.vincent.gettingstarted;
import static org.easymock.EasyMock.*;
import org.junit.*;

public class ExampleTest_StaticMethod {

    private ClassUnderTest classUnderTest;

    private Collaborator mock;

    @Before
    public void setUp() {
        mock = mock(Collaborator.class);
        classUnderTest = new ClassUnderTest();
        classUnderTest.setListener(mock);
    }

    @Test
    public void testRemoveNonExistingDocument() {
        String title = "Does not exist";

        //在 replay 之前，的意思就是说 mock 应该有什么行为，包括参数应该是什么，相当于这里就是 expected
        //注意：如果在 replay 函数出现之前没有记录 mocked object 得行为（例如 mock.documentAdded(title)），然后直接测试得话，就会出错
        mock.documentAdded(title);

        //录制，把所有得记住了
        replay(mock);

        // 开始测试
        classUnderTest.removeDocument(title);
    }

}
