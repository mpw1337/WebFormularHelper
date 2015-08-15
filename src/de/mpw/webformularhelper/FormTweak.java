package de.mpw.webformularhelper;

import org.w3c.dom.Document;

/**
 * Created by Markus on 15.08.2015.
 */
public class FormTweak extends FormBlueprint {
    public String FIRSTNAME = "signupForm_firstName";
    public String LASTNAME = "signupForm_lastName";
    public String EMAIL = "signupForm_email";
    private String Password1 = "signupForm_password";
    private String Password2 = "signupForm_password_again";

    FormTweak(Document d, Namen n) {
        super(d, n);
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
}
