package github.tomstringer.goofycraft.model;

public class Sound
{
    private final String name;
    private final Double volume;

    private Sound(String name, Double volume)
    {
        this.name = name;
        this.volume = volume;
    }

    public static Sound sound(String name)
    {
        return new Sound(name, null);
    }

    public static Sound sound(String name, double volume)
    {
        return new Sound(name, volume);
    }
}
