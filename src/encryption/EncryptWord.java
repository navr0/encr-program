package encryption;

public class EncryptWord {
    // 0 = return key, 1 = return word
    public String encryptW(String word, int whatToReturn){
        GenerateKey gen = new GenerateKey();
        String passingData="", myKey = gen.genKey(word);

        if(whatToReturn==0){
            passingData = myKey;
        }
        else if (whatToReturn==1) {
            passingData="encryptedWord";
        }
        return passingData;
    }
}
