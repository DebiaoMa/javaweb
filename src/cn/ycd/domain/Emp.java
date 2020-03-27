package cn.ycd.domain;


import java.util.Date;

public class Emp {
    //名字不一定和数据库变量保持一致，但是尽量一致
    private int id;
    private String name;
    private String nickname;
    private String sex;
    private Date in_time;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public Date getIn_time() {
        return in_time;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", in_time=" + in_time +
                '}';
    }
}
