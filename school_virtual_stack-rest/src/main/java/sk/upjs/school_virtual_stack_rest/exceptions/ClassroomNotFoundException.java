package sk.upjs.school_virtual_stack_rest.exceptions;

public class ClassroomNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private long classroomId;

	public ClassroomNotFoundException(long classroomId) {
		this.classroomId = classroomId;
	}

	public long getClassroomId() {
		return classroomId;
	}
}
