package de.mpw.webformularhelper;

import org.w3c.dom.Document;

/**
 * Created by Markus on 11.04.2015.
 */
public class FormLive extends FormBlueprint {

    public String FIRSTNAME = "FirstName";
    public String LASTNAME = "LastName";
    public String EMAIL = "MemberName";
    public String Password1 = "Password";
    public String Password2 = "RetypePassword";
    public String ZipCode = ""; //Inactive
    public String BirthDay = "BirthDay";
    public String BirthMonth = "BirthMonth";
    public String BirthYear = "BirthYear";
    public String Gender = "Gender";

    public FormLive(Document document, Namen n) {
        super(document, n);
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
