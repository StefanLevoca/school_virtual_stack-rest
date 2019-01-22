package sk.upjs.school_virtual_stack_rest.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import sk.upjs.school_virtual_stack_rest.exceptions.ClassroomNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.ComputerNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.DaoException;
import sk.upjs.school_virtual_stack_rest.exceptions.PermissionNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.ProjectorNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.UserNotFoundException;

@ControllerAdvice
public class RestAdvizer {

	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleNumberFormatException(NumberFormatException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), "Id must be a number");
	}

	@ExceptionHandler(ClassroomNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleClassroomNotFoundException(ClassroomNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(),
				String.format("Classroom with id %d does not exists", e.getClassroomId()));
	}

	@ExceptionHandler(ComputerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleComputerNotFoundException(ComputerNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(),
				String.format("Computer with id %d does not exists", e.getComputerId()));
	}

	@ExceptionHandler(PermissionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handlePermissionNotFoundException(PermissionNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(),
				String.format("Permission with id %d does not exists", e.getPermissionId()));
	}

	@ExceptionHandler(ProjectorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleProjectorNotFoundException(ProjectorNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(),
				String.format("Projector with id %d does not exists", e.getProjectorId()));
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleUserNotFoundException(UserNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(),
				String.format("User with id %d does not exists", e.getUserId()));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), String.format("Not in a right format: %s", e.getMessage()));
	}

	@ExceptionHandler(DaoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleDaoException(DaoException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(),
				String.format("Not in a right format: %s", e.getCause().getMessage()));
	}
}
