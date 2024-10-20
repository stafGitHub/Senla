package TaskThree.Util;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ParseMap {
    public static Map<String, ArrayList<Object>> passwordMap = new HashMap<>();

    public static void initMap(Properties properties){
        for (int i = 0; i < properties.size(); i++) {
            passwordMap.put(PasswordEn.values()[i].toString(),
                    new ArrayList<>(List.of(properties.get(PasswordEn.values()[i].toString()).toString().split(",")))
                    );
        }
    }

    public static Properties getProperties(String url){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
