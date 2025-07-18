package com.Project.TaskManager.Controller;

import com.Project.TaskManager.Entity.users;
import com.Project.TaskManager.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TO-DOAPP/users")
public class UserController {
    @Autowired
    private userService userservice;
    @PostMapping
    public users saveusers(@RequestBody users user)
    {
        return userservice.saveusers(user);
    }
    @GetMapping("/tasks")
    public List<users> getusertaskdetails()
    {
        return userservice.getusertaskdetails();
    }
    @DeleteMapping("{userid}")
    public String deleteUsertasks(@PathVariable int userid)
    {
        userservice.deleteusertaskdetails(userid);
        return "deleted sucessfully";

    }
}
