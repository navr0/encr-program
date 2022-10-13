package encryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EncryptionMain implements ActionListener{
    JFrame mainWindow;
    JTextField word, encrWord;
    JTextArea keyWord;

    //bottomPanel - copyrights, etc
    //upperPanel - panel for program name
    //textPanel - panel for text fields
    JPanel bottomPanel, upperPanel, textPanel;
    JButton decode, encrypt;
    JLabel titleLabel, upperLabel, bottomLabel;
    JLabel wordLabel, encrWordLabel, keyWordLabel;
    Font myFont = new Font(Font.SANS_SERIF,Font.BOLD,20);
    ImageIcon keyIcon = new ImageIcon("src/logo.png");


    EncryptionMain(){
        mainWindow = new JFrame("Encryption Program");
        mainWindow.setIconImage(keyIcon.getImage());
        mainWindow.setLayout(null);
        mainWindow.setSize(800,600);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.getContentPane().setBackground(Color.DARK_GRAY);

        //default settings for bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setBounds(50,500,685,50);
        bottomPanel.setBackground(new Color(40, 32, 37, 146));
        bottomPanel.setFont(myFont);

        bottomLabel = new JLabel("Wersja programu: alpha 10/2022.");
        bottomLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        bottomLabel.setForeground(Color.white);
        bottomPanel.add(bottomLabel);

        //default settings for upperPanel
        upperPanel = new JPanel();
        upperPanel.setBounds(50,15,685,100);
        upperPanel.setBackground(new Color(40, 32, 37, 146));
        upperPanel.setFont(myFont);

        upperLabel = new JLabel("Program Szyfrujący");
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
        //textPanel.setLayout(new );

        wordLabel = new JLabel("Type your word:");
        wordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        wordLabel.setBounds(35,5,540,35);
        wordLabel.setForeground(Color.white);

        word = new JTextField();
        word.setColumns(20);
        word.setFont(myFont);
        //word.setPreferredSize(new Dimension(250,35));
        word.setBounds(35,35,540,35);
        word.setText("testWord");

        encrWordLabel = new JLabel("Your encrypted word: (copy it after encrypt!!!)");
        encrWordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        encrWordLabel.setBounds(35,75,540,35);
        encrWordLabel.setForeground(Color.white);

        encrWord = new JTextField();
        encrWord.setColumns(20);
        //encrWord.setPreferredSize(new Dimension(250,35));
        encrWord.setFont(myFont);
        encrWord.setBounds(35,105,540,35);
        encrWord.setText("testEncrWord");

        keyWordLabel = new JLabel("Your special key: (copy it after encrypt!!!)");
        keyWordLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        keyWordLabel.setBounds(35,145,540,35);
        keyWordLabel.setForeground(Color.white);

        keyWord = new JTextArea();
        keyWord.setColumns(20);
        //keyWord.setPreferredSize(new Dimension(250,65));
        keyWord.setLineWrap(true);
        keyWord.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        keyWord.setBounds(35,175,540,95);
        keyWord.setText("testKey");

        decode = new JButton("Decode");
        decode.setBounds(590,165,80,105);
        decode.setLayout(null);
        decode.addActionListener(this);

        encrypt = new JButton("Encrypt");
        encrypt.setBounds(590,35,80,105);
        encrypt.setLayout(null);
        encrypt.addActionListener(this);

        textPanel.add(wordLabel);
        textPanel.add(encrWordLabel);
        textPanel.add(keyWordLabel);
        textPanel.add(decode);
        textPanel.add(encrypt);
        textPanel.add(word);
        textPanel.add(encrWord);
        textPanel.add(keyWord);
        //textPanel.add(titleLabel);

        mainWindow.add(bottomPanel);
        mainWindow.add(upperPanel);
        mainWindow.add(textPanel);
        mainWindow.setVisible(true);
    }
    public static void main(String[] args) {
        EncryptionMain e = new EncryptionMain();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == encrypt){
            //take word -> encrypt -> insert encrypted word & key
            //System.out.println("ENCRYPTION");
            EncryptWord x = new EncryptWord();
            String myWord = word.getText(), myKey = x.encryptW(myWord, 0), keyLine = "";
            System.out.println(myWord);

            //encrWord.setText(x.encryptW(key,1));
            System.out.println("### SŁOWA PRZED SZYFROWANIEM ###");
            System.out.println(myWord);
            System.out.println(myKey);
            System.out.println(keyLine);

            keyWord.setText(myKey);
            for(int keyTable=0; keyTable<myKey.length()+1;keyTable++){
                if (keyTable % 72 != 0 || keyTable == 0){
                    keyLine = keyLine + myKey.charAt(keyTable);
                }
                else{
                    System.out.println(keyLine + "\n");
                    keyLine = "";
                }
            }
            System.out.println("### SŁOWA PO SZYFROWANIU ###");
            System.out.println(myWord);
            System.out.println(myKey);
            System.out.println(keyLine);


        }
        if(e.getSource() == decode){
            //take key & encrypted word -> decrypt -> insert word
            //System.out.println("DECODING");

            word.setText("Decoding word...");
            encrWord.setText("testEncryptedWord");
            keyWord.setText("Input your Key (copy from board)");



        }
    }

}
