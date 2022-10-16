package encryption;

import java.util.ArrayList;
import java.util.List;

public class Decode {
    public String wordDecode(String encryptedWord, String key){
        String resultWord = "";
        List<Character> decodedWord = new ArrayList<>();
        List<String> keyList = new ArrayList<>();
        /**
         * checking if value of length equals 0
         */
        if(encryptedWord.length() == 0){
            return null;
        }
        /**
         * dividing big key into smaller keys for each letter
         */
        for(int i=0;i<encryptedWord.length();i++){
            String smallerKey = "";
            for(int j=0;j<72;j++){
                smallerKey = smallerKey + key.charAt(i*72+j);
            }
            keyList.add(smallerKey);
        }
        /**
         * decoding each letter
         */
        int counter = 0;
        for(Character wordToTable:encryptedWord.toCharArray()){
            if(wordToTable == ':'){
                decodedWord.add(' ');
                counter++;
            }
            else{
                decodedWord.add(decoding(wordToTable,keyList.get(counter)));
                counter++;
            }
        }
        /**
         * list to string
         */
        for(Character ab:decodedWord){
            resultWord = resultWord + ab;
        }
        return resultWord;
    }

    public Character decoding(Character myChar, String myKey){
        Character wordLetter = myChar;
        for(int i=0;i<myKey.length();i++){
          if(wordLetter == myKey.charAt(i)){

              wordLetter = myKey.charAt(myKey.length()-i-1);
              break;
          }
          else if(i==myKey.length()-1)
          {
              break;
          }
        }
        return wordLetter;
    }

}
