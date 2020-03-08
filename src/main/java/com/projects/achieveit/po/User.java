package com.projects.achieveit.po;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "userPassword")
    private String userpassword;

    @Column(name = "isAdmin")
    private String isadmin;

    private String salt;

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return userPassword
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * @param userpassword
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    /**
     * @return isAdmin
     */
    public String getIsadmin() {
        return isadmin;
    }

    /**
     * @param isadmin
     */
    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin == null ? null : isadmin.trim();
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}