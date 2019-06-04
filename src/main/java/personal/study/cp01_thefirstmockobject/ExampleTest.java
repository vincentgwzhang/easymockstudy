package personal.study.cp01_thefirstmockobject;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.easymock.EasyMock.mock;

public class ExampleTest {

	private ClassTested classUnderTest;

	private Collaborator mock;

	@BeforeEach
	public void setUp() {
		mock = mock(Collaborator.class); // 1
		classUnderTest = new ClassTested();
		classUnderTest.setListener(mock);
	}

	@Test
	public void testRemoveNonExistingDocument() {
		// This call should not lead to any notification
		// of the Mock Object:
		//classUnderTest.removeDocument("Does not exist");
	}
}