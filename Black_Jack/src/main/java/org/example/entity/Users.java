package org.example.entity;


import java.util.concurrent.atomic.AtomicInteger;

public class Users {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected int id_user;
    protected String username;
    protected String password;
    protected Roles role;

    public Users() {
        this.id_user = count.incrementAndGet();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
