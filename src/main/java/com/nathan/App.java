package com.nathan;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {
  JFrame frame;
  JPanel panel;
  JButton button;
  JLabel emailLabel;
  JLabel warningLabel;
  JLabel appendedEmailLabel;
  JTextField emailTextField;

  private void genereatePanel() {
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(emailLabel);
    panel.add(emailTextField);
    panel.add(button);
    panel.add(warningLabel);
    panel.add(appendedEmailLabel);
  }

  private void generateFrame() {
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Email Appender");
    frame.setSize(600, 250);
    frame.setVisible(true);
  }

  private void generateNewEmail() {
    String[] emailParts = emailTextField.getText().split("@");
    if (emailParts.length != 2) {
      warningLabel.setText("Errors: invalid email address");
      return;
    } else {
      warningLabel.setText("No Errors");
    }

    String username = emailParts[0];
    String domain = emailParts[1];
    String appendation = new SimpleDateFormat("MMM.dd.yy-HH.mm.ss").format(Calendar.getInstance().getTime());
    String appendedEmail = username + "+" + appendation + "@" + domain;

    StringSelection stringSelection = new StringSelection(appendedEmail);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);

    appendedEmailLabel.setText("Appended email address: " + appendedEmail);
  }

  private DocumentListener emailTextFieldDocumentListener() {
    return new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent arg0) {
        updateLabelText();
      }

      @Override
      public void insertUpdate(DocumentEvent arg0) {
        updateLabelText();
      }

      @Override
      public void removeUpdate(DocumentEvent arg0) {
        updateLabelText();
      }

      public void updateLabelText() {
        emailLabel.setText("email address: " + emailTextField.getText());
      }
    };
  }

  public App() {
    frame = new JFrame();
    panel = new JPanel();
    button = new JButton("Append Email & Copy to Clipboard!");
    emailLabel = new JLabel("Email address: ");
    warningLabel = new JLabel("No Errors");
    warningLabel.setForeground(java.awt.Color.RED);
    appendedEmailLabel = new JLabel("Appended email address: ");
    emailTextField = new JTextField(50);
    emailTextField.setText("tsuki@cat.com");

    emailTextField.getDocument().addDocumentListener(emailTextFieldDocumentListener());
    button.addActionListener(e -> generateNewEmail());

    genereatePanel();
    generateFrame();
  }

  public static void main(String[] args) {
    new App();
  }
}
