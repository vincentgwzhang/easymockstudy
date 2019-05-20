package org.vincent.gettingstarted;

import static org.easymock.EasyMock.replay;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 一定要加入这个 annotation, 否则 @Mock 和 @TestSubject 会失效
 */
@RunWith(EasyMockRunner.class)
public class ExampleTest_Annotated {

    @TestSubject
    private ClassUnderTest classUnderTest = new ClassUnderTest();

    /**
     *
     * The annotation has an optional element,
     *
     *
     * 'type', to refine the mock as a 'nice' mock or a 'strict' mock.
     * Another optional annotation, 'name', allows setting of a name for the mock that will be used in the mock() call,
     * which will appear in expectation failure messages for example.
     *
     * fieldName 就是在被测试 Object 里面应该被取缔的属性
     *
     *
     * If more than one mock can be assigned to the same field then this is considered an error.
     * The fieldName qualifier can be used in this scenario to disambiguate the assignments.
     *
     *
     */
    @Mock(type = MockType.NICE, name = "this_is_mock_name", fieldName = "listener")
    private Collaborator mock;

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
