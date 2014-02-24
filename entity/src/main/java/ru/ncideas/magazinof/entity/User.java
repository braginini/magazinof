package ru.ncideas.magazinof.entity;

import java.util.Date;

public class User {

    Long id;

    String username;

    String password;

    Date lastLogged;

    Date created;

    String first_name;

    String last_name;

    String email;

    Account account;

    UserStatus status;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, String password, Date lastLogged, Date created, Account account, UserStatus status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLogged = lastLogged;
        this.created = created;
        this.account = account;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getLastLogged() {
        return lastLogged;
    }

    public void setLastLogged(Date lastLogged) {
        this.lastLogged = lastLogged;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (lastLogged != null ? !lastLogged.equals(user.lastLogged) : user.lastLogged != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastLogged != null ? lastLogged.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLogged=" + lastLogged +
                ", created=" + created +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}