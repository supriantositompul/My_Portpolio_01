package academic.model;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

public class Enrollment {
      private String code;
    private String id;
    private String year;
    private String semester;
    private String grade;

     public Enrollment(String code, String id, String year, String semester) {
        this.code = code;
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.grade = "None";
    }
           

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getYear() {
        return year;
    }


    public void setYear(String year) {
        this.year = year;
    }


    public String getSemester() {
        return semester;
    }


    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String toString(){
        return this.code + "|" + 
                this.id + "|" + 
                this.year + "|" + 
                this.semester+"|"+
                this.grade;
    }

}