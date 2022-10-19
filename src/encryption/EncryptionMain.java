package encryption;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.HashMap;


public class EncryptionMain implements ActionListener{

    /**
     * declaring main elements, like app window and internal elements (labels, textareas etc.)
     */
    JFrame mainWindow;
    JTextField word, encrWord;
    JTextArea keyWord;
    JPanel bottomPanel, upperPanel, textPanel;
    JButton decode, encrypt;
    JButton copyBtn, copyWord, clearAll, hashMapBtn;
    JLabel upperLabel, bottomLabel;
    JLabel wordLabel, encrWordLabel, keyWordLabel;
    Font myFont = new Font(Font.SANS_SERIF,Font.BOLD,20);
    ImageIcon keyIcon = new ImageIcon("src/logo.png");
    /**
     * Creating main window app
     */
    EncryptionMain(){
        //settings for main window app
        mainWindow = new JFrame("Encryption program");
        mainWindow.setIconImage(keyIcon.getImage());
        mainWindow.setLayout(null);
        mainWindow.setSize(800,600);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.getContentPane().setBackground(Color.DARK_GRAY);
        mainWindow.setLocationRelativeTo(null);

        //default settings for bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setBounds(50,500,685,50);
        bottomPanel.setBackground(new Color(40, 32, 37, 146));
        bottomPanel.setFont(myFont);

        bottomLabel = new JLabel("Author: https://github.com/navr0 Version: alpha, 10/2022");

        bottomLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        bottomLabel.setForeground(Color.white);
        bottomPanel.add(bottomLabel);

        //default settings for upperPanel
        upperPanel = new JPanel();
        upperPanel.setBounds(50,15,685,100);
        upperPanel.setBackground(new Color(40, 32, 37, 146));
        upperPanel.setFont(myFont);

        upperLabel = new JLabel("Encryption program");
        upperLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        upperLabel.setForeground(Color.white);
        upperPanel.add(upperLabel);

        //default settings for textPanel
        textPanel = new JPanel();
        textPanel.setBounds(50,130,685,350);
        textPanel.setBackground(new Color(40, 32, 37, 146));
        textPanel.setFont(myFont);
        textPanel.isFocusable();
        textPanel.setLayout(null);

        wordLabel = new JLabel("Enter your word:");
        wordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        wordLabel.setBounds(35,5,540,35);
        wordLabel.setForeground(Color.white);

        //creating text field for user's word
        word = new JTextField();
        word.setColumns(20);
        word.setFont(myFont);
        word.setBounds(35,35,540,35);
        word.setText("TEST");

        encrWordLabel = new JLabel("Encrypted word:");
        encrWordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        encrWordLabel.setBounds(35,75,540,35);
        encrWordLabel.setForeground(Color.white);

        //creating text field for encrypted word
        encrWord = new JTextField();
        encrWord.setColumns(20);
        encrWord.setFont(myFont);
        encrWord.setBounds(35,105,540,35);
        encrWord.setText("");

        keyWordLabel = new JLabel("Your key:");
        keyWordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        keyWordLabel.setBounds(35,145,540,35);
        keyWordLabel.setForeground(Color.white);

        //creating text area for once
        keyWord = new JTextArea();
        keyWord.setColumns(20);
        keyWord.setLineWrap(true);
        keyWord.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        keyWord.setBounds(35,175,540,95);
        keyWord.setText("");

        // button responsible for decoding word
        decode = new JButton("Decode");
        decode.setBounds(590,165,80,105);
        decode.setLayout(null);
        decode.addActionListener(this);

        // button responsible for encrypting word
        encrypt = new JButton("Encrypt");
        encrypt.setBounds(590,35,80,105);
        encrypt.setLayout(null);
        encrypt.addActionListener(this);

        // button responsible for copying key
        copyBtn = new JButton("Copy key");
        copyBtn.setBounds(220,295,120,35);
        copyBtn.setLayout(null);
        copyBtn.addActionListener(this);

        // button responsible for copying encrypted word
        copyWord = new JButton("Copy word");
        copyWord.setBounds(70,295,120,35);
        copyWord.setLayout(null);
        copyWord.addActionListener(this);

        // button responsible for clear all program windows
        clearAll = new JButton("Clear all");
        clearAll.setBounds(370,295,120,35);
        clearAll.setLayout(null);
        clearAll.addActionListener(this);

        // button responsible for convert data to HashMap format
        hashMapBtn = new JButton("to HashMap");
        hashMapBtn.setBounds(520,295,120,35);
        hashMapBtn.setLayout(null);
        hashMapBtn.addActionListener(this);

        textPanel.add(hashMapBtn);
        textPanel.add(clearAll);
        textPanel.add(copyWord);
        textPanel.add(copyBtn);
        textPanel.add(wordLabel);
        textPanel.add(encrWordLabel);
        textPanel.add(keyWordLabel);
        textPanel.add(decode);
        textPanel.add(encrypt);
        textPanel.add(word);
        textPanel.add(encrWord);
        textPanel.add(keyWord);

        // adding all elements to main window app
        mainWindow.add(bottomPanel);
        mainWindow.add(upperPanel);
        mainWindow.add(textPanel);
        mainWindow.setVisible(true);
    }
    public static void main(String[] args) {
        EncryptionMain e = new EncryptionMain();
    }

    /**
     * Activities when each button is active
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){
        /** encrypting the word
         *  input: word
         *  outputs: encryptedWord, keyWord
         *
         *  user has to copy outputs from GUI section
         */
        if(e.getSource() == encrypt){
            EncryptWord x = new EncryptWord();
            String myWord = word.getText();
            String[] myKey = x.encryptW(myWord);
            encrWord.setText(myKey[1]);
            keyWord.setText(myKey[0]);
        }
        /** decoding the word
         *  inputs: encryptedWord, keyWord
         *  output: word
         *
         *  user has to paste inputs into GUI section
         */
        if(e.getSource() == decode){
            Decode dcd = new Decode();
            String userWord = "",
                    userEncrWord = "",
                    userKey = "";
            userEncrWord = encrWord.getText();
            userKey = keyWord.getText();
            word.setText(dcd.wordDecode(userEncrWord,userKey));
        }

        if(e.getSource() == copyBtn){
            StringSelection copy = new StringSelection(keyWord.getText());
            Clipboard clcopy = Toolkit.getDefaultToolkit().getSystemClipboard();
            clcopy.setContents(copy,null);
        }

        if(e.getSource() == copyWord){
            StringSelection copy = new StringSelection(encrWord.getText());
            Clipboard clcopy = Toolkit.getDefaultToolkit().getSystemClipboard();
            clcopy.setContents(copy, null);
        }

        if(e.getSource() == clearAll){
            word.setText("");
            keyWord.setText("");
            encrWord.setText("");
        }

        if(e.getSource() == hashMapBtn){
            HashMap<String,String> hashMapKey = new HashMap<String, String>();
            hashMapKey.put("pass", encrWord.getText());
            hashMapKey.put("key", keyWord.getText());

            StringSelection copy = new StringSelection(hashMapKey.toString());
            Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
            cp.setContents(copy, null);

            //System.out.println(hashMapKey);
        }

    }

}
