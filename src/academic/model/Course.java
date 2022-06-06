package academic.model;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

 public class Course {
    private String code;
    private String name;
    private int credit;
    private String passinggrade;
    private String inslist;
   
    public Course(String code, String name, int credit, String passinggrade,String inslist) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.passinggrade = passinggrade;
        this.inslist= inslist;
    }
      
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCredit() {
        return credit;
    }


    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getPassinggrade() {
        return passinggrade;
    }
    public void setPassinggrade(String passinggrade) {
        this.passinggrade = passinggrade;
    }


     public String getInslist() {
        return inslist;
    }
    public void setInslist(String inslist) {
        this.inslist = inslist;
    }
    
    public String toString(){
        return this.code + "|" + 
                this.name + "|" + 
                this.credit + "|" + 
                this.passinggrade + "|" +
                this.inslist;
    }


}
