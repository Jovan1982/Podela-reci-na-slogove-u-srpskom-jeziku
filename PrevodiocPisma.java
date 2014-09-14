/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static lang.Pismo.Cyr;
import static lang.Pismo.Lat;

/**
 *
 * @author Jovo
 */
public class PrevodiocPisma {

    Pismo p;
    final List<String> cirilicnaSlova = Arrays.asList("а", "б", "в", "г", "д", "ђ", "е", "ж", "з", "и", "ј", "к", "л", "љ", "м", "н", "њ", "о", "п", "р", "с", "т", "ћ", "у", "ф", "х", "ц", "ч", "џ", "ш");
    final List<String> latinicnaSlova = Arrays.asList("a", "b", "v", "g", "d", "đ", "dj", "е", "ž", "z", "i", "j", "k", "l", "lj", "m", "n", "nj", "o", "p", "r", "s", "t", "ć", "u", "f", "h", "c", "č", "dž", "š");
    private Map cirilicaLatinica = new HashMap();
    private Map latinicaCirilica = new HashMap();
    private final String dvoslovnaSlova = "n,l,d";

    private void setCirilicaLatinica() {
        cirilicaLatinica.put("а", "а");
        cirilicaLatinica.put("б", "b");
        cirilicaLatinica.put("в", "v");
        cirilicaLatinica.put("г", "g");
        cirilicaLatinica.put("д", "d");
        cirilicaLatinica.put("ђ", "đ");
        cirilicaLatinica.put("е", "e");
        cirilicaLatinica.put("ж", "ž");
        cirilicaLatinica.put("з", "z");
        cirilicaLatinica.put("и", "i");
        cirilicaLatinica.put("ј", "j");
        cirilicaLatinica.put("к", "k");
        cirilicaLatinica.put("л", "l");
        cirilicaLatinica.put("љ", "lj");
        cirilicaLatinica.put("м", "m");
        cirilicaLatinica.put("н", "n");
        cirilicaLatinica.put("њ", "nj");
        cirilicaLatinica.put("о", "o");
        cirilicaLatinica.put("п", "p");
        cirilicaLatinica.put("р", "r");
        cirilicaLatinica.put("с", "s");
        cirilicaLatinica.put("т", "t");
        cirilicaLatinica.put("ћ", "ć");
        cirilicaLatinica.put("у", "u");
        cirilicaLatinica.put("ф", "f");
        cirilicaLatinica.put("х", "h");
        cirilicaLatinica.put("ц", "c");
        cirilicaLatinica.put("ч", "č");
        cirilicaLatinica.put("џ", "dž");
        cirilicaLatinica.put("ш", "š");

        cirilicaLatinica.put("А", "A");
        cirilicaLatinica.put("Б", "B");
        cirilicaLatinica.put("В", "V");
        cirilicaLatinica.put("Г", "G");
        cirilicaLatinica.put("Д", "D");
        cirilicaLatinica.put("Ђ", "Đ");
        cirilicaLatinica.put("Е", "E");
        cirilicaLatinica.put("Ж", "Ž");
        cirilicaLatinica.put("З", "Z");
        cirilicaLatinica.put("И", "I");
        cirilicaLatinica.put("Ј", "J");
        cirilicaLatinica.put("К", "K");
        cirilicaLatinica.put("Л", "L");
        cirilicaLatinica.put("Љ", "Lj");
        cirilicaLatinica.put("М", "M");
        cirilicaLatinica.put("Н", "N");
        cirilicaLatinica.put("Њ", "Nj");
        cirilicaLatinica.put("О", "O");
        cirilicaLatinica.put("П", "P");
        cirilicaLatinica.put("Р", "R");
        cirilicaLatinica.put("С", "S");
        cirilicaLatinica.put("Т", "T");
        cirilicaLatinica.put("Ћ", "Ć");
        cirilicaLatinica.put("У", "U");
        cirilicaLatinica.put("Ф", "F");
        cirilicaLatinica.put("Х", "H");
        cirilicaLatinica.put("Ц", "C");
        cirilicaLatinica.put("Ч", "Č");
        cirilicaLatinica.put("Џ", "Dž");
        cirilicaLatinica.put("Ш", "Š");

    }

