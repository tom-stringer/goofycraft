package github.tomstringer.goofycraft;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

import static github.tomstringer.goofycraft.Goofycraft.WHAT_THE_SIGMA;

public class SigmaStick extends Item
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public SigmaStick()
    {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        LOGGER.info("SigmaStick used");

        player.playSound(WHAT_THE_SIGMA.get());

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
