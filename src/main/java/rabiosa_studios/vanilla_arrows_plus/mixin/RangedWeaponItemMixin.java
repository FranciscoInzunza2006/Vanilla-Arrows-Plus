package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.RangedWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(RangedWeaponItem.class)
public abstract class RangedWeaponItemMixin {
    @Inject(method = "createArrowEntity", at = @At("TAIL"))
    private void applyArrowDamage(CallbackInfoReturnable<ProjectileEntity> cir,
                                  @Local ArrowItem arrow,
                                  @Local PersistentProjectileEntity arrow_entity) {
        if (arrow instanceof CustomArrowItem custom_arrow) {
            arrow_entity.setDamage(custom_arrow.damage);
        }
    }
}
