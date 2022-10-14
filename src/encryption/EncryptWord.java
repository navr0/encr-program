package encryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncryptWord {
    // 0 = return key, 1 = return word
    public String encryptW(String word, int whatToReturn){
        GenerateKey gen = new GenerateKey();
        String passingData="", myKey = gen.genKey(word);
        int loopCount = myKey.length()/72;
        String[] keyTable = new String[loopCount];

        List<Character> myWord = new ArrayList<Character>();
        List<Character> encWord = new ArrayList<Character>();
        for(Character c:word.toCharArray()) {
            myWord.add(c);
            if (c == 32) {
                System.out.println("Space: " + c);
            } else {
                System.out.println("Letter: " + c);
            }
        }

        // Dividing entire key into smaller lines (modulo 72, 72 ascii symbols)
        System.out.println("klucz:" + myKey + "\ndlugosc klucza: " + myKey.length());

        //liczba kluczy
        System.out.println(loopCount);

        for(int i = 0; i<loopCount; i++){
            keyTable[i] = "";
            for(int j=0;j<72;j++){
                    keyTable[i] = keyTable[i] + myKey.charAt(j+i*72);
            }
            System.out.println(keyTable[i]);
        }

        for(int g=0;g<loopCount;g++){
            int counter = 0;
            for(Character ch:keyTable[g].toCharArray()){
                if(word.charAt(g) == ch){
                    System.out.println("Found letter " + word.charAt(g) + " at index: " + counter + " in key number: " + g);
                    encWord.add(keyTable[g].charAt(71-counter));
                    break;
                }
                if(word.charAt(g) == 32){
                    System.out.println("SPACE");
                    encWord.add(':');
                    break;
                }
                counter++;
            }
        }


        System.out.println("przed szyfrem");
        System.out.println(myWord);
        System.out.println("Zaszyfrowane slowo");
        System.out.println(encWord);

        if(whatToReturn==0){
            passingData = myKey;
        }
        else if (whatToReturn==1) {
            for(Character a:encWord){
                passingData=passingData+a;
            }
        }
        return passingData;
    }
}
