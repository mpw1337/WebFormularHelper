package de.mpw.webformularhelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLInputElement;
import org.w3c.dom.html.HTMLSelectElement;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormBlueprint {
    public final static String FIRSTNAME = "FirstName";
    public final static String LASTNAME = "LastName";
    public final static String EMAIL = "MemberName";
    public static final String Password1 = "Password";
    public static final String Password2 = "RetypePassword";
    public static final String ZipCode = ""; //Inactive
    public static final String BirthDay = "BirthDay";
    public static final String BirthMonth = "BirthMonth";
    public static final String BirthYear = "BirthYear";
    public static final String Gender = "Gender";
    public static final String Mobile = "mobile";
    private Document d;
    private Namen n;

    public FormBlueprint(Document d, Namen n) {
        this.d = d;
        this.n = n;
    }

    public void firstName(String fn) {
        Element firstName = d.getElementById(FIRSTNAME);
        firstName.setAttribute("value", fn);
        HTMLInputElement inputFirstName = (HTMLInputElement) firstName;
        inputFirstName.setValue(fn);
    }

    public void lastName(String ln) {
        Element lastName = d.getElementById(LASTNAME);
        lastName.setAttribute("value", ln);
    }

    public void email(String e) {
        Element email = d.getElementById(EMAIL);
        email.setAttribute("value", e);
    }

    public void passwort(String pw) {
        Element passwort1 = d.getElementById(FormLive.Password1);
        Element passwort2 = d.getElementById(FormLive.Password2);
        passwort1.setAttribute("value", pw);
        passwort2.setAttribute("value", pw);
        passwort2.setAttribute("type", "");
    }

    public void birthday() {
        Element day = d.getElementById(FormLive.BirthDay);
        HTMLSelectElement selectDay = (HTMLSelectElement) day;
        int iday = n.getDay();
        int imonth = n.getMonth();
        int iyear = n.getYear();
        System.out.println("Tag" + iday + " Monat" + imonth + " Jahr" + iyear);
        selectDay.setSelectedIndex(iday);
        selectDay.setAttribute("value", String.valueOf(iday));
        System.out.println(selectDay.getOptions().toString());

        Element month = d.getElementById(FormLive.BirthMonth);
        HTMLSelectElement selectMonth = (HTMLSelectElement) month;
        selectMonth.setSelectedIndex(imonth);
        selectMonth.setValue(String.valueOf(imonth));
        selectMonth.setAttribute("value", String.valueOf(imonth));

        Element year = d.getElementById(FormLive.BirthYear);
        HTMLSelectElement selectYear = (HTMLSelectElement) year;
        selectYear.setSelectedIndex(iyear);
        selectYear.setValue(String.valueOf(iyear));

    }

    public void gender() {
        Element gender = d.getElementById(FormLive.Gender);
        HTMLSelectElement selectGender = (HTMLSelectElement) gender;
        selectGender.setSelectedIndex(1);
        selectGender.setValue("m");
    }

    public void mobile() {
        HTMLInputElement mobileNr = (HTMLInputElement) d.getElementById(Mobile);
        mobileNr.setValue("16041584227");
    }
}
