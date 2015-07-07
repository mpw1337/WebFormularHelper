package de.mpw.webformularhelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLInputElement;
import org.w3c.dom.html.HTMLSelectElement;

public class Controller {
    public Button btStart;
    public Button btEintragenSnelNL;
    public Button btLoad1;
    public ProgressBar pbWeb;
    public TextArea taInformation;
    public Button btLoadLive;
    public Button btEintragenLive;
    public ChoiceBox cbHost;
    private WebEngine webEngine;
    public WebView WvMain;
    public Button btLoad;
    public Button btGenerieren;
    public TextField tfVorname;
    public TextField tfNachname;
    public TextField tfEmail;
    public TextField tfPasswort;
    public Button btEintragen;


    public final void getWebEngine() {
        webEngine = WvMain.getEngine();

        webEngine.setJavaScriptEnabled(true);
        webEngine.getLoadWorker().progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pbWeb.setProgress(newValue.doubleValue());
                System.out.println("Old " + oldValue + " New " + newValue);
            }
        });
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newState) {
                System.out.println("webEngine result " + newState.toString());
                if (newState == Worker.State.SUCCEEDED) {
                    btEintragen.setDisable(true);
                    btEintragenSnelNL.setDisable(true);
                    btEintragenLive.setDisable(true);
                    System.out.println("Auf der Seite " + webEngine.getLocation());
                    if (webEngine.getLocation().contains("eu.edit.yahoo.com/registration?.pd=&intl=de")) {
                        btEintragen.setDisable(false);
                    }
                    if (webEngine.getLocation().contains("https://www.snelnl.com/en/cart/checkout")) {
                        btEintragenSnelNL.setDisable(false);
                    }
                    if (webEngine.getLocation().contains("https://signup.live.com/signup")) {
                        btEintragenLive.setDisable(false);
                    }
                }
            }
        });
        btLoad.setDisable(false);
        btLoad1.setDisable(false);
        btLoadLive.setDisable(false);
    }

    public void loadYahoo(ActionEvent actionEvent) {
        webEngine.load("https://eu.edit.yahoo.com/registration?.pd=&intl=de");
    }

    public void loadLive(ActionEvent event) {
        webEngine.load("https://signup.live.com/signup.aspx?lic=1&mkt=DE-DE");
    }

    public void loadSnelNL(ActionEvent event) {
        webEngine.load("http://www.snelnl.com/subscribe/test-trial-usenet");
    }

    public void generiereDaten(ActionEvent event) {
        Namen n = new Namen();
        tfEmail.setText(Namen.getMail());
        tfPasswort.setText(Namen.getPasswort());
        tfVorname.setText(n.getVorname(false));
        tfNachname.setText(n.getNachname());
    }

    public void eintragenYahoo(ActionEvent event) {
        Namen n = new Namen();
        Document document = WvMain.getEngine().getDocument();
        Element firstName = document.getElementById("first-name");
        firstName.setAttribute("value", tfVorname.getText());
        Element lastName = document.getElementById("last-name");
        lastName.setAttribute("value", tfNachname.getText());
        Element email = document.getElementById("user-name");
        email.setAttribute("value", tfEmail.getText());
        Element passwort1 = document.getElementById("password");
        Element passwort2 = document.getElementById("confirm-password");
        passwort1.setAttribute("value", tfPasswort.getText());
        passwort2.setAttribute("value", tfPasswort.getText());
        passwort2.setAttribute("type", "");
        Element day = document.getElementById("day");
        HTMLSelectElement selectDay = (HTMLSelectElement) day;
        int iday = n.getDay();
        int imonth = n.getMonth();
        int iyear = n.getYear();
        System.out.println("Tag" + iday + " Monat" + imonth + " Jahr" + iyear);
        selectDay.setSelectedIndex(iday);
        selectDay.setAttribute("value", String.valueOf(iday));
        System.out.println(selectDay.getOptions().toString());

        Element month = document.getElementById("month");
        HTMLSelectElement selectMonth = (HTMLSelectElement) month;
        selectMonth.setSelectedIndex(imonth);
        selectMonth.setValue(String.valueOf(imonth));
        selectMonth.setAttribute("value", String.valueOf(imonth));

        Element year = document.getElementById("year");
        HTMLSelectElement selectYear = (HTMLSelectElement) year;
        selectYear.setSelectedIndex(iyear);
        selectYear.setValue(String.valueOf(iyear));

        HTMLInputElement genderM = (HTMLInputElement) document.getElementById("male");
        genderM.setChecked(true);

        HTMLInputElement mobileNr = (HTMLInputElement) document.getElementById("mobile");
        mobileNr.setValue("16041584227");
        showData("yahoo.de");
    }

    public void eintragenLive(ActionEvent event) {
        Namen n = new Namen();
        Document document = WvMain.getEngine().getDocument();
        FormLive fl = new FormLive(document, n);
        fl.firstName(tfVorname.getText());
        fl.lastName(tfNachname.getText());
        fl.email(tfEmail.getText());
        fl.passwort(tfPasswort.getText());
        fl.birthday();
        fl.gender();
        showData("outlook.de");
    }

    private void showData(String mailsuffix) {
        Document document = WvMain.getEngine().getDocument();
        HTMLInputElement inputtelnr = (HTMLInputElement) document.getElementById("mobile");
        String telNr = "";
        if (inputtelnr != null) {
            telNr = inputtelnr.getValue();
        }
        String information = tfEmail.getText() + "@" + mailsuffix + "	" + tfPasswort.getText() + "    -	-	" + telNr;
        taInformation.setText(information);
    }

    public void eintragenSnelNL(ActionEvent event) {
        Document document = WvMain.getEngine().getDocument();
        String host = cbHost.getValue().toString();
        String email = tfEmail.getText() + "@" + host;
        Element emailprimary = document.getElementById("edit-panes-customer-primary-email");
        emailprimary.setAttribute("value", email);
        Element emailsecondary = document.getElementById("edit-panes-customer-primary-email-confirm");
        emailsecondary.setAttribute("value", email);

    }
}
