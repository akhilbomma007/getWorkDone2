package com.example.getworkdone;

public class Model {
    private String work,college,field,deadline,image,pay;

    public Model(){}

    public Model(String work, String college, String field, String pay, String deadline, String image) {
        this.work = work;
        this.college = college;
        this.field = field;
        this.pay = pay;
        this.deadline = deadline;
        this.image = image;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPay() {
        return pay;
    }
    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
