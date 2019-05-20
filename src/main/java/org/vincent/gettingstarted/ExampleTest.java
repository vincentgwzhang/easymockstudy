package org.vincent.gettingstarted;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ExampleTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator; // 1, Create the mock

    @TestSubject
    private ClassTested classUnderTest = new ClassTested(); // 2. Have it set to the tested class

    /**
     * verifyAll 就是测试是不是所有mock 都运行了
     */
    @Test
    public void addDocument() {
        collaborator.documentAdded("New Document"); // 3. Record what we expect the mock to do
        replayAll(); // 4.Tell all mocks we are now doing the actual testing
        classUnderTest.addDocument("New Document", "content"); // 5. Test
        verifyAll(); // 6.Make sure everything that was supposed to be called was called
    }
}