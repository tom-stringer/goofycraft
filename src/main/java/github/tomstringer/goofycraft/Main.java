package github.tomstringer.goofycraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import static github.tomstringer.goofycraft.SoundsFactory.createSounds;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Sounds sounds = createSounds();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("src/assets/minecraft/sounds.json"))
        {
            gson.toJson(sounds.getSoundEvents(), writer);
        }
    }
}
