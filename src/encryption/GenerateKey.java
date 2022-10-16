package encryption;

public class GenerateKey {
    public String genKey(String word){
        /**
         * putting all keys together into one big key
         */
        String key = "";
        ReadAsciiNumbers read = new ReadAsciiNumbers();
        for(int i=0;i<word.length();i++){
            key = key + read.aNmb();
        }
        return key;
    }
}
