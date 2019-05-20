package org.vincent.gettingstarted;

import static org.easymock.EasyMock.expect;
import org.easymock.EasyMockSupport;
import org.easymock.IMocksControl;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SupportDelegationTest {

    private EasyMockSupport support = new EasyMockSupport();

    private Collaborator collaborator;

    private ClassTested classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new ClassTested();
    }

    @Test
    public void addDocument() {
        collaborator = support.mock(Collaborator.class);
        classUnderTest.setListener(collaborator);
        collaborator.documentAdded("New Document");
        support.replayAll();
        classUnderTest.addDocument("New Document", "content");
        support.verifyAll();
    }

    @Test
    public void voteForRemovals() {

        IMocksControl ctrl = support.createControl();
        collaborator = ctrl.createMock(Collaborator.class);
        classUnderTest.setListener(collaborator);

        collaborator.documentAdded("Document 1");

        expect(collaborator.voteForRemovals("Document 1")).andReturn((byte) 20);

        collaborator.documentRemoved("Document 1");

        support.replayAll();

        classUnderTest.addDocument("Document 1", "content");
        assertTrue(classUnderTest.removeDocuments("Document 1"));

        support.verifyAll();
    }
}