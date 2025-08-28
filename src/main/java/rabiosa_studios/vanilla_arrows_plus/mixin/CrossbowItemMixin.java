package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.ChargedProjectilesComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin {
    @ModifyConstant(method = "getPullTime", constant = @Constant(floatValue = CustomArrowItem.VANILLA_CROSSBOW_PULL_TIME))
    private static float applyChargeTime(float pull_time, @Local(argsOnly = true) ItemStack crossbow, @Local(argsOnly = true) LivingEntity user) {
        return pull_time *
                (user.getProjectileType(crossbow).getItem() instanceof CustomArrowItem arrow ? arrow.getChargeTime() : 1.0f);
    }

    @Inject(method = "getSpeed", at = @At("RETURN"), cancellable = true)
    private static void applyArrowSpeed(ChargedProjectilesComponent stack, CallbackInfoReturnable<Float> cir) {
        if (stack.getProjectiles().getFirst().getItem() instanceof CustomArrowItem arrow) {
            cir.setReturnValue(CustomArrowItem.VANILLA_CROSSBOW_SPEED_MULTIPLIER * arrow.getSpeed());
        }
    }
}
