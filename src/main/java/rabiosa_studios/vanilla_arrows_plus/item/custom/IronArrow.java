package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.IronArrowEntity;

public class IronArrow extends CustomArrowItem {
    /**
     * @param max_damage  Vanilla arrow max damage (full speed no enchantments) is {@value VANILLA_MAX_DAMAGE}, read note below.
     * @param speed       Vanilla speed is {@value VANILLA_SPEED}
     * @param divergence  Vanilla divergence is {@value VANILLA_DIVERGENCE}
     * @param charge_time Vanilla charge time is {@value VANILLA_CHARGE_TIME}, this value is in seconds.
     *                    <p>Note: Since the formula for the damage to the arrow is damage * speed, increasing the speed a lot and lowering the damage only a bit will end up with an arrow that does way more damage than planned. This function fixes it automatically.</p>
     */
    public IronArrow(Item.Settings settings, double max_damage, float speed, float divergence, float charge_time) {
        super(settings, max_damage, speed, divergence, charge_time);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new IronArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        IronArrowEntity ironArrowEntity = new IronArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        ironArrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;

        return ironArrowEntity;
    }
}
