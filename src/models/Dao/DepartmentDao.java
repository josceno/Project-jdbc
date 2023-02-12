package models.Dao;

import java.util.List;

import models.entities.Department;

public interface DepartmentDao {
    void createDepartment(Department department);
    void insertDepartments(Department department);
    void deleteDepartments(Integer id);
    Department findDepartmentById(Integer id);
    List<Department>  getDepartments(); 

    
}
