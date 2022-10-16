package encryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadAsciiNumbers {
    public String aNmb(){
        /**
         * adding ascii symbols to key
         */
        String abc = "";
        char[] ascii = new char[]{'a','b','c','d','e','f','g','h','i', 'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(char c:ascii){
            abc = abc + c;
        }
        abc = abc + abc.toUpperCase();
        for(int i=0;i<10;i++){
            abc = abc + i;
        }
        abc = abc + "!@#$%^&*()";
        List<Character> shuffle = new ArrayList<Character>();
        for(char ch:abc.toCharArray()){
            shuffle.add(ch);
        }
        /**
         * shuffling array
         */
        Collections.shuffle(shuffle);
        abc = "";
        for(Character c:shuffle){
            abc = abc + c;
        }
        return abc;
    }
}
