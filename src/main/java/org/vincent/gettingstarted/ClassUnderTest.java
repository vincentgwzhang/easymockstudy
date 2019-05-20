package org.vincent.gettingstarted;

public class ClassUnderTest {

    private Collaborator listener;

    public void setListener(Collaborator listener) {
        this.listener = listener;
    }

    public void removeDocument(String title) {
        listener.documentAdded(title);
    }
}