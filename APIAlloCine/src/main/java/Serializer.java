import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serializer {

    public static Adresse deserialize(String gsonAdresse) {
        Gson gson = new Gson();

        Type type = new TypeToken<Adresse>() {
        }.getType();

        return gson.fromJson(gsonAdresse, type);
    }

    public static String serialize(Adresse adresse) {
        Gson gson = new Gson();
        return gson.toJson(adresse);
    }

    public static List<Seance> deserializeListSeance(String gsonListSeance) {
        Gson gson = new Gson();

        Type type = new TypeToken<List<Seance>>() {
        }.getType();

        return gson.fromJson(gsonListSeance, type);
    }

    public static String serialize(List<Seance> seanceList) {
        Gson gson = new Gson();
        return gson.toJson(seanceList);
    }
}
