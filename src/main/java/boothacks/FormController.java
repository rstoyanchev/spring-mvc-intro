package boothacks;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {


	@RequestMapping(method=RequestMethod.GET)
	public void setupForm(Model model) {
		model.addAttribute(new FormBean());
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processFormSubmit(@Valid FormBean formBean, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		return "redirect:/";
	}
	
}
