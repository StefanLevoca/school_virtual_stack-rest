package sk.upjs.school_virtual_stack_rest.exceptionHandlers;

public class ApiError {
	private int status;
	private String errorMessage;

	public ApiError(int status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public int getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
