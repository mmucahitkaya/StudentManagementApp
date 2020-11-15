/*
Mehmet Mücahit KAYA
TMS-3 160501403
INF102 Abschlussprojekt
*/

import java.util.Vector;



public class Dozent extends Person {
    private String DozentIDNummer = "";
    private String FachBereich = "";
    private Vector<LVA> LVAs = new Vector<>();


    public Dozent(String Vorname, String Nachname, String DozentIDNummer, String IDNummer, String FachBereich, String Fakultaet, String Mail, String Alte) {
        super(Vorname, Nachname, Fakultaet, IDNummer, Mail, Alte);
        this.DozentIDNummer = DozentIDNummer;
        this.FachBereich = FachBereich;
    }

    public static boolean checkDozentIDNummer(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s .charAt(i) > '9') {
                return false;
            }
        }
        return ((s.charAt(0) != '0') && (s.length() == 7));
    }

    public Vector<LVA> getLVAs() {
        return LVAs;
    }
    
    public void AddLVA(LVA GetLVA) {
        if(this.LVAs.contains(GetLVA) == false){
            LVAs.add(GetLVA);
        }else {
            System.out.println("Dieser Dozent ist schon in der LVA angemeldet");
        }

    }
    public void removeLVA(String p){
        for(LVA d : LVAs){
            if(d.getLVACode().equals(p)){
                this.LVAs.remove(d);
                System.out.println("Dozent hat diese LVA gelöscht.");
                return;
            }
            else{
                System.out.println("Dozent schon hat diese LVA.");
            }
        }
    }
    public void ListLVAas() {
        for (int i = 0; i < this.LVAs.size(); i++) {
            System.out.println("Die Folgende sind die Hauptattributen der " + (i + 1) + ". Vorlesung, woran dieser Dozent taetig ist: " + this.getVorname() + this.getNachname()+ "\n" + this.LVAs.get(i).toString());
        }

    }

    public String getDozentIDNummer() {
        return this.DozentIDNummer;
    }

    public void setDozentIDNummer(String dozentIDNummer) {
        this.DozentIDNummer = dozentIDNummer;
    }

    public String getFachBereich() {
        return this.FachBereich;
    }

    public void setFachBereich(String fachBereich) {
        this.FachBereich = fachBereich;
    }

    public String toString() {
        return "Name: " + toTitleCase(super.getVorname()) + " " + super.getNachname().toUpperCase()
                + "\nDozent ID Nummer: " + DozentIDNummer
                + "\nIDNummer: " + super.getIDNummer()
                + "\nFachbereich: " + FachBereich
                + "\nFakultät: " + super.getFakultaet()
                + "\nMail: " + super.getMail()
                + "\nAlte: "+ super.getAlte();
    }

    public boolean equals(Object obj) {
        Dozent s = (Dozent) obj;

        if (s.DozentIDNummer.equals(this.DozentIDNummer)) {
            return true;
        }
        else {
            return false;
        }
    }
}
