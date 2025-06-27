package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile create(Profile profile);

    // Added These two methods
    Profile getByUserId(int userId);
    void update(Profile profile);

}
