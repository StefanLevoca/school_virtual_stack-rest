package sk.upjs.school_virtual_stack_rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import paz1c_projekt.school_virtual_stack.entity.Classroom;
import paz1c_projekt.school_virtual_stack.perzistentna.ClassroomDAO;
import paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory;
import sk.upjs.school_virtual_stack_rest.exceptions.ClassroomNotFoundException;
import sk.upjs.school_virtual_stack_rest.exceptions.DaoException;

@CrossOrigin
@RestController
public class ClassroomController {
//toto
	private ClassroomDAO classroomDao = DAOFactory.INSTANCE.getClassroomDAO();

	@RequestMapping(value = "/classrooms", method = RequestMethod.POST)
	public Classroom addClassroom(@RequestBody Classroom classroom) throws DaoException {
		try {
			classroomDao.addClassroom(classroom);
			return classroom;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@RequestMapping("/classrooms")
	public List<Classroom> getAll() {
		return classroomDao.getAll();
	}

	@RequestMapping("/classrooms/{id}")
	public Classroom getByDeviceId(@PathVariable long id) {
		Classroom classroom = classroomDao.getByDeviceId(id);
		if (classroom == null) {
			throw new ClassroomNotFoundException(id);
		}
		return classroom;
	}

	/*
	 * @RequestMapping(value = "/classrooms/{newName}", method = RequestMethod.PUT)
	 * public void updateClassroom(@PathVariable String newName, @RequestBody
	 * Classroom classroom) throws DaoException { try {
	 * classroomDao.update(classroom, newName); } catch (Exception e) { throw new
	 * DaoException(e); } }
	 */

	@RequestMapping(value = "/classrooms", method = RequestMethod.DELETE)
	public void deleteClassroom(@RequestBody Classroom classroom) throws ClassroomNotFoundException {
		classroomDao.delete(classroom);
	}
}
