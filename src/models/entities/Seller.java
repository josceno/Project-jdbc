package models.entities;

import java.io.Serializable;
import java.sql.Date;

public class Seller extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Seller other = (Seller) obj;
        if (this.getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!this.getId().equals(other.getId()))
            return false;
        return true;
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

