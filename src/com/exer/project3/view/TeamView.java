package com.exer.project3.view;

import com.exer.project3.domain.Employee;
import com.exer.project3.domain.Programmer;
import com.exer.project3.service.NameListService;
import com.exer.project3.service.TeamException;
import com.exer.project3.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }

            System.out.println("1-Team List 2-Add Team Member 3-Delete Team Member 4-Quit    Please Choose (1-4):");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("Do you really want to exit (Y/N):");
                    char selection = TSUtility.readConfirmSelection();
                    if (selection == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }

    }

    private void listAllEmployees() {
        System.out.println("----------------------------------Development Team Management Software----------------------------------");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("There are no employees in company");
        } else {
            System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    private void getTeam() {
        System.out.println("---------------------Team Member--------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("There is no member in the team");
        } else {
            System.out.println("TID/ID\tName\tAge\tSalary\tPosition\tBonus\tStock");
            for (Programmer programmer : team) {
                System.out.println(programmer.getInfoForTeam());
            }
        }
        System.out.println("----------------------------------------------------");
    }

    private void addMember() {
        System.out.println("------------------Add Team Member------------------");
        System.out.println("Please enter the ID of employee you want to add to team:");
        int id = TSUtility.readInt();
        try {
            teamSvc.addMember(listSvc.getEmployee(id));
            System.out.println("Added successfully!");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember() {
        System.out.println("------------------Delete Team Member------------------");
        System.out.println("Please enter the TID of employee you want to delete from team:");
        int id = TSUtility.readInt();
        System.out.println("Do you really want to delete (Y/N):");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }

        try {
            teamSvc.removeMember(id);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
