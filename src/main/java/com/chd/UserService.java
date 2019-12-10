package com.chd;

import com.chd.model.Users;
import com.chd.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    public void addUser(Users users){
        Users newUser = new Users();
        newUser.setName(users.getName());
        newUser.setSalary(users.getSalary());
        newUser.setTeamName(users.getTeamName());
        usersRepo.save(newUser);
    }

    public void deleteAll(){
        usersRepo.deleteAll();
    }

    public void deleteUser(int id){
        usersRepo.deleteById(id);
    }

    public List<Users> getAll(){
        return (List<Users>) usersRepo.findAll();
    }

    public Optional<Users> getUserById(int id){
        return usersRepo.findById(id);
    }

    public Users getLastUser(){
        List<Users> usersList = usersRepo.findAll();
        int size = usersList.size();
        return usersList.get(size - 1);
    }
}
