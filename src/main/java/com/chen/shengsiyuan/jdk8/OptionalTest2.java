package com.chen.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest2 {

    public static void main(String[] args) {
        Employee zhangsan = new Employee();
        zhangsan.setName("zhangsan");

        Employee lisi = new Employee();
        lisi.setName("lisi");

        Company company = new Company();
        company.setName("company");

        List<Employee> employees = Arrays.asList(zhangsan, lisi);
//        company.setEmployees(employees);
        System.out.println(company.getEmployees()); // 默认会打印null

        List<Employee> list = company.getEmployees();

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        System.out.println(optionalCompany.map(c -> c.getEmployees()).orElseGet(() -> Collections.emptyList()));
    }
}