    private void setLatinicaCirilica() {
        latinicaCirilica.put("a", "а");
        latinicaCirilica.put("b", "б");
        latinicaCirilica.put("v", "в");
        latinicaCirilica.put("g", "г");
        latinicaCirilica.put("d", "д");
        latinicaCirilica.put("đ", "ђ");
        latinicaCirilica.put("dj", "ђ");
        latinicaCirilica.put("e", "е");
        latinicaCirilica.put("ž", "ж");
        latinicaCirilica.put("z", "з");
        latinicaCirilica.put("i", "и");
        latinicaCirilica.put("j", "ј");
        latinicaCirilica.put("k", "к");
        latinicaCirilica.put("l", "л");
        latinicaCirilica.put("lj", "љ");
        latinicaCirilica.put("m", "м");
        latinicaCirilica.put("n", "н");
        latinicaCirilica.put("nj", "њ");
        latinicaCirilica.put("o", "о");
        latinicaCirilica.put("p", "п");
        latinicaCirilica.put("r", "р");
        latinicaCirilica.put("s", "с");
        latinicaCirilica.put("t", "т");
        latinicaCirilica.put("ć", "ћ");
        latinicaCirilica.put("u", "у");
        latinicaCirilica.put("f", "ф");
        latinicaCirilica.put("h", "х");
        latinicaCirilica.put("c", "ц");
        latinicaCirilica.put("č", "ч");
        latinicaCirilica.put("dž", "џ");
        latinicaCirilica.put("š", "ш");

        latinicaCirilica.put("A", "А");
        latinicaCirilica.put("B", "Б");
        latinicaCirilica.put("V", "В");
        latinicaCirilica.put("G", "Г");
        latinicaCirilica.put("D", "Д");
        latinicaCirilica.put("Đ", "Ђ");
        latinicaCirilica.put("Dj", "Ђ");
        latinicaCirilica.put("DJ", "Ђ");
        latinicaCirilica.put("E", "Е");
        latinicaCirilica.put("Ž", "Ж");
        latinicaCirilica.put("Z", "З");
        latinicaCirilica.put("I", "И");
        latinicaCirilica.put("J", "Ј");
        latinicaCirilica.put("K", "К");
        latinicaCirilica.put("L", "Л");
        latinicaCirilica.put("Lj", "Љ");
        latinicaCirilica.put("LJ", "Љ");
        latinicaCirilica.put("M", "М");
        latinicaCirilica.put("N", "Н");
        latinicaCirilica.put("Nj", "Њ");
        latinicaCirilica.put("NJ", "Њ");
        latinicaCirilica.put("O", "О");
        latinicaCirilica.put("P", "П");
        latinicaCirilica.put("R", "Р");
        latinicaCirilica.put("S", "С");
        latinicaCirilica.put("T", "Т");
        latinicaCirilica.put("Ć", "Ћ");
        latinicaCirilica.put("U", "У");
        latinicaCirilica.put("F", "Ф");
        latinicaCirilica.put("H", "Х");
        latinicaCirilica.put("C", "Ц");
        latinicaCirilica.put("Č", "Ч");
        latinicaCirilica.put("Dž", "Џ");
        latinicaCirilica.put("DŽ", "Џ");
        latinicaCirilica.put("Š", "Ш");

    }

    public Pismo getP() {
        return p;
    }

    public void setP(Pismo p) {
        this.p = p;
    }

    public PrevodiocPisma() {
        setCirilicaLatinica();
        setLatinicaCirilica();
    }

    public String prevediIzPismaUPismo(String rec, Pismo iz, Pismo u) {
        if (iz.equals(Cyr) && u.equals(Lat)) {
            return prevediIzCiriliceULatinicu(rec);
        } else if (iz.equals(Lat) && u.equals(Cyr)) {
            return prevediIzLatiniceUCirilicu(rec);
        } else {
            return "Može se prevoditi samo iz latinice u ćirilicu i obratno !";
        }

    }

    private String prevediIzCiriliceULatinicu(String rec) {
        String recCirlica = "";
        String slovo = "";
        char c;
        for (int i = 0; i < rec.length(); i++) {

            slovo = (String) cirilicaLatinica.get(String.valueOf(rec.charAt(i)));
            if (slovo != null) {
                recCirlica = recCirlica + slovo;

            } else {
                recCirlica = recCirlica + rec.charAt(i);
            }
        }
        return recCirlica;

    }

    private String prevediIzLatiniceUCirilicu(String rec) {

        String recLatinica = "";
        String slovo = "";
        char c;
        niz:
        for (int i = 0; i < rec.length(); i++) {

            //provera da li su u pitanju dvoslovna slova
            if ((i != rec.length() - 1 && String.valueOf(rec.charAt(i + 1)).equalsIgnoreCase("j") && dvoslovnaSlova.indexOf(String.valueOf(rec.charAt(i)).toLowerCase()) != -1) || (i != rec.length() - 1 && String.valueOf(rec.charAt(i + 1)).equalsIgnoreCase("ž") && String.valueOf(rec.charAt(i)).equalsIgnoreCase("d"))) {
                slovo = slovo + String.valueOf(rec.charAt(i));
                continue niz;
            }

            if (slovo.length() < 1) {
                slovo = (String) latinicaCirilica.get(String.valueOf(rec.charAt(i)));
            } else {

                slovo = (String) latinicaCirilica.get(slovo + String.valueOf(rec.charAt(i)));
            }

            if (slovo != null) {
                recLatinica = recLatinica + slovo;

            } else {
                recLatinica = recLatinica + rec.charAt(i);
            }
            slovo = "";

        }
        return recLatinica;
    }

}
