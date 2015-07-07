package de.mpw.webformularhelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLInputElement;
import org.w3c.dom.html.HTMLSelectElement;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormBlueprint {
    public String FIRSTNAME = "";
    public String LASTNAME = "LastName";
    public String EMAIL = "MemberName";
    public String Password1 = "Password";
    public String Password2 = "RetypePassword";
    public String ZipCode = ""; //Inactive
    public String BirthDay = "BirthDay";
    public String BirthMonth = "BirthMonth";
    public String BirthYear = "BirthYear";
    public String Gender = "Gender";
    public String Mobile = "mobile";
    protected Document d;
    private Namen n;

    public FormBlueprint(Document d, Namen n) {
        this.d = d;
        this.n = n;
    }

    public void firstName(String fn) {
        System.out.println(getFIRSTNAME());
        Element firstName = d.getElementById(getFIRSTNAME());
        firstName.setAttribute("value", fn);
        HTMLInputElement inputFirstName = (HTMLInputElement) firstName;
        inputFirstName.setValue(fn);
    }

    public void lastName(String ln) {
        Element lastName = d.getElementById(getLASTNAME());
        lastName.setAttribute("value", ln);
    }

    public void email(String e) {
        Element email = d.getElementById(getEMAIL());
        email.setAttribute("value", e);
    }

    public void passwort(String pw) {
        Element passwort1 = d.getElementById(getPassword1());
        Element passwort2 = d.getElementById(getPassword2());
        passwort1.setAttribute("value", pw);
        passwort2.setAttribute("value", pw);
        passwort2.setAttribute("type", "");
    }

    public void birthday() {
        Element day = d.getElementById(getBirthDay());
        HTMLSelectElement selectDay = (HTMLSelectElement) day;
        int iday = n.getDay();
        int imonth = n.getMonth();
        int iyear = n.getYear();
        System.out.println("Tag" + iday + " Monat" + imonth + " Jahr" + iyear);
        selectDay.setSelectedIndex(iday);
        selectDay.setAttribute("value", String.valueOf(iday));
        System.out.println(selectDay.getOptions().toString());

        Element month = d.getElementById(getBirthMonth());
        HTMLSelectElement selectMonth = (HTMLSelectElement) month;
        selectMonth.setSelectedIndex(imonth);
        selectMonth.setValue(String.valueOf(imonth));
        selectMonth.setAttribute("value", String.valueOf(imonth));

        Element year = d.getElementById(getBirthYear());
        HTMLSelectElement selectYear = (HTMLSelectElement) year;
        selectYear.setSelectedIndex(iyear);
        selectYear.setValue(String.valueOf(iyear));

    }

    public void gender() {
        Element gender = d.getElementById(getGender());
        HTMLSelectElement selectGender = (HTMLSelectElement) gender;
        selectGender.setSelectedIndex(1);
        selectGender.setValue("m");
    }

    public void mobile() {
        HTMLInputElement mobileNr = (HTMLInputElement) d.getElementById(getMobile());
        mobileNr.setValue("16041584227");
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPassword1() {
        return Password1;
    }

    public String getPassword2() {
        return Password2;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public String getBirthMonth() {
        return BirthMonth;
    }

    public String getBirthYear() {
        return BirthYear;
    }

    public String getGender() {
        return Gender;
    }

    public String getMobile() {
        return Mobile;
    }
}
