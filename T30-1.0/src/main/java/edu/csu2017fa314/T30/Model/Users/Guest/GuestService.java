package edu.csu2017fa314.T30.Model.Users.Guest;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Users.BasePurchase;
import edu.csu2017fa314.T30.Model.Users.BaseService;

import java.util.ArrayList;

public class GuestService extends BaseService<Guest> implements BasePurchase {

    ArrayList<Guest> users;
    Gson gson;

    public GuestService(){
        users = new ArrayList<Guest>();
        gson = new Gson();
    }

    @Override
    public String getAllData() {
        // Convert Java objects to JSON
        String json = gson.toJson(users);
        System.out.println(json);
        return json;
    }

    @Override
    public String search(String searchVal) {
        Guest myUser = new Guest();

        // get single object entry
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email.equals(searchVal)) {
                myUser = users.get(i);
            }
        }
        String json = gson.toJson(myUser);
        System.out.println(json);
        return json;
    }

    @Override
    public void addUser (Guest user){
        users.add(user);
    }

    @Override
    public String purshase() {
        return "GuestPurchase";
    }
}
