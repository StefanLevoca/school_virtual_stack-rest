/*
 * package sk.upjs.school_virtual_stack_rest.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import paz1c_projekt.school_virtual_stack.entity.Device; import
 * paz1c_projekt.school_virtual_stack.perzistentna.DAOFactory; import
 * paz1c_projekt.school_virtual_stack.perzistentna.DeviceDAO; import
 * sk.upjs.school_virtual_stack_rest.exceptions.DaoException;
 * 
 * @CrossOrigin
 * 
 * @RestController public class DeviceController {
 * 
 * private DeviceDAO deviceDAO = DAOFactory.INSTANCE.getDeviceDAO();
 * 
 * @RequestMapping(value = "/devices", method = RequestMethod.POST) public
 * Device addDevice(@RequestBody Device device) throws DaoException { try {
 * deviceDAO.addDevice(device); return device; } catch (Exception e) { throw new
 * DaoException(e); } }
 * 
 * @RequestMapping("/devices") public List<Device> getAll() { return
 * deviceDAO.getAll(); }
 * 
 * @RequestMapping(value = "/devices", method = RequestMethod.PUT) public void
 * saveDevice(@RequestBody Device device) throws DaoException { try {
 * deviceDAO.saveDevice(device); } catch (Exception e) { throw new
 * DaoException(e); } } }
 */