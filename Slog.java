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

    final String samoglasniciL = "a,e,i,o,u";
    final String sonatiL = "j,v,r,m,l,lj,n,nj";
    final String slogotvorniSonatiL = "r,l,n";
    final String suglasniciL = "b,v,g,d,đ,dj,ž,z,j,k,l,lj,m,n,nj,p,r,s,t,ć,f,h,c,č,dž,š";
    final String konsonantiL = "b,g,d,z,ž,đ,dž,p,k,t,s,š,ć,č,h,f,c";
    final String zvucniKonsonantiL = "b,g,d,z,ž,đ,dž";
    final String bezZvucniKonsonantiL = "p,k,t,s,š,ć,č,h,f,c";

    final String samoglasniciC = "а,е,и,о,у";
    final String sonatiC = "ј,в,р,м,л,љ,н,њ";
    final String slogotvorniSonatiC = "р,л,н";
    final String suglasniciC = "б,в,г,д,ђ,дј,ж,з,ј,к,л,љ,м,н,њ,п,р,с,т,ћ,ф,х,ц,ч,џ,ш";
    final String konsonantiC = "б,г,д,з,ж,ђ,џ,п,к,т,с,ш,ћ,ч,х,ф,ц";
    final String zvucniKonsonantiC = "б,г,д,з,ж,ђ,џ";
    final String bezZvucniKonsonantiC = "п,к,т,с,ш,ћ,ч,х,ф,ц";

    Pismo p;

    private String rec;
    private String slovo;
    private StringBuilder recPodeljenaNaSlogove = new StringBuilder();

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

    public boolean isSamoglasnikL(String s) {
        if (samoglasniciL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isSonatL(String s) {
        if (sonatiL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSlogotvorniSonatiL(String s) {
        if (slogotvorniSonatiL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSuglasnikL(String s) {
        if (suglasniciL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isKonsonantiL(String s) {
        if (konsonantiL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isZvucniKonsonantiL(String s) {
        if (zvucniKonsonantiL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBezZvucniKonsonantiL(String s) {
        if (bezZvucniKonsonantiL.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSamoglasnikC(String s) {
        if (samoglasniciC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isSonatC(String s) {
        if (sonatiC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSlogotvorniSonatiC(String s) {
        if (slogotvorniSonatiC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSuglasnikC(String s) {
        if (suglasniciC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isKonsonantiC(String s) {
        if (konsonantiC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isZvucniKonsonantiC(String s) {
        if (zvucniKonsonantiC.indexOf(s.toLowerCase()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBezZvucniKonsonantiC(String s) {
        if (bezZvucniKonsonantiC.indexOf(s.toLowerCase()) == -1) {
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

            if (this.p == Cyr) {
                if (isSamoglasnikC(slovo) && i < this.rec.length() - 2) {
                    recPodeljenaNaSlogove = recPodeljenaNaSlogove.append("-");
                }
            } else {
                if (isSamoglasnikL(slovo) && i < this.rec.length() - 2) {
                    recPodeljenaNaSlogove = recPodeljenaNaSlogove.append("-");
                }
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
                if (this.p == Cyr) {
                    /*ukoliko su u slogu dve suglasnika jedan do drugog
                     prebaci prvi suglasnik u prethodni slog za cirilicu*/
                    if (isSuglasnikC(t[i].substring(0, 1)) && isSuglasnikC(t[i].substring(1, 2)) && t[i].length() >= 3) {
                        t[i - 1] = t[i - 1] + t[i].substring(0, 1);
                        t[i] = t[i].substring(1, t[i].length());
                    }
                } else {
                    /*ukoliko su u slogu dve suglasnika jedan do drugog
                     prebaci prvi suglasnik u prethodni slog za latinicu*/
                    if (isSuglasnikL(t[i].substring(0, 1)) && isSuglasnikL(t[i].substring(1, 2)) && t[i].length() >= 3) {
                        t[i - 1] = t[i - 1] + t[i].substring(0, 1);
                        t[i] = t[i].substring(1, t[i].length());
                    }

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

        if (this.p == Cyr) {
            for (int i = 0; i < slogovi.length; i++) {
                if (slogovi[i].length() >= 3) {
                    if (isSuglasnikC(slogovi[i].substring(0, 1)) && isSuglasnikC(slogovi[i].substring(1, 2)) && isSuglasnikC(slogovi[i].substring(2, 3))) {
                        if (isSlogotvorniSonatiC(slogovi[i].substring(0, 1))) {
                            slogovi[i] = slogovi[i].substring(0, 1) + "-" + slogovi[i].substring(1, slogovi[i].length() - 1);
                        } else if (isSlogotvorniSonatiC(slogovi[i].substring(1, 2))) {
                            slogovi[i] = slogovi[i].substring(0, 2) + "-" + slogovi[i].substring(2, slogovi[i].length() - 1);
                        } else if (isSlogotvorniSonatiC(slogovi[i].substring(2, 3))) {
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
        } else {

            for (int i = 0; i < slogovi.length; i++) {
                if (slogovi[i].length() >= 3) {
                    if (isSuglasnikL(slogovi[i].substring(0, 1)) && isSuglasnikL(slogovi[i].substring(1, 2)) && isSuglasnikL(slogovi[i].substring(2, 3))) {
                        if (isSlogotvorniSonatiL(slogovi[i].substring(0, 1))) {
                            slogovi[i] = slogovi[i].substring(0, 1) + "-" + slogovi[i].substring(1, slogovi[i].length());
                        } else if (isSlogotvorniSonatiL(slogovi[i].substring(1, 2))) {
                            slogovi[i] = slogovi[i].substring(0, 2) + "-" + slogovi[i].substring(2, slogovi[i].length());
                        } else if (isSlogotvorniSonatiL(slogovi[i].substring(2, 3))) {
                            slogovi[i] = slogovi[i].substring(0, 3) + "-" + slogovi[i].substring(3, slogovi[i].length());
                        }

                    }
                }
                if (i == 0) {
                    povratniSlog = povratniSlog + slogovi[i];
                } else {
                    povratniSlog = povratniSlog + "-" + slogovi[i];
                }
            }
        }
        povratniSlog = povratniSlog.replace("--", "-");
        return povratniSlog;
 
    }
    //OSTAJE DA SE PROMENE ALGORITMI I DA SE IZBACI DUPLIRANJE KODA KOD LATINICE I CIRILICA
    //KAKO BI SE OLAKSALE IZMENE I ODRZAVANJE
    //slovo r na pocetku sloga 
    private String slovoRnaPocetkuSloga(String a)
    {
    //...
    
    return a;
    }

}
