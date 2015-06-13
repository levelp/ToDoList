package levelp.home;

import levelp.support.web.MessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        model.addAttribute(new SearchForm());
        return getView(principal);
    }

    private String getView(Principal principal) {
        return principal != null ? "home/homeSignedIn" :
                "home/homeNotSignedIn";
    }


    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SearchForm searchForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return getView(null);
        }
        MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
