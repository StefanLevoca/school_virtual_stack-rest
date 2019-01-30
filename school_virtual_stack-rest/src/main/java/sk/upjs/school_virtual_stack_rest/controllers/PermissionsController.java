/*
 * package sk.upjs.school_virtual_stack_rest.controllers;
 * 
 * import org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import paz1c_projekt.school_virtual_stack.entity.Permissions; import
 * paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory; import
 * paz1c_projekt.school_virtual_stack.perzistentna.PermissionDAO; import
 * sk.upjs.school_virtual_stack_rest.exceptions.PermissionNotFoundException;
 * 
 * @CrossOrigin
 * 
 * @RestController public class PermissionsController {
 * 
 * private PermissionDAO permissionDAO = DAOFactory.INSTANCE.getPermissionDAO();
 * 
 * 
 * @RequestMapping(value = "/permissions/{id}", method = RequestMethod.POST)
 * public void addPermission(@PathVariable long id, @RequestBody String
 * permission) throws DaoException { try { permissionDAO.addPermission(id,
 * permission); } catch (Exception e) { throw new DaoException(e); } }
 * 
 * 
 * @RequestMapping("/permissions/{id}") public Permissions
 * getPermissionByUserId(@PathVariable long id) { Permissions permission =
 * permissionDAO.getPermissionByUserId(id); if (permission == null) { throw new
 * PermissionNotFoundException(id); } return permission; }
 * 
 * 
 * 
 * @RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT)
 * public void updatePermission(@PathVariable long id, @RequestBody List<String>
 * list) throws DaoException { try { permissionDAO.update(id, list); } catch
 * (Exception e) { throw new DaoException(e); } }
 * 
 * 
 * 
 * @RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
 * public void deletePermission(@PathVariable long id, @RequestBody String
 * permission) throws PermissionNotFoundException { permissionDAO.delete(id,
 * permission); }
 * 
 * 
 * }
 */