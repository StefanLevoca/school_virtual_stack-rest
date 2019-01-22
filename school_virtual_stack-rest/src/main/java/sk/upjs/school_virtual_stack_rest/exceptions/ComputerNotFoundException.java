package sk.upjs.school_virtual_stack_rest.exceptions;

public class ComputerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private long computerId;

	public ComputerNotFoundException(long computerId) {
		this.computerId = computerId;
	}

	public long getComputerId() {
		return computerId;
	}
}
