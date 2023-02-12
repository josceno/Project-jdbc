package Models.entities;

import java.sql.Date;

public class Seller extends Employees {
    
    private  Department department;
    public Seller(){

    }
    public Seller(int id, String name, String email, Date birthday, double baseSalary, Department department) {
       super(id,name,email,birthday,baseSalary);
       this.department = department;
    }
    public Seller(String name, String email, Date birthday, double baseSalary, Department department) {
        super(name,email,birthday,baseSalary);
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", birthday=" + this.getEmail() +
                ", baseSalary=" + this.getBaseSalary() +
                ", depId=" + this.getDepartment().getId() +
                '}';
    }
}
