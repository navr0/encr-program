package encryption;

import java.util.ArrayList;
import java.util.List;

public class EncryptWord {
    /**
     *
     * @param word

     * @return
     */
    public String[] encryptW(String word){
        /** Generating key (key length depends on word length)
         *  passingData - output, default: empty
         *  myKey - key that matches to user's word (generated randomly, from ascii symbols)
         */
        GenerateKey gen = new GenerateKey();
        String[] passingData = {"",""};
        String myKey = gen.genKey(word);
        /**
         * checking if key length is ok (should equal word length * 72)
         * keyTable - array of keys for each word's letter
         */
        int loopCount = myKey.length()/72;
        String[] keyTable = new String[loopCount];
        /**
         * converting Strings to list of characters
         */
        List<Character> myWord = new ArrayList<Character>();
        List<Character> encWord = new ArrayList<Character>();
        for(Character c:word.toCharArray()) {
            myWord.add(c);
        }
        /**
         * dividing big key into smaller keys (for each word's letter)
         */
        for(int i = 0; i<loopCount; i++){
            keyTable[i] = "";
            for(int j=0;j<72;j++){
                    keyTable[i] = keyTable[i] + myKey.charAt(j+i*72);
            }
        }
        /**
         * checking if letter from word matches with any letter from key
         * checking if letter equals space (ascii: 32)
         */
        for(int g=0;g<loopCount;g++){
            int counter = 0;
            for(Character ch:keyTable[g].toCharArray()){
                if(word.charAt(g) == ch){
                    /**
                     * encrypting word (encWord[g] = keyTable[71-counter])
                     */
                    encWord.add(keyTable[g].charAt(71-counter));
                    break;
                }
                if(word.charAt(g) == 32){
                    /**
                     * space is replaced by ":" symbol
                     */
                    encWord.add(':');
                    break;
                }
                if(counter==71){
                    /**
                     * other case (character is not in key array)
                     */
                    encWord.add(word.charAt(g));
                }
                counter++;
            }
        }

        passingData[0] = myKey;
        for(Character a:encWord){
            passingData[1]=passingData[1]+a;
        }
        return passingData;
    }
}
