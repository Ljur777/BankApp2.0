package com.example.bankapp.controller;

import com.example.bankapp.entity.Client;
import com.example.bankapp.service.Impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addClient(@RequestParam String username, @RequestParam String password) {
       Client client = new Client();
       client.getName(username);
       client.setPassword(password);

        if (!clientServiceImpl.save(client)) {
       //     model.put("client", "Client exists!");
            return "registration";
        }

        return "redirect:/login";
    }

//    @GetMapping("/activate/{code}")
//    public String activate(Model model, @PathVariable String code) {
//     //   boolean isActivated = clientService.activateUser(code);
//
//        if (isActivated) {
//            model.addAttribute("message", "User successfully activated");
//        } else {
//            model.addAttribute("message", "Activation code is not found!");
//        }
//
//        return "login";
//    }
}
