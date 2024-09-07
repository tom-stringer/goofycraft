package github.tomstringer.goofycraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import github.tomstringer.goofycraft.model.Sounds;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class SoundsWriter
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final SoundsFactory soundsFactory;
    private final Path path;

    public SoundsWriter(SoundsFactory soundsFactory, Path path)
    {
        this.soundsFactory = soundsFactory;
        this.path = path;
    }

    public void writeSoundsFile() throws IOException
    {
        Sounds sounds = soundsFactory.createSounds();

        try (FileWriter writer = new FileWriter(path.toString()))
        {
            GSON.toJson(sounds.getSoundEvents(), writer);
        }
    }
}
