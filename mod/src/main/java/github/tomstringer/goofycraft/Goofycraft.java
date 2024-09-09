package github.tomstringer.goofycraft;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Goofycraft.MOD_ID)
public class Goofycraft
{
    public static final String MOD_ID = "goofycraft";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Goofycraft()
    {
        LOGGER.info("Building Goofycraft mod");

        MinecraftForge.EVENT_BUS.register(this);
    }
}
