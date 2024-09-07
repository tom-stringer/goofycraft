package github.tomstringer.goofycraft;

import github.tomstringer.goofycraft.model.Sounds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static github.tomstringer.goofycraft.model.Sound.sound;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SoundsWriterTest
{
    @TempDir
    private Path tempDir;

    @Mock
    private SoundsFactory soundsFactory;

    private Path soundsPath;
    private SoundsWriter soundsWriter;

    @BeforeEach
    void setup()
    {
        soundsPath = tempDir.resolve("sounds.json");
        soundsWriter = new SoundsWriter(soundsFactory, soundsPath);
    }

    @Test
    void testWritesSounds() throws IOException
    {
        when(soundsFactory.createSounds()).thenReturn(
                new Sounds()
                        .add(
                                "event.1",
                                sound("path/1"),
                                sound("path/2")
                        )
                        .add(
                                "event.2",
                                sound("path/3")
                        )
        );

        soundsWriter.writeSoundsFile();

        String expectedSounds = """
                {
                  "event.1": {
                    "sounds": [
                      {
                        "name": "path/1"
                      },
                      {
                        "name": "path/2"
                      }
                    ]
                  },
                  "event.2": {
                    "sounds": [
                      {
                        "name": "path/3"
                      }
                    ]
                  }
                }""";

        String sounds = Files.readString(soundsPath);

        assertThat(sounds).isEqualTo(expectedSounds);
    }

    @Test
    void testWritesWithEventOverrides() throws IOException
    {
        when(soundsFactory.createSounds()).thenReturn(
                new Sounds()
                        .add(
                                "event.1",
                                sound("path/1"),
                                sound("path/2")
                        )
                        .add(
                                "event.1",
                                sound("path/3")
                        )
        );

        soundsWriter.writeSoundsFile();

        String expectedSounds = """
                {
                  "event.1": {
                    "sounds": [
                      {
                        "name": "path/1"
                      },
                      {
                        "name": "path/2"
                      },
                      {
                        "name": "path/3"
                      }
                    ]
                  }
                }""";

        String sounds = Files.readString(soundsPath);

        assertThat(sounds).isEqualTo(expectedSounds);
    }

    @Test
    void testWritesWithVolume() throws IOException
    {
        when(soundsFactory.createSounds()).thenReturn(
                new Sounds()
                        .add(
                                "event.1",
                                sound("path/1", 0.5)
                        )
        );

        soundsWriter.writeSoundsFile();

        String expectedSounds = """
                {
                  "event.1": {
                    "sounds": [
                      {
                        "name": "path/1",
                        "volume": 0.5
                      }
                    ]
                  }
                }""";

        String sounds = Files.readString(soundsPath);

        assertThat(sounds).isEqualTo(expectedSounds);
    }
}
