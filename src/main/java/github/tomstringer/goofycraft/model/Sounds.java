package github.tomstringer.goofycraft.model;

import java.util.Map;
import java.util.TreeMap;

public class Sounds
{
    private final Map<String, SoundEvent> soundEvents;

    public Sounds()
    {
        this.soundEvents = new TreeMap<>();
    }

    public Sounds add(String event, Sound... sounds)
    {
        soundEvents.compute(event, (key, value) -> (value == null) ? new SoundEvent(sounds) : value.add(sounds));
        return this;
    }

    public Map<String, SoundEvent> getSoundEvents()
    {
        return soundEvents;
    }
}
