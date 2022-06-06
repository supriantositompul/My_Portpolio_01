package academic.model;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

 public class AcademicDetails extends Student{
    private double gpa = 0;
    private int totalcredit;
  

    //constructor
    public AcademicDetails(String nim, String code, String year, String studyprogram, int totalcredit) {
        super(nim, code, year, studyprogram);
        this.gpa = 0;
        this.totalcredit = totalcredit;
    }

    
    //Setter

    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public void setTotalCredit(int totalcredit){
        this.totalcredit = totalcredit;
    }

    //Getter
    public double getGpa(){
        return gpa;
    }
    public int getTotalCredit(){
        return totalcredit;
    }


    public String toString(){
        return super.toString() + "|" + String.format("%.2f", gpa) +
                  "|" + 
                totalcredit;

    }
}