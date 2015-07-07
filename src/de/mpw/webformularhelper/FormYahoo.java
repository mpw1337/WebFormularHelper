package de.mpw.webformularhelper;

import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLInputElement;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormYahoo extends FormBlueprint {
    public String FIRSTNAME = "first-name";
    public String LASTNAME = "last-name";
    public String EMAIL = "user-name";
    public String Password1 = "password";
    public String Password2 = "confirm-password";
    public String ZipCode = ""; //Inactive
    public String BirthDay = "day";
    public String BirthMonth = "month";
    public String BirthYear = "year";
    public String Gender = "Gender";

    public FormYahoo(Document d, Namen n) {
        super(d, n);
    }

    @Override
    public void gender() {
        HTMLInputElement genderM = (HTMLInputElement) d.getElementById("male");
        genderM.setChecked(true);
    }

    @Override
    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    @Override
    public String getLASTNAME() {
        return LASTNAME;
    }

    @Override
    public String getEMAIL() {
        return EMAIL;
    }

    @Override
    public String getPassword1() {
        return Password1;
    }

    @Override
    public String getPassword2() {
        return Password2;
    }

    @Override
    public String getZipCode() {
        return ZipCode;
    }

    @Override
    public String getBirthDay() {
        return BirthDay;
    }

    @Override
    public String getBirthMonth() {
        return BirthMonth;
    }

    @Override
    public String getBirthYear() {
        return BirthYear;
    }

    @Override
    public String getGender() {
        return Gender;
    }
}
