/*
Mehmet Mücahit KAYA
TMS-3 160501403
INF102 Abschlussprojekt
*/

import java.util.Vector;

public class LVA {
    private String LVACode = "";
    private String LVAName = "";
    private int LVAakts = 0;
    private Vector<Student> Studenten = new Vector<>();
    private Vector<Dozent> Dozenten = new Vector<>();




    public LVA(String LVACode, String LVAName, int LVAakts) {
        this.LVACode = LVACode;
        this.LVAName = LVAName;
        this.LVAakts = LVAakts;
        }
    
    public Vector<Student> getStudenten() {
        return Studenten;
    }
    public Vector<Dozent> getDozenten() {
        return Dozenten;
    }

    public static boolean checkLVACode(String e) {
        if((e.length() == 6)){
            if(!e.substring(0,3).matches("[A-Z]+") || !e.substring(3,6).matches("[0-9]+")){
                return false;
            }else{
                return true;
                }
            } else{
            return false;
                }
        }

    public void Addstudent(Student Getstudent) {
        if(this.Studenten.contains(Getstudent)==false){
            Studenten.add(Getstudent);
        }
    }
    public void Adddozent(Dozent Getdozent) {
        if(this.Dozenten.contains(Getdozent)==false){
            Dozenten.add(Getdozent);
        }
    }
    public void removeStudent(String p){
        for(Student d : Studenten){
            if(d.getMatrikelNummer().equals(p)){
                this.Studenten.remove(d);
                System.out.println("Student hat diese LVA gelöscht.");
                return;
            }
            else{
                System.out.println("Student schon hat diese LVA.");
            }
        }
    }
    public void removeDozent(String p){
        for(Dozent d : Dozenten){
            if(d.getDozentIDNummer().equals(p)){
                this.Dozenten.remove(d);
                System.out.println("Dozent hat diese LVA gelöscht.");
                return;
            }
            else{
                System.out.println("Dozent schon hat diese LVA.");
            }
        }
    }

    public void auflistenStudenten() {
        for (int i = 0; i < this.Studenten.size(); i++) {
            System.out.println("Die Folgende sind die Hauptattribute der " + (i + 1) + ". Student der LVA :  " + this.LVAName + "\n" + this.Studenten.get(i).toString());
        }
    }

    public void auflistenlistDozenten() {
        for (int i = 0; i < this.Dozenten.size(); i++) {
            System.out.println("Die Folgende sind die Hauptattribute der " + (i + 1) + ". Dozent der LVA : " + this.LVAName + "\n" + this.Dozenten.get(i).toString());
        }

    }



    public String getLVACode() {
        return this.LVACode;
        }

    public void setLVACode(String LVACode) {
        this.LVACode = LVACode;
        }

    public String getLVAName() {
        return this.LVAName;
        }

    public void setLVAName(String LVAName) {
        this.LVAName = LVAName;
        }

    public int getLVAakts() {
        return this.LVAakts;
        }

    public void setLVAakts(int LVAakts) {
        this.LVAakts = LVAakts;
        }

    public boolean equals(Object obj) {
        LVA l = (LVA) obj;

        if (l.LVACode.equals(this.LVACode)) {
            return true;
        } else {
            return false;
            }
        }

        public String toString() {
        return "LVA Name: " + LVAName
                + "\nLVA Code: " + LVACode
                + "\nLVA AKTS: " + LVAakts;
        }

}

