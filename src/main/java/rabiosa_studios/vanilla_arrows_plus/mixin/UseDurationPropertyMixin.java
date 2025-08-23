package rabiosa_studios.vanilla_arrows_plus.mixin;

import net.minecraft.client.render.item.property.numeric.UseDurationProperty;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(UseDurationProperty.class)
public abstract class UseDurationPropertyMixin {
    @Inject(method = "getTicksUsedSoFar", at = @At(value = "RETURN"), cancellable = true)
    private static void applyArrowChargeTimePullingVisual(ItemStack stack, LivingEntity user, CallbackInfoReturnable<Integer> cir) {
        if (stack.getItem() != Items.BOW) return;

        if (user.getProjectileType(stack).getItem() instanceof CustomArrowItem arrow) {
            cir.setReturnValue((int) (cir.getReturnValue() / arrow.charge_time));
        }
    }
}
