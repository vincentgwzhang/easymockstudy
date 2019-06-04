package personal.study.cp01_thefirstmockobject;

public class ClassTested {

	private Collaborator listener;

	public void setListener(Collaborator listener) {
		this.listener = listener;
	}

	public void addDocument(String title, String document) {
		listener.documentAdded(title);
	}
}