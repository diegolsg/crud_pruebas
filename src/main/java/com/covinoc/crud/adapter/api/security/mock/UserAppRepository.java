package com.covinoc.crud.adapter.api.security.mock;


import com.covinoc.crud.adapter.api.security.models.UserApp;
import com.covinoc.crud.adapter.api.security.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAppRepository {

    private UserApp getCustomer(){
        UserRole role=new UserRole("customer","CUSTOMER",new Date());
        List<UserRole> roles= List.of(role);
        return new UserApp("customer","customer@mail.com","$2y$10$XjtMg3Hv98qIPizCN7cxPed2MMEyPCLvu4lR79xJtfNa8vSPaBxtS",false,false,roles);
    }

    private UserApp getAdmin(){
        UserRole role=new UserRole("admin","ADMIN",new Date());
        List<UserRole> roles= List.of(role);
        return new UserApp("admin","admin@mail.com","$2y$10$H8bv6Zslv7LtNGYlvdby6OG/WPi3rHrc79sIUWCt72UBvnKP2ZAbO",false,false,roles);
    }

    public UserApp findById(String username){
        UserApp user = null;
        switch (username) {
            case ("admin") -> 
                user=getAdmin();
            case ("customer") -> 
                user=getCustomer();            
            default -> {
            }
        }
        return user;
    }


}
