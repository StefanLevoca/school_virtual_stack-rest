package sk.upjs.school_virtual_stack_rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import paz1c_projekt.school_virtual_stack.entity.User;
import paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory;
import paz1c_projekt.school_virtual_stack.perzistentna.UserDAO;
import sk.upjs.school_virtual_stack_rest.exceptions.DaoException;
import sk.upjs.school_virtual_stack_rest.exceptions.UserNotFoundException;

@CrossOrigin
@RestController
public class UserController {

	private UserDAO userDAO = DAOFactory.INSTANCE.getUserDAO();

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) throws DaoException {
		try {
			userDAO.addUser(user);
			return user;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@RequestMapping("/users")
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@RequestMapping("/users/{id}")
	public User getByDeviceId(@PathVariable long id) {
		User user = userDAO.getByDeviceId(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		return user;
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public void saveUser(@RequestBody User user) throws DaoException {
		try {
			userDAO.saveUser(user);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public void updatePassword(@PathVariable long id, @RequestBody String newPasswd) throws DaoException {
		try {
			userDAO.updatePassword(id, newPasswd);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
