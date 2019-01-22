package sk.upjs.school_virtual_stack_rest.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private long userId;

	public UserNotFoundException(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}
}
