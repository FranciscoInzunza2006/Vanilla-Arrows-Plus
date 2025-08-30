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
import rabiosa_studios.vanilla_arrows_plus.entity.custom.ClusterArrowEntity;

public class ClusterArrow extends CustomArrowItem {
    public ClusterArrow(Item.Settings settings) {
        super(settings,
                VANILLA_MAX_DAMAGE,
                VANILLA_SPEED,
                VANILLA_DIVERGENCE,
                VANILLA_PULL_TIME);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new ClusterArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        ClusterArrowEntity entity = new ClusterArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        entity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;

        return entity;
    }
}
