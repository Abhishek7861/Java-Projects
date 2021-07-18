package SchoolPkg;

/**
 * Created by Abhishek Singh
 * This class is responsible for Keeping Track of Student
 * 
 */ 

public class Student{

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * Creates a new Student Object.
     * @param id id for the Student.
     * @param name name of the Student.
     * @param grade grade of the Student.
     * @param fees fees of the Student.
     */ 

    public Student(int id, String name, int grade){
        feesPaid = 0;
        feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    /**
     * @param grade set grade for student.
     */ 

    public void setGrade(int grade){
        this.grade = grade;
    }

    /**
     * @param feesPaid update fees paid for student.
     */ 

    public void payFees(int fees){
        this.feesPaid = this.feesPaid+fees;
        School.updateTotalMoneyEarned(feesPaid);
    }
    
    /**
     * @return id for the Student.
     */ 

    public int getId(){
        return this.id;
    }

    /**
     * @return name for the Student.
     */ 

    public String getName(){
        return this.name;
    }

    /**
     * @return Grade for the Student.
     */ 
    
    public int getGrade(){
        return this.grade;
    }

    /**
     * @return Fees Paid for the Student.
     */ 
    
    public int getFeesPaid(){
        return this.feesPaid;
    }

    /**
     * @return Total Fees for the Student.
     */ 

    public int getFeesTotal(){
        return this.feesTotal;
    }


    public int getRemainingFees(){
        return this.feesTotal-this.feesPaid;
    }

}