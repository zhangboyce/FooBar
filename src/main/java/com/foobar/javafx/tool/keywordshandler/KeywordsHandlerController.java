package com.foobar.javafx.tool.keywordshandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Boyce
 * Date: 16/3/15
 * Time: 16:59
 */
public class KeywordsHandlerController {

    @FXML
    private TextArea source_textArea;
    @FXML
    private TextArea handled_textArea;

    @FXML
    private Button copy_button;
    @FXML
    private Button close_button;
    @FXML
    private Button apply_button;

    private Stage stage;

    @FXML
    public void initialize() {
        UnaryOperator<TextFormatter.Change> filter = c -> {
            c.setText(c.getText().replaceAll("\r", "\n"));
            return c ;
        };
        source_textArea.setTextFormatter(new TextFormatter<>(filter));

        close_button.setOnAction(e -> stage.close());

        copy_button.setOnAction(e -> {
            String text = handled_textArea.getText();
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(text);
            clipboard.setContent(content);
        });

        apply_button.setOnAction(e -> {
            String source = source_textArea.getText();
            String handled = handleText(source);

            handled_textArea.setText(handled);
        });

        source_textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            String handled = handleText(newValue);
            handled_textArea.setText(handled);
        });
    }

    public void setStageAndSetupListeners(Stage stage) {
        this.stage = stage;
    }

    private String handleText(String source) {
        if (null == source || "".equals(source)) return "";

        String patternString = "(.*?)\t(.*?)\t(.*?)\t(.*)";
        Pattern p = Pattern.compile(patternString);
        Matcher m = p.matcher(source);
        StringBuffer s = new StringBuffer();

        String replacedTemplate = "\"$1-$2\":[keywords:\"$3,$4\",negative:\"$4\"],";
        while (m.find()) {
            String replaced = replacedTemplate
                    .replace("$1", m.group(1))
                    .replace("$2", m.group(2))
                    .replace("$3", replaceSplitChar(m.group(3)))
                    .replace("$4", replaceSplitChar(m.group(4)));
            m.appendReplacement(s, replaced);
        }
        return s.toString();
    }

    private String replaceSplitChar(String text) {
        if (null == text || "".equals(text)) return "";

        return text.replaceAll("OR", ",").replaceAll("；", ",").replaceAll(";", ",").replaceAll(" ", "");
    }
}
