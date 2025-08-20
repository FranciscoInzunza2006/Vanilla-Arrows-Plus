package rabiosa_studios.vanilla_arrows_plus.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IronArrowEntity extends ArrowEntity {
    public IronArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public IronArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
    }

    public IronArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
    }
}
