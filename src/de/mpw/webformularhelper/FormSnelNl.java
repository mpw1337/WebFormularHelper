package de.mpw.webformularhelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormSnelNl extends FormBlueprint {
    public String FIRSTNAME = "edit-panes-cm-profile-field-first-name-und-0-value";
    public String LASTNAME = "edit-panes-cm-profile-field-last-name-und-0-value";
    public String EMAIL = "edit-panes-customer-primary-email";
    public String EMAIL2 = "edit-panes-customer-primary-email-confirm";

    public FormSnelNl(Document d, Namen n) {
        super(d, n);
    }

    @Override
    public void email(String e) {
        Element emailprimary = d.getElementById("edit-panes-customer-primary-email");
        emailprimary.setAttribute("value", e);
        Element emailsecondary = d.getElementById("edit-panes-customer-primary-email-confirm");
        emailsecondary.setAttribute("value", e);
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
}
