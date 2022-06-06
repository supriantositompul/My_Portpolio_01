package academic.model;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

public class Student {
    private String nim ;
    private String code;
    private String year;
    private String studyprogram;

    public Student (String nim, String code , String year, String studyprogam) {
        this.nim = nim;
        this.code = code;
        this.year = year;
        this.studyprogram = studyprogam;
    }
    public String getId() {
        return nim;
    }
    public void setId(String nim) {
    this.nim = nim;
    }
    public String getName() {
        return code;
    }
        public void setName(String code) {
        this.code = code;
    }

    
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
    this.year = year;
    }

    public String getStudyProgram() {
        return studyprogram;
    }

    public void setStudyProgram(String studyprogram) {
        this.studyprogram = studyprogram;   
    }
    public String toString(){
        return this.nim + "|" + 
                this.code + "|" + 
                this.year + "|" + 
                this.studyprogram;

    }
}
