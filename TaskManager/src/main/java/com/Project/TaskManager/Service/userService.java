package com.Project.TaskManager.Service;

import com.Project.TaskManager.Entity.users;
import com.Project.TaskManager.Repo.usersrepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userService {
    @Autowired
    private usersrepo userrepo;
    public users saveusers(users user)
    {
        return userrepo.save(user);
    }
    public List<users> getusertaskdetails()
    {
        return userrepo.findAll();
    }
    public void deleteusertaskdetails(int userid)
    {
        userrepo.deleteById(userid);
    }
    public users updateuserdetails(users user)
    {
        return userrepo.save(user);
    }

}
