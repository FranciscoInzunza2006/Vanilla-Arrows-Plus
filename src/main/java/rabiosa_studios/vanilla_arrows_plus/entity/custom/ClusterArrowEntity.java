package rabiosa_studios.vanilla_arrows_plus.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rabiosa_studios.vanilla_arrows_plus.entity.ModEntities;
import rabiosa_studios.vanilla_arrows_plus.item.ModItems;

public class ClusterArrowEntity extends PersistentProjectileEntity {
    public ClusterArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ClusterArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.CLUSTER_ARROW, owner, world, stack, shotFrom);
    }

    public ClusterArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.CLUSTER_ARROW, x, y, z, world, stack, shotFrom);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.CLUSTER_ARROW);
    }
}


