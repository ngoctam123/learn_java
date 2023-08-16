package predev07.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import predev07.domain.Company;
import predev07.domain.Position;
import predev07.domain.Post;
import predev07.domain.User;
import predev07.service.CompanyService;
import predev07.service.GroupService;
import predev07.service.PositionService;
import predev07.service.PostService;
import predev07.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@Autowired
	CompanyService companyService;

	@Autowired
	PositionService positionService;

	@Autowired
	GroupService groupService;

	@ModelAttribute("postes")
	public List<Post> getPostList() {
		return postService.findAll();
	}

	@ModelAttribute("positions")
	public List<Position> getPositionList() {
		return positionService.findAll();
	}

	@ModelAttribute("companies")
	public List<Company> getCompanies() {
		return companyService.findAll();
	}

	@GetMapping("/list")
	public String list(Model model, @RequestParam(name = "searchSelectBox", required = false) String search,
			@RequestParam(name = "searchInput", required = false) String searchInput) {
		model.addAttribute("user", new User());
		List<User> list = null;
		if (StringUtils.hasText(search)) {

			list = userService.findByCompanyIdQuery(search);
		} else {
			list = userService.findAll();
		}

//		users.forEach(t-> System.out.println(t.getUserId()));
		model.addAttribute("listUser", list);
		return "user/user";
	}

	@RequestMapping("/list/delete")
	public String delete(Model model, @RequestParam(name = "delete", required = false) String userId
		) {
		model.addAttribute("user", new User());
		List<User> list = null;
		if (StringUtils.hasText(userId)) {
			String[] userIdArr = userId.split(",");
			for (String string : userIdArr) {
				Optional<User> optional = userService.findById(Long.parseLong(string));
				if(optional.isPresent()) {
					userService.delete(optional.get());
					System.out.println("delete success");
				}else {
					System.out.println("not found");
				}
			}
		}
		list = userService.findAll();
//		users.forEach(t-> System.out.println(t.getUserId()));
		model.addAttribute("listUser", list);
		return "redirect:/user/list";
	}

	@RequestMapping("/saveOrUpdate/{department}")
	public String saveOrUpdate(Model model, @Valid @ModelAttribute("user") User user,
			@PathVariable("department") String nameCompany, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "user/list";
		}

		String[] postes = nameCompany.split(",");
		for (String string : postes) {
			Company company = companyService.findByCompanyNameContaining(string);
			user.setCompany(company);
			userService.save(user);
			System.out.println("Success");
		}

		attributes.addFlashAttribute("message", "User is saved!");
//			model.addAttribute("message", "Category is saved!");
		return "redirect:/user/list";

	}

}
