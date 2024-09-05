package github.tomstringer.goofycraft.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundEvent
{
    private final List<Sound> sounds;

    public SoundEvent(Sound... sounds)
    {
        this.sounds = new ArrayList<>(Arrays.asList(sounds));
    }

    public SoundEvent add(Sound... newSounds)
    {
        sounds.addAll(Arrays.asList(newSounds));
        return this;
    }
}
