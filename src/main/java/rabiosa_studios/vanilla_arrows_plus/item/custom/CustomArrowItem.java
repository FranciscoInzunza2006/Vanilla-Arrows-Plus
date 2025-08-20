package rabiosa_studios.vanilla_arrows_plus.item.custom;

import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;

public abstract class CustomArrowItem extends ArrowItem {
    protected static final double BASE_DAMAGE = 2.0d;
    protected static final float BASE_SPEED = 3.0f;
    protected static final float BASE_DIVERGENCE = 1.0f;

    public final double damage;
    public final float speed;
    public final float divergence;

    public CustomArrowItem(Item.Settings settings, double damage, float speed, float divergence) {
        super(settings);

        this.damage = damage;
        this.speed = speed;
        this.divergence = divergence;
    }

    protected void setDamage(ArrowEntity arrow_entity) {
        arrow_entity.setDamage(this.damage);
    }


//    @Override
//    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
//        ArrowEntity arrowEntity = new ArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
//
//        arrowEntity.setDamage(damage);
//
//        return arrowEntity;
//    }
//
//    @Override
//    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
//        ArrowEntity arrowEntity = new ArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
//        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
//
//        arrowEntity.setDamage(damage);
//
//        return arrowEntity;
//    }
}
