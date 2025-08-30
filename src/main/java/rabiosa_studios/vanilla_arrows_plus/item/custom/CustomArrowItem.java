package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;

public abstract class CustomArrowItem extends ArrowItem {
    public static final double VANILLA_DAMAGE = 2.0d;
    public static final float VANILLA_SPEED = 3.0f;
    public static final double VANILLA_MAX_DAMAGE = VANILLA_DAMAGE * VANILLA_SPEED;
    public static final float VANILLA_DIVERGENCE = 1.0f;
    public static final float VANILLA_PULL_TIME = 1.0f;

    public static final float VANILLA_CROSSBOW_SPEED = 3.15f;
    public static final float VANILLA_CROSSBOW_SPEED_MULTIPLIER = VANILLA_CROSSBOW_SPEED / VANILLA_SPEED;
    public static final float VANILLA_CROSSBOW_PULL_TIME = 1.25F;

    private final double damage;
    private final float speed_multiplier;
    private final float divergence_multiplier;
    private final float pull_time_multiplier;

    /**
     * @param max_damage  Vanilla arrow max damage (full speed no enchantments bow) is {@value VANILLA_MAX_DAMAGE}, read note below.
     * @param speed_multiplier       Vanilla bow speed is {@value VANILLA_SPEED}
     * @param divergence_multiplier  Vanilla player divergence is {@value VANILLA_DIVERGENCE}
     * @param pull_time_multiplier Vanilla bow pull time is {@value VANILLA_PULL_TIME}, this value is in seconds.
     *                    <p>Note: Since the formula for the damage of the arrow is damage * speed, increasing the speed a lot and lowering the damage only a bit will end up with a arrow that does way more damage than planned. This function fixes it automatically.</p>
     *                    <p>Crossbows have a {@value VANILLA_CROSSBOW_SPEED_MULTIPLIER} speed multiplier</p>
     *                    <p>Divergence doesn't affect crossbows</p>
     */
    public CustomArrowItem(Item.Settings settings, double max_damage, float speed_multiplier, float divergence_multiplier, float pull_time_multiplier) {
        super(settings);

        this.damage = max_damage / speed_multiplier;
        this.speed_multiplier = speed_multiplier;
        this.divergence_multiplier = divergence_multiplier;
        this.pull_time_multiplier = pull_time_multiplier;
    }

    public double getDamage(Entity user) {
        return damage;
    }

    public float getSpeed(Entity user) {return speed_multiplier;}

    public float getDivergence(Entity user) {
        return divergence_multiplier;
    }

    public float getPullTime(Entity user) {return pull_time_multiplier;}
}
