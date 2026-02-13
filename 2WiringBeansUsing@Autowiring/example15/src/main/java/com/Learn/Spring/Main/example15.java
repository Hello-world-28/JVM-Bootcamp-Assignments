package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Company;
import com.Learn.Spring.Beans.Employee;
import com.Learn.Spring.Beans.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class example15 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//        System.out.println("------------Making Singleton Bean------------");
//        Company c1 = context.getBean(Company.class);
//        Company c2 = context.getBean(Company.class);
//        System.out.println("This is first bean : " + c1);
//        System.out.println("This is first bean : " + c2);
//        System.out.println("Is c1==c2 : " + (c1==c2));
//        System.out.println("c1 hasCode() : " + c1.hashCode());
//        System.out.println("c2 hashCode() : " + c2.hashCode());
//        System.out.println("c1.hashCode()==c2.hashCode() = " +  (c1.hashCode()==c2.hashCode()));
//        System.out.println("------------Making Prototype Bean------------");
//        Employee e1 = context.getBean(Employee.class);
//        Employee e2 = context.getBean(Employee.class);
//        System.out.println("This is first bean : " + e1);
//        System.out.println("This is first bean : " + e2);
//        System.out.println("Is e1==e2 : " + (e1==e2));
//        System.out.println("e1 hasCode() : " + e1.hashCode());
//        System.out.println("e2 hashCode() : " + e2.hashCode());
//        System.out.println("e1.hashCode()==e2.hashCode() = " +  (e1.hashCode()==e2.hashCode()));

    }
}
