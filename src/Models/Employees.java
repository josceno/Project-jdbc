package Models;

import java.sql.Date;


abstract public class Employees {
    private int id;
    private String name;
    private String email;
    private Date birthday;
    private  double baseSalary;
    private  Department department;

    public Employees(){}
    public Employees(int id, String name, String email, Date birthday, double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    public Employees(String name, String email, Date birthday, double baseSalary, Department department) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    
}
