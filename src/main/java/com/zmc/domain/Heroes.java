package com.zmc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by zhongmc on 2017/4/5.
 */
@Entity
public class Heroes {
    @Id
    @GeneratedValue
    private Integer id;//id
    @Size(min = 1,max = 200,message = "只能填写1-200个字符")
    private String first_name;//名字
    @Size(min = 1,max = 200,message = "只能填写1-200个字符")
    private String last_name;//全名
    @Size(min = 1,max = 1,message = "性别只能男或者女")
    private String sex;//性别
    @Size(min = 1,max = 20,message = "只能填写1-20个字符")
    private String type;//英雄类型 比如 刺客。。。
    @Size(min = 1,max = 20,message = "只能填写1-20个字符")
    private String position;//英雄位置
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Heroes(){}

    @Override
    public String toString() {
        return "Heroes{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
