package de.mpw.webformularhelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLInputElement;

public class Controller {
    public Button btStart;
    public Button btEintragenSnelNL;
    public Button btLoad1;
    public ProgressBar pbWeb;
    public TextArea taInformation;
    public Button btLoadLive;
    public Button btEintragenLive;
    public ChoiceBox cbHost;
    public WebView WvMain;
    public Button btLoad;
    public Button btGenerieren;
    public TextField tfVorname;
    public TextField tfNachname;
    public TextField tfEmail;
    public TextField tfPasswort;
    public Button btEintragen;
    private WebEngine webEngine;
    private String str_Host_title = "Kein Host";
    private String str_Host_content = "Bitte wählen sie einen E-Mail Host aus";
    private String str_Host_header = "Information";

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
        FormYahoo form = new FormYahoo(document, n);
        form.firstName(tfVorname.getText());
        form.lastName(tfNachname.getText());
        form.email(tfEmail.getText());
        form.passwort(tfPasswort.getText());
        form.birthday();
        form.gender();
        form.mobile();
        showData("yahoo.de");
    }

    public void eintragenLive(ActionEvent event) {
        Namen n = new Namen();
        Document document = WvMain.getEngine().getDocument();
        FormLive form = new FormLive(document, n);
        form.firstName(tfVorname.getText());
        form.lastName(tfNachname.getText());
        form.email(tfEmail.getText());
        form.passwort(tfPasswort.getText());
        form.birthday();
        form.gender();
        showData("outlook.de");
    }

    public void eintragenSnelNL(ActionEvent event) {
        Namen n = new Namen();
        Document document = WvMain.getEngine().getDocument();
        FormSnelNl form = new FormSnelNl(document, n);
        String host = "";
        if (cbHost.getValue() != null) {
            host = cbHost.getValue().toString();
            String email = tfEmail.getText() + '@' + host;
            form.email(email);
            form.firstName(tfVorname.getText());
            form.lastName(tfNachname.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(str_Host_title);
            alert.setHeaderText(str_Host_header);
            alert.setContentText(str_Host_content);
            alert.show();
        }


    }
    private void showData(String mailsuffix) {
        Document document = WvMain.getEngine().getDocument();
        HTMLInputElement inputtelnr = (HTMLInputElement) document.getElementById("mobile");
        String telNr = "";
        if (inputtelnr != null) {
            telNr = inputtelnr.getValue();
        }
        String information = tfEmail.getText() + '@' + mailsuffix + '	' + tfPasswort.getText() + "    -	-	" + telNr;
        taInformation.setText(information);
    }


}
