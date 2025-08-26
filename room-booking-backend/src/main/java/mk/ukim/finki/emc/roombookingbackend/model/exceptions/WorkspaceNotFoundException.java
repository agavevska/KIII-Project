package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class WorkspaceNotFoundException extends RuntimeException {

    public WorkspaceNotFoundException(Long id) {
        super(String.format("The workspace with ID %s does not exist.", id));
    }

}
