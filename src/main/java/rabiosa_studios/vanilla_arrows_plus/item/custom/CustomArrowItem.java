package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;

public class CustomArrowItem extends ArrowItem {
    public static final double VANILLA_DAMAGE = 2.0d;
    public static final float VANILLA_SPEED = 3.0f;
    public static final double VANILLA_MAX_DAMAGE = VANILLA_DAMAGE * VANILLA_SPEED;
    public static final float VANILLA_DIVERGENCE = 1.0f;
    public static final float VANILLA_CHARGE_TIME = 1.0f;

    public static final float VANILLA_CROSSBOW_SPEED = 3.15f;
    public static final float VANILLA_CROSSBOW_SPEED_MULTIPLIER = VANILLA_CROSSBOW_SPEED/VANILLA_SPEED;
    public static final float VANILLA_CROSSBOW_PULL_TIME = 1.25F;

    public final double damage;
    public final float speed;
    public final float divergence;
    public final float charge_time;

    /**
     * @param max_damage  Vanilla arrow max damage (full speed no enchantments) is {@value VANILLA_MAX_DAMAGE}, read note below.
     * @param speed       Vanilla speed is {@value VANILLA_SPEED}
     * @param divergence  Vanilla divergence is {@value VANILLA_DIVERGENCE}
     * @param charge_time Vanilla charge time is {@value VANILLA_CHARGE_TIME}, this value is in seconds.
     *                    <p>Note: Since the formula for the damage of the arrow is damage * speed, increasing the speed a lot and lowering the damage only a bit will end up with a arrow that does way more damage than planned. This function fixes it automatically.</p>
     *                    <p>Crossbows have a {@value VANILLA_CROSSBOW_SPEED_MULTIPLIER} speed multiplier</p>
     *                    <p>Divergence doesn't affect crossbows</p>
     */
    public CustomArrowItem(Item.Settings settings, double max_damage, float speed, float divergence, float charge_time) {
        super(settings);

        this.damage = max_damage / speed;
        this.speed = speed;
        this.divergence = divergence;
        this.charge_time = charge_time;
    }
}
