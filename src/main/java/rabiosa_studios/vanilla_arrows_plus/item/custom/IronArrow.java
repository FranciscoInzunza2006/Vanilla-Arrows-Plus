package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
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
    public IronArrow(Item.Settings settings, double damage, float speed, float divergence) {
        super(settings, damage, speed, divergence);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        IronArrowEntity ironArrowEntity = new IronArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);

        ironArrowEntity.setDamage(this.damage);

        return ironArrowEntity;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        IronArrowEntity ironArrowEntity = new IronArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        ironArrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;

        ironArrowEntity.setDamage(damage);

        return ironArrowEntity;
    }
}
