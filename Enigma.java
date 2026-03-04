public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        String result = "";
        for(int i = 0; i < message.length(); i++){
            int outerIdx = rotors[2].indexOf(message.charAt(i));
            char middleChar = rotors[1].charAt(outerIdx);
            int outerIdx2 = rotors[2].indexOf(middleChar);
            result += rotors[0].charAt(outerIdx2);
            rotate();
        }
        return result
    }


    
    public String encrypt(String message){
    String result = "";
    for(char ch : message.toCharArray()){
        int innerIdx = rotors[0].indexOf(ch);
        char outerChar = rotors[2].charAt(innerIdx);
        int middleIdx = rotors[1].indexOf(outerChar);
        result += rotors[2].charAt(middleIdx);
        rotate();
    }
    return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
