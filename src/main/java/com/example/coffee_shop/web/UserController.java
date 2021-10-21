package com.example.coffee_shop.web;

import com.example.coffee_shop.model.binding.UserLoginBindingModel;
import com.example.coffee_shop.model.binding.UserRegisterBindingModel;
import com.example.coffee_shop.model.service.UserLoginService;
import com.example.coffee_shop.model.service.UserRegisterService;
import com.example.coffee_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("userExists")) {
            model.addAttribute("userExists",true);
        }

        return "login";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute @Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.passwordsMatch()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);

            return "redirect:register";

        }

        boolean usernameExists = this.userService.
                checkIfUserExistsByUsername(
                        userRegisterBindingModel.getUsername()
                );

        boolean emailExists = this.userService.
                checkIfUserExistsByEmail(
                        userRegisterBindingModel.getEmail()
                );

        if (usernameExists || emailExists) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);

            return "redirect:register";
        }

        this.userService.saveUser(modelMapper.map(userRegisterBindingModel, UserRegisterService.class));

        return "redirect:login";

    }

    @PostMapping("/login")
    public String loginConfirm(@ModelAttribute @Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            return "redirect:login";
        }

        boolean userExistByUsernameAndPassword = this.userService.
                checkIfUserExistsByUsernameAndPassword(
                        userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword()
                );
        if (!userExistByUsernameAndPassword) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            redirectAttributes.addFlashAttribute("userExists",false);

            return "redirect:login";
        }

        this.userService.loginUser(modelMapper.map(userLoginBindingModel, UserLoginService.class));

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";
    }
}
