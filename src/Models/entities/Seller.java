package Models.entities;

import java.sql.Date;

public class Seller extends Employees {
    

    public Seller(){

    }
    public Seller(int id, String name, String email, Date birthday, double baseSalary, Department depId) {
       super(id,name,email,birthday,baseSalary,depId);
    }
    public Seller(String name, String email, Date birthday, double baseSalary, Department depId) {
        super(name,email,birthday,baseSalary,depId);
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
