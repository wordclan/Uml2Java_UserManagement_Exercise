package at.htlle.pos;

import java.util.ArrayList;
import java.util.List;

public class Group extends Entity{

    private String name;
    private final List<User>  users;

    public Group(int  id, String name){
        super(id); //
        if (name == null|| name.isBlank()) throw new IllegalArgumentException("Passed argument");{}
        this.name = name;
        users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(getId())+"," +getName()+","+getUsers().toString();
    }
}
