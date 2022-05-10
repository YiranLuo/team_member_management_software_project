package com.exer.project3.test;

import com.exer.project3.domain.Employee;
import com.exer.project3.service.NameListService;
import com.exer.project3.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * Test class for NameListService
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        for (Employee employee : service.getAllEmployees()) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployee() {
          NameListService service = new NameListService();
          int id = 38;

        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
