package org.vincent.gettingstarted;

public interface Collaborator {

    void documentAdded(String title);

    byte voteForRemovals(String title);

    boolean documentRemoved(String title);

}
