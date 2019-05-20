package org.vincent.gettingstarted;

public class ClassTested {

    private Collaborator listener;

    public void setListener(Collaborator listener) {
        this.listener = listener;
    }

    public void addDocument(String title, String document) {
        listener.documentAdded(title);
    }

    public boolean removeDocuments(String title) {
        return listener.documentRemoved(title);
    }
}