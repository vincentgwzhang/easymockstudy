package org.vincent.gettingstarted;

import static org.easymock.EasyMock.replay;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

public class ExampleTest_Rule {

    @TestSubject
    private ClassUnderTest classUnderTest = new ClassUnderTest();

    @Mock
    private Collaborator mock;

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Before
    public void setUp() {
        //mock = mock(Collaborator.class); 已经是用了 @Mock

        /**
         * 是用了 @TestSubject 那么会自动 inject mocked object
        classUnderTest = new ClassUnderTest();
        classUnderTest.setListener(mock);
         */
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
