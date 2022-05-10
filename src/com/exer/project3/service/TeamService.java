package com.exer.project3.service;

import com.exer.project3.domain.Architect;
import com.exer.project3.domain.Designer;
import com.exer.project3.domain.Employee;
import com.exer.project3.domain.Programmer;

/**
 * Provide service for a development team
 */
public class TeamService {
    private static int counter = 1; // to initialize memberId
    private final int MAX_NUMBER = 5;
    private Programmer[] team = new Programmer[5]; // store the team members
    private static int total; // actual number of members in the team

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];// attention: this.team means the field of the object, instead of the local variable
        }
        return team;
    }

    /**
     * Add an employee to the team
     */
    public void addMember(Employee e) throws TeamException {
        // team is full, add failed
        if (total >= MAX_NUMBER) {
            throw new TeamException("Team is full! Add failed...");
        }

        // employee is not a programmer, add failed
        if (!(e instanceof Programmer)) {
            throw new TeamException("Not a programmer! Add failed...");
        }

        // employee is already in the team, add failed
        if (isExist(e)) {
            throw new TeamException("Employee already in the team! Add failed...");
        }

        // employee is in other team, add failed
        // employee is on vacation, add failed
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("Employee is in other team! Add failed...");
        }
        if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("Employee is on vacation! Add failed...");
        }

        // at most one architect in team
        // at most two designer in team
        // at most three programmer in team

        // get the number of architect, designer and programmer

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            Employee employee = team[i];
            if (employee instanceof Architect) {
                numOfArch++;
            }else if (employee instanceof Designer) {
                numOfDes++;
            }else {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("At most 1 architect in team! Add failed...");
            }
        }else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("At most 2 designers in team! Add failed...");
            }
        }else {
            if (numOfPro >= 3) {
                throw new TeamException("At most 3 programmers in team! Add failed...");
            }
        }

        // add employee to team
        team[total++] = p;

        p.setStatus(Status.BUSY);

        p.setMemberId(counter++);

    }

    /**
     * To judge if the employee already exists in the team
     * @param e
     * @return true if exist, false if not
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove a member from the team
     */
    public void removeMember(int memberId) throws TeamException{

        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        // not found
        if (i == total) {
            throw new TeamException("Employee not found! Delete failed...");
        }
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        team[--total] = null;
    }
}
