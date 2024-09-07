package github.tomstringer.goofycraft;

import java.io.IOException;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Path soundsPath = Path.of("src/main/resources/assets/minecraft/sounds.json");

        new SoundsWriter(new SoundsFactory(), soundsPath)
                .writeSoundsFile();
    }
}
