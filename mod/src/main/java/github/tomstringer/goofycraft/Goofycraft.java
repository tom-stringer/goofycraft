package github.tomstringer.goofycraft;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(Goofycraft.MOD_ID)
public class Goofycraft
{
    public static final String MOD_ID = "goofycraft";

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    private static final RegistryObject<Item> SIGMA_STICK = ITEMS.register("sigma_stick", SigmaStick::new);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> SIGMA_STICK.get().getDefaultInstance())
            .displayItems((parameters, output) -> output.accept(SIGMA_STICK.get())).build());

    public static final RegistryObject<SoundEvent> WHAT_THE_SIGMA = SOUNDS.register(
            "what_the_sigma",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MOD_ID, "what_the_sigma"))
    );

    public Goofycraft(FMLJavaModLoadingContext context)
    {
        LOGGER.info("Building Goofycraft mod");

        IEventBus modEventBus = context.getModEventBus();

        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        SOUNDS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
