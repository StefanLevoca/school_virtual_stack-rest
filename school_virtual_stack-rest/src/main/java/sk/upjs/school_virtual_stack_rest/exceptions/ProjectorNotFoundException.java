package sk.upjs.school_virtual_stack_rest.exceptions;

public class ProjectorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private long projectorId;

	public ProjectorNotFoundException(long projectorId) {
		this.projectorId = projectorId;
	}

	public long getProjectorId() {
		return projectorId;
	}
}
