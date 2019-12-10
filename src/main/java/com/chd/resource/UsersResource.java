package com.chd.resource;

import com.chd.UserService;
import com.chd.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersResource {

    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    private List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/all/{id}")
    private Optional<Users> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/load")
    private ResponseEntity add(@RequestBody Users users){
        userService.addUser(users);
        return ResponseEntity.accepted().body("User has been added! \n"+ userService.getLastUser());
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteRow(@PathVariable int id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping (path = "/deleteAll")
    private ResponseEntity<String> deleteAll(){
        userService.deleteAll();
        return ResponseEntity.accepted().body("All User deleted");
    }

//    @PutMapping("newelement/{id}")
//    public  replaceContent(@RequestBody Users users, @PathVariable int id){
//        return usersRepo.findById(id).map(obj -> {
//            obj.setName(users.getName());
//            obj.setTeamName(users.getTeamName());
//            obj.setSalary(users.getSalary());
//            return usersRepo.save(obj);
//        }).orElseGet(() -> {
//            users.setId(id);
//            return usersRepo.save(users);
//        });
//    }

}
