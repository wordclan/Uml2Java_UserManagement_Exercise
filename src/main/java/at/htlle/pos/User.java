package at.htlle.pos;

public class User extends Entity{

    private String username;
    private String password;
    private Group group;

    public User(int id, String username, String password){
        super(id);
        if(username == null|| username.isBlank()) throw new IllegalArgumentException("Passed argument 'username' must not be null, empty or blank");{}
        this.username = username;
        if (password == null|| password.isBlank()) throw new IllegalArgumentException("Passed argument 'password' must not be null, empty or blank");{}
        this.password = password;
    }
    public Group getGroup(){
        return this.group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return getId()+","+username+","+password;
    }
}
