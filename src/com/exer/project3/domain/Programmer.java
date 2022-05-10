package com.exer.project3.domain;

import com.exer.project3.service.Status;

public class Programmer extends Employee {
    private int memberId; // id in the development team
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {
    }

    @Override
    public String toString() {
        return getInfo() + "\t程序员\t" + status.getNAME() + "\t\t\t" + equipment.getDescription();
    }

    public String getInfoForTeam() {
        return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
    }
}
