public class Student{
    private String name;
    private double[] marks;
    private double average;
    private String grade;

    public Student (String name, double[] marks){
        this.name = name;
        this. marks = marks;
    }
    // Getters
     public String getName(){
        return name;
     }
     public double[] getMarks(){
        return marks;
     }
     public double  getAverage(){
        return average;
     }
     public String getGrade(){
        return grade;
     }

     //Setter
    public void setAverage(double average){
        this.average = average;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }

    @Override
    public String toString(){
        return name + " | Average:"  + average + " | Grade:" + grade;
    }

}