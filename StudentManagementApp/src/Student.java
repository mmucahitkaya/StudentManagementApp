/*
Mehmet Mücahit KAYA
TMS-3 160501403
INF102 Abschlussprojekt
*/
import java.util.Vector;

public class Student extends Person {
   
    private String MatrikelNummer = "" ;
    private String Studiengang = "";
    private String Semester = "";
    private Vector<LVA> LVAs = new Vector<>();


  public Student(String Vorname,String Nachname,String MatrikelNummer,String IDNummer,String Studiengang, String Fakultaet,  String Mail, String Semester, String Alte){

      super(Vorname,Nachname,Fakultaet,IDNummer,Mail,Alte);
      this.MatrikelNummer = MatrikelNummer;
      this.Studiengang = Studiengang;
      this.Semester = Semester;
  }
  public Vector<LVA> getLVAs() {
        return LVAs;
    }

   @Override
  public boolean equals(Object obj) {
        Student s = (Student) obj;
        
        if (s.MatrikelNummer.equals(this.MatrikelNummer)) {
                return true;
        }
        else {
            return false;
        }
    }

   public static boolean checkMatrikelNummer(String s) {
 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s .charAt(i) > '9') {
                return false;
            }
        }
        return ((s.charAt(0) != '0') && (s.length() == 7));
    }

    public void anmeldenLVA(LVA getLVA){
      if(this.LVAs.contains(getLVA)==false){
          LVAs.add(getLVA);
      }else{
          System.out.println("Dieser student ist schon in der LVA angemeldet.");
      }
    }

    public void abmeldenLVA(String p){
        for(LVA d : LVAs){
            if(d.getLVACode().equals(p)){
                this.LVAs.remove(d);
                System.out.println("Student hat diese LVA abgemeldet.");
                return;
            }
            else{
                System.out.println("Student schon hat diese LVA.");
            }
        }
    }

    public void auflistenLVA(){
      for(int i = 0;i<this.LVAs.size();i++){
          System.out.println("Die Folgende sind die Hauptattributen der " + (i + 1) + ". Vorlesung, woran dieser Student angemeldet ist: " + this.getVorname() + this.getNachname() + "\n" + this.LVAs.get(i).toString());
      }
    }

    public void setMatrikelNummer(String MatrikelNummer){
        this.MatrikelNummer = MatrikelNummer;
    }

    public void setStudiengang(String Studiengang){
        this.Studiengang = Studiengang;
    }

    public void setSemester(String Semester){
        this.Semester = Semester;
    }

    public String getMatrikelNummer(){
        return this.MatrikelNummer;
    }

    public String getStudiengang(){
        return this.Studiengang;
    }

    public String getSemester(){
        return this.Semester;
    }

    @Override
    public String toString() {
          return "Name: " + toTitleCase(super.getVorname()) + " " + super.getNachname().toUpperCase()
                  + "\nMatrikelnummer: " + MatrikelNummer
                  + "\nIDNummer: " + super.getIDNummer()
                  + "\nStudiengang: " + Studiengang
                  + "\nFakultät: " + super.getFakultaet()
                  + "\nMail: " + super.getMail()
                  + "\nSemester: " + Semester
                  + "\nAlte: "+ super.getAlte(); 
    }

    }



