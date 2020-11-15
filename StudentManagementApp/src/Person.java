/*
Mehmet Mücahit KAYA
TMS-3 160501403
INF102 Abschlussprojekt
*/

public class Person {
    private String Vorname = "";
    private String Nachname = "";
    private String Fakultaet = "";
    private String IDNummer = "";
    private String Mail = "";
    private String Alte = "";
    
    public Person(String Vorname, String Nachname, String Fakultaet, String IDNummer, String Mail, String Alte){
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Fakultaet = Fakultaet;
        this.IDNummer = IDNummer;
        this.Mail = Mail;
        this.Alte = Alte;
    }

    public static boolean checkIDNummer(String e) {

        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) < '0' || e.charAt(i) > '9') {
                return false;
            }
        }
        return ((e.charAt(0) != '0') && (e.length() == 11));
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        this.Nachname = nachname;
    }

    public String getFakultaet() {
        return this.Fakultaet;
    }

    public void setFakultaet(String fakultaet) {
        this.Fakultaet = fakultaet;
    }

    public String getIDNummer() {
        return this.IDNummer;
    }

    public void setIDNummer(String IDNummer) {
        this.IDNummer = IDNummer;
    }

    public String getMail() {
        return this.Mail;
    }

    public void setMail(String mail) {
        this.Mail = mail;
    }

    public String getAlte() {
        return this.Alte;
    }

    public void setAlte(String alte) {
        this.Alte = alte;
    }

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }


}
