package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

import java.util.List;
import java.util.function.Consumer;

@Mixin(RangedWeaponItem.class)
public abstract class RangedWeaponItemMixin {
    @Shadow protected abstract void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target);

    @Inject(method = "createArrowEntity", at = @At("TAIL"))
    private void applyArrowDamage(CallbackInfoReturnable<ProjectileEntity> cir,
                                  @Local(argsOnly = true) LivingEntity shooter,
                                  @Local ArrowItem arrow,
                                  @Local PersistentProjectileEntity arrow_entity) {
        if (arrow instanceof CustomArrowItem custom_arrow) {
            arrow_entity.setDamage(custom_arrow.getDamage(shooter));
        }
    }

    @ModifyArg(method = "shootAll", index = 3, at= @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/ProjectileEntity;spawn(Lnet/minecraft/entity/projectile/ProjectileEntity;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/item/ItemStack;Ljava/util/function/Consumer;)Lnet/minecraft/entity/projectile/ProjectileEntity;"))
    private Consumer<ProjectileEntity> applyArrowAttributes(Consumer<ProjectileEntity> beforeSpawn,
                                                            @Local(argsOnly = true, ordinal = 0) LivingEntity shooter,
                                                            @Local(argsOnly = true) ItemStack weapon,
                                                            @Local(argsOnly = true) List<ItemStack> projectiles,
                                                            @Local(argsOnly = true, ordinal = 0) float speed,
                                                            @Local(argsOnly = true, ordinal = 1) float divergence,
                                                            @Local(argsOnly = true, ordinal = 1) @Nullable LivingEntity target,

                                                            @Local(ordinal = 0) int projectile_index,
                                                            @Local(ordinal = 6) float yaw
                                                            ) {
        if (!(projectiles.getFirst().getItem() instanceof CustomArrowItem arrow))
            return beforeSpawn;

        float final_speed = speed * arrow.getSpeed(shooter);
        float final_divergence = divergence * (weapon.getItem() == Items.CROSSBOW ? arrow.getDivergence(shooter) : 1.0f);

        return (projectile -> this.shoot(shooter, projectile, projectile_index, final_speed, final_divergence, yaw, target));
    }
}
