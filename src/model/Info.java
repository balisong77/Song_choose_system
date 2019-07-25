package model;

import java.util.Date;

public class Info {
    private String name;
    private String phone_num;
    private String college_name;
    private String class_name;
    private String to_name;
    private String message;
    private Date date_time;
    private int id;
    private String song;
    private String singer;
    private String uuid;
    private int status_code;
    private int is_anonymous;
    private String to_college;

    public int getIs_anonymous() {
        return is_anonymous;
    }

    public void setIs_anonymous(int is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public String getTo_college() {
        return to_college;
    }

    public void setTo_college(String to_college) {
        this.to_college = to_college;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", college_name='" + college_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", to_name='" + to_name + '\'' +
                ", message='" + message + '\'' +
                ", date_time=" + date_time +
                ", id=" + id +
                '}';
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
