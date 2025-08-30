package rabiosa_studios.vanilla_arrows_plus.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rabiosa_studios.vanilla_arrows_plus.entity.ModEntities;
import rabiosa_studios.vanilla_arrows_plus.item.ModItems;

public class GoldenArrowEntity extends PersistentProjectileEntity {
    public GoldenArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GoldenArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.GOLDEN_ARROW, owner, world, stack, shotFrom);
    }

    public GoldenArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.GOLDEN_ARROW, x, y, z, world, stack, shotFrom);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.GOLDEN_ARROW);
    }
}


