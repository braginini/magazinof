package ru.ncideas.magazinof.gwt.client.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {

    Long id;

    String username;

    String password;

    Date lastLogged;

    Date created;

    String first_name;

    String last_name;

    String email;

    AccountDto account;

    UserStatusDto status;

    public UserDto() {
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

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
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

    public UserStatusDto getStatus() {
        return status;
    }

    public void setStatus(UserStatusDto status) {
        this.status = status;
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

        UserDto userDto = (UserDto) o;

        if (created != null ? !created.equals(userDto.created) : userDto.created != null) return false;
        if (email != null ? !email.equals(userDto.email) : userDto.email != null) return false;
        if (first_name != null ? !first_name.equals(userDto.first_name) : userDto.first_name != null) return false;
        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (lastLogged != null ? !lastLogged.equals(userDto.lastLogged) : userDto.lastLogged != null) return false;
        if (last_name != null ? !last_name.equals(userDto.last_name) : userDto.last_name != null) return false;
        if (password != null ? !password.equals(userDto.password) : userDto.password != null) return false;
        if (username != null ? !username.equals(userDto.username) : userDto.username != null) return false;

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
        return "UserDto{" +
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
