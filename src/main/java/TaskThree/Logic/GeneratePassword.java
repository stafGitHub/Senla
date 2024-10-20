package TaskThree.Logic;

import TaskThree.Util.ParseMap;
import TaskThree.Util.PasswordEn;
import TaskThree.Util.Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class GeneratePassword {
    private static Map<String, Double> probabilities = new HashMap<>();

    public static String generateSymbol() {
        int flag = -1;

        for (int i = 0; i < Arrays.stream(PasswordEn.values()).count(); i++) {
            if (probabilities.get(PasswordEn.values()[i].toString()) > Random.random(0,1)) {
                flag = i;
                probabilities.replace(PasswordEn.values()[i].toString(),
                        probabilities.get(PasswordEn.values()[i].toString())*Random.random(0.2,0.6));
                break;
            }
        }

        if (flag != -1) {
            for (int i = 0; i < Arrays.stream(PasswordEn.values()).count(); i++) {
                if (i==flag){
                    continue;
                }
                probabilities.replace(PasswordEn.values()[i].toString(),
                        probabilities.get(PasswordEn.values()[i].toString())*Random.random(1.1,1.5));

            }
            String result = ParseMap.passwordMap.get(PasswordEn.values()[flag].toString())
                    .get(Random.randomInt(0, ParseMap.passwordMap.get(PasswordEn.values()[flag].toString()).size())).toString();

            flag = -1;

            return result;

        }else {
            AtomicReference<String> probabilitiesName = new AtomicReference<>();
            AtomicReference<Double> probabilitiesDouble = new AtomicReference<>((double) 0);

            probabilities.forEach((name, aDouble) ->{
                        if (aDouble > probabilitiesDouble.get()){
                            probabilitiesName.set(name);
                            probabilitiesDouble.set(aDouble);
                        }
                    });

            probabilities.replace(probabilitiesName.get(),probabilitiesDouble.get()*Random.random(0.4,0.8));

            return ParseMap.passwordMap.get(probabilitiesName.get())
                    .get(Random.randomInt(0,ParseMap.passwordMap.get(probabilitiesName.get()).size())).toString();
        }



    }

    public static void init(){
        for (int i = 0; i < Arrays.stream(PasswordEn.values()).count(); i++) {
            probabilities.put(PasswordEn.values()[i].toString(),Math.random());
        }
    }

}
