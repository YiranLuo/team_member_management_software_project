package com.exer.project3.service;

import com.exer.project3.domain.*;

import static com.exer.project3.service.Data.*;

/**
 *
 */
public class NameListService {
    private Employee[] employees;

    /**
     * to initialize employees and its elements
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            // get 4 basic fields of an employee
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;

            }
        }
    }

    /**
     * get ith employee's equipment
     * @param i index of an employee
     * @return the equipment object
     */
    private Equipment creatEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);
        Equipment equipment = null;
        switch (type) {
            case PC:
                equipment = new PC(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
                break;
            case NOTEBOOK:
                equipment = new NoteBook(EQUIPMENTS[i][1], Double.parseDouble(EQUIPMENTS[i][2]));
                break;
            case PRINTER:
                equipment = new Printer(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
                break;
        }
        return equipment;
    }

    /**
     * get all employees
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("No such employee!");
    }
}
