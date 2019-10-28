package edu.csu2017fa314.T30.Model.Users;

import edu.csu2017fa314.T30.Model.Users.Guest.Guest;

public abstract class BaseService<T> {

    public abstract String getAllData();
    public abstract String search(String searchVal);
    public abstract void addUser (T user);

}
