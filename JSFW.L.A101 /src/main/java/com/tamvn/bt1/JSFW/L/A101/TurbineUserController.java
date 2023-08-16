package com.tamvn.bt1.JSFW.L.A101;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tamvn.bt1.DAO.TurbineUserDAO;
import com.tamvn.bt1.entities.TurbineUser;

@Controller
public class TurbineUserController {
	@Autowired
	private TurbineUserDAO userDao;

	@GetMapping("/users")
	public String getAllUsers(Model model) throws SQLException {

		List<TurbineUser> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	
	
	@GetMapping("/userdetail/{userId}")
	public String getUser(@PathVariable int userId, Model model) {
	    try {
	        TurbineUser user = userDao.getUserById(userId);
	        model.addAttribute("user", user);
	        return "userdetail";
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "error";
	    }
	}

//	@RequestMapping(value = "/userCreated", method = RequestMethod.POST)
    @GetMapping("/userCreated")
    public String createdUser(@ModelAttribute("user") TurbineUser user, Model model) throws SQLException {
//		TurbineUser createdUser = userDao.addUser(user);
//        model.addAttribute("user", createdUser);
//        return "userCreated";
    
    // tao mot empty user
    TurbineUser turbineUser = new TurbineUser();
    
    	// add emtty user vao model
    
    model.addAttribute("user", turbineUser);
    	
    // return form
    return "userCreated";
    }
    
    @PostMapping("/userCreated")
    public String saveUser(@ModelAttribute("user") TurbineUser user) throws SQLException {
//		TurbineUser createdUser = userDao.addUser(user);
//        model.addAttribute("user", createdUser);
//        return "userCreated";
    
    // tao mot empty user
//    TurbineUser turbineUser = new TurbineUser();
    
    	// add emtty user vao model
    
//    model.addAttribute("user", turbineUser);
    	
    // return form
    	
    	userDao.addUser(user);
    return "redirect:/users";
    }
    
    
    
    @PostMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable("id") int userId, TurbineUser user) throws SQLException {
        userDao.updateUser(user);
        return "redirect:/userUpdate/" + userId;
    }
}
