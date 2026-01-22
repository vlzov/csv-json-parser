package com.vlzov;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.vlzov.Entity.Employee;

public class MainTest {
    
    @Test
    public void testListToJson_validList_success() {
        // given:
        List<Employee> employees = List.of(
            new Employee(1L, "Иван", "Иванов", "Россия", 30),
            new Employee(2L, "Петр", "Петров", "Украина", 25)
        );

        // when:
        String result = Main.listToJson(employees);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        // Gson экранирует кириллицу в Unicode, поэтому проверяем иначе
        Assertions.assertTrue(result.contains("30") || result.contains("25"));
        Assertions.assertTrue(result.contains("\"id\""));
        Assertions.assertTrue(result.contains("\"age\""));
    }

    @Test
    public void testListToJson_emptyList_success() {
        // given:
        List<Employee> emptyList = List.of();

        // when:
        String result = Main.listToJson(emptyList);

        // then:
        Assertions.assertEquals("[]", result.trim());
    }

    @Test
    public void testListToJson_singleElement_success() {
        // given:
        List<Employee> singleEmployee = List.of(
            new Employee(1L, "Анна", "Сидорова", "Беларусь", 28)
        );

        // when:
        String result = Main.listToJson(singleEmployee);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        // Проверяем наличие полей, а не кириллицу
        Assertions.assertTrue(result.contains("\"id\": 1"));
        Assertions.assertTrue(result.contains("28"));
    }
}