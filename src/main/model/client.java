package main.model; 

public class client { 

    private String username; 
    private String password; 

    public client(String username, String password) { 
        this.username = username; 
        this.password = password; 
    }

    public String getUsername() { 
        return username; 
    }

    public String getPassword() { 
        return password;
    }

    public void editData(String newUsername, String newPassword) { 
        this.username = newUsername; 
        this.password = newPassword; 
    }
}