package com.dnc.projs.helpdesk.dnchelpdesk.controller;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import com.dnc.projs.helpdesk.dnchelpdesk.service.UserService;
import com.dnc.projs.helpdesk.dnchelpdesk.util.Response;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity<Response<User>> create(HttpServletRequest request,
                                                 @RequestBody User user,
                                                 BindingResult bindingResult) {
        Response<User> response = new Response<>();
        try {
            validateCreateUser(user, bindingResult);
            if(bindingResult.hasErrors()) {
                bindingResult
                        .getAllErrors()
                        .forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User userPersisted = this.userService.createOrUpdate(user);
            response.setData(userPersisted);

        }catch (DuplicateKeyException de) {
            response.getErrors().add("Email already registered");
        }catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    private void validateCreateUser(User user, BindingResult bindingResult) {
        if(user.getEmail() == null){
            bindingResult.addError(new ObjectError("User", "Email no information"));
        }
    }
