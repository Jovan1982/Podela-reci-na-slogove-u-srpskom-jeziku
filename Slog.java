/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lang;

import java.util.ArrayList;
import java.util.Arrays;
import static lang.Pismo.Cyr;
import static lang.Pismo.Lat;

/**
 *
 * @author Jovo
 */
public class Slog {

    final String samoglasnici = "a,e,i,o,u,а,е,и,о,у";
    final String sonati = "j,v,r,m,l,lj,n,nj,ј,в,р,м,л,љ,н,њ";
    final String slogotvorniSonati = "r,l,n,р,л,н";
    final String suglasnici = "b,v,g,d,đ,dj,ž,z,j,k,l,lj,m,n,nj,p,r,s,t,ć,f,h,c,č,dž,š,б,в,г,д,ђ,дј,ж,з,ј,к,л,љ,м,н,њ,п,р,с,т,ћ,ф,х,ц,ч,џ,ш";
    final String konsonanti = "b,g,d,z,ž,đ,dž,p,k,t,s,š,ć,č,h,f,c,б,г,д,з,ж,ђ,џ,п,к,т,с,ш,ћ,ч,х,ф,ц";
    final String zvucniKonsonanti = "b,g,d,z,ž,đ,dž,б,г,д,з,ж,ђ,џ";
    final String bezZvucniKonsonanti = "p,k,t,s,š,ć,č,h,f,c,п,к,т,с,ш,ћ,ч,х,ф,ц";
    final String strujniSuglasnici = "z,s,ž,š,f,h,з,с,ж,ш,ф,х";
    final String afrikateSuglasnici = "c,ć,č,dj,đ,dž,ц,ћ,ч,ђ,џ";
    final String specijalniSonati = "v,j,r,l,lj,в,ј,р,л,љ";

    private String rec;
    private String slovo;
    private StringBuilder recPodeljenaNaSlogove = new StringBuilder();

    private Pismo p;

    public void setRec(String r) {
        this.rec = r;
        if (isCyrilic(this.rec)) {
            p = Cyr;
        } else {
            p = Lat;
        }
    }

    public String getRec() {
        return this.rec;
    }

    public Slog() {

    }

    private boolean isCyrilic(String word) {
        int latCounter = 0;
        int cyrCounter = 0;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(c))) {
                cyrCounter++;
            } else {
                latCounter++;
            }
            if (latCounter > cyrCounter) {
                return false;
            } else {
                return true;
            }
        }

        return true;
    }

    public boolean isSamoglasnik(String s) {
        if (samoglasnici.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isStrujniSuglasnici(String s) {
        if (strujniSuglasnici.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isAfrikateSuglasnici(String s) {
        if (afrikateSuglasnici.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isSpecijalniSonati(String s) {
        if (specijalniSonati.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isSonat(String s) {
        if (sonati.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSlogotvorniSonati(String s) {
        if (slogotvorniSonati.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSuglasnik(String s) {
        if (suglasnici.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isKonsonanti(String s) {
        if (konsonanti.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isZvucniKonsonantiL(String s) {
        if (zvucniKonsonanti.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBezZvucniKonsonantiL(String s) {
        if (bezZvucniKonsonanti.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String podeliNaSlogovePoSamoglasnicima() {
        /*
         prvobitna podela reci na slogove gde se rec 
         na slogove deli samo po samoglasnicima
         */

        //ukoliko je rac od 3 slova ili manje nemoj je rastavljati vrati celu rec
        if (this.rec.length() <= 3) {
            return this.rec;
        }

        char c;
        for (int i = 0; i < this.rec.length(); i++) {
            c = this.rec.charAt(i);
            slovo = String.valueOf(c);
            recPodeljenaNaSlogove = recPodeljenaNaSlogove.append(c);

            if (isSamoglasnik(slovo) && i < this.rec.length() - 2) {
                recPodeljenaNaSlogove = recPodeljenaNaSlogove.append("-");
            }

        }

        return podeliNaSlogovePoSuglasnicima(this.recPodeljenaNaSlogove.toString());
    }

    private String podeliNaSlogovePoSuglasnicima(String prethodnoPodeljenoPoSamoglasnicima) {
        /*
         ponovno deljenje vec podeljene reci po suglasnicima 
         kako bi smo identifikovali pogresno podeljene slogove
         u kojima su ostali suglasnici jedan do drugug
         */
        String[] t = prethodnoPodeljenoPoSamoglasnicima.split("-");
        String iznovaDeljeno = "";
        for (int i = 1; i < t.length; i++) {

            char c;

            /*proveraj mi samo one slogove koji imaju 2 slova i vise 
             da li u tim slogovima postoje suglasnici koji su spojeni ako 
             postoje razdvojiti ih tako da ne budu u istom slogu*/
            if (t[i].length() >= 2) {

                /*ukoliko su u slogu dve suglasnika jedan do drugog
                 prebaci prvi suglasnik u prethodni slog */
                if (isSuglasnik(t[i].substring(0, 1)) && isSuglasnik(t[i].substring(1, 2)) && t[i].length() >= 3) {
                    t[i - 1] = t[i - 1] + t[i].substring(0, 1);
                    t[i] = t[i].substring(1, t[i].length());
                }

            }

        }
        for (int i = 0; i < t.length; i++) {

            iznovaDeljeno = iznovaDeljeno + t[i];
            if (i != t.length - 1) {
                iznovaDeljeno = iznovaDeljeno + "-";
            }
        }

        return podelaPoSlogotvornimSonatima(iznovaDeljeno);
    }

    private String podelaPoSlogotvornimSonatima(String a) {
        String[] slogovi = a.split("-");
        String povratniSlog = "";

        for (int i = 0; i < slogovi.length; i++) {
            if (slogovi[i].length() >= 3) {
                if (isSuglasnik(slogovi[i].substring(0, 1)) && isSuglasnik(slogovi[i].substring(1, 2)) && isSuglasnik(slogovi[i].substring(2, 3))) {
                    if (isSlogotvorniSonati(slogovi[i].substring(0, 1))) {
                        slogovi[i] = slogovi[i].substring(0, 1) + "-" + slogovi[i].substring(1, slogovi[i].length() - 1);
                    } else if (isSlogotvorniSonati(slogovi[i].substring(1, 2))) {
                        slogovi[i] = slogovi[i].substring(0, 2) + "-" + slogovi[i].substring(2, slogovi[i].length() - 1);
                    } else if (isSlogotvorniSonati(slogovi[i].substring(2, 3))) {
                        slogovi[i] = slogovi[i].substring(0, 3) + "-" + slogovi[i].substring(3, slogovi[i].length() - 1);
                    }

                }
            }
            if (i == 0) {
                povratniSlog = povratniSlog + slogovi[i];
            } else {
                povratniSlog = povratniSlog + "-" + slogovi[i];
            }
        }

        povratniSlog = povratniSlog.replace("--", "-");
        return povratniSlog;

    }

    //OSTAJE DA SE PROMENE ALGORITMI 
    //KAKO BI SE OLAKSALE IZMENE I ODRZAVANJE
    //slovo r na pocetku sloga 
    private String slovoRnaPocetkuSloga(String a) {
        //...

        return a;
    }

}
