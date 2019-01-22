package sk.upjs.school_virtual_stack_rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import paz1c_projekt.school_virtual_stack.entity.Projector;
import paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory;
import paz1c_projekt.school_virtual_stack.perzistentna.ProjectorDAO;
import sk.upjs.school_virtual_stack_rest.exceptions.DaoException;
import sk.upjs.school_virtual_stack_rest.exceptions.ProjectorNotFoundException;

@CrossOrigin
@RestController
public class ProjectorController {

	private ProjectorDAO projectorDAO = DAOFactory.INSTANCE.getProjectorDAO();

	@RequestMapping(value = "/projectors", method = RequestMethod.POST)
	public Projector addProjector(@RequestBody Projector projector) throws DaoException {
		try {
			projectorDAO.addProjector(projector);
			return projector;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@RequestMapping("/projectors")
	public List<Projector> getAll() {
		return projectorDAO.getAll();
	}

	@RequestMapping("/projectors/{id}")
	public Projector getByDeviceId(@PathVariable long id) {
		Projector projector = projectorDAO.getByDeviceId(id);
		if (projector == null) {
			throw new ProjectorNotFoundException(id);
		}
		return projector;
	}

	@RequestMapping(value = "/projectors", method = RequestMethod.PUT)
	public void saveProjector(@RequestBody Projector projector) throws DaoException {
		try {
			projectorDAO.saveProjector(projector);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
