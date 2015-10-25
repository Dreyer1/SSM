package com.dreyer.ssm.dao.user;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    private String user_name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_time
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    private Date create_time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param user_name the value for user.user_name
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_time
     *
     * @param create_time the value for user.create_time
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Sep 02 23:33:21 GMT+08:00 2015
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", user_name=").append(user_name);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", create_time=").append(create_time);
        sb.append("]");
        return sb.toString();
    }
}