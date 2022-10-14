package encryption;

import java.io.*;
import java.util.*;

public class GenerateKey {
    public String genKey(String word){
        String key = "";
        ReadAsciiNumbers read = new ReadAsciiNumbers();

        for(int i=0;i<word.length();i++){
            key = key + read.aNmb();
        }


        System.out.println("Dlugosc wyrazenia: " + key.length());
        return key;
    }
}
