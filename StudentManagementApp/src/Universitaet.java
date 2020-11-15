/*
Mehmet Mücahit KAYA
TMS-3 160501403
INF102 Abschlussprojekt
*/
import java.util.Vector;

public class Universitaet {
    private String Name = "";
    private String Adresse = "";
    private String Tel = "";
    private String id = "";
    private String code = "";
    private Vector<Student> Studenten = new Vector();
    private Vector<Dozent> Dozenten = new Vector();
    private Vector<LVA> LVAs = new Vector();


    public void hinfuegenStudent(Student p){
 
       if(this.Studenten.contains(p)==false){
           Studenten.add(p);
       }
       else{
           System.out.println("Dieser Student schon existiert");
       }
    }
    public Student auflistenStudent(){
        Student student1 = null;
        for(int i = 0; i < Studenten.size(); i++){
            student1 = (Student)Studenten.elementAt(i);
        }
        return student1;
    }
    
    public Vector<Student> getStudenten() {
        return Studenten;
    }
    
    public Vector<Dozent> getDozenten() {
        return Dozenten;
    }
    
    public Vector<LVA> getLVAs() {
        return LVAs;
    }
    
    

    public Student suchenStudent(String s){
        for (Student a : Studenten){
            if(a.getMatrikelNummer().equals(s)){
                System.out.println(a.toString());
                return a;
                
            }else{
            } 
        } 
        return null;
    }
    
    public void loeschenStudent(String p){
        for(Student s : Studenten){
            if(s.getMatrikelNummer().equals(p)){
                this.Studenten.remove(s);
                System.out.println("Student gelöscht");
                return;
            }
            else{
            System.out.println("Student nicht gefunden");
            }
        }
    }

    public void hinfuegenDozent(Dozent d){

        if(this.Dozenten.contains(d)==false){
            Dozenten.add(d);
        }
        else{
            System.out.println("Dieser Dozent schon existiert");
        }
    }

    public void auflistenDozent(){

        for(int i = 0; i < Dozenten.size(); i++){
            Dozent dozent1 = (Dozent)Dozenten.elementAt(i);
            System.out.println(dozent1);
        }
    }

    public Dozent suchenDozent(String s){
        for (Dozent d : Dozenten){
            if(d.getDozentIDNummer().equals(s)){
                System.out.println(d.toString());
                return d;
            }else{
                
            }
        }
        return null;
    }

    public void loeschenDozent(String p){
        for(Dozent d : Dozenten){
            if(d.getDozentIDNummer().equals(p)){
                this.Dozenten.remove(d);
                System.out.println("Dozent gelöscht");
                return;
            }
            else{
                System.out.println("Dozent nicht gefunden");
            }
        }
    }

    public void hinfuegenLVA(String LVACode, String LVAName, int LVAakts) {
        LVA e = new LVA(LVACode, LVAName, LVAakts);
        if (this.LVAs.contains(e) == false) {
            LVAs.add(e);

        } else {
            System.out.println("Diese Lehrveranstaltung schon existiert!");
        }
    }

    public void auflistenLVA(){

        for(int i = 0; i < LVAs.size(); i++){
            LVA lva1 = (LVA)LVAs.elementAt(i);
            System.out.println(lva1);
        }
    }

    public LVA suchenLVA(String l){
        for (LVA a : LVAs){
            if(a.getLVACode().equals(l)){
                System.out.println(a.toString());
                return a;
                
            }else{
                
            }
        }
        return null;
    }

    public void loeschenLVA(String p){
        for(LVA s : LVAs){
            if(s.getLVACode().equals(p)){
                this.LVAs.remove(s);
                System.out.println("Lehrveranstaltung gelöscht");
                return;
            }
            else{
                System.out.println("Lehrveranstaltung nicht gefunden");
            }
        }
    }

    public Student Getstudent(String id) {
        for(Student a : Studenten){
            if(a.getMatrikelNummer().equals(id)){
                return a;
            }
        }
        System.out.println("Student existiert nich im System!");
        return null;
    }

    public Dozent Getdozent(String id) {
        for(Dozent b : Dozenten){
            if(b.getDozentIDNummer().equals(id)){
                return b;
            }
        }
        System.out.println("Ein Dozent mit solcher id existiert nicht im System!");
        return null;
    }
    public LVA GetLVA (String code) {
        for(LVA c : LVAs){

            if(c.getLVACode().equals(code)){
                return c;
            }
        }
        System.out.println("LVA existiert nicht im System!");
        return null;
    }

    public void StudentLVAAnmelden(String id,String code){        
        this.id = id;
        this.code = code;
        if(Getstudent(id)!= null && GetLVA(code)!= null){
            Getstudent(id).anmeldenLVA(GetLVA(code));
            GetLVA(code).Addstudent(Getstudent(id));
        }
    }

    public void DozentLVAAnmelden(String id, String code) {
        this.id = id;
        this.code = code;
        if(Getdozent(id)!= null && GetLVA(code)!= null){
            Getdozent(id).AddLVA(GetLVA(code));
            GetLVA(code).Adddozent(Getdozent(id));
        }
    }

    public void StudentLVAAbmelden(String id,String code){
        this.id = id;
        this.code = code;
        if(Getstudent(id)!= null && GetLVA(code)!= null){
            Getstudent(id).abmeldenLVA(code);
            GetLVA(code).removeStudent(id);
        }
    }

    public void DozentLVAAbmelden(String id, String code) {
        this.id = id;
        this.code = code;
        if(Getdozent(id)!= null && GetLVA(code)!= null){
            Getdozent(id).removeLVA(code);
            GetLVA(code).removeDozent(id);
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    
    
}

