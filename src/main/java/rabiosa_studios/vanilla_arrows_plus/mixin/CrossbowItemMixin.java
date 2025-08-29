package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.ChargedProjectilesComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin {
    @ModifyConstant(method = "getPullTime", constant = @Constant(floatValue = CustomArrowItem.VANILLA_CROSSBOW_PULL_TIME))
    private static float applyChargeTime(float pull_time, @Local(argsOnly = true) ItemStack crossbow, @Local(argsOnly = true) LivingEntity user) {
        return pull_time *
                (user.getProjectileType(crossbow).getItem() instanceof CustomArrowItem arrow ? arrow.getChargeTime(user) : 1.0f);
    }

    // TODO: This doesnt affect entities, check CrossbowUser interface
    @WrapOperation(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/CrossbowItem;getSpeed(Lnet/minecraft/component/type/ChargedProjectilesComponent;)F"))
    private static float applyArrowSpeed(ChargedProjectilesComponent stack, Operation<Float> original, @Local(argsOnly = true)PlayerEntity user) {
        if (stack.getProjectiles().getFirst().getItem() instanceof CustomArrowItem arrow) {
            return CustomArrowItem.VANILLA_CROSSBOW_SPEED_MULTIPLIER * arrow.getSpeed(user);
        }

        return original.call(stack);
    }
}
