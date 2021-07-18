package SchoolPkg;

/**
 * Created by Abhishek Singh
 * This class is responsible for keeping Track of
 * teacher's id, name, salary.
 * 
 */ 


public class Teacher {

    private int id;
    private String name;
    private int salary;
    private int salaryEarned;   
    
    /**
     * Creates a new Teacher Object.
     * @param id id for the Teacher.
     * @param name name of the Teacher.
     * @param salary salary of the Teacher. 
     */ 
    
    public Teacher(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    /**
     * @return id for the Teacher.
     */ 

    public int getId(){
        return this.id;
    }

    /**
     * @return the name of the Teacher.
     */ 

    public String getName(){
        return this.name;
    }
    
    /**
     * @return Salary of the Teacher.
     */ 

    public int getSalary(){
        return this.salary;
    }

    /**
     * update salary of the Teacher
     */ 

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void receiveSalary(int salary){
        salaryEarned+=salary;
        School.updateTotalMoneySpent(salary);
    }

}
