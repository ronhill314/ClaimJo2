package Abstracts;

import java.util.ArrayList;
import java.util.List;

public class School {
    
    private List<Student> students = new ArrayList<Student>();
    private List<Employee> employees = new ArrayList<Employee>();


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    

    @Override
    public String toString() {
        return "School [students=" + students + ", employees=" + employees + "]";
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }    


}
