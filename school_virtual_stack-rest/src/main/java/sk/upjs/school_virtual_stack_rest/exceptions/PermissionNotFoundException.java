package sk.upjs.school_virtual_stack_rest.exceptions;

public class PermissionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private long permissionId;

	public PermissionNotFoundException(long permissionId) {
		this.permissionId = permissionId;
	}

	public long getPermissionId() {
		return permissionId;
	}
}
