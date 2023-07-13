package backend.controllers;

import backend.exeptions.UserAlreadyExist;
import backend.exeptions.UserNotFound;
import backend.service.UserService;
import backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    ResponseEntity addUser(@RequestBody Map<String, String> map){
        try {
            User user = new User(
                    map.get("lastname"),
                    map.get("firstname"),
                    map.get("patronymic"),
                    map.get("nickname"),
                    map.get("tg"),
                    map.get("vk"),
                    map.get("phone"),
                    map.get("password"),
                    false
            );
            userService.addUser(user);
            User userInfo = userService.getUser(map.get("phone"),map.get("password"));
            return ResponseEntity.ok().body(userInfo);
        }catch (UserAlreadyExist e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody Map<String, String> map){
        try{
            User authUser = userService.auth(map.get("phone"), map.get("password"));
            return ResponseEntity.ok().body(authUser);
        }catch (UserNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
