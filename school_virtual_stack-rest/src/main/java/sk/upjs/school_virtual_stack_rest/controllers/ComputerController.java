package sk.upjs.school_virtual_stack_rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import paz1c_projekt.school_virtual_stack.entity.Computer;
import paz1c_projekt.school_virtual_stack.perzistentna.ComputerDAO;
import paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory;
import sk.upjs.school_virtual_stack_rest.exceptions.ComputerNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.DaoException;

@CrossOrigin
@RestController
public class ComputerController {
	//toto
	private ComputerDAO computerDAO = DAOFactory.INSTANCE.getComputerDAO();

	@RequestMapping(value = "/computers", method = RequestMethod.POST)
	public Computer addCompter(@RequestBody Computer computer) throws DaoException {
		try {
			computerDAO.addComputer(computer);
			return computer;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@RequestMapping("/computers")
	public List<Computer> getAll() {
		return computerDAO.getAll();
	}

	@RequestMapping("/computers/{id}")
	public Computer getByDeviceId(@PathVariable long id) {
		Computer computer = computerDAO.getByDeviceId(id);
		if (computer == null) {
			throw new ComputerNotFoundException(id);
		}
		return computer;
	}
	
	//neimplementovane
	/*
	 * @RequestMapping(value = "/computers", method = RequestMethod.PUT) public void
	 * saveComputer(@RequestBody Computer computer) throws DaoException { try {
	 * computerDAO.saveComputer(computer); } catch (Exception e) { throw new
	 * DaoException(e); } }
	 */
}
