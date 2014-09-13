/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lang;

import java.util.Arrays;
import java.util.List;
import static lang.Pismo.Cyr;
import static lang.Pismo.Lat;

/**
 *
 * @author Jovo
 */
public class Slog {

    final List<String> samoglasnici = Arrays.asList("a", "e", "i", "o", "u", "а", "е", "и", "о", "у");
    final List<String> sonati = Arrays.asList("j", "v", "r", "m", "l", "lj", "n", "nj", "ј", "в", "р", "м", "л", "љ", "н", "њ");
    final List<String> slogotvorniSonati = Arrays.asList("r", "l", "n", "р", "л", "н");
    final List<String> suglasnici = Arrays.asList("b", "v", "g", "d", "đ", "dj", "ž", "z", "j", "k", "l", "lj", "m", "n", "nj", "p", "r", "s", "t", "ć", "f", "h", "c", "č", "dž", "š", "б", "в", "г", "д", "ђ", "ж", "з", "ј", "к", "л", "љ", "м", "н", "њ", "п", "р", "с", "т", "ћ", "ф", "х", "ц", "ч", "џ", "ш");
    final List<String> konsonanti = Arrays.asList("b", "g", "d", "z", "ž", "đ", "dj", "dž", "p", "k", "t", "s", "š", "ć", "č", "h", "f", "c", "б", "г", "д", "з", "ж", "ђ", "џ", "п", "к", "т", "с", "ш", "ћ", "ч", "х", "ф", "ц");
    final List<String> zvucniKonsonanti = Arrays.asList("b", "g", "d", "z", "ž", "đ", "dj", "dž", "б", "г", "д", "з", "ж", "ђ", "џ");
    final List<String> bezZvucniKonsonanti = Arrays.asList("p", "k", "t", "s", "š", "ć", "č", "h", "f", "c", "п", "к", "т", "с", "ш", "ћ", "ч", "х", "ф", "ц");
    final List<String> strujniSuglasnici = Arrays.asList("z", "s", "ž", "š", "f", "h", "з", "с", "ж", "ш", "ф", "х");
    final List<String> afrikateSuglasnici = Arrays.asList("c", "ć", "č", "dj", "đ", "dž", "ц", "ћ", "ч", "ђ", "џ");
    final List<String> strujniIsliveniSuglasnici = Arrays.asList("c", "ć", "č", "dj", "đ", "dž", "ц", "ћ", "ч", "ђ", "џ", "z", "s", "ž", "š", "f", "h", "з", "с", "ж", "ш", "ф", "х");
    final List<String> specijalniSonati = Arrays.asList("v", "j", "r", "l", "lj", "в", "ј", "р", "л", "љ");

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
            return latCounter <= cyrCounter;
        }
        return true;
    }

    public boolean isSamoglasnik(String s) {
        return this.samoglasnici.contains(s.toLowerCase());
    }

    public boolean isStrujniSuglasnici(String s) {
        return strujniSuglasnici.contains(s.toLowerCase());
    }

    public boolean isAfrikateSuglasnici(String s) {
        return afrikateSuglasnici.contains(s.toLowerCase());
    }

    public boolean isstrujniISliveniSuglasnici(String s) {
        return strujniIsliveniSuglasnici.contains(s.toLowerCase());
    }

    public boolean isSpecijalniSonati(String s) {
        return specijalniSonati.contains(s.toLowerCase());
    }

    public boolean isSonat(String s) {
        return sonati.contains(s.toLowerCase());
    }

    public boolean isSlogotvorniSonati(String s) {
        return slogotvorniSonati.contains(s.toLowerCase());
    }

    public boolean isSuglasnik(String s) {
        return suglasnici.contains(s.toLowerCase());
    }

    public boolean isKonsonanti(String s) {
        return konsonanti.contains(s.toLowerCase());
    }

    public boolean isZvucniKonsonantiL(String s) {
        return zvucniKonsonanti.contains(s.toLowerCase());
    }

    public boolean isBezZvucniKonsonantiL(String s) {
        return bezZvucniKonsonanti.contains(s.toLowerCase());
    }
    
    public String podeliNaSlogove()
    {
    return podeliNaSlogovePoSamoglasnicima();
    }
    
    private String podeliNaSlogovePoSamoglasnicima() {
        /*
         prvobitna podela reci na slogove gde se rec
         na slogove deli samo po samoglasnicima
         */
//ukoliko je rec od 3 slova ili manje nemoj je rastavljati vrati celu rec
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
                 prebaci prvi suglasnik u prethodni slog osim ako nije neki od slucajeva oznacenih sa logicnim 'ne'-!()*/
                if (isSuglasnik(t[i].substring(0, 1)) && isSuglasnik(t[i].substring(1, 2)) && t[i].length() >= 3) {
                    //uvek je granica sloga ispred grupe suglasnika ako je na prvom mestu bilo koji suglasnik osim sonanta, a na drugom mestu sonanti. V, J, R, L, LJ:
                    if (!(!isSonat(t[i].substring(0, 1)) && isSpecijalniSonati(t[i].substring(1, 2)))) {
                        //ako nije strujni ili sliveni na prvom mestu

                        //Uvek je granica ispred grupe suglasnika koju čine dva sonanta, a drugi je JE (kratak refleks JATA):čo-vjek
                        if (!(isSonat(t[i].substring(0, 1)) && t[i].substring(1, 2).equalsIgnoreCase("j") && t[i].substring(2, 3).equalsIgnoreCase("e"))) {
                            //uvek je granica sloga ispred grupe suglasnika koju čine strujni, afrikate ili neki drugi suglasnik:
                            if (!isstrujniISliveniSuglasnici(t[i].substring(0, 1))) {

                                t[i - 1] = t[i - 1] + t[i].substring(0, 1);
                                t[i] = t[i].substring(1, t[i].length());

                            }
                        }

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
        for (int i = 0; i < slogovi.length; i++) {
            if (slogovi[i].length() >= 3) {

                if (isSuglasnik(slogovi[i].substring(0, 1)) && isSuglasnik(slogovi[i].substring(1, 2)) && isSuglasnik(slogovi[i].substring(2, 3))) {
                    if (isSlogotvorniSonati(slogovi[i].substring(0, 1))) {
                        slogovi[i] = slogovi[i].substring(0, 1) + "-" + slogovi[i].substring(1, slogovi[i].length());
                    } else if (isSlogotvorniSonati(slogovi[i].substring(1, 2))) {
                        slogovi[i] = slogovi[i].substring(0, 2) + "-" + slogovi[i].substring(2, slogovi[i].length());
                    } else if (isSlogotvorniSonati(slogovi[i].substring(2, 3)) && slogovi[i].length() >= 5) {
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
        povratniSlog = povratniSlog.replace("--", "-");
        return slovoRnaPocetkuSloga(povratniSlog);
    }

//slovo r na pocetku sloga
    private String slovoRnaPocetkuSloga(String a) {
        if (!a.substring(0, 1).toLowerCase().equals("r")) {
            return a;
        }

        String[] slog = a.split("-");

        if (slog[0].length() >= 3 && isSuglasnik(slog[0].substring(1, 2))) {
            return a.substring(0, 1) + "-" + a.substring(1, a.length());
        }

        return a;

    }
}
