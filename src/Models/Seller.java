package Models;

import java.time.LocalDate;

public class Seller {
    private int id;
    private String name;
    private String email;
    private LocalDate birthday;
    private  double baseSalary;
    private  Department depId;

    public Seller(){

    }
    public Seller(int id, String name, String email, LocalDate birthday, double baseSalary, Department depId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.baseSalary = baseSalary;
        this.depId = depId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepId() {
        return depId;
    }

    public void setDepId(Department depId) {
        this.depId = depId;
    }
}
