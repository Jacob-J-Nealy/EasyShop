package org.yearup.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.ProfileDao;
import org.yearup.data.UserDao;
import org.yearup.models.Profile;
import org.yearup.models.User;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProfileController {

    private ProfileDao profileDao;
    private UserDao userDao;

    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }



    @GetMapping
    public Profile getProfile(Principal principal)
    {
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);

        if (user == null)
            throw new RuntimeException("User not found: " + userName);

        return profileDao.getByUserId(user.getId());
    }

    @PutMapping
    public void updateProfile(@RequestBody Profile profile, Principal principal)
    {
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);

        if (user == null)
            throw new RuntimeException("User not found: " + userName);


        profile.setUserId(user.getId());
        profileDao.update(profile);
    }
}
