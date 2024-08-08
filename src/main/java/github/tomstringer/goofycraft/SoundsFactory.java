package github.tomstringer.goofycraft;

import java.util.List;

import static github.tomstringer.goofycraft.Sound.sound;

public class SoundsFactory
{
    public static Sounds createSounds()
    {
        Sounds sounds = new Sounds()
                .add(
                        "entity.sheep.shear",
                        sound("mob/sheep/i_like_ya_cut_g"),
                        sound("mob/sheep/just_had_haircut")
                )
                .add(
                        "entity.villager.ambient",
                        sound("mob/villager/what_the_sigma")
                )
                .add(
                        "entity.villager.trade",
                        sound("mob/villager/spare", 0.8)
                )
                .add(
                        "entity.villager.hurt",
                        sound("mob/villager/what_the_sigma")
                )
                .add(
                        "entity.villager.yes",
                        sound("mob/villager/spare", 0.8)
                )
                .add(
                        "entity.villager.no",
                        sound("mob/villager/spare", 0.8)
                )
                .add(
                        "entity.player.death",
                        sound("entity/player/badlands"),
                        sound("entity/player/oh_hell_nah_man"),
                        sound("entity/player/vine_boom")
                )
                .add(
                        "entity.wolf.growl",
                        sound("mob/wolf/what_da_dog_doin"),
                        sound("mob/wolf/scooby")
                )
                .add(
                        "entity.wolf.pant",
                        sound("mob/wolf/what_da_dog_doin"),
                        sound("mob/wolf/scooby")
                )
                .add(
                        "entity.wolf.whine",
                        sound("mob/wolf/what_da_dog_doin"),
                        sound("mob/wolf/scooby")
                )
                .add(
                        "entity.zombie.death",
                        sound("mob/zombie/bruh")
                );

        hostileMobDeathEvents()
                .forEach(event -> sounds.add(event,
                        sound("mob/eff_off_greggs"),
                        sound("mob/fart_reverb"),
                        sound("mob/you_robbing"),
                        sound("mob/get_out"),
                        sound("mob/vine_boom"),
                        sound("mob/hitman")));

        return sounds;
    }

    private static List<String> hostileMobDeathEvents()
    {
        return List.of(
                "entity.blaze.death",
                "entity.creeper.death",
                "entity.drowned.death",
                "entity.drowned.death_water",
                "entity.elder_guardian.death",
                "entity.elder_guardian.death_land",
                "entity.ender_dragon.death",
                "entity.ender_eye.death",
                "entity.enderman.death",
                "entity.endermite.death",
                "entity.evoker.death",
                "entity.ghast.death",
                "entity.guardian.death",
                "entity.guardian.death_land",
                "entity.hoglin.death",
                "entity.hostile.death",
                "entity.husk.death",
                "entity.illusioner.death",
                "entity.magma_cube.death",
                "entity.magma_cube.death_small",
                "entity.phantom.death",
                "entity.pig.death",
                "entity.piglin.death",
                "entity.pillager.death",
                "entity.ravager.death",
                "entity.shulker.death",
                "entity.skeleton.death",
                "entity.skeleton_horse.death",
                "entity.slime.death",
                "entity.slime.death_small",
                "entity.snow_golem.death",
                "entity.spider.death",
                "entity.strider.death",
                "entity.vex.death",
                "entity.vindicator.death",
                "entity.witch.death",
                "entity.wither.death",
                "entity.wither_skeleton.death",
                "entity.zoglin.death",
                "entity.zombie.death",
                "entity.zombie_horse.death",
                "entity.zombie_villager.death",
                "entity.zombified_piglin.death"
        );
    }
}
