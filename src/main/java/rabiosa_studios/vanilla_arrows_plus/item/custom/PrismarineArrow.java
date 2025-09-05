package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.PrismarineArrowEntity;

public class PrismarineArrow extends CustomArrowItem {
    private static final float NOT_IN_WATER_MULTIPLIER = 0.6f;
    private static final float IN_RAIN_MULTIPLIER = 1f;
    private static final float IN_WATER_MULTIPLIER = 1.3f;

    public PrismarineArrow(Item.Settings settings) {
        super(settings,
                VANILLA_MAX_DAMAGE,
                1,
                1,
                1);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new PrismarineArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        PrismarineArrowEntity entity = new PrismarineArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        entity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;

        return entity;
    }

    private float getArrowWaterBonus(Entity user) {
        if (!user.isTouchingWaterOrRain())
            return NOT_IN_WATER_MULTIPLIER;
        else if (user.isSubmergedInWater())
            return IN_WATER_MULTIPLIER;
        else
            return IN_RAIN_MULTIPLIER; // FIXME: Touching a pixel of water counts
    }


    @Override
    public float getSpeed(Entity user) {
        return  getArrowWaterBonus(user) * super.getSpeed(user);
    }

    @Override
    public float getPullTime(Entity user) {
        final float time = super.getPullTime(user);
        return time - (time * getArrowWaterBonus(user) - time);
    }
}
