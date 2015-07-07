package de.mpw.webformularhelper;

import org.w3c.dom.Document;

/**
 * Created by Markus on 07.07.2015.
 */
public class FormYahoo extends FormBlueprint {
    public final static String FIRSTNAME = "first-name";
    public final static String LASTNAME = "last-name";
    public final static String EMAIL = "user-name";
    public static final String Password1 = "password";
    public static final String Password2 = "confirm-password";
    public static final String ZipCode = ""; //Inactive
    public static final String BirthDay = "day";
    public static final String BirthMonth = "month";
    public static final String BirthYear = "year";
    public static final String Gender = "Gender";

    public FormYahoo(Document d, Namen n) {
        super(d, n);
    }

}
