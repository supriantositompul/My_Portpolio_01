package academic.model;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

 public class Lecturer {
    private String id ;
    private String name;
    private String initial;
    private String email;
    private String studyprogram;


     public Lecturer (String id, String name , String initial,String email, String studyprogam) {
        this.id = id;
        this.name = name;
        this.initial = initial;
        this.email=email;
        this.studyprogram = studyprogam;
    }   

        public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStudyprogram() {
        return studyprogram;
    }
    public void setStudyprogram(String studyprogram) {
        this.studyprogram = studyprogram;
    }

    public String toString(){
        return this.id + "|" + 
                this.name + "|" + 
                this.initial + "|" + 
                this.email + "|" + 
                this.studyprogram;
    }
}
